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
				throw new IllegalArgumentException("Invalid username: Username must be at least 5 and atmost 8 character long");
			}

			System.out.print("Enter password: ");
			pwd = sc.nextLine();

			if (!InputValidation.isValidPassword(pwd)) {
				throw new IllegalArgumentException(
						"Invalid password: Password must be at least 8 and atmost 14 character long");
			}

			System.out.print("Enter file name: ");

			file_ = sc.nextLine();
			Path path = Paths.get(file_);

			if (!(Files.exists(path))) {
				throw new IllegalArgumentException("File does not exist: " + file_);
			}

			User myLove = new User(name, pwd, file_);

			System.out.println(myLove.get_user_name());
			System.out.println(myLove.get_user_pwd());
			System.out.println(myLove.get_file_path());

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
