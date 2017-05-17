package venus.jogjaenglish.login;

/**
 * Created by adicatur on 4/20/17.
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import venus.jogjaenglish.R;
import venus.jogjaenglish.private_program.LoginPresenter;
import venus.jogjaenglish.private_program.LoginService;
import venus.jogjaenglish.private_program.LoginView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

    @Mock
    private LoginView view;
    @Mock
    private LoginService service;
    
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view, service);
    }

    @Test
    public void shouldShowErrorMessageWhenUsernameIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("");
        presenter.login();

        verify(view).showUsernameError(R.string.error_username);
    }

    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception {
        when(view.getUsername()).thenReturn("test");
        when(view.getPassword()).thenReturn("");
        presenter.login();

        verify(view).showPasswordError(R.string.error_password);
    }

    @Test
    public void startActityWhenUsernameAndPasswordAreCorrect() throws Exception {
        when(view.getUsername()).thenReturn("test");
        when(view.getPassword()).thenReturn("1234");
        when(service.login("test", "1234")).thenReturn(true);
        presenter.login();

        verify(view).startActivity();

    }

    @Test
    public void shouldShowLoginErrorWhenUsernameAndPasswordInvalid() throws Exception {
        when(view.getUsername()).thenReturn("test");
        when(view.getPassword()).thenReturn("1234");
        when(service.login("test", "1234")).thenReturn(false);
        presenter.login();

        verify(view).showInvalidLogging(R.string.error_login);
    }
}
