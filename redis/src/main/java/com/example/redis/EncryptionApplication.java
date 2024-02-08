package com.example.redis;


import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import java.util.Base64;
	
	public class EncryptionApplication {


//		 private static final String AES_SECRET_KEY = "mysecretkey";
//
//		    public static void main(String[] args) {
//		        String originalString = "Hello, world!";
//
//		        try {
//		            // Generate AES key
//		            SecretKey secretKey = generateAESKey(AES_SECRET_KEY);
//
//		            // Encrypt the string
//		            String encryptedString = encrypt(originalString, secretKey);
//		            System.out.println("Encrypted string: " + encryptedString);
//
//		            // Decrypt the string
//		            String decryptedString = decrypt(encryptedString, secretKey);
//		            System.out.println("Decrypted string: " + decryptedString);
//		        } catch (Exception e) {
//		            System.err.println("Error: " + e.getMessage());
//		        }
//		    }
//
//		    public static SecretKey generateAESKey(String secretKey) throws Exception {
//		        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//		        keyGenerator.init(128); // AES key length is 128 bits
//		        return keyGenerator.generateKey();
//		    }
//
//		    public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
//		        Cipher cipher = Cipher.getInstance("AES");
//		        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//
//		        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
//		        return Base64.getEncoder().encodeToString(encryptedBytes);
//		    }
//
//		    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {
//		        Cipher cipher = Cipher.getInstance("AES");
//		        cipher.init(Cipher.DECRYPT_MODE, secretKey);
//
//		        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
//		        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
//		        return new String(decryptedBytes, StandardCharsets.UTF_8);
//		    }
//	}

		 public static void main(String[] args) throws Exception {
		        // Generate a key pair (public key and private key)

		        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSARSA");

		        keyPairGenerator.initialize(2048); // Key size
		        KeyPair keyPair = keyPairGenerator.generateKeyPair();
		        PublicKey publicKey = keyPair.getPublic();
		        PrivateKey privateKey = keyPair.getPrivate();

		        // The string to be encrypted
		        String originalString = "Hello, World!";

		        // Encryption
		        byte[] encryptedBytes = encrypt(originalString, publicKey);

		        // Convert the encrypted bytes to a string
		        String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);

		        // Decryption
		        byte[] decryptedBytes = decrypt(encryptedBytes, privateKey);

		        // Convert the decrypted bytes to a string
		        String decryptedString = new String(decryptedBytes, StandardCharsets.UTF_8);

		        // Output
		        System.out.println("Original string: " + originalString);
		        System.out.println("Public Key: " + publicKey);
		        System.out.println("Encrypted string: " + encryptedString);
		        System.out.println("Decrypted string: " + decryptedString);
		    }

		    public static byte[] encrypt(String plainText, PublicKey publicKey) throws Exception {
		        Cipher cipher = Cipher.getInstance("RSA");
		        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		        return cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
		    }

		    public static byte[] decrypt(byte[] cipherText, PrivateKey privateKey) throws Exception {
		        Cipher cipher = Cipher.getInstance("RSA");
		        cipher.init(Cipher.DECRYPT_MODE, privateKey);
		        return cipher.doFinal(cipherText);
		    }
		}
