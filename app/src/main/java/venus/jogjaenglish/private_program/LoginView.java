package venus.jogjaenglish.private_program;

/**
 * Created by adicatur on 4/20/17.
 */

public interface LoginView {
    String getUsername();

    void showUsernameError(int message);

    String getPassword();

    void showPasswordError(int message);

    void startActivity();

    void showInvalidLogging(int message);
}
