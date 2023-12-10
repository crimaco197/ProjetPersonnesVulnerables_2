
import static org.junit.Assert.*;


import org.Views.*;
import org.Controller.*;
import org.assertj.core.error.ShouldBeFalse;
import org.junit.Before;
import org.junit.Test;
import org.Model.*;

import javax.swing.*;
import javax.swing.JOptionPane;

public class SignUPTest {

    private SignUP signUpFrame;

    @Before
    public void setUp() {
        signUpFrame = new SignUP();
        signUpFrame.setVisible(false);
    }



   /* @Test
    public void testSuccessfulSignUp() {
        // Input: Valid user information
        signUpFrame.getFirstname().setText("JoDcedhn");
        signUpFrame.getLastName().setText("DedeZe");
        signUpFrame.getEmail().setText("johE.doe@example.codm");
        signUpFrame.getPhone().setText("14Zdc25D590");
        signUpFrame.getPassword().setText("paZzdword123");

        // Trigger Sign Up button click
       signUpFrame.getButsign().doClick();
        assertEquals("You have signed up", signUpFrame.getMessi());



    }
*/
    @Test
    public void testEmptyFieldsErrorMessage() {
        // Laisser tous les champs vides et appeler la nouvelle méthode
        signUpFrame.getFirstname().setText("");
        signUpFrame.getLastName().setText("");
        signUpFrame.getEmail().setText("");
        signUpFrame.getPhone().setText("");
        signUpFrame.getPassword().setText("");

        // Trigger Sign Up button click
        signUpFrame.getButsign().doClick();


        // Assurer que le message d'erreur est correct
        assertEquals("All fields must be filled out.", signUpFrame.getMessi());
    }

    @Test
    public void testGetterMethods() {
        // Input: None
        // Expected Output: Verify that getter methods return the correct components
        assertNotNull(signUpFrame.getLastName());
        assertNotNull(signUpFrame.getFirstname());
        assertNotNull(signUpFrame.getEmail());
        assertNotNull(signUpFrame.getPassword());
        assertNotNull(signUpFrame.getPhone());
        assertNotNull(signUpFrame.getButsign());
    }

    // Add more tests as needed based on your specific requirements

    @Test
    public void testSignUpInitialization() {
        assertNotNull(signUpFrame);
    }

    @Test
    public void testGetLastName() {
        signUpFrame.getLastName().setText("Doe");
        assertEquals("Doe", signUpFrame.getLastName().getText());
    }

    @Test
    public void testGetFirstname() {
        signUpFrame.getFirstname().setText("John");
        assertEquals("John", signUpFrame.getFirstname().getText());
    }

    @Test
    public void testGetEmail() {
        signUpFrame.getEmail().setText("john.doe@example.com");
        assertEquals("john.doe@example.com", signUpFrame.getEmail().getText());
    }

    @Test
    public void testGetPassword() {
        signUpFrame.getPassword().setText("securePassword");
        assertEquals("securePassword", signUpFrame.getPassword().getText());
    }

    @Test
    public void testGetPhone() {
        signUpFrame.getPhone().setText("1234567890");
        assertEquals("1234567890", signUpFrame.getPhone().getText());
    }

    @Test
    public void testGetButsign() {
        assertNotNull(signUpFrame.getButsign());
    }

    @Test
    public void testTransitionTologin() {
        // Appeler la méthode qui traite le bouton "Sign Up"

        signUpFrame.getButlogin().doClick();

        // Vérifier que la fenêtre SignUP est ouverte après avoir cliqué sur le bouton
        assertTrue(signUpFrame.isSignUpButtonClicked());
    }
}

