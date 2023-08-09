package frames;

import ConnectorP.Performcollection;
import Tables.goodTablemodel;
import database.collections;
import database.Drug;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class ShowProduces extends JPanel implements ActionListener {
    ClassLoader cl= this.getClass().getClassLoader();
   
    URL dir=cl.getResource("frames/icons/Refresh.png");
    ImageIcon icon8=new ImageIcon(dir);
    Image refresh = icon8.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon refff=new ImageIcon(refresh);

  
    public goodTablemodel model;
    JTable table;
    
   
    JButton queuetab;
    JButton refreshtab;
    JButton  popbtn;
    JButton peektbn;
    JButton qpeektbn;
    JButton qremovetbn;
    JPanel TopPanel;
    JPanel optionpanel;
    JLabel qcount;
    JPanel Tablep;
    public Font robotoFont;
    JLabel Totalproduct;
    JButton lremovetbn;
JLabel listrl;
    GridBagLayout fl=new GridBagLayout();
    JPanel Action_tabs;
    Border newborder;
    JRadioButton ascen;
    Border margin;
    JButton collection;
    JButton searcsort;
    JComboBox searchbox;
    DefaultComboBoxModel bb;
    JLabel searchl;
    JRadioButton des;
JLabel filter;

JTextField listr;
Resuables utils;
    private Performcollection control;
    collections db=new collections();
    ShowProduces() throws Exception {
        utils=new Resuables();
        qcount=new JLabel("N/A");
        Totalproduct=new JLabel("total products");
        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));
        listr=new JTextField(5);
        listrl=new JLabel(" Find by ID");
        /*******************  JPANELS *****************************************************************/
        BorderLayout newb=new BorderLayout();
        filter=new JLabel("Order Product By");
        BorderLayout Tablelayout=new BorderLayout();
        Tablep=new JPanel(Tablelayout);
        TopPanel=new JPanel(newb);
        Action_tabs=new JPanel(fl);
        GridBagLayout op=new GridBagLayout();
        optionpanel=new JPanel(op);
        optionpanel.setBackground(new Color(201, 235, 240));
        optionpanel.setPreferredSize(new Dimension(300,50));
       
        TopPanel.add(Action_tabs,BorderLayout.CENTER);
      
        searchbox=new JComboBox();
        searchbox.setPreferredSize(new Dimension(140,40));
        searchl=new JLabel("Filter By Vendors");
        searcsort=new JButton("Find");
        collection=new JButton("Collection");
        ascen = new JRadioButton("ascending");
        ascen.setMnemonic(KeyEvent.VK_B);
        ascen.setActionCommand("ascending");
        ascen.setSelected(true);
        des = new JRadioButton("decending");
        ascen.setMnemonic(KeyEvent.VK_C);
        ascen.setActionCommand("decending");
        ButtonGroup bg=new ButtonGroup();
        bg.add(ascen);
        bg.add(des);
        control=new Performcollection();
    
        queuetab=new JButton("Sort by Queue");
      
        refreshtab=new JButton("Refresh");
        newborder=BorderFactory.createTitledBorder("Actions Controls");
        margin=new EmptyBorder(10,0,10,0);






/***** action perform button **/
        popbtn=new JButton("Pop");
         peektbn=new JButton("Peek");
        qpeektbn=new JButton("Peek");
         qremovetbn=new JButton("Remove");
        lremovetbn=new JButton("Remove");


setLayout(new BorderLayout());
GridBagLayout   gd=new GridBagLayout();
        model=new goodTablemodel();
        table=new JTable(model);

        table.setDefaultRenderer(Object.class,new RoundedBorderTableCellRenderer());
        table.getTableHeader().setDefaultRenderer(new CustomTableHeaderRenderer());



            Border bd=new EmptyBorder(15,15,15,15);
            table.setBorder(bd);
            JScrollPane ScrollTable=new JScrollPane(table);
            ScrollTable.setBorder(bd);
        ScrollTable.setBackground(new Color(191, 220, 224));


        add(TopPanel,BorderLayout.PAGE_START);


        /**                         Layout for Action Action_tabs          ***/


        utils.buttdesign(refreshtab);
        utils.buttdesign(lremovetbn);
        buttondesign(queuetab);
bb=new DefaultComboBoxModel();

        Performcollection controller=new Performcollection();
        controller.loadname();
        for(Map.Entry<String, Integer>e:controller.getvendorsid().entrySet()){
            bb.addElement(e.getKey().trim());


        }
        searchbox.setModel(bb);


Action_tabs.setBackground(new Color(211, 219, 214));


des.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            control.connect();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        try {
            control.load_d();

            setp(control.load_d());
            refresh();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
});
        ascen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    control.connect();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    control.load_a();

                    setp(control.load_a());
                    refresh();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });






/************************* Searching action *******************************************************/






searchbox.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedcat=(String) searchbox.getSelectedItem();
        try {
            control.connect();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        try {
            control.getFilterg().clear();
            control.load();
            control.performfilter(controller.getvendorsid().get(selectedcat));
          //  db.FilterProduct(selectedcat);

            setp(control.getFilterg());
            refresh();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
});


/**************** LAYOUT DESIGN**************************/


GridBagConstraints opl=new GridBagConstraints();
opl.gridy=0;
opl.gridx=0;
optionpanel.add(collection,opl);
opl.gridy=6;



        buttdesign(searcsort);
        buttdesign(collection);

        GridBagConstraints tg=new GridBagConstraints();
        tg.insets=new Insets(5,30,0,0);
        tg.gridx=1;

        Action_tabs.add(searchl,tg);
        tg.gridy=1;
        Action_tabs.add(searchbox);
        tg.gridx=3;
        tg.gridy=0;
        Action_tabs.add(filter,tg);
        tg.gridx=5;
        Action_tabs.add(ascen,tg);
        tg.gridy=0;
        tg.gridx=6;
        Action_tabs.add(des,tg);

        tg.gridx=0;
        tg.gridy=0;
        tg.anchor=GridBagConstraints.LINE_START;
        Action_tabs.add(refreshtab,tg);
refreshtab.addActionListener(this);
        tg.gridx=1;
      
      tg.gridy=1;
      

        queuetab.addActionListener(this);

        tg.gridx=2;
        tg.gridy=5;

        Action_tabs.add(popbtn,tg);
        tg.gridx=1;

        tg.gridx=5;
        tg.gridy=0;


        tg.gridx=9;
        Action_tabs.add(listrl,tg);
        tg.gridy=0;
tg.gridx=10;
Action_tabs.add(listr,tg);
        tg.gridx=11;
        Action_tabs.add(lremovetbn,tg);



buttonp(peektbn);
        buttonp(popbtn);
        buttonp(qpeektbn);
        buttonp(qremovetbn);


        popbtn.setVisible(false);
        peektbn.setVisible(false);


        qpeektbn.setVisible(false);
        qremovetbn.setVisible(false);


/******           tab end                                          ***/
collection.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {


    }
});

Action_tabs.setPreferredSize(new Dimension(100,200));
Tablep.add(ScrollTable,BorderLayout.CENTER);
        add(Tablep,BorderLayout.CENTER);
lremovetbn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int index=Integer.parseInt(listr.getText());
        try {
            control.delectList(index);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null ,"ERROR '"+ex+"'");
            throw new RuntimeException(ex);
        }

        try {
            control.load();
            JOptionPane.showMessageDialog(null ,"list Item with index'"+index+"'");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        refresh();

        setp(control.getall());

    }
});
popbtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            control.delectStack();

            control.load();
            setp(control.getall());
            refresh();
            JOptionPane.showMessageDialog(null ,"Stack item remove");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null ,"ERROR'"+ex+"'");
            throw new RuntimeException(ex);
        }
    }
});
    }


    public void setp(List<Drug> p){
        model.setp(p);
    }

    public void refresh(){

        model.fireTableDataChanged();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var btn=e.getSource();


Performcollection control=new Performcollection();
        try {
            control.connect();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        if(btn==refreshtab) {
                settype("ALL");
                try {
                    control.load();
                    qcount.setText(String.valueOf(control.getall().size()));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                setp(control.getall());
                refresh();

            }



    }

    private void settype(String all) {
    }

    /************remove  button acton ************************  *******/

    static class RoundedBorder implements Border {

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
    private void buttondesign(JButton b){

        b.setBackground(Color.WHITE);
        b.setPreferredSize(new Dimension(180,40));
       b.setBorder(new RoundedBorder(20));

        b.setOpaque(false);
       b.setFocusPainted(false);
       b.setBorderPainted(false);

       b.setFont(new Font("Arial", Font.BOLD, 14));
    }
    private void buttdesign(JButton b){

        b.setBackground(Color.WHITE);
        b.setPreferredSize(new Dimension(150,40));

        b.setBorder( new CompoundBorder(new EmptyBorder(5,0,5,0),new RoundedBorder(20)));

        b.setOpaque(false);
        b.setFocusPainted(false);


        b.setFont(robotoFont.deriveFont(Font.BOLD,14f));

    }
    private void buttonp(JButton b){
        b.setOpaque(false);
        b.setBackground(new Color(139, 138, 145));
        b.setForeground(Color.WHITE);
        b.setPreferredSize(new Dimension(100,40));
        b.setBorder(new RoundedBorder(20));
        b.setFocusPainted(false);
        b.setFont(new Font("Arial", Font.BOLD, 14));
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


