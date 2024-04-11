import java.util.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        String name;
        String pwd;
        String file_;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter username: ");
            name = sc.nextLine();

            if (!InputValidation.isValidUsername(name)) {
                throw new IllegalArgumentException(
                        "Invalid username: Username must be at least 5 and atmost 8 character long");
            }

            System.out.print("Enter password: ");
            pwd = sc.nextLine();

            if (!InputValidation.isValidPassword(pwd)) {
                throw new IllegalArgumentException(
                        "Invalid password: Password must be at least 5 and atmost 8 character long");
            }

            System.out.println("1. Encrypt File");
            System.out.println("2. Decrypt File");
            int ask = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter file name: ");

            file_ = sc.nextLine();
            Path path = Paths.get(file_);

            if (!(Files.exists(path))) {
                throw new IllegalArgumentException("File does not exist: " + file_);
            }

            User usr = new User(name, pwd, file_);
            HashString hashStr = new HashString(usr);

            Encryption enc = new Encryption(usr, hashStr);

            if (ask == 1) {
                enc.encrypt();
            } else {
                enc.decrypt();
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}