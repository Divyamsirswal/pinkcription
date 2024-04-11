import java.io.*;

public class Encryption {

    private final String key;
    private final String in_file;
    private final String out_file;

    public Encryption(User usr, HashString hashed) {
        this.key = hashed.getKey();
        this.in_file = usr.get_file_path();
        this.out_file = decide_ouputFile(usr.get_file_path());
    }

    private String decide_ouputFile(String filePath) {
        for(int i=filePath.length()-1; i>=0; i--) {
            if(filePath.charAt(i) == '\\') {
                return "enc-" + filePath.substring(i+1);
            }
        }
        return "encrypted.txt";
    }

    public String cypher(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = (char) (str.charAt(i) ^ key.charAt(i % key.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

    public void encrypt() {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(in_file));
            writer = new BufferedWriter(new FileWriter(out_file));

            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = cypher(line);
                writer.write(encryptedLine);
                writer.newLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decrypt(){
        encrypt();
    }
}
