import java.nio.file.Files;
import java.nio.file.Paths;

public class User {
  private String user_name;
  private String user_pwd;
  private String file_ = "path/gonna_update_later";

  public User(String name, String pwd, String file_) {

    this.user_name = name;
    this.user_pwd = pwd;
    this.file_ = file_;
  }

  public String get_user_name() {
    return user_name;
  }

  public String get_user_pwd() {
    return user_pwd;
  }

  public String get_file_path() {
    return file_;
  }
}
