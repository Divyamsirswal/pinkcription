import java.security.MessageDigest;

public class HashString {

    public static String generateKey(String sample){
        MessageDigest md = null;
        StringBuilder sb = new StringBuilder();

        try{
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(sample.getBytes());

            for(byte b : hash){
                String s = Integer.toHexString(b & 0xff);
                if(s.length() == 1){
                    sb.append('0');
                }
                sb.append(s);
            }
        }
        catch (Exception e){
            System.err.println("Some Error Occured : (Code : 101)");
        }

        return sb.toString();
    }
}
