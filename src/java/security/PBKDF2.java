package pt.ubi.di.security.model;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import security.SecurityUtil;


public class PBKDF2 {

    /**
     * @param password   String password from which a derived key is generated
     * @param iterations int number of iterations (recommended values: 4096, 2000, 10000, 5000 100000)
     * @param keyLength  int length of the generated key in bits (recommended: 512)
     * @return String representation of derived key generated
     * <p>
     * Examples of pseudorandom function for PBKDF2 include
     * HMAC with SHA-1, SHA-224, SHA-256, SHA-384, SHA-512
     */
    public static String hashPassword(String algorithm, String password, int iterations, int keyLength) {

        String salt = "123456789abcdef123456789abcdef"; // String cryptographic salt (recommended: at least 64 bits)
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = salt.getBytes();

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHMAC" + algorithm);
            PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, iterations, keyLength);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();


            return SecurityUtil.byteArrayToHex(res);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            System.out.println("The provided algorithm is not valid, check -help to more details");
            return "";
        }
    }


}
