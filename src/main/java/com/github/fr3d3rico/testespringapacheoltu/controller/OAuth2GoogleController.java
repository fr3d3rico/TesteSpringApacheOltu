package com.github.fr3d3rico.testespringapacheoltu.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAuthzResponse;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.fr3d3rico.testespringapacheoltu.AppProperties;

@Component
@Path("/google")
public class OAuth2GoogleController {
	
	private AppProperties app;
	public static String accessToken = null;
	
	@Autowired
	public void setApp(AppProperties app) {
		this.app = app;
	}
	
	@GET
	@Path("/login")
	public Response login() throws OAuthSystemException, MalformedURLException, URISyntaxException {
		
		OAuthClientRequest request = OAuthClientRequest
			.authorizationProvider(OAuthProviderType.GOOGLE)
			.setClientId(app.getGoogleClientId())
			.setRedirectURI(app.getGoogleRedirecturi())
			.setResponseType("code")
			.setScope(app.getGoogleAuthScope())
			.buildQueryMessage();
		
		URL url = new URL(request.getLocationUri());
		
		return Response.seeOther(url.toURI()).build();
	}
	
	@GET
	@Path("/redirect")
	public String backFeedback(@Context HttpServletRequest httpRequest) throws OAuthProblemException, OAuthSystemException {
		OAuthAuthzResponse oar = OAuthAuthzResponse.oauthCodeAuthzResponse(httpRequest);
		String code = oar.getCode();
		
		OAuthClientRequest request = OAuthClientRequest
            .tokenProvider(OAuthProviderType.GOOGLE)
            .setGrantType(GrantType.AUTHORIZATION_CODE)
            .setClientId(app.getGoogleClientId())
            .setClientSecret(app.getGoogleClientSecret())
            .setRedirectURI(app.getGoogleRedirecturi())
            .setCode(code)
            .buildBodyMessage();
		
 
		OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
 
		OAuthJSONAccessTokenResponse accessTokenResponse = oAuthClient.accessToken(request);
 
		String accessToken = accessTokenResponse.getAccessToken();
		
		OAuth2GoogleController.accessToken = accessToken;
		            
		return accessToken;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/info")
	public String info() throws OAuthSystemException, OAuthProblemException {
		OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest(app.getGoogleBearerUrl()).setAccessToken(OAuth2GoogleController.accessToken).buildQueryMessage();
		
		OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
		OAuthResourceResponse resourceResponse = oAuthClient.resource(bearerClientRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);
		
		/*System.out.println("Google **********************");
		Map responseMap = JSONUtils.parseJSON(resourceResponse.getBody());
		Set<String> keys = responseMap.keySet();
		for(String key: keys) {
			System.out.println(key + " = " + responseMap.get(key));
		}*/
		
		return resourceResponse.getBody();
	}
	
}
