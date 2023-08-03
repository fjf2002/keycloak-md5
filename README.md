# Keycloak MD5

A password hash provider to handle Unix Cyrpt MD5 passwords inside Keycloak.

Cannot encrypt passwords, can only verify them.

The primary purpose is to smoothly migrate from legacy databases with MD5 hashes.

You should set Authentication->Policies->Hashing Algorithm to `pbkdf2-sha256`.
Keycloak will then automatically replace your legacy MD5 hashes
with pbkdf2-sha256 hashes at the first login of the corresponding user.

## Build JAR

```bash
./gradlew assemble -Pdependency.keycloak.version=${KEYCLOAK_VERSION}
```

## Install
Copy the jar file (`./build/libs`) to the keycloak providers directory.

You need to restart Keycloak.

## How test.
Take a user with existing credentials, and modify them to be MD5 credentials.

For example,
* Open the database's `credential` table.
* Locate the user's row.
* In the `secret_data` column, set `value` to the full `$1$...` password hash.
* In the `credential_data` column, set `algorithm` to `md5`.
* You need to restart Keycloak to clear its caches.
