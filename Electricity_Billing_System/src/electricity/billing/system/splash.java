package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {
    splash(){

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/splash/Splash.jpg"));
        Image imageOne = img.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageOne);
        JLabel imagelable =new JLabel(imageIcon2);
        add(imagelable);


        setSize(400,400);
        setLocation(500,200);
        setVisible(true);

        try {
                Thread.sleep(5000);
                setVisible(false);

                new Login();


            }catch (Exception e){
            e.printStackTrace();
            }

    }
    public static void main(String[] args) {
        new splash();
    }

}
