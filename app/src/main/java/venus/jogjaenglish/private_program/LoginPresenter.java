package venus.jogjaenglish.private_program;

import venus.jogjaenglish.R;

/**
 * Created by adicatur on 4/20/17.
 */

public class LoginPresenter {
    private LoginView view;
    private LoginService service;

    public LoginPresenter(LoginView view, LoginService service) {
        this.view = view;
        this.service = service;
    }

    public void login() {
        String username = view.getUsername();
        String password = view.getPassword();
        if (username.isEmpty()){
            view.showUsernameError(R.string.error_username);
            return;
        }
        if (password.isEmpty()){
            view.showPasswordError(R.string.error_password);
            return;
        }

        boolean loginSucceded = service.login(username, password);

        if (loginSucceded){
            view.startActivity();
            return;
        }
        view.showInvalidLogging(R.string.error_login);
    }
}
