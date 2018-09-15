package com.sreenu.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * @author Anil
 *
 * Sep 15, 2018
 */
public class SwaggerConfiguration extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:7070");
		beanConfig.setBasePath("/order-web/rest");
		beanConfig.setResourcePackage("com.dominos.resource");
		beanConfig.setScan(true);

	}

}