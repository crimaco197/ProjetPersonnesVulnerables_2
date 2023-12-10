import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


import org.Views.VHelprequest;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class VHelprequestTest {

    @Test
    public void testConstructor() {
        VHelprequest helpRequest = new VHelprequest("testUser");
        assertNotNull(helpRequest);
    }

    @Test
    public void testValidateInput() {
        VHelprequest helpRequest = new VHelprequest("testUser");
        helpRequest.getTextField_Tittle().setText("Test Title");
        helpRequest.getText_Description().setText("Test Description");
        helpRequest.getTextField_Date().setText("2023-12-10");
        helpRequest.getTextField_Status().setText("Test Status");

        try {
            helpRequest.ValiderActionPerformed(null);
            assertEquals("add succesfuly", helpRequest.getSuccess());

        } catch (Exception e) {
            fail("Validation failed: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidInput() throws SQLException, ClassNotFoundException {
        VHelprequest helpRequest = new VHelprequest("testUser");
        helpRequest.getTextField_Tittle().setText("");
        helpRequest.getText_Description().setText("Test Description");
        helpRequest.getTextField_Date().setText("2023-12-10");
        helpRequest.getTextField_Status().setText("Test Status");
            helpRequest.ValiderActionPerformed(null);
            assertEquals("Enter all data", helpRequest.getError());
    }

    @Test
    public void testloadData() {
        VHelprequest helpRequest = new VHelprequest("testUser");
        helpRequest.getBtn_show_table_data().doClick();
        // Assuming there is at least one row in the table
        //helpRequest.TableRequest.setRowSelectionInterval(0,0);

        // Simulate a mouse click on the table
        //helpRequest.jTable1MouseClicked(null);

        // Check if text fields are populated with the correct values
        assertEquals(" data loaded", helpRequest.getSuccess());

    }
    @Test
    public void testloadDatas() {
        VHelprequest helpRequest = new VHelprequest("testUser");
        helpRequest.getBtn_show_table_data().doClick();
        // Assuming there is at least one row in the table
        helpRequest.TableRequest.setRowSelectionInterval(2,2);


        // Simulate a mouse click on the table
        helpRequest.jTable1MouseClicked(null);
        // Check if text fields are populated with the correct values
        assertEquals(" data loaded", helpRequest.getSuccess());
        assertEquals("request 3", helpRequest.getTextField_Tittle().getText());
        assertEquals("2023-12-10", helpRequest.getTextField_Date().getText());
        assertEquals("assigned", helpRequest.getTextField_Status().getText());
        assertEquals("hr3 description", helpRequest.getText_Description().getText());
    }


    @Test
    public void testMultiselection() {
        VHelprequest helpRequest = new VHelprequest("testUser");
        helpRequest.getBtn_show_table_data().doClick();
        // Assuming there is at least one row in the table
        helpRequest.TableRequest.setRowSelectionInterval(1, 4);


        // Simulate a mouse click on the table
        helpRequest.jTable1MouseClicked(null);


        try {
            helpRequest.btnupdateActionPerformed(null);
            assertEquals("Please select Single Row for update", helpRequest.getError());


        } catch (Exception ignored) {

        }
    }
}
