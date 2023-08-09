package database;

import java.sql.Date;

public class sales_contractor {

    private int id;
    private String drug;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrug() {
        return drug;
    }

    public void setdrug(String product) {
        this.drug = product;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Double getPriceu() {
        return priceu;
    }

    public void setPriceu(Double priceu) {
        this.priceu = priceu;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCus() {
        return cus;
    }

    public void setCus(String cus) {
        this.cus = cus;
    }

    private String cat;
    private Double priceu;
    private  int qty;
    private double total;
    private String cus;
    private String issuer;

    public String getIssuer() {
        return issuer;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;
private  Integer drugid;
public Integer getDrugid(){
    return drugid;
}
    public sales_contractor(String product, String cat, Double price, int qty, double total, String cus,String issuer){

        this.id=id;
        this.drug=product;
        this.cat=cat;
        this.qty=qty;
        this.cus=cus;
        this.priceu=price;
        this.total=total;
        this.issuer=issuer;
        this.drugid=drugid;
    }
    public sales_contractor(int id, String product, String cat, Double price, int qty, double total, String cus,String issuer, Date date,Integer drugid){
        this.id=id;
        this.drug=product;
        this.cat=cat;
        this.qty=qty;
this.id=id;
this.date=date;
this.drugid=drugid;
        this.cus=cus;
        this.priceu=price;
        this.total=total;
        this.issuer=issuer;



    }




}
