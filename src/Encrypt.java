import java.io.*;
public class Encrypt {
    public void encryption(String key,String filename){
        modifyFile(filename,key);
    }
    public void modifyFile(String filename, String key) {
        // Read the content of the file
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error 102:"+e.getMessage());
            return;
        }
        int c;
        String newstr="";
        for(int i=0;i<content.length();i++)
        {
            c=content.charAt(i);
            String num=Integer.toString(c);
            StringBuilder revstr = new StringBuilder(num).reverse();
            int reverse=Integer.parseInt(revstr.toString());
            if(reverse>256)
                reverse=reverse%10;
            char ch=(char)reverse;
            newstr=newstr+ch;
        }
        //Modify the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(newstr);
        } catch (IOException e) {
            System.err.println("Error 103:"+e.getMessage());
        }
    }
}
