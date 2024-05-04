package feed;

public class Article {
    
    private String title;
    private String description;
    private String pubDate;
    private String link;

    public Article(String title, String description, String pubDate, String link) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }
    public String getLink(){
        return link;
    }

    public void printArticle(){
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Publicationn Date: " + pubDate);
        System.out.println("Link:\n" + title);
    }
}   