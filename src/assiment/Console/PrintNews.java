/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assiment.Console;

import assiment.Control.AssimentControl;
import assiment.Entity.TypeEntity;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.nodes.Element;

/**
 *
 * @author Admin
 */
public class PrintNews {
    
    static AssimentControl menu = new AssimentControl();
    
    public static void printListNews(HashMap<Integer, Element> map) {
        for (Map.Entry<Integer, Element> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Element value = entry.getValue();
            String concat;
            if (value.className().equals("fon6")) {
                concat = value.text().concat(" | Dân trí");
            } else {
                concat = value.text().concat(" | Vnexpress");
            }
            System.out.println("------------------------------------------------------------------------------");
            System.out.println(key + " | " + concat + " | ");
            System.out.println("------------------------------------------------------------------------------");
        }

//        menu.menuNewsCategory();
    }
    
    public static void printOneArticle(HashMap<String, TypeEntity> oneArticle, ResourceBundle bundle){
        for (Map.Entry<String, TypeEntity> entry : oneArticle.entrySet()) {
            String key = entry.getKey();
            TypeEntity value = entry.getValue();
            
            System.out.println("------------------------------------------------------ Title -------------------------------------------------------");
            System.out.println(value.getTitle());
            System.out.println("------------------------------------------------------ Description -------------------------------------------------");
            System.out.println(value.getDescription());
            System.out.println("------------------------------------------------------ Content -----------------------------------------------------");
            System.out.println(value.getContent());
            System.out.println("------------------------------------------------------ Link --------------------------------------------------------");
            System.out.println(key);
            
        }
        menu.menuExpost();
    }
}
