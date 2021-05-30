package com.todo1.hulkstore.util;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AesUtil {

  private static final String CIPHER_ALGORITHM = "AES/GCM/NoPadding";
  
  private AesUtil() {}

  /**
   * Encrypt a text.
   *
   * @return A String with the text encripted.
   */
  public static String encryptString(String input, SecretKey key)
      throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
          InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, key);
    byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
    byte[] cipherText = cipher.doFinal(inputBytes);
    byte[] iv = cipher.getIV();
    byte[] message = new byte[12 + inputBytes.length + 16];
    System.arraycopy(iv, 0, message, 0, 12);
    System.arraycopy(cipherText, 0, message, 12, cipherText.length);
    return Base64.getEncoder()
        .encodeToString(message);
  }

  /**
   * Decrypt a text.
   *
   * @return A String with the text decripted.
   */
  public static String decryptString(String cipherText, SecretKey secretKey)
      throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
          InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
    byte[] encryptedText = Base64.getDecoder().decode(cipherText);
    GCMParameterSpec params = new GCMParameterSpec(128, encryptedText, 0, 12);
    cipher.init(Cipher.DECRYPT_MODE, secretKey, params);
    byte[] plainText = cipher.doFinal(encryptedText, 12, encryptedText.length - 12);
    return new String(plainText,StandardCharsets.UTF_8);
  }

  /**
   * Generate a SecretKey with a defined key size.
   *
   * @return A new SecretKey.
   */
  public static SecretKey generateSecretKey() throws NoSuchAlgorithmException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(KeySize.AES128.getValue());
    return keyGenerator.generateKey();
  }

  /**
   * Generate a SecretKey generated with a specific password and salt.
   *
   * @return A new SecretKey.
   */
  public static SecretKey getSecretKeyFromPassword(String password, String salt)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(StandardCharsets.UTF_8), 65536, 256);
    return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
  }

}
