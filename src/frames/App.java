package frames;

import Backend_database.Storeroom;
import ConnectorP.Performcollection;
import database.collections;

import javax.swing.*;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        Performcollection controller=new Performcollection();
        collections DB=new collections();

        MainFrame app=new MainFrame();
        app.setSize(1200,700);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

}

