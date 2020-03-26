package executor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateLoadingScreen extends JFrame{
    public CreateLoadingScreen(){
        this.setSize(450,250);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setType(Type.POPUP);
//        
//        JPanel panel = new JPanel();
//        panel.setLayout(null);
//        this.add(panel);
        
        JLabel background = new JLabel(new ImageIcon("Image\\bg2.png"));
        background.setSize(450,250);
        this.add(background);
    }
}
