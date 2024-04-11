import java.util.*;
import java.io.*;

public class InputValidation {
  private static final String valid_user_name = "^[a-zA-Z0-9_-]{5,8}$";
  private static final String valid_user_pwd = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{5,8}$";

  public static boolean isValidUsername(String username) {
    return Pattern.matches(USERNAME_REGEX, username);
  }

  public static boolean isValidPassword(String password) {
    return Pattern.matches(PASSWORD_REGEX, password);
  }

}
