package database;


import java.sql.Date;

public class Drug {

    private  int count=0;
    private int Id;
    private int Supplier;
    private String Category;
    private String Drug;
    private  Date Date;
    private int Quant;
    private  Double Unit_price;
    private  Double Saleprice;
    private Double Grossprice;
    private Date expiry;

    public  Drug(String category, String drug, java.sql.Date date, java.sql.Date expiry, int quant, Double unitP, Double saleP, Double grossp, int supplier){
        this.Category=category;
       this.Drug=drug;
        this.Grossprice=grossp;
        this.Quant=quant;
        this.Unit_price=unitP;
        this.Supplier=supplier;
        this.expiry=expiry;
        this.Id=count;
        this.Date=date;
        count++;

        this.Saleprice=saleP;



    }
    public  Drug(int id,String category,String drug,Date date,Date expiry,int quant,Double unit_p,Double sale_p,Double grossp,int supplier){
        this(category,drug,date,expiry,quant,unit_p, sale_p, grossp, supplier);
        this.Id=id;
        this.Saleprice=sale_p;



    }




    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getSupplier() {
        return Supplier;
    }

    public void setSupplier(int supplier) {
         Supplier=supplier;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDrug() {
        return Drug;
    }

    public void setGood(String good) {
        Drug = good;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }
    public java.util.Date getExpiry() {
        return expiry;
    }

    public void setExpiry(java.sql.Date date) {
        expiry = date;
    }

    public int getQuant() {
        return Quant;
    }

    public void setQuant(int quant) {
        Quant = quant;
    }

    public Double getUnit_price() {
        return Unit_price;
    }

    public void setUnit_price(Double unit_price) {
        Unit_price = unit_price;
    }

    public Double getSaleprice() {
        return Saleprice;
    }

    public void setSaleprice(Double saleprice) {
        Saleprice = saleprice;
    }

    public Double getGrossprice() {
        return Grossprice;
    }

    public void setGrossprice(Double grossprice) {
        Grossprice = grossprice;
    }



}
