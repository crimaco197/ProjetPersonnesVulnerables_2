package org.Controller;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomDialog extends JDialog {

    public CustomDialog(String message, String title, int durationInSeconds) {
        super(null, title, JDialog.DEFAULT_MODALITY_TYPE);

        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(label);

        // Configurer une minuterie pour fermer automatiquement la fenêtre après la durée spécifiée
        javax.swing.Timer timer = new javax.swing.Timer(durationInSeconds * 500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fermer la fenêtre après la durée spécifiée
            }
        });
        timer.setRepeats(false); // Ne se répète pas

        // Démarrer la minuterie
        timer.start();

        // Configurer la taille et la position de la fenêtre
        pack();
        setLocationRelativeTo(null);

        // Rendre visible
        setVisible(true);
    }
}
