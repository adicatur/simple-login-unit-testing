package venus.jogjaenglish.private_program;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import venus.jogjaenglish.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter loginPresenter;
    private EditText usernameView;
    private EditText userpasswordView;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameView = (EditText) findViewById(R.id.et_username);
        userpasswordView = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        loginPresenter = new LoginPresenter(this, new LoginService());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login();
            }
        });
    }


    @Override
    public String getUsername() {
        return usernameView.getText().toString();
    }

    @Override
    public void showUsernameError(int message) {
        usernameView.setError(getString(message));
    }

    @Override
    public String getPassword() {
        return userpasswordView.getText().toString();
    }

    @Override
    public void showPasswordError(int message) {
        userpasswordView.setError(getString(message));
    }

    @Override
    public void startActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void showInvalidLogging(int message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
