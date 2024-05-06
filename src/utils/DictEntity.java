package utils;

import java.util.ArrayList;
import java.util.List;

public class DictEntity {
    private String label;
    private List<String> keywords;
    private String category;
    private List<String> topics; 

    //constructor
    public DictEntity(String label, String category, List<String> topics, List<String> keywords) {
        this.label = label;
        this.keywords = keywords;
        this.category = category;
        this.topics = topics;
    }

    //getters
    public String getLabel() {
        return label;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getCategory() {
        return category;
    }

    public List<String> topics (){
        return topics;
    }

    //
}
