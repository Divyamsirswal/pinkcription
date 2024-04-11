import java.util.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        String name;
        String pwd;
        String file_;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\n\n-------Enter username--------\n");
            name = sc.nextLine();

            if (!InputValidation.isValidUsername(name)) {
                throw new IllegalArgumentException(
                        "\nInvalid username: Username must be at least 5 and atmost 8 character long");
            }

            System.out.print("\n\n-------Enter password--------\n");
            pwd = sc.nextLine();

            if (!InputValidation.isValidPassword(pwd)) {
                throw new IllegalArgumentException(
                        "\nInvalid password: Password must be at least 5 and atmost 8 character long");
            }
            System.out.println("\n------Please fill your choice-----");
            System.out.println("1. Encrypt File");
            System.out.println("2. Decrypt File");
            int ask = sc.nextInt();
            sc.nextLine();

            System.out.print("\n------> Enter file name <------\n");

            file_ = sc.nextLine();
            Path path = Paths.get(file_);

            if (!(Files.exists(path))) {
                throw new IllegalArgumentException("\n------ File does not exist !!!! ------ \n" + file_);
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