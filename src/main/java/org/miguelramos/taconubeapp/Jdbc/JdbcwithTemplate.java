package org.miguelramos.taconubeapp.Jdbc;

import org.miguelramos.taconubeapp.dominios.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * clearly much simpler than the raw JDBC example OldJdbcway there aren’t any statements or connections
 * being created. And, after the method is finished, there isn’t any cleanup of those objects. Finally,
 * there isn’t any handling of exceptions that can’t properly be handled in a catch block. What’s left is
 * code that’s focused solely on performing a query (the call to JdbcTemplate’s queryForObject() method)
 * and mapping the results to an Ingredient object (in the mapRowToIngredient() method).
 *
 * This code is what you need to do to use JdbcTemplate to persist and read data in the Taco Cloud application.
 * Let’s take the next steps necessary to outfit the application with JDBC persistence. We’ll start by making
 * a few tweaks to the domain objects.
 */

public class JdbcwithTemplate {
    private JdbcTemplate jdbcTemplate;
    public Ingredient findOne(String id){
        return jdbcTemplate.queryForObject("select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient,id);
    }
    private Ingredient mapRowToIngredient(ResultSet rs, int rewNum) throws SQLException {
        return new Ingredient(rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }
}
