import java.util.regex.*;

public class InputValidation {
  private static final String valid_user_name = "^[a-zA-Z0-9_-]{5,8}$";
  private static final String valid_user_pwd = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{5,8}$";

  public static boolean isValidUsername(String username) {
    return Pattern.matches(valid_user_name, username);
  }

  public static boolean isValidPassword(String password) {
    return Pattern.matches(valid_user_pwd, password);
  }

}
