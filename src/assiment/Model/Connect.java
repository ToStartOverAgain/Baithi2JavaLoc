/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assiment.Model;

import assiment.Entity.TypeEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Admin
 */
public class Connect {

    public static HashMap<Integer, Element> getNews(String url, String dantri) {
        ArrayList<Element> list = new ArrayList<>();
        HashMap<Integer, Element> map = new HashMap<>();
        try {
            Document document = Jsoup.connect(url).get();
            Document document1 = Jsoup.connect(dantri).get();
            String css = "section.container .sidebar_1 article.list_news .title_news a[title]";
            Elements elements = document.select(css);
            Elements elements1 = document1.select("#listcheckepl .mt3 .mr1 h2 a[title]");
            for (int i = 0; i < 5; i++) {
                Element get = elements.get(i);
                list.add(get);
                Element get1 = elements1.get(i);
                list.add(get1);
            }
            for (int i = 0; i < list.size(); i++) {
                Element get = list.get(i);
                map.put(i, get);
            }

        } catch (IOException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }

    public static HashMap<String, TypeEntity> getNewsContent(String url) {
        TypeEntity typeEntity = new TypeEntity();
        HashMap<String, TypeEntity> map = new HashMap<>();
        try {

            String slTitle;
            String slDescription;
            String slContent;
            String slHtml;

            if (url.matches("(.*)vnexpress(.*)")) {  // nếu là vnexpress 
                System.out.println("vnexpress");
                slTitle = "section.sidebar_1 h1.title_news_detail";
                slDescription = "section.sidebar_1 h2.description";
                slContent = "section.sidebar_1 article p";
                slHtml = "section.sidebar_1";

            } else {// nếu là dân trí
                System.out.println("dan tri");
                url = "http://dantri.com.vn" + url;
                slTitle = ".clearfix .wid470 #ctl00_IDContent_Tin_Chi_Tiet h1.fon31";
                slDescription = ".clearfix .wid470 #ctl00_IDContent_Tin_Chi_Tiet h2.fon33";
                slContent = ".clearfix .wid470 #ctl00_IDContent_Tin_Chi_Tiet #divNewsContent p";
                slHtml = "div.clearfix #ctl00_IDContent_Tin_Chi_Tiet";

            }

            Document document = Jsoup.connect(url).get();

            Elements elTitle = document.select(slTitle);
            Elements elDescription = document.select(slDescription);
            Elements elContent = document.select(slContent);
            Elements elHtml = document.select(slHtml);
            for (Element element : elHtml) {
                typeEntity.setHtml(element);
            }

            typeEntity.setTitle(elTitle.text());
            typeEntity.setDescription(elDescription.text());
            typeEntity.setContent(elContent.text());

            map.put(url, typeEntity);

        } catch (IOException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
}
