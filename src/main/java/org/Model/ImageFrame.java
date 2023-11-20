/*package org.Model;

import javax.swing.*;
import java.awt.*;

public class ImageFrame extends JFrame {

    public ImageFrame() {
        // Establece el título del JFrame
        setTitle("Ejemplo de Imagen en JFrame");

        // Crea un ImageIcon desde una ruta de archivo
        ImageIcon imageIcon = new ImageIcon("/images/healthcare.png"); // reemplaza con la ruta de tu imagen

        // Ajusta la imagen al tamaño que deseas
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back

        // Crea un JLabel y establece su icono a ImageIcon
        JLabel label = new JLabel(imageIcon);

        // Agrega el JLabel al JFrame
        add(label);

        // Ajusta el tamaño del JFrame basado en el contenido
        pack();

        // Establece la operación de cierre por defecto
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Hace el JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageIcon icon = new ImageIcon(ImageFrame.class.getResource("/images/healthcare.png"));
            JLabel label = new JLabel(icon);
            frame.add(label);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
*/

