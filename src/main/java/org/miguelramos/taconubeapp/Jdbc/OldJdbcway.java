package org.miguelramos.taconubeapp.Jdbc;

import org.miguelramos.taconubeapp.dominios.Ingredient;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * there are a couple of lines that query the database for ingredients.
 * But I’ll bet you had a hard time spotting that query needle in the
 * JDBC haystack. It’s surrounded by code that creates a connection,
 * creates a statement, and cleans up by closing the connection,
 * statement, and result set.
 */
public class OldJdbcway {
    private DataSource dataSource;
    public Ingredient findOne(String id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(
                    "select id, name, type from Ingredient where id=?");
            statement.setString(1,id);
            resultSet = statement.executeQuery();
            Ingredient ingredient = null;
            if(resultSet.next()){
                ingredient = new Ingredient(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        Ingredient.Type.valueOf(resultSet.getString("type"))
                );
            }
            return ingredient;
        }catch (SQLException e){
            /**
             * SQLException is a checked exception, which requires handling in a
             * catch block. But the most common problems, such as failure to
             * create a connection to the database or a mistyped query, can’t
             * possibly be addressed in a catch block and are likely to be
             * rethrown for handling upstream.
             */
            return new Ingredient(null,"no ingredient found",null);
        }finally {
            if (resultSet != null){
                try{
                    resultSet.close();
                }catch (SQLException e){}
            }
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException e){

                }
            }
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException e){

                }
            }
        }
    }
}
