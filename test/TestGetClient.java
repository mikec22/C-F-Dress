
import com.db.ClientDB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mike
 */
public class TestGetClient {
    public static void main(String[] args){
        ClientDB db = new ClientDB("jdbc:mysql://dev16.asuscomm.com:3306/CF_DB", "root", "root");
        System.out.println(db.getClient(1));
        System.out.println(db.getClient(2));
    }
}
