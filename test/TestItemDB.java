
import com.db.ItemDB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mike
 */
public class TestItemDB {
    public static void main(String[] args){
        ItemDB db = new ItemDB("jdbc:mysql://dev16.asuscomm.com:3306/CF_DB", "root", "root");
        //System.out.println(db.queryItemByKeyword(""));
        System.out.println(db.getAllDesigners());
    }
}
