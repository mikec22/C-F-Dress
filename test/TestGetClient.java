
import com.db.OrderDB;

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
        OrderDB orderDB = new OrderDB("jdbc:mysql://127.0.0.1:3306/CF_DB", "root", "");
        System.out.println(orderDB.queryIncompleteOrder());
    }
}
