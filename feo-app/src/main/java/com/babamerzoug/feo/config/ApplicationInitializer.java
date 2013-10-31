package com.babamerzoug.feo.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created with IntelliJ IDEA.
 * User: merzoug
 * Date: 10/31/13
 * Time: 12:22 PM
 */
public class ApplicationInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_MAPPING = "/";
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // spring context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationContext.class);

        // servlet dispatcher
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(rootContext));
        registration.setLoadOnStartup(1);
        registration.addMapping(DISPATCHER_SERVLET_MAPPING);

        // listeners
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // filters


    }

}
