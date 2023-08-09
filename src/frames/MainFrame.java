package frames;

import ConnectorP.Performcollection;
import database.User;
import database.collections;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.Stack;

public class MainFrame extends JFrame implements MouseListener {
    public Stack<User> myuser;

    Resuables utils=new Resuables();
    ClassLoader cl= this.getClass().getClassLoader();
    URL dirr1=cl.getResource("frames/icons/timen.png");
    ImageIcon icon7=new ImageIcon(dirr1);
    Image minuss = icon7.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon stac=new ImageIcon(minuss);
    CardLayout card;
    JPanel pan;
    JPanel pan1;
    JPanel pan2;

    collections database;





    ShowProduces viewg;

    JLabel lb1;
    JLabel userf;
    JLabel userl;
    JLabel Dashbord;
    JLabel lb2;
    JLabel lb3;
    JLabel lb4;
    JLabel lb5;
    JLabel lb6;
    JLabel spacc;
    JLabel spacc1;
    Resuables resuables;
    JLabel spacc2;
    JLabel spacc3;
    JLabel spacc4;
    Border borderl;
    Border margin;
    JLabel issuer;
    public Stack<User> addlogs(Stack u){
        this.myuser=u;
        return myuser;
    }
    private Performcollection controller;
    MainFrame() throws Exception {
        super("Pharmacy Assistant Handcrafted by James Mensah");

        /**  ***********  IMPORT PAGES ****************************************************************/
resuables=new Resuables();
        ClassLoader cl = this.getClass().getClassLoader();
        URL dirr1 = cl.getResource("frames/icons/timen.png");
        ImageIcon icon7 = new ImageIcon(dirr1);
        Image minuss = icon7.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon uicon = new ImageIcon(minuss);

        database=new collections();
        Suppliers vendorp=new Suppliers();
        viewg=new ShowProduces();
        addStockProduct addgood=new addStockProduct(viewg);
        viewBill_p viewb=new viewBill_p();
        issueGoodpanel issueg=new issueGoodpanel();
        displaySold_p viewissueg=new displaySold_p();
      controller=new Performcollection();
        pan =new JPanel(   new FlowLayout(FlowLayout.CENTER));
        pan2 =new JPanel();
        card =new CardLayout();
        pan1 =new JPanel(card);
        /** label tabs*/
        spacc=new JLabel("           ");
        spacc1=new JLabel("           ");
        spacc2=new JLabel("           ");
        spacc3=new JLabel("           ");
        spacc4=new JLabel("           ");
        issuer=new JLabel("");
        issuer.setIcon(uicon);
userf=new JLabel("");
userl=new JLabel("");
        lb1=new JLabel("  My Suppliers",JLabel.LEFT);
        lb2=new JLabel("  Add new Product",JLabel.CENTER);
        lb3=new JLabel("   Product Details",JLabel.CENTER);
        lb5=new JLabel("  Sales Section",JLabel.CENTER);
        lb6=new JLabel("   Sale History",JLabel.CENTER);
        borderl=BorderFactory.createMatteBorder(1,1,1,1,new Color(204, 200, 207 ));
        margin = new EmptyBorder(10,10,10,10);
        lb1.addMouseListener(this);
        lb2.addMouseListener(this);
        lb3.addMouseListener(this);
        lb5.addMouseListener(this);
        lb6.addMouseListener(this);
        lb1.setForeground(Color.WHITE);
        lb1.setBorder( new CompoundBorder(borderl,margin));
        lb2.setForeground(Color.WHITE);
        lb3.setForeground(Color.WHITE);
        lb5.setForeground(Color.WHITE);
        lb6.setForeground(Color.WHITE);
        setLayout(new BorderLayout());

        pan.add(lb1);
        pan.add(spacc);
        pan.add(spacc);
        pan.add(spacc);

        pan.add(lb2);
        pan.add(spacc1);
        pan.add(spacc);

        pan.add(lb3);
        pan.add(spacc2);
        pan.add(spacc);

        /** // pan.add(lb4);
       pan.add(spacc3);*/

        pan.add(lb5);
        pan.add(spacc4);
        pan.add(spacc);

        pan.add(lb6);

        pan.setBackground(utils.getpanalcolor());


        add(pan,BorderLayout.PAGE_START);
        pan1.add(vendorp,"pan2");

        pan1.add(addgood,"pan3");
        pan1.add(viewg,"pan4");
        pan1.add(viewb,"pan5");
        pan1.add(issueg,"pan6");
        pan1.add(viewissueg,"pan7");




        add(pan1,BorderLayout.CENTER);
        setIconImage(stac.getImage());

        resuables.lables(lb1,new Color(106, 0, 133));
        resuables.lables(lb2,new Color(106, 0, 133));
        resuables.lables(lb3,new Color(106, 0, 133));

        resuables.lables(lb5,new Color(106, 0, 133));
        resuables.lables(lb6,new Color(106, 0, 133));
userf.setForeground(Color.white);
        userl.setForeground(Color.white);


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==lb1){
            lb1.setBorder(new CompoundBorder(borderl,margin));
            lb1.setForeground(new Color(92, 75, 105));
            lb2.setForeground(new Color(106, 0, 133));
            lb3.setForeground(new Color(106, 0, 133));
            lb5.setForeground(new Color(106, 0, 133));
            lb6.setForeground(new Color(106, 0, 133));

            lb2.setBorder(margin);
            lb3.setBorder(margin);

            lb5.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan2");




        }

        else if(e.getSource()==lb2){
            lb2.setBorder(new CompoundBorder(borderl,margin));
            lb2.setForeground(new Color(92, 75, 105));
            lb1.setForeground(new Color(106, 0, 133));
            lb3.setForeground(new Color(106, 0, 133));
            lb5.setForeground(new Color(106, 0, 133));
            lb6.setForeground(new Color(106, 0, 133));
            lb1.setBorder(margin);
            lb3.setBorder(margin);
            lb5.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan3");

        }
        else if(e.getSource()==lb3){
            lb3.setBorder(new CompoundBorder(borderl,margin));
            lb3.setForeground(new Color(92, 75, 105));
            lb1.setForeground(new Color(106, 0, 133));
            lb2.setForeground(new Color(106, 0, 133));
            lb5.setForeground(new Color(106, 0, 133));
            lb6.setForeground(new Color(106, 0, 133));
            try {
                controller.connect();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            try {

                controller.load();
                    viewg.setp(controller.getall());
                viewg.refresh();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }



            lb2.setBorder(margin);
            lb1.setBorder(margin);

            lb5.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan4");
        }

        else if(e.getSource()==lb5){
            lb1.setForeground(new Color(106, 0, 133));
            lb3.setForeground(new Color(106, 0, 133));
            lb2.setForeground(new Color(106, 0, 133));
            lb6.setForeground(new Color(106, 0, 133));
            lb5.setForeground(new Color(92, 75, 105));
            lb5.setBorder(new CompoundBorder(borderl,margin));
            lb2.setBorder(margin);
            lb3.setBorder(margin);

            lb1.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan6");
        }
        else if(e.getSource()==lb6){
            lb1.setForeground(new Color(106, 0, 133));
            lb3.setForeground(new Color(106, 0, 133));
            lb5.setForeground(new Color(106, 0, 133));
            lb2.setForeground(new Color(106, 0, 133));
            lb6.setBorder(new CompoundBorder(borderl,margin));
            lb6.setForeground(new Color(92, 75, 105));

            lb2.setBorder(margin);
            lb3.setBorder(margin);

            lb5.setBorder(margin);
            lb1.setBorder(margin);
            card.show(pan1,"pan7");

        }








    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void actions(){
        System.out.print("okkk");
        viewg.setBackground(Color.RED);
    }
}
