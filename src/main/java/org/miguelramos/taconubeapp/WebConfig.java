package org.miguelramos.taconubeapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

         /**
          * @WebConfig is that it implements the WebMvcConfigurer interface. WebMvcConfigurer defines
          *several methods for configuring Spring MVC. Even though it’s an interface, it provides default
          * implementations of all the methods, so you only need to override the methods you need.
          * In this case, you override addViewControllers().
          */
@Configuration
public class WebConfig implements WebMvcConfigurer {
        /**
         * The addViewControllers() method is given a ViewControllerRegistry that you can use to
         * register one or more view controllers. Here, you call addViewController() on the registry,
         * passing in "/", which is the path for which your view controller will handle GET requests.
         * That method returns a ViewControllerRegistration object, on which you immediately call
         * setViewName() to specify home as the view that a request for "/" should be forwarded to.
         */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home");
    }
}
