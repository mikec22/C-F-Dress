
import com.bean.Client;
import com.db.ClientDB;
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mike
 */
public class TestAddClient {

    public static void main(String[] args) {
        int year = 97;
        int month = 6;
        int day = 1;
        Date dob = new Date(year, month,day);
        //System.out.println(dob);
        ClientDB db = new ClientDB("jdbc:mysql://dev16.asuscomm.com:3306/CF_DB", "root", "root");
        Client c = new Client(0, "JSON", "123", "JSON Lam", "M", dob,
                "joe@vtc.edu.hk", "87654321", "abc", 0, false, 0,0);
        System.out.println(db.addClient(c));
        System.out.println(db.getClient("Joe"));
    }
}
