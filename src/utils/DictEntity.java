package utils;

import java.util.ArrayList;
import java.util.List;

public class DictEntity {

    private class Entity {
        private String label;
        private List<String> keywords;
        private String category;
        private List<String> topics;

    
        //constructor
        public Entity(String label, String category, List<String> topics, List<String> keywords) {
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

    }

    
    public Entity<List> dictionary;

    public DictEntity(){
        dictionary = new ArrayList<>();
    }

    public addToDictEntity(String label, String category, List<String> topics, List<String> keywords){
        dictionary.add(new Entity(label, category, topics, keywords));
    }
    
    public bool DictContainsLabel (String label){
        //completar
    }


    //PRE: DictContainsLabel(label)
    
    //toma una label, y devuelve la categoria de esa entidad si es que existe
    public String getCategoryfromlabel (String label){

    }

    //toma una label y devuelve el topico de la entidad si es que existe
    public List<String> getTopicFromLabel (String label){

    }

    //toma una label y devuelve la lista de keywords de la entidad si es que existe
    public List<String> getKeywordsFromLabel (String label){

    }

    //toma una keyword y devuelve la label asociada
    public String getLabelFromKeyword (String keyword){

    }
}

public class Entity {
    private String label;
    private List<String> keywords;
    private String category;
    private List<String> topics;

    
    //constructor
    public Entity(String label, String category, List<String> topics, List<String> keywords) {
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

}
