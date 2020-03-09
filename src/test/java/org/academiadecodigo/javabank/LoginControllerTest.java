package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class LoginControllerTest {

    private LoginController loginController;
    private Controller nextController;
    private AuthService authService;
    private View view;

    @Before
    public void setup(){
        loginController = new LoginController();

        nextController = Mockito.mock(Controller.class);
        authService = Mockito.mock(AuthService.class);
        view = Mockito.mock(View.class);

        loginController.setNextController(nextController);
        loginController.setAuthService(authService);
        loginController.setView(view);

    }

    @Test
    public void onLoginPassTest(){
        int fakeId = 123;

        when(authService.authenticate(fakeId)).thenReturn(true);

        loginController.onLogin(fakeId);

        verify(authService).authenticate(fakeId);
        verify(view, never()).show();
        verify(nextController).init();
    }

    @Test
    public void onLoginFailTest(){
        int fakeId = 321;

        when(authService.authenticate(fakeId)).thenReturn(false);

        loginController.onLogin(fakeId);

        verify(authService).authenticate(fakeId);
        verify(view).show();
        verify(nextController, never()).init();
    }
}
