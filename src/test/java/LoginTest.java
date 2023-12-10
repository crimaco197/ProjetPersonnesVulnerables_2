import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import javax.swing.*;
import org.Controller.CustomDialog;


import org.Views.Login;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.Window;

public class LoginTest {

    private Login loginFrame;
    private JOptionPane mockOptionPane;

    @Before
    public void setUp() {
        loginFrame = new Login();
        loginFrame.setVisible(false);
    }
    @After
    public void tearDown() {
        // Fermer la frame après chaque test
        loginFrame.dispose();
    }

    @Test
    public void testSuccessfulLogin() {
        // Simuler la saisie d'un email et d'un mot de passe corrects
        loginFrame.getEmail().setText("laveramor@gmail.com");
        loginFrame.getPasswordfield().setText("ComoAsi123");

        // Appeler la méthode qui traite le bouton de connexion
        loginFrame.getButlogin().doClick();

        // Vérifier que la fenêtre VHelprequest est ouverte après la connexion réussie
        assertTrue(loginFrame.isLoginSuccessful());
    }

    @Test
    public void testFailedLoginEmptyFields() {
        // Laisser les champs email et mot de passe vides
        loginFrame.getEmail().setText("");
        loginFrame.getPasswordfield().setText("");

        // Cliquer sur le bouton de connexion
        loginFrame.getButlogin().doClick();
        assertEquals("All fields must be filled out.", loginFrame.getRrromsg());


    }



    @Test
    public void testFailedLoginIncorrectCredentials() {
        // Saisir un email valide mais un mot de passe incorrect
        loginFrame.getEmail().setText("user@example.com");
        loginFrame.getPasswordfield().setText("incorrectPassword");

        // Appeler la méthode qui traite le bouton de connexion
        loginFrame.getButlogin().doClick();

        // Vérifier que la boîte de dialogue d'erreur s'affiche avec le message "Incorrect email or password. Please try again."
        assertEquals("Incorrect email or password. Please try again.", loginFrame.getRrromsg());
    }

    @Test
    public void testTransitionToSignUp() {
        // Appeler la méthode qui traite le bouton "Sign Up"

        loginFrame.getButsignup().doClick();

        // Vérifier que la fenêtre SignUP est ouverte après avoir cliqué sur le bouton
        assertTrue(loginFrame.isSignUpButtonClicked());
    }
}
