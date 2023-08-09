package ConnectorP;

import database.User;
import database.collections;
import database.Drug;
import database.sales_contractor;

import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Performcollection {
    private Drug stack_good;

    collections db=new collections();
public List<Drug>getall(){
        return db.Productlist;
}
    public Map<String,Integer> getvendorsid() {
       return  db.getvendorsname();
    }
    public Map<Integer,String> getvendorstable() throws Exception {
    db.connect();
    db.vendorname();

        return  db.getvendorsnids();
    }


    public void connect() throws Exception {
        db.connect();
}
public void performfilter(Integer a){
        db.FilterProduct(a);
}
public List<Drug> getFilterg(){
      return  db.Filtergood;
}
public void save_with_stack() throws SQLException {

        db.addgood(stack_good);
        db.save_To_database_stack();

}


public Queue<Drug> getQueengood(){

    return db.getQueueGood();
}

public void load() throws SQLException {
        db.Load_data();

}
    public List<Drug> load_a() throws SQLException {
        db.Load_data_by_p_a();
        return db.Productlist;

    }
    public  Stack<Drug> getStacks(){
    return  db.stackGood;
    }
    public List<Drug> load_d() throws SQLException {
        db.Load_data_by_p_d();
        return db.Productlist;

    }
    public void loadname() throws Exception {

        db.connect();
        db.vendorname();

    }

    public  void addDefaultcate() throws Exception {

    db.connect();
    db.add_default_cate();
    db.loadcategory();

    }


    public void adduserC(User person) throws Exception {

        db.adduser(person);
        db.connect();
        db.registerUser();

    }

    public List<User> getAllusers() throws Exception {

    db.connect();
    db.getAlluser();

    return db.getuser();

    }

    public List<User> getusers()  {

        return db.getuser();
    }


    public void loginP(String username,String password) throws Exception {

    db.connect();
        db.getlogins(username,password);

    }

    public Stack<User> getlogU(){
        return db.person;
    }
    public void delectList(int index) throws  Exception{
    db.connect();
    db.Load_data();
    db.removelistgood(index);

    }

    public List<String> getCatelist(){
        return  db.getCategorylist();
    }

public void SetDISPLAYTYPE(String a){
        db.setDisplayType(a);
}
public String getDISPLAYTYPE(){
     return db.getDisplayType();
}

public void delectStack() throws Exception {
        db.connect();
        db.Load_data();
       db.removegood();

}

public void AddSaleRecord(int a ,int index) throws Exception {
db.connect();
    db.saveToVsaleDate(a,index);
}
public void  Disconnect(){
    db.disconnected();
}
public Map<Integer, sales_contractor> getAllsales() throws Exception {
  db.connect();
  db.Load_data_SALE();
  return db.getSales();
}
    public Map<Integer, sales_contractor> getnewsale()  {
        return db.getSales();
    }
    public void Addsales(Integer n, sales_contractor sale)  {
     db.storesale(n,sale);
    }


    public void adddrugstack(String catn, String drugn,Date date, Date expiry, int quatn, double purchn, double salena, double grosna,  int supplier) throws ParseException {
      stack_good=new Drug(catn,drugn,date,expiry,quatn,purchn,salena,grosna,supplier);

    }



}
