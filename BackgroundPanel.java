import javax.swing.*;
import java.awt.*;

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String backgroundImagePath) {
        // Load the background image
        backgroundImage = new ImageIcon(backgroundImagePath).getImage();

        // Set the preferred size to match the image size
        setPreferredSize(new Dimension(backgroundImage.getWidth(this), backgroundImage.getHeight(this)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

