package com.github.fr3d3rico.testespringapacheoltu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
	
	@Value("${google.client.id}")
	private String googleClientId;
	
	@Value("${google.client.secret}")
	private String googleClientSecret;
	
	@Value("${google.auth.scope}")
	private String googleAuthScope;
	
	@Value("${google.redirecturi}")
	private String googleRedirecturi;
	
	@Value("${google.bearer.url}")
	private String googleBearerUrl;
	
	@Value("${facebook.authorization.location}")
	private String facebookAuthorizationLocation;
	
	@Value("${facebook.client.id}")
	private String facebookClientId;
	
	@Value("${facebook.client.secret}")
	private String facebookClientSecret;
	
	@Value("${facebook.redirecturi}")
	private String facebookRedirecturi;
	
	@Value("${facebook.bearer.url}")
	private String facebookBearerUrl;

	public String getGoogleClientId() {
		return googleClientId;
	}

	public void setGoogleClientId(String googleClientId) {
		this.googleClientId = googleClientId;
	}

	public String getGoogleClientSecret() {
		return googleClientSecret;
	}

	public void setGoogleClientSecret(String googleClientSecret) {
		this.googleClientSecret = googleClientSecret;
	}

	public String getGoogleAuthScope() {
		return googleAuthScope;
	}

	public void setGoogleAuthScope(String googleAuthScope) {
		this.googleAuthScope = googleAuthScope;
	}

	public String getGoogleRedirecturi() {
		return googleRedirecturi;
	}

	public void setGoogleRedirecturi(String googleRedirecturi) {
		this.googleRedirecturi = googleRedirecturi;
	}

	public String getGoogleBearerUrl() {
		return googleBearerUrl;
	}

	public void setGoogleBearerUrl(String googleBearerUrl) {
		this.googleBearerUrl = googleBearerUrl;
	}

	public String getFacebookAuthorizationLocation() {
		return facebookAuthorizationLocation;
	}

	public void setFacebookAuthorizationLocation(String facebookAuthorizationLocation) {
		this.facebookAuthorizationLocation = facebookAuthorizationLocation;
	}

	public String getFacebookClientId() {
		return facebookClientId;
	}

	public void setFacebookClientId(String facebookClientId) {
		this.facebookClientId = facebookClientId;
	}

	public String getFacebookClientSecret() {
		return facebookClientSecret;
	}

	public void setFacebookClientSecret(String facebookClientSecret) {
		this.facebookClientSecret = facebookClientSecret;
	}

	public String getFacebookRedirecturi() {
		return facebookRedirecturi;
	}

	public void setFacebookRedirecturi(String facebookRedirecturi) {
		this.facebookRedirecturi = facebookRedirecturi;
	}

	public String getFacebookBearerUrl() {
		return facebookBearerUrl;
	}

	public void setFacebookBearerUrl(String facebookBearerUrl) {
		this.facebookBearerUrl = facebookBearerUrl;
	}
	
}
