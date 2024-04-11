import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.MessageDigest;

public class Encryption {
    private final SecretKey key;
    private String in_file;
    private String out_file;

    public Encryption(User user, HashString hashString) {
        this.key = generateKey(hashString.getKey());
        this.in_file = user.get_file_path();
        this.out_file = "enc.txt";
    }

    private SecretKey generateKey(String keyStr) {
        byte[] keyBytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            keyBytes = md.digest(keyStr.getBytes());
        } catch (Exception e) {
            System.err.println("Error generating key");
        }
        return new SecretKeySpec(keyBytes, "AES");
    }

    public void encrypt() {
        try{
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, key);

            encDecFile(c);
        }
        catch (Exception e) {
            System.err.println("Error encrypting");
        }
    }

    public void decrypt() {
        try{
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, key);
            encDecFile(c);
        }
        catch (Exception e) {
            System.err.println("Error decrypting");
        }
    }

    private void encDecFile(Cipher cipher){
        try {
            FileInputStream inputStream = new FileInputStream(in_file);
            FileOutputStream outputStream = new FileOutputStream(out_file);

            byte[] buffer = new byte[64];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byte[] bytes = cipher.update(buffer, 0, bytesRead);
                if (bytes != null) {
                    outputStream.write(bytes);
                }
            }

            byte[] bytes = cipher.doFinal();
            if (bytes != null) {
                outputStream.write(bytes);
            }

            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            System.err.println("Error encryptin/decrypting");
        }
    }
}
