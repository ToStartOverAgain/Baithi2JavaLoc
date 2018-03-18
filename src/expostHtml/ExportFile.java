/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expostHtml;

import assiment.Entity.TypeEntity;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ExportFile {

    public static void exportNews(HashMap<String, TypeEntity> news){
        FileWriter fw = null;
        try {
            fw = new FileWriter("news.html");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<String, TypeEntity> entry : news.entrySet()) {
                String key = entry.getKey();
                TypeEntity value = entry.getValue();
                bw.write(value.getHtml().html());
                bw.flush();
                bw.close();
                System.out.println("sucess");
            }
        } catch (IOException ex) {
            Logger.getLogger(ExportFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(ExportFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
