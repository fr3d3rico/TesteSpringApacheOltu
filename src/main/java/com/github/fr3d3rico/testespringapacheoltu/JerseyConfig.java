package com.github.fr3d3rico.testespringapacheoltu;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
//		register(OAuth2FacebookController.class);
		packages("com.github.fr3d3rico.testespringapacheoltu.controller");
	}
	
}
