package frames;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.io.IOException;

public class Resuables {
    public Font robotoFont;
    public Border borderd;
    public Border roundborder;


    Resuables() throws IOException, FontFormatException {
        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));

        borderd= BorderFactory.createLineBorder(new Color(201, 235, 240), 1, true);
        roundborder= new RoundedBorder(10);


    }

    public Border  gettextfieldborder() {
        return roundborder;
    }
   public Font getFont(){
        return robotoFont;
    }

    public Dimension getfieldDimension(){
        return  new Dimension(110,30);
    }
    public Color getfieldColor(){
        return  new Color(201, 235, 240);
    }

    public Color getBackColor1(){
        return new Color(227, 227, 227);
    }
    public Color getpanalcolor(){
        return new Color(227, 227, 227);

    }
    public void  Field(JTextField fieldt){
        fieldt.setFont(robotoFont.deriveFont(Font.BOLD,13f));
        fieldt.setBorder(gettextfieldborder());
        fieldt.setBackground(getpanalcolor());
        fieldt.setPreferredSize(new Dimension(230,30));
    }
    public void  combo(JComboBox fieldt){
        fieldt.setFont(robotoFont.deriveFont(Font.BOLD,13f));
   //     fieldt.setBorder(gettextfieldborder());
        fieldt.setBackground(getpanalcolor());
        fieldt.setPreferredSize(new Dimension(230,40));
    }



    public void  lables(JLabel fieldt,Color c){
        fieldt.setFont(robotoFont.deriveFont(Font.BOLD,15f));
       fieldt.setForeground( c);
    }

    public void  lablesheader(JLabel fieldt,Color c){
        fieldt.setFont(robotoFont.deriveFont(Font.BOLD,20f));
        fieldt.setForeground( c);
    }




    public void buttdesign(JButton b){
        b.setBackground(Color.WHITE);
        b.setPreferredSize(new Dimension(130,30));
        b.setBorder(new RoundedBorder(20));

        b.setOpaque(false);
        b.setFocusPainted(false);
        b.setFont(new Font("Arial", Font.BOLD, 14));
    }




    public static class RoundedBorder implements Border {
        private final int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(new Color(134, 181, 189));
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }


}
