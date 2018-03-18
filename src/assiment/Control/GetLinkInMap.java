/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assiment.Control;

import java.util.HashMap;
import java.util.Map;
import org.jsoup.nodes.Element;

/**
 *
 * @author Admin
 */
public class GetLinkInMap {
      public  static String getLink(int choise, HashMap<Integer, Element> map){
        String link;
        for (Map.Entry<Integer, Element> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Element value = entry.getValue();
            if (choise == key) {
                link = value.attr("href");
                return link;
            }
        }
        return null;
    }
}
