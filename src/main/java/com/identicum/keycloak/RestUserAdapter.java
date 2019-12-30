package com.identicum.keycloak;

import javax.json.JsonObject;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.adapter.AbstractUserAdapter;

public class RestUserAdapter extends AbstractUserAdapter {

	JsonObject user;
	String keycloakId;

	public RestUserAdapter(KeycloakSession session, RealmModel realm, ComponentModel model, JsonObject user) {
		super(session, realm, model);
		this.user = user;
		this.keycloakId = StorageId.keycloakId(model, user.getString("username"));
	}

	@Override
	public String getId() {
		return this.keycloakId;
	}
	
	@Override
	public String getUsername() {
		return user.getString("username");
	}

	@Override
	public String getFirstName() {
		return user.getString("firstName");
	}

	@Override
	public String getLastName() {
		return user.getString("lastName");
	}

	@Override
	public String getEmail() {
		return user.getString("email");
	}

}
