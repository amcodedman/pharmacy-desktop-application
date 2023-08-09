package frames;

import ConnectorP.Performcollection;
import database.collections;
import database.supplier_constructor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;

public class Suppliers extends JPanel implements  ActionListener{
Resuables designl;
    public JLabel venl;
    public Font robotoFont;
    public JTextField product;
    public JTextField vencont;

    public JTextField vencom;


    JTable table;

    public JLabel logo;
    public JLabel cityla;
    public JTextField City;

    DefaultTableModel model;
    public JLabel venaddl;
    public collections DB;
    public JLabel vencontl;
    public JLabel vencoml;
    public JTextField vendor;
    public JTextField venadd;

    public JPanel display;






    public JButton addbtn;

    public JButton reloadbtn;



    private Performcollection control;
    public JPanel lpanel;
    public JPanel rpanel;
    public JTextField country;
    public   JLabel conl;


    public Suppliers() throws Exception {
        ClassLoader cl= this.getClass().getClassLoader();

designl=new Resuables();
        /*    fonts  **/

        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));

        country=new JTextField();
        conl=new JLabel("Country");
        City=new JTextField();
        model=new DefaultTableModel();

        collections DB=new collections();
        model=new DefaultTableModel(0,0);
        model.addColumn("ID");
        model.addColumn("NAME");
        model.addColumn("ADDRESS");
        model.addColumn("CONTACT");
        model.addColumn("COMPANY");
        model.addColumn("COUNTRY");
        model.addColumn("CITY");


        table=new JTable(model);

        table.setDefaultRenderer(Object.class,new RoundedBorderTableCellRenderer());
        table.getTableHeader().setDefaultRenderer(new CustomTableHeaderRenderer());
        table.setBorder(new RoundedBorder(20));

        refresh();

        URL dirr=cl.getResource("frames/icons/shop.png");
        ImageIcon icon6=new ImageIcon(dirr);
        Image adds = icon6.getImage().getScaledInstance(60 ,50, Image.SCALE_DEFAULT);
        ImageIcon log=new ImageIcon(adds);

        logo=new JLabel();
        logo.setIcon(log);
        addbtn=new JButton("Add");

        cityla=new JLabel("city");
        City=new JTextField();
        product=new JTextField();


        venadd=new JTextField();
        venaddl=new JLabel("Address");

        vendor=new JTextField();
        venl=new JLabel("Supplier name");
        vencoml=new JLabel("Company");
        vencom=new JTextField();
        vencont=new JTextField();
        vencontl=new JLabel("Contact no");

/** fonts **/
        venaddl.setFont(robotoFont.deriveFont(Font.BOLD,15f));
        cityla.setFont(robotoFont.deriveFont(Font.BOLD,15f));
        vencontl.setFont(robotoFont.deriveFont(Font.BOLD,15f));
        vencoml.setFont(robotoFont.deriveFont(Font.BOLD,15f));
        venl.setFont(robotoFont.deriveFont(Font.BOLD,15f));
        conl.setFont(robotoFont.deriveFont(Font.BOLD,15f));



        ldesign(addbtn);
        control=new Performcollection();
        GridBagLayout gb=new GridBagLayout();
        GridBagLayout tg=new GridBagLayout();
        rpanel=new JPanel(tg);
        lpanel=new JPanel(gb);
        BorderLayout bl=new BorderLayout();
        setLayout(bl);

        setBackground(new Color(211, 219, 214));

        BorderLayout tbl=new BorderLayout();


/**   adding Jpanels left and right   ----------------------------------------------------------------   */
        add(lpanel,BorderLayout.WEST);

        lpanel.setPreferredSize(new Dimension(300,300));
        add(rpanel,BorderLayout.CENTER);
       

        rpanel. setBackground(new Color(211, 219, 214));

        rpanel.setPreferredSize(new Dimension(880,500));


        lpanel.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10),new RoundedBorder(10)));
       


/**     ALIGNING LABLES IN LEFT PANEL---------------------------------------------------------------------*/

        GridBagConstraints gbl=new GridBagConstraints();
        gbl.anchor=GridBagConstraints.FIRST_LINE_START;


        gbl.gridy=7;
        lpanel.add(venl,gbl);
        gbl.gridy=8;
        lpanel.add(vendor,gbl);
        gbl.gridy=9;

        lpanel.add(venaddl,gbl);
        gbl.gridy=10;
        lpanel.add(venadd,gbl);
        gbl.gridy=11;

        lpanel.add(vencontl,gbl);
        gbl.gridy=12;
        lpanel.add(vencont,gbl);
        gbl.gridy=13;
        lpanel.add(vencoml,gbl);
        gbl.gridy=14;

        gbl.insets=new Insets(10,0,10,0);
        lpanel.add(vencom,gbl);

        gbl.gridy=15;

        gbl.insets=new Insets(10,0,0,0);
        lpanel.add(cityla,gbl);

        gbl.gridy=16;

        lpanel.add(City,gbl);
        gbl.insets=new Insets(0,0,0,0);
        gbl.gridy=17;
        lpanel.add(conl,gbl);
        gbl.gridy=18;
        gbl.insets=new Insets(10,0,10,0);
        lpanel.add(country,gbl);
        gbl.gridy=20;
        lpanel.add(addbtn,gbl);


/*** --------------------------------------------------------------------------------------------------------- */
        setBackground(new Color(211, 219, 214));

        designl.Field(venadd);
        designl.Field(vendor);
        designl.Field(vencom);
        designl.Field(vencont);
        designl.Field(City);
        designl.Field(country);
        designl.buttdesign(addbtn);


        lpanel.setOpaque(false);
        rpanel.setOpaque(false);


        lpanel.setForeground(new Color(170, 169, 176));
        rpanel.setForeground(new Color(170, 169, 176));

        rpanel.setLayout(tbl);
        DB.connect();
        DB.Load_data_v();
        model.setRowCount(0);
        for (Map.Entry<String, supplier_constructor> ind : DB.Getvendors().entrySet()) {
            model.addRow(new Object[]{ind.getValue().getId(), ind.getKey(),
                    ind.getValue().getAddress(), ind.getValue().getContact(), ind.getValue().getCompany(),
                    ind.getValue().getCountry(), ind.getValue().getTown()});
        }

/********** Actions *************************************************************/


        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                String address;
                int contact;
                String company;
                String count;
                String city;
                try {

                    name = vendor.getText().trim();
                    address = venadd.getText().trim();
                    contact = Integer.parseInt(vencont.getText());

                    company = vencom.getText().trim();
                    count= country.getText().trim();
                    city = City.getText();


                    Performcollection control = new Performcollection();
                    try {
                        control.connect();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    DB.Getvendors().clear();
                    DB.Addvendor(name, new supplier_constructor(address, company, contact, count, city));
                    try {
                        DB.connect();
                        DB.save_To_database_vendor();
                        DB.connect();
                        DB.Load_data_v();
                        model.setRowCount(0);
                        for (Map.Entry<String, supplier_constructor> ind : DB.Getvendors().entrySet()) {
                            model.addRow(new Object[]{ind.getValue().getId(), ind.getKey(),
                                    ind.getValue().getAddress(), ind.getValue().getContact(), ind.getValue().getCompany(),
                                    ind.getValue().getCountry(), ind.getValue().getTown()});
                        }


                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    for (Map.Entry<String, supplier_constructor> indes : DB.Getvendors().entrySet()) {

                    }
                } catch (
                        Exception ee
                ) {
                    JOptionPane.showMessageDialog(null, ee);
                }
            }

        });

        /***  RIGHT PANEL DESIGN TABLE  **/
        Border bd=new EmptyBorder(50,50,50,50);


        table.setBorder(bd);
        JScrollPane spt=new JScrollPane(table);
        spt.setBorder(bd);
        rpanel.add(spt,BorderLayout.CENTER);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("ok button working");
    }





    private class RoundedBorderTableCellRenderer extends DefaultTableCellRenderer {

        private final Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        private final int borderRadius = 10;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


            setOpaque(true);
            setForeground(new Color(57, 60, 61));
            setBackground(new Color(211, 219, 214));
            setFont(robotoFont.deriveFont(Font.BOLD,12f));

            setHorizontalAlignment(CENTER);
            // Set the rounded border for the ce
            // ll renderer component
            ((JComponent) rendererComponent).setBorder(BorderFactory.createEmptyBorder());

            return rendererComponent;
        }
    }



    private class CustomTableHeaderRenderer extends JLabel implements TableCellRenderer {

        public CustomTableHeaderRenderer() {
            setOpaque(true);
            setForeground(Color.WHITE);
            setBackground(Color.GRAY);
            setHorizontalAlignment(CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }
    public void design(JTextField P){
        P.setPreferredSize(new Dimension(230,30));
        Border borderd= BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(102, 237, 237));

        P.setBorder(borderd);
        P.setBackground(new Color(223, 242, 239));
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
    public void refresh(){
        model.fireTableDataChanged();

    }
    public void ldesign(JButton b){
        b.setBackground(new Color(156, 121, 252));
        b.setPreferredSize(new Dimension(220,30));
        b.setBorder(new RoundedBorder(20));
        b.setOpaque(false);
        b.setFocusPainted(false);
    }
}