package org.miguelramos.taconubeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 * you could have added the same view controller declaration
 * to the bootstrap TacoCloudApplication class like this
 */
@SpringBootApplication
public class TacoNubeAppApplication extends WebConfig {

	public static void main(String[] args) {
		SpringApplication.run(TacoNubeAppApplication.class, args);
	}

	/**
	 *By extending an existing configuration class, you can avoid creating a new configuration class,
	 *keeping your project artifact count down. But I tend to prefer creating a new configuration
	 * class for each kind of configuration (web, data, security, and so on), keeping the application
	 * bootstrap configuration clean and simple
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/").setViewName("home");
	}
}
