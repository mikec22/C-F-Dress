
import com.bean.Client;
import com.db.ClientDB;
import com.db.OrderDB;
import com.db.StaffDB;
import java.util.Vector;

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

    public static void main(String[] args) {
        ClientDB db = new ClientDB("jdbc:mysql://dev16.asuscomm.com:3306/CF_DB", "root", "root");
        OrderDB orderDB = new OrderDB("jdbc:mysql://dev16.asuscomm.com:3306/CF_DB", "root", "root");
        Vector<Client> clients = db.queryClientByName("wong");
        for (Client client : clients) {
            System.out.println(orderDB.getOrders(client.getClient_id()));
        }
    }
}
