/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assiment.Entity;

import org.jsoup.nodes.Element;

/**
 *
 * @author Admin
 */
public class TypeEntity {

    private String title;
    private String description;
    private String content;
    private Element html;

    public Element getHtml() {
        return html;
    }

    public void setHtml(Element html) {
        this.html = html;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
