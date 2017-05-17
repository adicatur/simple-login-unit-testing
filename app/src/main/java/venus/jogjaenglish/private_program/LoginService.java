package venus.jogjaenglish.private_program;

/**
 * Created by adicatur on 4/20/17.
 */

public class LoginService {
    public boolean login(String username, String password){
        return username.equals("test") && password.equals("123");
    }
}
