package database;
import ConnectorP.Performcollection;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.*;
import java.util.Random;
public class collections {

    public Stack<Drug> stackGood;
    public Queue<Drug> queueGood;
    public List<User> users;
    public HashMap<String, supplier_constructor> suppliers;
    public HashMap<String,Integer> vendornames;
    public HashMap<Integer,String> vendornamids;
    public List<Drug>Productlist;
    public List<Drug>Filtergood;
    public List<String>categorylist;
    public Stack<User> person;
    private int rand;
    public  Map<Integer, sales_contractor>sales;

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    private String displayType;


    public Connection con;


    public collections(){
        person=new Stack<>();
    users=new ArrayList<>();
        stackGood= new Stack<>();
        queueGood= new LinkedList<>();
      suppliers=new HashMap<>();
        Productlist=new ArrayList<>();
        Filtergood=new ArrayList<>();
        vendornames=new HashMap<>();
        vendornamids=new HashMap<>();
sales=new HashMap<>();
categorylist=new ArrayList<>();





    }

public void adduser(User p){
        users.add(p);
}

    public List<User> getuser(){
     return users;
    }
    public void loginPerson(User p){
        person.push(p);
    }

    public Stack<User> getloguser(){
        return person;
    }


    /** stack   ADD    */
    public void addgood(Drug g){

        stackGood.push(g);


    }

public void FilterProduct(Integer a){

for(Drug g:Productlist){
    if(Objects.equals(a, g.getSupplier())){
        Filtergood.add(g);

    }

}

}
    /** *******************REMOVE FROM  STACK ***********************/
    public void removegood() throws SQLException {
         Drug nw=stackGood.pop();
        String deletestate="delete from drug where id="+nw.getId();
        PreparedStatement stm=con.prepareStatement(deletestate);
        stm.executeUpdate();
        stm.close();


    }
    public void removelistgood(int index) throws SQLException {
        Drug nw=Productlist.remove(index);
        String deletestate="delete from drug where id="+nw.getId();
        PreparedStatement stm=con.prepareStatement(deletestate);
        stm.executeUpdate();
        stm.close();


    }



    public int a_l(){
        return Productlist.size();
    }


    /*** GET GOOD FROM stack***********************************/


    public Stack<Drug> getgood(){
        return stackGood;
    }
    public Queue<Drug> getQueueGood(){
        return queueGood;
    };
/*****

*

 / **************LIST FOR ADD CATEGORY 8 TO 11 ****************************************/
/** add */

    public void add_vendorname(String name,Integer id){
        vendornames.put(name,id);
    }
    public void add_vendorids(Integer id,String name){
        vendornamids.put(id,name);
    }
    public Map<String,Integer> getvendorsname(){
    return vendornames;
    }
    public Map<Integer,String> getvendorsnids(){
        return vendornamids;
    }
/** *****REMOVE FROM LIST************************************ */



/**********END ************************************ **/


/********************** ADD******************/




/****************************        STORE VENDOR DETAILS USING HASHMAP***/
public void  Addcategorylist(String name){
    categorylist.add(name);
    }
    public List<String>  getCategorylist(){
       return categorylist;
    }
public void Addvendor(String name, supplier_constructor detail){
    suppliers.put(name,detail);
}

/****      sales record                   ******************     ***/
public  Map<Integer, sales_contractor> getSales(){
return sales;
}
public void storesale(int id, sales_contractor s){
    sales.put(id,s);
}
/*************  GET SALE RECORDS ******/

/********** Get vendors*********************/
public HashMap<String, supplier_constructor> Getvendors(){
    return
            suppliers;
}

public void removevendor(String n){
    suppliers.remove(n);
}
/*************** end of hashmap****/





/********   DATABASE CONNECTION *******************************************/
    public void connect() throws Exception  {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver connected");


    String mysqlurl="jdbc:mysql://localhost:3306/inventory";
    con= DriverManager.getConnection(mysqlurl,"root","manifest");
        System.out.println("driver connected");
        Statement statement = con.createStatement();

        String issuedrug = "CREATE TABLE IF NOT EXISTS solddrug ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "drug VARCHAR(50) DEFAULT NULL,"
                + "category VARCHAR(50) DEFAULT NULL,"
                + "quantity INT DEFAULT NULL,"
                + "unit_price DOUBLE DEFAULT NULL,"
                + "total_price DOUBLE DEFAULT NULL,"
                + "date_issued TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "patient VARCHAR(50) DEFAULT NULL,"
                + "drugid INT DEFAULT NULL,"
                + "issuer VARCHAR(50) DEFAULT NULL"

                + ")";

        String vendortable = "CREATE TABLE IF NOT EXISTS suppliers ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(50) NOT NULL,"
                + "address VARCHAR(30) DEFAULT NULL,"
                + "firm VARCHAR(50) DEFAULT NULL,"
                + "contact_number INT DEFAULT NULL,"
                + "country VARCHAR(30) DEFAULT NULL,"
                + "city VARCHAR(30) DEFAULT NULL"
                + ")";

        String usertable = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "firstname VARCHAR(50) DEFAULT NULL,"
                + "lastname VARCHAR(50) DEFAULT NULL,"
                + "username VARCHAR(50) DEFAULT NULL,"
                + "account VARCHAR(50) DEFAULT NULL,"
                + "password VARCHAR(50) DEFAULT NULL"
                + ")";

        String categories = "CREATE TABLE IF NOT EXISTS drugcategories ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(50) DEFAULT NULL,"
                + "description VARCHAR(50) DEFAULT NULL"
                + ")";

        String drug = "CREATE TABLE IF NOT EXISTS drug ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "category VARCHAR(50) DEFAULT NULL,"
                + "drug VARCHAR(50) DEFAULT NULL,"
                + "date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "quantity INT DEFAULT NULL,"
                + "unit_price DOUBLE DEFAULT NULL,"
                + "sale_price DOUBLE DEFAULT NULL,"
                + "gross_price DOUBLE DEFAULT NULL,"
                + "supplier INT DEFAULT NULL,"
                + "expiry DATE DEFAULT NULL"
                + ")";
        statement.executeUpdate(vendortable);
      statement.executeUpdate(drug);
      statement.executeUpdate(issuedrug);
      statement.executeUpdate(usertable);
       statement.executeUpdate(categories);
statement.close();

    }


    /*** DISCONNECT***************************/
    public void disconnected()  {
if(con !=null){
    try{
        con.close();
        System.out.println("connection close");
    }
    catch(SQLException e){
      System.out.println("not close");
    }

}
    }






    /**** add default catgories   *****/

    public void add_default_cate() throws SQLException {
String loader="SELECT * from drugcategories";
Statement statement=con.createStatement();
ResultSet results=statement.executeQuery(loader);

if(results.next()){

}
else{
    results.close();
    statement.close();

    List<String> Category=new ArrayList<String>();
    Category.add("Headache");
    Category.add("Muscle relaxants");
    Category.add("Adjunct Medications for Pain");
    Category.add("Smoking Cessation");
    Category.add("Injectable diabetic agents");
    Category.add("Contraceptives");
    Category.add("Erectile Dysfunction");
    Category.add("Overactive Bladder");
    Category.add("Allergies");
    Category.add("Cough and Cold");
    Category.add("Infectious Disease Drugs");
    Category.add("Glaucoma");
    Category.add("Erectile Dysfunction");


    for(String cat:Category ){
        String Doc="insert into drugcategories (name) values(?)";
        PreparedStatement insertDoc=con.prepareStatement(Doc);
        insertDoc.setString(1, cat);
        insertDoc.executeUpdate();
        insertDoc.close();

    }

}















    }








    /****************************sAVE VENDORS**********************************/
public void save_To_database_vendor() throws Exception {
    String Doc="insert into suppliers (name,address,firm,contact_number,country,city) values(?,?,?,?,?,?)";
    PreparedStatement insertDoc=con.prepareStatement(Doc);
for(HashMap.Entry<String, supplier_constructor>e:suppliers.entrySet()){
    String name=e.getKey().toString();
    String add=e.getValue().getAddress();
   int cont=e.getValue().getContact();
    String comp=e.getValue().getCompany();
    String count=e.getValue().getCountry();
    String town=e.getValue().getTown();
    int size=suppliers.size()+1;
    insertDoc.setString(1,name);
    insertDoc.setString(2,add);
    insertDoc.setString(3,comp);
    insertDoc.setInt(4,cont);
    insertDoc.setString(5,count);
    insertDoc.setString(6,town);

    insertDoc.executeUpdate();
    System.out.print("vendor saved");

}

    insertDoc.close();

}



    public void registerUser() throws SQLException {
        String Doc="insert into users (firstname,lastname,username,account,password) values(?,?,?,?,?)";
        PreparedStatement insertDoc=con.prepareStatement(Doc);
        Iterator hash = suppliers.entrySet().iterator();
        for(User u:users){
           String firstname=u.getFirstname();
           String lastname=u.getLastname();
           String username=u.getUsername();
           String account=u.getAccount();
           String password=u.getPassword();
            int size=suppliers.size()+1;
            insertDoc.setString(1,firstname);
            insertDoc.setString(2,lastname);
            insertDoc.setString(3,username);
            insertDoc.setString(4,account);
            insertDoc.setString(5,password);
            insertDoc.executeUpdate();
        }
        System.out.println(users);
        users.clear();
        insertDoc.close();
    }


    public void getlogins(String username,String password) throws SQLException {


        String doc = "SELECT * FROM users WHERE username= ? AND password = ? ";

       PreparedStatement statement=con.prepareStatement(doc);
        statement.setString(1,username);
        statement.setString(2,password);
        ResultSet result=statement.executeQuery();
        while(result.next()){
         loginPerson(new User(result.getInt("id"),
                      result.getString("firstname"),result.getString("lastname"),
                      result.getString("username"),result.getString("account"),result.getString("password")));
        }
statement.close();

        result.close();

    }


    public void getAlluser() throws SQLException {
users.clear();
        String Doc="SELECT * FROM users ";

        Statement statement=con.createStatement();
        ResultSet result=statement.executeQuery(Doc);
        while(result.next()){
            System.out.println(  result.getString("firstname"));
                adduser(new User(result.getInt("id"),
                        result.getString("firstname"),result.getString("lastname"),
                        result.getString("username"),result.getString("account"),result.getString("password")));
        }
        statement.close();
        result.close();
    }












    /********    adding to database  using *****************/
    public void save_To_database_stack() throws SQLException {


        int size= new Random().nextInt(99001) + 1000;
        String Doc="insert into drug(id,category,drug,quantity,unit_price,sale_price,gross_price,supplier,expiry) values(?,?,?,?,?,?,?,?,?)";

        PreparedStatement insertDoc=con.prepareStatement(Doc);
System.out.println(stackGood.size());
        for(Drug g:stackGood){

            int id=g.getId();


            String  cat=g.getCategory();
            String p=g.getDrug();
           Date dat= (Date) g.getDate();
            Date expiry= (Date) g.getExpiry();
            int quan=g.getQuant();
            Double up=g.getUnit_price();
            Double sp=g.getSaleprice();
            Double gp=g.getGrossprice();

            int supplier=g.getSupplier();

insertDoc.setInt(1,size);
            System.out.println("inserted");
                insertDoc.setString(2,cat);
                insertDoc.setString(3,p);
                insertDoc.setInt(4,quan);
                insertDoc.setDouble(5,up);
                insertDoc.setDouble(6,sp);
                insertDoc.setDouble(7,gp);
                insertDoc.setDouble(8,supplier);
                insertDoc.setDate(9,expiry);
                insertDoc.executeUpdate();

        }



        insertDoc.close();
        getgood().clear();
        Productlist.clear();
        stackGood.clear();


    }


    /**************** queues *********************************************************************/



/********           Storing product with list ************/

    String gh="d";
    public void Load_data() throws SQLException {
        stackGood.clear();
        Productlist.clear();
        queueGood.clear();
        String loader="select * from drug";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            int id=result.getInt("id");
            String cat=result.getString("category");
            String good=result.getString("drug");
           Date date=result.getDate("date");
            int quan=result.getInt("quantity");
            Double unitprice=result.getDouble("unit_price");
            Double salep=result.getDouble("sale_price");
            Double grossp=result.getDouble("gross_price");
            Date expiry=result.getDate("expiry");
            int supplier=result.getInt("supplier");
            gh=cat;
            Productlist.add(new Drug(id,cat,good,date,expiry,quan,unitprice,salep,grossp,supplier));
            queueGood.add(new Drug(id,cat,good,date,expiry,quan,unitprice,salep,grossp,supplier));
            stackGood.add(new Drug(id,cat,good,date,expiry,quan,unitprice,salep,grossp,supplier));
        }
        result.close();
        state.close();

    }






    public void Load_data_by_p_d() throws SQLException {
        stackGood.clear();
        Productlist.clear();
        queueGood.clear();
        String loader="select * from drug ORDER BY drug DESC";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){

            int id=result.getInt("id");
            String cat=result.getString("category");
            String good=result.getString("drug");
            Date date=result.getDate("date");
            int quan=result.getInt("quantity");
            Double unitprice=result.getDouble("unit_price");
            Double salep=result.getDouble("sale_price");
            Double grossp=result.getDouble("gross_price");
            Date expiry=result.getDate("expiry");
            int supplier=result.getInt("supplier");
            gh=cat;
            Productlist.add(new Drug(id,cat,good,date,expiry,quan,unitprice,salep,grossp,supplier));
            queueGood.add(new Drug(id,cat,good,date,expiry,quan,unitprice,salep,grossp,supplier));
            stackGood.add(new Drug(id,cat,good,date,expiry,quan,unitprice,salep,grossp,supplier));
        }

        result.close();
        state.close();

    }


    public void Load_data_by_p_a() throws SQLException {
        stackGood.clear();
        Productlist.clear();
        queueGood.clear();
        String loader="select * from drug ORDER BY drug ASC";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            int id=result.getInt("id");
            String cat=result.getString("category");
            String good=result.getString("drug");
            Date date=result.getDate("date");
            int quan=result.getInt("quantity");
            Double unitprice=result.getDouble("unit_price");
            Double salep=result.getDouble("sale_price");
            Double grossp=result.getDouble("gross_price");
            Date expiry=result.getDate("expiry");
            int supplier=result.getInt("supplier");
            gh=cat;
            Productlist.add(new Drug(id,cat,good,date,expiry,quan,unitprice,salep,grossp,supplier));
            queueGood.add(new Drug(id,cat,good,date,expiry,quan,unitprice,salep,grossp,supplier));
            stackGood.add(new Drug(id,cat,good,date,expiry,quan,unitprice,salep,grossp,supplier));
        }
        result.close();
        state.close();

    }






    public void vendorname() throws SQLException {
        vendornamids.clear();
        vendornames.clear();
        String loader="select name, id from suppliers";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            String name=result.getString("name");
            int id=result.getInt("id");
            add_vendorname(name,id);
            add_vendorids(id,name);

        }
        result.close();
        state.close();
    }

    public void loadcategory() throws SQLException {
        String loader="select name from drugcategories";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            String name=result.getString("name");
            Addcategorylist(name);
        }
        result.close();
        state.close();
    }






    public void Load_data_v() throws SQLException {

        suppliers.clear();
        Getvendors().clear();
        String loader="select * from suppliers";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            int id=result.getInt("id");
            String name=result.getString("name");
            String address=result.getString("address");
            String company=result.getString("firm");
            int contact=result.getInt("contact_number");
            String country=result.getString("country");
            String city=result.getString("city");
            Addvendor(name,new supplier_constructor(id,address,company,contact,country,city));

        }

        for(Map.Entry<String, supplier_constructor>e:Getvendors().entrySet()){

        }

        result.close();
        state.close();

    }

    public void saveToVsaleDate(int gty,int index) throws SQLException {
        Statement statement=con.createStatement();
        String upda="update drug set quantity='"+gty+"' where id='"+index+"'";
        System.out.println("while");
                for (Map.Entry<Integer, sales_contractor> e : getSales().entrySet()) {
                    int id = e.getKey();
                    String cat = e.getValue().getCat();
                    String prod = e.getValue().getDrug();
                    String cus = e.getValue().getCus();
                    int qty = e.getValue().getQty();
                    double u_p = e.getValue().getPriceu();
                    double total = e.getValue().getTotal();
                    String issuer = e.getValue().getIssuer();
                    String doc = "INSERT INTO solddrug (drug, category, quantity, unit_price, total_price, patient, issuer, drugid) VALUES ('"
                            + prod + "', '" + cat + "', " + qty + ", " + u_p + ", " + total + ", '" + cus + "', '" + issuer + "', " + id + ")";

                    statement.executeUpdate(doc);
                    statement.executeUpdate(upda);
                    getSales().clear();
                }

        statement.close();
    }
    public void Load_data_SALE() throws SQLException {
        String loader="select * from solddrug";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            System.out.println(result.getString("category"));
            int id=result.getInt("id");
            String product=result.getString("drug");
            String category=result.getString("category");
            int quan=result.getInt("quantity");
            Double up=result.getDouble("unit_price");
            Double tp=result.getDouble("total_price");
            String cus=result.getString("patient");
            String issuer=result.getString("issuer");
            Date date=result.getDate("date_issued");
            int fid=result.getInt("drugid");
            storesale(id,new sales_contractor(fid,product,category,up,quan,tp,cus,issuer,date,id));
        }
System.out.println(sales);


        for(Map.Entry<Integer, sales_contractor>e:getSales().entrySet()){
            System.out.println("loaded to MAP"+Getvendors().size());
        }

        System.out.println("loaded to MAP");
        result.close();
        state.close();
    }




}


