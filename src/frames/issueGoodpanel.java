package frames;

import ConnectorP.Performcollection;
import database.Drug;
import database.collections;

import database.sales_contractor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class issueGoodpanel extends JPanel {
    public Font robotoFont;
    public JLabel catl;

    public JLabel prodl;
    public JLabel datl;
    public JLabel quatl;
    public JLabel purchl;
    public  JOptionPane SHOW;
    public JLabel salel;
    public JLabel grossl;
    public JLabel grosSalel;
    public JTextField catname;
    public JTextField productn;
    public JTextField customer;
    public JLabel custname;
    public JTextField quatname;
    public JTextField total;
    public JLabel totall;
    public JTextField purchname;
    public JTextField salename;
    public JTextField grosname;
    public JTextField grosSalename;
    private String ID;
    private String cats;
    private Integer drugid;
    private String Produc;
    private String quant;
    private String pric;
    private String totp;
    private double grosp;
    public JButton buy;
    public JButton start;
    public JButton update;
    public  Resuables reus;
    private JPanel controls;
    DefaultTableModel model;
    private JTable table;
    List<Drug> Products;
    private collections DB=new collections();
    private JPanel lpanel;
    private JPanel rpanel;

    issueGoodpanel() throws Exception {
reus=new Resuables();
        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));

        DB=new collections();
        custname=new JLabel("Customer");
        customer=new JTextField();
        GridBagLayout newl=new GridBagLayout();
        BorderLayout newr=new BorderLayout();
lpanel=new JPanel(newl);
rpanel=new JPanel(newr);
        Performcollection control=new Performcollection();
        update=new JButton("Update");
        total=new JTextField(10);
        totall=new JLabel("Gross Price");
        catl=new JLabel("category");
        prodl=new JLabel("Product");
        quatl=new JLabel("Quantity");
        purchl=new JLabel("Price per unit");
        salel=new JLabel("total Price");
        start=new JButton("Refresh");

        quatname=new JTextField(10);
        purchname=new JTextField(10);
        salename=new JTextField(10);
        grosname=new JTextField(10);
        grosSalename=new JTextField(10);
        catname=new JTextField(10);
        productn=new JTextField(10);
        buy=new JButton(" Comfirm Purchase");

        model=new DefaultTableModel(0,0);
        GridBagLayout gbl=new GridBagLayout();


        model.addColumn( "ID");
        model.addColumn("CATEGOORY");
        model.addColumn("DRUG");
        model.addColumn("EXPIRY");
        model.addColumn("QUANTITY");
        model.addColumn("PRICE PER UNIT");
        model.addColumn("TOTAL PRICE");
        model.addColumn("SUPPLIERS");
        controls=new JPanel(gbl);
        table=new JTable(model);
        table.setDefaultRenderer(Object.class,new RoundedBorderTableCellRenderer());
        table.getTableHeader().setDefaultRenderer(new CustomTableHeaderRenderer());



        setLayout(new BorderLayout());
        add(lpanel,BorderLayout.PAGE_START);
        lpanel.setPreferredSize(new Dimension(1500,170));
lpanel.setBackground(new Color(211, 219, 214));
        JScrollPane spt=new JScrollPane(table);
        spt.setBorder(new EmptyBorder(30,20,20,30));

        add(rpanel,BorderLayout.CENTER);
        rpanel.add(spt,BorderLayout.CENTER);
        rpanel.   setBackground(new Color(211, 219, 214));
        GridBagConstraints gc=new GridBagConstraints();
        gc.gridx=0;
        gc.gridy=0;
      lpanel.add(prodl,gc);
        gc.gridx=1;
        lpanel.add(productn,gc);

        gc.gridx=2;
        lpanel.add(purchl,gc);
        gc.gridx=3;

        lpanel.add(purchname,gc);
        gc.gridx=4;

        lpanel.add(quatl,gc);
        gc.gridx=5;

       lpanel.add(quatname,gc);
        gc.gridy=2;
        gc.insets=new Insets(30,10,0,0);
        gc.gridx=0;
        lpanel.add(salel,gc);
        gc.gridx=1;

   lpanel.add(salename,gc);

        /** quantity*/


        gc.gridx=2;

        lpanel.add(custname,gc);


        gc.gridx=3;

        lpanel.add(customer,gc);

        salename.setEnabled(false);


        gc.gridx=4;



        lpanel.add(buy,gc);


        gc.gridx=5;
        lpanel.add(start,gc);
        buy.setPreferredSize(new Dimension(100,40));
reus.Field(productn);
        reus.Field(purchname);
        reus.Field(salename);
        reus.Field(catname);
        reus.Field(customer);
        reus.Field(quatname);
purchname.setEnabled(false);
ldesign(start);
ldesign(buy);

    

        setBackground(new Color(191, 220, 224));

/*** purchase*/

        DB.connect();
        DB.Load_data();

        for (Drug g: DB.Productlist) {
            try {
                model.addRow(new Object[] {
                        g.getId(),g.getCategory(),g.getDrug(),g.getExpiry(),
                        g.getQuant(),g.getUnit_price(),g.getSaleprice(),
                        control.getvendorstable().get(g.getSupplier())

                });
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
start.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            DB.connect();

model.setRowCount(0);
            DB.Productlist.clear();
            DB.Load_data();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        for (Drug g: DB.Productlist) {
            try {
                model.addRow(new Object[] {
                        g.getId(),g.getCategory(),g.getDrug(),g.getExpiry(),
                        g.getQuant(),g.getUnit_price(),g.getSaleprice(),
                        control.getvendorstable().get(g.getSupplier())

                });
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }


    }
});
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cato=catname.getText();
                String producto=productn.getText();
                int quantt=Integer.parseInt(quatname.getText());
                double u_p=Double.parseDouble(purchname.getText());
                double ttt=Double.parseDouble(salename.getText());
                int qty=Integer.parseInt(quant);
                int selqty=qty-quantt;
                String cust=customer.getText();
                String issuer="Admin";

                try {
                    DB.storesale(Integer.parseInt(ID),new sales_contractor(producto,cato,u_p,quantt,ttt,cust,issuer));
                        DB.connect();
                        System.out.println("result");
                        DB.saveToVsaleDate(selqty,Integer.parseInt(ID));

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    JOptionPane.showMessageDialog(null,productn.getText() +"with quantity "+quatname.getText() + "sold successfully");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        quatname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("workssss");
            }
        });
        quatname.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
System.out.println("working update");
            }
            public void removeUpdate(DocumentEvent e) {
                if(! quatname.getText().trim().isEmpty() && !purchname.getText().trim().isEmpty()) {
                    System.out.println("working must");
                    int a = Integer.parseInt(quatname.getText());
                    if (!purchname.getText().trim().isEmpty()) {

                        if (Integer.parseInt(quant) < a) {
                            JOptionPane.showMessageDialog(null, "Out of stock!! Available quantity is " + quant);
                            salename.setText("");

                        }
                        {

                            double b = Double.parseDouble(purchname.getText());
                            double c = a * b;
                            salename.setText(String.valueOf(c));
                        }

                    }
                }
                }
            public void insertUpdate(DocumentEvent e) {
                System.out.println("working insert");
                if(quatname.getText() !="" && purchname.getText() !=""){
                    System.out.println("working must");
                    int a= Integer.parseInt(quatname.getText());
                    if(! purchname.getText().trim().isEmpty()){
                        if(Integer.parseInt(quant) <a){
                            JOptionPane.showMessageDialog(null,"Out of stock!! Available quantity is "+quant);
                            salename.setText("");
                        }{

                            double  b=Double.parseDouble(purchname.getText());
                            double c=a*b;
                            salename.setText(String.valueOf(c));
                        }

                    }





                }
            }
        });


        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {


                JTable source = (JTable)evt.getSource();
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                String id=source.getModel().getValueAt(row,0)+"";
                String catt=source.getModel().getValueAt(row,1)+"";
                String prod=source.getModel().getValueAt(row,2)+"";
                String quants=source.getModel().getValueAt(row,4)+"";
                String p=source.getModel().getValueAt(row,5)+"";
                totp=source.getModel().getValueAt(row,6)+"";
                if (row >= 0 && col >= 0) {
                    ID= id;
                    cats=catt;
                    Produc=prod;
                    quant=quants;
                    pric=p;


                    catname.setText(catt);
                    productn.setText(Produc);
                    quatname.setText(quants);
                    purchname.setText(totp);



                }
            }
        });





    }
    private static class RoundedBorder implements Border {

        private int radius;


        RoundedBorder(int radius) {
            this.radius = radius;
        }


        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }


        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }

    }
    public  void design(JTextField p){
        p.setPreferredSize(new Dimension(400,30));
     p.setColumns(15);
    }
    public void ldesign(JButton b){
        b.setBackground(new Color(156, 121, 252));
        b.setPreferredSize(new Dimension(120,30));
        b.setBorder(new RoundedBorder(20));
        b.setOpaque(false);
        b.setFocusPainted(false);
    }











    private class RoundedBorderTableCellRenderer extends DefaultTableCellRenderer {

        private final Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        private final int borderRadius = 10;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


            setOpaque(true);
            setForeground(Color.DARK_GRAY);
            setBackground(new Color(211, 219, 214));
            setFont(robotoFont.deriveFont(Font.BOLD,12f));

            setHorizontalAlignment(CENTER);
            // Set the rounded border for the ce
            // ll renderer component
            ((JComponent) rendererComponent).setBorder(new EmptyBorder(5,5,5,5));

            return rendererComponent;
        }
    }



    private class CustomTableHeaderRenderer extends JLabel implements TableCellRenderer {

        public CustomTableHeaderRenderer() {
            setOpaque(true);
            setForeground(Color.WHITE);
            setBackground(Color.GRAY);
            setHorizontalAlignment(CENTER);
            setFont(robotoFont.deriveFont(Font.BOLD,13f));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }







}
