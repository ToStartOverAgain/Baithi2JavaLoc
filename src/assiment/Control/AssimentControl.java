/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assiment.Control;

import assiment.Console.PrintNews;
import assiment.Entity.Language;
import assiment.Entity.TypeEntity;
import assiment.Model.Connect;
import expostHtml.ExportFile;
import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.nodes.Element;

/**
 *
 * @author Admin
 */
public class AssimentControl {

    static Scanner scan = new Scanner(System.in);
    static HashMap<Integer, Element> map = new HashMap<>();
    static ResourceBundle bundle = Language.chooseLanguage();

    public static void menuNewsList() {

        while (true) {
            System.out.println("===================== " + bundle.getString("News list") + " ======================");
            System.out.println("1. " + bundle.getString("World"));
            System.out.println("2. " + bundle.getString("Law"));
            System.out.println("3. " + bundle.getString("Business"));
            System.out.println("4. " + bundle.getString("Entertainment"));
            System.out.println("5. " + bundle.getString("Sport"));
            System.out.println("6. " + bundle.getString("Exit"));
            System.out.println("-------------------------------------------------");
            System.out.println(bundle.getString("Please select an item"));
            System.out.println("--------");
            int choise = scan.nextInt();
            scan.nextLine();
            AssimentControl ac = new AssimentControl();
            switch (choise) {
                case 1:
                    System.out.println("==========----------==========---------=========");
                    System.out.println("1. >> " + bundle.getString("World"));
                    map = Connect.getNews("https://vnexpress.net/tin-tuc/the-gioi", "http://dantri.com.vn/the-gioi.htm");
                    System.out.println("----------==========---------==========---------");
                    break;
                case 2:
                    System.out.println("2. >> " + bundle.getString("Law"));
                    map = Connect.getNews("https://vnexpress.net/tin-tuc/phap-luat", "http://dantri.com.vn/phap-luat.htm");
                    break;
                case 3:
                    System.out.println("3. >> " + bundle.getString("Business"));
                    map = Connect.getNews("https://kinhdoanh.vnexpress.net/", "http://dantri.com.vn/kinh-doanh.htm");
                    break;
                case 4:
                    System.out.println("4. >> " + bundle.getString("Entertainment"));
                    map = Connect.getNews("https://giaitri.vnexpress.net/", "http://dantri.com.vn/giai-tri.htm");
                    break;
                case 5:
                    System.out.println("5. >>" + bundle.getString("Sport"));
                    map = Connect.getNews("https://thethao.vnexpress.net/", "http://dantri.com.vn/the-thao.htm");
                    break;
                case 6:
                    System.out.println("6. >>" + bundle.getString("Exit"));
                    System.exit(0);
                    break;
                default:
                    System.out.println(bundle.getString("Enter wrong input"));
                    break;
            }
            ac.menuNewsCategory();
        }
    }
    static HashMap<String, TypeEntity> oneArticle = new HashMap<>();

    public void menuNewsCategory() {
        System.out.println("=============================================== " + bundle.getString("News category") + " =================================================");
        if (map.size() > 1) {
            PrintNews.printListNews(map);
        }

        System.out.println(bundle.getString("Choose news you want to read (0 - 9)"));
        System.out.println("10. " + bundle.getString("come back"));
        System.out.println("11. " + bundle.getString("Exit"));
        int choise = scan.nextInt();
        String link = GetLinkInMap.getLink(choise, map);
        switch (choise) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 0:
            case 2:
            case 4:
            case 6:
            case 8:
                if (link != null) {
                    oneArticle = Connect.getNewsContent(link);
                }
                 {
                     PrintNews.printOneArticle(oneArticle, bundle);
                }
                break;
            case 10:
                menuNewsList();
                break;
            case 11:
                System.out.println(bundle.getString("Exit"));
                System.exit(0);
                break;
            default:
                System.out.println(bundle.getString("Enter wrong input"));
        }
    }

    public void menuExpost() {
        System.out.println("---------------------------------------========================================-------------------------------------");
        System.out.println("1. " + bundle.getString("come back") + " " + bundle.getString("News list"));
        System.out.println("2. " + bundle.getString("come back") + " " + bundle.getString("News category"));
        System.out.println("3. " + bundle.getString("Export"));
        System.out.println("4. " + bundle.getString("Exit"));

        int choise = scan.nextInt();
        scan.nextLine();
        switch (choise) {
            case 1:
                menuNewsList();
                break;
            case 2:
                menuNewsCategory();
                break;
            case 3:  {
                ExportFile.exportNews(oneArticle);
            }
            break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println(bundle.getString("Enter wrong input"));
                break;
        }
    }
}
