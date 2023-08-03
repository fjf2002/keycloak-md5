/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.fjf2002.keycloak.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/**
 * Operations to simplify common {@link java.security.MessageDigest} tasks. This
 * class is immutable and thread-safe. However the MessageDigest instances it
 * creates generally won't be.
 * <p>
 * The {@link MessageDigestAlgorithms} class provides constants for standard
 * digest algorithms that can be used with the {@link #getDigest(String)} method
 * and other methods that require the Digest algorithm name.
 * </p>
 * <p>
 * Note: the class has shorthand methods for all the algorithms present as
 * standard in Java 6. This approach requires lots of methods for each
 * algorithm, and quickly becomes unwieldy. The following code works with all
 * algorithms:
 * </p>
 * 
 * <pre>
 * import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_224;
 * ...
 * byte [] digest = new DigestUtils(SHA_224).digest(dataToDigest);
 * String hdigest = new DigestUtils(SHA_224).digestAsHex(new File("pom.xml"));
 * </pre>
 * 
 * @see MessageDigestAlgorithms
 */
public class DigestUtils {

	/**
	 * Returns a {@code MessageDigest} for the given {@code algorithm}.
	 *
	 * @param algorithm the name of the algorithm requested. See <a href=
	 *                  "http://docs.oracle.com/javase/6/docs/technotes/guides/security/crypto/CryptoSpec.html#AppA"
	 *                  >Appendix A in the Java Cryptography Architecture Reference
	 *                  Guide</a> for information about standard algorithm names.
	 * @return A digest instance.
	 * @see MessageDigest#getInstance(String)
	 * @throws IllegalArgumentException when a {@link NoSuchAlgorithmException} is
	 *                                  caught.
	 */
	public static MessageDigest getDigest(final String algorithm) {
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (final NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Returns an MD5 MessageDigest.
	 *
	 * @return An MD5 digest instance.
	 * @throws IllegalArgumentException when a {@link NoSuchAlgorithmException} is
	 *                                  caught, which should never happen because
	 *                                  MD5 is a built-in algorithm
	 * @see MessageDigestAlgorithms#MD5
	 */
	public static MessageDigest getMd5Digest() {
		return getDigest("MD5");
	}

}