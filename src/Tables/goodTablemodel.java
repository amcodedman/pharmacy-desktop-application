package Tables;

import ConnectorP.Performcollection;
import database.Drug;
import database.collections;


import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class goodTablemodel extends AbstractTableModel {


        Stack<Drug>product;
        collections DB=new collections();
        Performcollection C=new Performcollection();
        List<Drug> allp;

Drug g;
Performcollection controller=new Performcollection();

private String [] col={ "ID","CATEGORY","DRUG","DATE","EXPIRY DATE","QUANTITY","PURCHASE PER UNIT","SALE PRICE","GROSS PRICE","SUPPLIER"};
    @Override
    public String getColumnName(int column) {
        return col[column];
    }

    private static  int ac=0;
    private static  int sc=0;
    private static  int lc=0;

    @Override
    public int getRowCount() {

            return ac;

    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

    g=allp.get(rowIndex);




        switch(columnIndex){
            case 0:
                return g.getId();
            case 1:
                return g.getCategory();
            case 2:
                return g.getDrug();
            case 3:
                return dateform(g.getDate());

            case 4:
                return dateform(g.getDate()) ;
            case 5:
                return g.getQuant();
            case 6:
                return g.getUnit_price();
            case 7:
                return g.getSaleprice();
            case 8:
                return g.getGrossprice();
            case 9:
                try {
                    return   controller.getvendorstable().get(g.getSupplier());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


        }
        return null;
    }

    public void setp(List<Drug> product){
        this.allp=product;
        ac=this.allp.size();

    }



    public  String dateform(Date e){
        String ee=new SimpleDateFormat("YYYY/MM/dd").format(e);
        return ee;



    }


}
