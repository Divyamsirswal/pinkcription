import java.io.*;

public class EncryptionCustom {
    private String in_file;
    private String out_file;
    private final String key;

    public EncryptionCustom(User usr, HashString hash) {
        this.in_file = usr.get_file_path();
        this.key = hash.getKey();
        this.out_file = "enc-out.txt";
    }

    public void encrypt() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.in_file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(this.out_file))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Pad the line if its length is less than 64 characters
                if (line.length() < 64) {
                    line = String.format("%-64s", line);
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char plainChar = line.charAt(i);
                    char keyChar = key.charAt(i % key.length());
                    char cipherChar = (char) (plainChar ^ keyChar);
                    sb.append(cipherChar);
                }

                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decrypt() {
        this.in_file = "enc-out.txt";
        this.out_file = "output-2.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(this.in_file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(this.out_file))) {

            String line;
            while ((line = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char cipherChar = line.charAt(i);
                    char keyChar = key.charAt(i % key.length());
                    char plainChar = (char) (cipherChar ^ keyChar);
                    sb.append(plainChar);
                }

                // Trim any padding from the decrypted line
                String decryptedLine = sb.toString().trim();
                bw.write(decryptedLine);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
