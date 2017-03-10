package com.github.fr3d3rico.testespringapacheoltu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class TesteSpringApacheOltuApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		new TesteSpringApacheOltuApplication().configure(new SpringApplicationBuilder(TesteSpringApacheOltuApplication.class)).run(args);
	}
}
