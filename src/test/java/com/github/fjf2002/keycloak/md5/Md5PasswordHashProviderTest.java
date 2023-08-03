package com.github.fjf2002.keycloak.md5;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.keycloak.models.credential.PasswordCredentialModel;

import com.github.fjf2002.keycloak.md5.Md5PasswordHashProvider;

class Md5PasswordHashProviderTest {
	private final String id = "phpass";
	private final Md5PasswordHashProvider provider = new Md5PasswordHashProvider();

	@Test
	void shouldVerify() {
		final String rawPassword = "DfLCED@*Z,wX";

		final PasswordCredentialModel model = PasswordCredentialModel.createFromValues(id, new byte[0], 0,
				"$1$b7e2d46e$cMZ0BpbfkiRn0TBRpvuKZ0");

		assertTrue(provider.verify(rawPassword, model));
	}

	@Test
	void shouldNotVerify() {
		final String rawPassword = "DfLCED@*Z,wX";

		final PasswordCredentialModel model = PasswordCredentialModel.createFromValues(id, new byte[0], 0,
				"$1$b7e2d46e$cMZ0BpbfkiRn0TBRpvuKZ1");

		assertFalse(provider.verify(rawPassword, model));
	}
}
