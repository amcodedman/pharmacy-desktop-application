package frames;

import Tables.goodTablemodel;
import ConnectorP.Performcollection;
import database.Drug;
import database.collections;
import database.sales_contractor;


import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;


public class addStockProduct extends JPanel {
   public JComboBox combo1;
   public JTextField drugname;
   public JLabel drugnamel;
   public Font robotoFont;
   public JLabel catl;
   public JLabel prodl;
   public JLabel datl;
    DateTimeFormatter formatter;
    public JLabel expirylabel;
   public JFormattedTextField expiryfield;
   public JLabel quatl;
   public JLabel purchl;
   public JLabel salel;
   public JLabel grossl;
   public JLabel grosSalel;
   public JLabel addnamel;
   public Integer countday=0;
   public  Integer expenseprice=0;
   public Integer profilevale=0;
    public JFormattedTextField datename;
    public JTextField quatname;
    public JTextField purchname;
    public JTextField salename;
    public JTextField grosname;
    public JTextField grosSalename;
    public JButton savebtn;
    public JButton refrestbtn;
    public JButton addbtn;
    public JButton removebtn;
    public Color colorsave;
    public JLabel vendorl;
    Resuables design;


    public JComboBox vendorname;
    public collections DB;
    public int vendorids=0;


    DefaultComboBoxModel categorym;
    DefaultComboBoxModel  vendorllist;

    Font labelf;
    Dimension setdimension;
    Border borderd;
    Border borderfocus;
    MainFrame des;
    JLabel updateP;
    JLabel stocktoday;
    JLabel stocktodayn;
    JLabel stockall;
    JLabel stockalln;
   JLabel updateR;
   JLabel expenses;
    JLabel expensen;
   JLabel profilel;
    JLabel profilen;


private Performcollection controller;

private final ShowProduces viewGood_p;
    public addStockProduct(ShowProduces vg) throws Exception {
        design=new Resuables();
        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        updateP=new JLabel("Products in Stock");
stocktoday=new JLabel("Products added Today   :");
stocktodayn=new JLabel("N/A");
        stockall=new JLabel(" Total     Products    :");
        stockalln=new JLabel("N/A");





        updateR=new JLabel("Revenue and Expense");
        expenses=new JLabel("Today   Expenses:");
        expensen=new JLabel("N/A");
        profilel=new JLabel(" Expected Total    Revenue  :");
        profilen=new JLabel("N/A");
        ClassLoader cl= this.getClass().getClassLoader();
        URL dir=cl.getResource("frames/icons/Refresh.png");
        ImageIcon icon9=new ImageIcon(dir);
        Image refresh = icon9.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
        ImageIcon refff=new ImageIcon(refresh);
        controller=new Performcollection();
        controller.loadname();
        controller.addDefaultcate();

        viewGood_p=vg;
DB=new collections();


        URL dirr=cl.getResource("frames/icons/addd.png");
        ImageIcon icon6=new ImageIcon(dirr);
        Image adds = icon6.getImage().getScaledInstance(15 ,15, Image.SCALE_DEFAULT);
        ImageIcon ad=new ImageIcon(adds);

        URL dirr1=cl.getResource("frames/icons/minus.png");
        ImageIcon icon7=new ImageIcon(dirr1);
        Image minuss = icon7.getImage().getScaledInstance(15 ,15, Image.SCALE_DEFAULT);
        ImageIcon mi=new ImageIcon(minuss);

        URL dirr2=cl.getResource("frames/icons/save.png");
        ImageIcon icon8=new ImageIcon(dirr2);
        Image savedb = icon8.getImage().getScaledInstance(15 ,15, Image.SCALE_DEFAULT);
        ImageIcon sicon=new ImageIcon(savedb);
        borderd= BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(164, 165, 166));
        borderfocus= BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE);
        DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
        datename= new JFormattedTextField(dateFormat);
        datename.setValue(new Date());
        expiryfield=new JFormattedTextField(dateFormat);
        expiryfield.setValue(new Date());
        expirylabel=new JLabel("Expiry date");
        datename.setPreferredSize(new Dimension(100,50));
        setdimension=new Dimension(350,30);
        colorsave=new Color( 3, 98, 252);
        labelf=robotoFont.deriveFont(Font.BOLD,16f);
        setLayout(new GridBagLayout());
        vendorl=new JLabel("Vendor");
        vendorl.setFont(labelf);
        vendorl.setForeground(colorsave);
       catl=new JLabel("Category");
       catl.setFont(labelf);
       catl.setForeground(colorsave);
     prodl=new JLabel("Good Name");
        prodl.setFont(labelf);
        prodl.setForeground(colorsave);
     datl=new JLabel("Date");
        datl.setFont(labelf);
        datl.setForeground(colorsave);
       quatl=new JLabel("Quantity");
        quatl.setFont(labelf);
        quatl.setForeground(colorsave);
        purchl=new JLabel("Purchasing price per unit");
        purchl.setFont(labelf);
        purchl.setForeground(colorsave);
     salel=new JLabel("Selling Price");
        salel.setFont(labelf);
        salel.setForeground(colorsave);
         grossl=new JLabel("Gross Price");
        grossl.setFont(labelf);
        grossl.setForeground(colorsave);
     grosSalel=new JLabel("Gross Sales");
        grosSalel.setFont(labelf);
        grosSalel.setForeground(colorsave);
      addnamel=new JLabel("Add Good");
        addnamel.setFont(labelf);
        addnamel.setForeground(colorsave);
       refrestbtn=new JButton("Refresh");
        quatname=new JTextField(20);
        purchname=new JTextField(20);
        salename=new JTextField(20);
        grosname=new JTextField(20);
        grosSalename=new JTextField(20);
        grosSalename.setBorder(borderd);

       savebtn=new JButton("SAVE");
       purchname.setBorder(borderd);
       salename.setBorder(borderd);
       removebtn=new JButton("   Undo save");

       addbtn=new JButton("  ADD GOOD");
       savebtn.setBackground(colorsave);

        design.buttdesign(refrestbtn);
        design.buttdesign(addbtn);
        design.buttdesign(removebtn);
       removebtn.setBackground(new Color(92, 75, 105 ));
       addbtn.setBackground(new Color(92, 75, 105 ));

       removebtn.setForeground(new Color(92, 75, 105 ));
       addbtn.setForeground(new Color(92, 75, 105 ));


       addbtn.setPreferredSize(new Dimension(150,40));
       removebtn.setPreferredSize(new Dimension(150,40));
       savebtn.setPreferredSize(new Dimension(150,40));

/** input text helper  */

grosname.setFont(labelf);
setBorder(new EmptyBorder(0,5,0,5));
combo1=new JComboBox();
drugname=new JTextField(20);

drugnamel=new JLabel("Drug Name");
expiryfield.setBorder(borderd);
expiryfield.setFont(labelf);
expirylabel.setFont(labelf);
        drugname.setBorder(borderd);
       drugnamel.setFont(labelf);
        drugnamel.setForeground(colorsave);
combo1.setEditable(true);
vendorname=new JComboBox();
        vendorllist=new DefaultComboBoxModel();
        categorym=new DefaultComboBoxModel();
        expiryfield.setBorder(borderd);

controller.loadname();
for(Map.Entry<String, Integer>e:controller.getvendorsid().entrySet()){
            vendorllist.addElement(e.getKey().trim());


}


vendorname.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        vendorids= controller.getvendorsid().get((String) vendorname.getSelectedItem());
System.out.println(controller.getvendorsid());



    }
});
combo1.setModel(categorym);
        for(String n:controller.getCatelist()){
            categorym.addElement(n);
        }
vendorname.setModel(vendorllist);
        combo1.setPreferredSize(new Dimension(280,30));
        vendorname.setPreferredSize(new Dimension(280,30));
GridBagConstraints gc=new GridBagConstraints();
/**  vendor*/

        gc.gridx=4;
        gc.gridy=0;
        add(updateP,gc);
        design.lablesheader(updateP,new Color(42, 23, 255));
        gc.gridx=4;
        gc.gridy=1;
        add(stocktoday,gc);
        design.lables(stocktoday,new Color(54, 96, 247));
        gc.gridx=5;
        gc.gridy=1;
        add(stocktodayn,gc);
        design.lablesheader(stocktodayn,new Color(128, 22, 242));

        gc.gridx=4;
        gc.gridy=2;
        add(stockall,gc);
        design.lables(stockall,new Color(54, 96, 247));
        gc.gridx=5;
        gc.gridy=2;
        add(stockalln,gc);
        design.lablesheader(stockalln,new Color(128, 22, 242));


        gc.gridx=4;
        gc.gridy=5;
        add(updateR,gc);
        design.lablesheader(updateR,new Color(42, 23, 255));
        gc.gridx=4;
        gc.gridy=6;
        add(expenses,gc);
        design.lables(expenses,new Color(54, 96, 247));
        gc.gridx=5;
        gc.gridy=6;
        add(expensen,gc);
        design.lablesheader(expensen,new Color(128, 22, 242));

        gc.gridx=4;
        gc.gridy=7;
        add(profilel,gc);
        design.lables(profilel,new Color(54, 96, 247));
        gc.gridx=5;
        gc.gridy=7;
        add(profilen,gc);
        design.lablesheader(profilen,new Color(128, 22, 242));














gc.gridx=0;
gc.gridy=0;
gc.anchor=GridBagConstraints.FIRST_LINE_START;
gc.insets=new Insets(0,0,10,150);
add(vendorl,gc);

gc.gridy=1;
gc.anchor=GridBagConstraints.FIRST_LINE_START;
gc.insets=new Insets(0,0,30,150);
add(vendorname,gc);

/** category */
gc.gridy=2;
gc.insets=new Insets(0,0,10,0);

add(catl,gc);

gc.gridy=3;
gc.insets=new Insets(0,0,30,0);
add(combo1,gc);

/** good name */





gc.gridy=4;

gc.insets=new Insets(0,0,10,0);

add(drugnamel,gc);
gc.gridy=5;
add(drugname,gc);

        /** quantity*/
        gc.gridy=6;
        add(quatl,gc);
        gc.gridy=7;
        add(quatname,gc);
        /*** purchase*/
        gc.gridy=8;
        gc.insets=new Insets(0,0,0,100);
        add(purchl,gc);
        gc.gridy=9;
        gc.insets=new Insets(0,0,0,100);
        add(purchname,gc);



        /** sales  price */

        gc.gridy=0;
        gc.gridx=1;



        add(salel,gc);

        gc.gridy=1;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(salename,gc);


        /**  Gross price */

        gc.gridy=2;

        add(grossl,gc);



        gc.gridy=3;
        gc.insets=new Insets(0,0,0,0);
        add(grosname,gc);

/** date */

        gc.gridx=1;
        gc.gridy=4;

        add(datl,gc);

        /** datename */
        gc.gridy=5;
        add(datename,gc);








/*** expiry **/

        gc.gridy=6;

        gc.insets=new Insets(0,0,10,0);
        add(expirylabel,gc);



        gc.gridy=7;
        gc.insets=new Insets(0,0,0,0);
        add(expiryfield,gc);



/** add button */
        gc.gridy=11;
        gc.gridx=5;
        gc.insets=new Insets(0,0,0,0);

        add(addbtn,gc);
/**  remove button*/
        gc.gridx=4;
        gc.gridy=11;


        add(removebtn,gc);



        gc.gridx=3;
        gc.gridy=11;
        gc.insets=new Insets(0,-100,0,10);
        refrestbtn.setPreferredSize(new Dimension(145,40));
        add(refrestbtn,gc);

        /***   Updates ***/




        setBackground(new Color(211, 219, 214));



setcolor(quatname);
setcolor(drugname);
setcolor(datename);
setcolor(purchname);
setcolor(salename);
setcolor(grosname);
setcolor(grosSalename);
setcolor(expiryfield);
expirylabel.setFont(labelf);

design.Field(quatname);
        design.Field(quatname);
        design.Field(drugname);
        design.Field(datename);
        design.Field(purchname);
        design.Field(salename);
        design.Field(grosname);
        design.Field(grosSalename);
        design.Field(expiryfield);
        design.combo(vendorname);
        design.combo(combo1);

        /**      ADD BUTTOM LISTENERS*/

        removebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.delectStack();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Error"+ex);
                    throw new RuntimeException(ex);
                }
            }
        });
        refrestbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    controller.loadname();
                    vendorllist.removeAllElements();
                    categorym.removeAllElements();
                    controller.addDefaultcate();
                    controller.load();
                    stockalln.setText (String.valueOf(controller.getall().size()));


                    for(Map.Entry<String, Integer>ei:controller.getvendorsid().entrySet()){
                        vendorllist.addElement(ei.getKey());
                    }
                    for(String n:controller.getCatelist()){
                        categorym.addElement(n);
                    }


                    LocalDate currentDate = LocalDate.now();



countday=0;
                        for(Drug g:controller.getall()) {

                            if (g.getDate().toString().equals(currentDate.format(formatter))) {
                              countday=countday+1;
                            }

                        }

                        stocktodayn.setText(countday.toString());






                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        controller.load();
        expenseprice=0;
        profilevale=0;
        stockalln.setText (String.valueOf(controller.getall().size()));
        for(Drug g:controller.getall()) {
            if (g.getDate().toString().equals(LocalDate.now().format(formatter))) {
                countday=countday+1;

            }

            expenseprice= (int) (expenseprice + g.getQuant()*g.getGrossprice());
            profilevale= (int) (profilevale+  g.getQuant()*g.getSaleprice());

        }
        expensen.setText(" GHC "+String.valueOf(expenseprice));
        profilen.setText(" GHC "+String.valueOf(profilevale));

        stocktodayn.setText(countday.toString());
        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {


                    goodTablemodel gm=new goodTablemodel();
                    collections c=new collections();
                    Date dd=new Date(datename.getText());
                    Date expdfield=new Date(expiryfield.getText());
                    java.sql.Date newt= new java.sql.Date(dd.getTime());
                    java.sql.Date expd= new java.sql.Date(expdfield.getTime());
                    java.sql.Date expirydate=new java.sql.Date(expd.getTime());
                    int quatn= Integer.parseInt(quatname.getText().trim());
                    double purchn=Double.parseDouble(purchname.getText().trim());
                    double salena=Double.parseDouble(salename.getText().trim());
                    double  grosna=Double.parseDouble(grosname.getText().trim());
String drugtext=drugname.getText();

                    int vendorn=vendorids;
                    String catsel=(String) combo1.getSelectedItem();

                    int result = JOptionPane.showConfirmDialog(null, " click Yes to add to Stocks", "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.YES_OPTION) {

                        controller.getStacks().clear();

                        controller.adddrugstack(catsel,drugtext,newt,expirydate,quatn,purchn,salena,grosna,vendorn);
                        controller.connect();
                        controller.save_with_stack();
                            controller.load();

                        removebtn.setEnabled(true);

                    } else if (result == JOptionPane.NO_OPTION) {

JOptionPane.showMessageDialog(null,"Operation exit");


                    } else if (result == JOptionPane.CLOSED_OPTION) {
                        // User closed the dialog box
                        System.out.println("User closed the dialog box.");
                    }


                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: Field required " + ex.getMessage());
                    throw new RuntimeException(ex);
                }

                viewGood_p.setp(controller.getall());


            }






        });
    }

    /**  remove rows*/






    private void setcolor(JTextField p){
        p.setBackground(new Color(223, 242, 239));

    }
    private void buttdesign(JButton b){
        b.setBackground(Color.WHITE);
        b.setPreferredSize(new Dimension(180,60));
        b.setBorder(new ShowProduces.RoundedBorder(20));

        b.setOpaque(false);
        b.setFocusPainted(false);


        b.setFont(new Font("Arial", Font.BOLD, 14));
    }
}
