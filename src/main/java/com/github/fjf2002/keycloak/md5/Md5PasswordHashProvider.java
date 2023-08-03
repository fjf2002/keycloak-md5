package com.github.fjf2002.keycloak.md5;

import org.keycloak.credential.hash.PasswordHashProvider;
import org.keycloak.models.PasswordPolicy;
import org.keycloak.models.credential.PasswordCredentialModel;

public class Md5PasswordHashProvider implements PasswordHashProvider {

	@Override
	public boolean policyCheck(final PasswordPolicy policy, final PasswordCredentialModel credential) {
		throw new UnsupportedOperationException("MD5 password policies are not supported.");
	}

	@Override
	public String encode(String rawPassword, int iterations) {
		throw new UnsupportedOperationException("MD5 password encoding is not supported.");
	}

	@Override
	public PasswordCredentialModel encodedCredential(final String rawPassword, final int iterations) {
		throw new UnsupportedOperationException("MD5 password encoding is not supported.");
	}

	@Override
	public void close() {
	}

	@Override
	public boolean verify(final String rawPassword, final PasswordCredentialModel credential) {
		final String storedHash = credential.getPasswordSecretData().getValue();

		return Md5Crypt.md5Crypt(rawPassword.getBytes(), storedHash).equals(storedHash);
	}
}
