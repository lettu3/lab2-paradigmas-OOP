package utils;

import java.util.ArrayList;
import java.util.List;

public class DictEntity {

    protected class Entity {
        private String label;
        private List<String> keywords;
        private String category;
        private List<String> topics;
        private int appearanceCount;
    
        //constructor
        private Entity(String label, String category, List<String> topics, List<String> keywords) {
            this.label = label;
            this.keywords = keywords;
            this.category = category;
            this.topics = topics;
            this.appearanceCount = 0;
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

        public List<String> getTopics (){
            return topics;
        }

        public int getAppearanceCount() {
            return appearanceCount;
        }

        public void increaseAppearanceCount() {
            appearanceCount++;
        }

    }

    public List<Entity> dictionary;

    public DictEntity(){
        dictionary = new ArrayList<>();
    }

    public void add(String label, String category, List<String> topics, List<String> keywords){
        dictionary.add(new Entity(label, category, topics, keywords));
    }
    
    public boolean DictContainsLabel (String label){
        for(Entity entity : dictionary) {
            if(entity.getLabel().equals(label)){
                return true;
            }
        }
        return false;
    }


    //PRE: DictContainsLabel(label)
    
    //toma una label, y devuelve la categoria de esa entidad si es que existe
    public String getCategoryfromlabel (String label){
        for(Entity entity : dictionary) {
            if(entity.getLabel().equals(label)){
                return entity.getCategory();
            }
        }
        return null;
    }

    //toma una label y devuelve el topico de la entidad si es que existe
    public List<String> getTopicFromLabel (String label){
        for(Entity entity : dictionary) {
            if(entity.getLabel().equals(label)){
                return entity.getTopics();
            }
        }
        return null;
    }

    //toma una label y devuelve la lista de keywords de la entidad si es que existe
    public List<String> getKeywordsFromLabel (String label){
        for(Entity entity : dictionary) {
            if(entity.getLabel().equals(label)){
                return entity.getKeywords();
            }
        }
        return null;
    }

    //toma una keyword y devuelve la label asociada
    public String getLabelFromKeyword (String keyword){
        for(Entity entity : dictionary) {
            for(String key : entity.getKeywords()){
                if(key.equals(keyword)){
                    return entity.getLabel();
                }
            }
        }
        return null;
    }

    // Para debugear
    public void print() {
        System.out.println("Cantidad de entradas(labels): " + dictionary.size());
        for(Entity entity : dictionary) {
            if(entity.getAppearanceCount() > 0) {
                System.out.println("Label: " + entity.getLabel() + ", Appearance Count: " + entity.getAppearanceCount());
            }
        }
    }

    public void increaseAppearanceCount(String label){
        for(Entity entity : dictionary) {
            if(entity.getLabel().equals(label)){
                entity.increaseAppearanceCount();
                return;   
            }
        }
    }

}
