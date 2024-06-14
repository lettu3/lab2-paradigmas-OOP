package utils;

import java.util.ArrayList;
import java.util.List;

import utils.DictEntity.Entity;

import namedEntities.PersonEntity;
import namedEntities.NamedEntity;
import namedEntities.OrganizationEntity;
import namedEntities.LocationEntity;
import namedEntities.OtherEntity;

public class Stats {
    
    public static List<Entity> getAppearedEntities(List<Entity> dictionary) {
        List<Entity> entities = new ArrayList<>();
        for (Entity entity : dictionary) {
            if(entity.getAppearanceCount() > 0) {
                entities.add(entity);
            }
        }
        return entities;
    }

    public static List<NamedEntity> objectCreator(List<Entity> dictionary) {
        List<NamedEntity> entities = new ArrayList<>();
        for(Entity entity : dictionary) {
            if (entity.getCategory() == "PERSON") {
                entities.add(new PersonEntity(entity.getLabel()));
            } else if (entity.getCategory() == "ORGANIZATION") {
                entities.add(new OrganizationEntity(entity.getLabel()));
            } else if (entity.getCategory() == "LOCATION") {
                entities.add(new LocationEntity(entity.getLabel()));
            } else {
                entities.add(new OtherEntity(entity.getLabel()));
            }
        }
        return entities;
    }

    //Devuelve en una lista las categorias que aparecieron.
    public static List<String> getCategories(List<Entity> dictionary) {
        List<String> categories = new ArrayList<>();
        for (Entity entity : dictionary) {
            //Agregar las categorias.
            if(!categories.contains(entity.getCategory())) {
                categories.add(entity.getCategory());
            }
        }
        return categories;
    }

    public List<String> getTopics(List<Entity> dictionary) {
        List<String> topics = new ArrayList<>();
        for (Entity entity : dictionary) {
            //Agregar las categorias.
        for(String topic : entity.getTopics()){
            if(!topics.contains(topic)) {
                topics.add(topic);
            }
        }
    }
        return topics;
    }

    public void printStatsByMode(List<Entity> dictionary, String mode) {
        if(mode.equals("cat")) {
            List<String> categories = getCategories(dictionary);
            for(String category : categories){
                System.out.println("Category:" + category);
                for(Entity currEntity : dictionary){
                    if(currEntity.getCategory().equals(category)){
                        System.out.println("    " + currEntity.getLabel() + "(" + currEntity.getAppearanceCount() + ")");
                    }
                }
            }
        } else if(mode.equals("topic")) {
            List<String> topics = getTopics(dictionary);
            for(String topic : topics){
                System.out.println("Topic:" + topic);
                for(Entity currEntity : dictionary){
                    if(currEntity.getTopics().contains(topic)){
                        System.out.println("    " + currEntity.getLabel() + "(" + currEntity.getAppearanceCount() + ")");
                    }
                }
            }
        } else {
            System.out.println("Invalid mode" + mode);
        }
    }
}
