public class InputValidation {
  public static boolean isValidUsername(String username) {
    return username.length() >= 5 && username.length() <= 8;
  }

  public static boolean isValidPassword(String password) {
    return password.length() >= 5 && password.length() <= 8;
  }
}
