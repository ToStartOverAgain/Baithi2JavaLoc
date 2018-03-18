/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assiment.Entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Language {

    static HashMap<String, String> mapCountryLanguage;

    public static ResourceBundle chooseLanguage() {
        Scanner scan = new Scanner(System.in);
        System.out.println("please choose language (vi | en)");
        String language = scan.nextLine();
        getCountryLanguage(language);
//        System.out.println(getCountryLanguage(language));
        Locale locale = new Locale(language, getCountryLanguage(language));
        ResourceBundle bundle = ResourceBundle.getBundle("source/lang", locale);
        return bundle;
    }

    public static String getCountryLanguage(String Language) {
        if (mapCountryLanguage == null) {
            getLanguageInFile();
        }
        return mapCountryLanguage.get(Language);
    }

    public static void getLanguageInFile() {
        mapCountryLanguage = new HashMap<>();
        try {
            FileWriter fw = new FileWriter("lang.txt"); // đường đãn đến file txt, nếu chưa có file đó filewrite sẽ tự tạo ra file
            BufferedWriter bw = new BufferedWriter(fw);// bộ đệm bufferedWrite giúp ta ghi vào file
            bw.write("vi|VN"); // ghi vào file
            bw.newLine();
            bw.write("en|US");
            bw.newLine();
            bw.flush(); // flush vào file có thể hiểu như save
            bw.close();

            List<String> list = Files.readAllLines(Paths.get("lang.txt")); // đọc 1 file txt; readAllLines trả về 1 list<>
            for (String string : list) {
                String[] slArray;
                slArray = string.split("\\|");
                if (slArray.length > 1) {
                    mapCountryLanguage.put(slArray[0], slArray[1]);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Language.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
