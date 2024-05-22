package utils;

import java.util.ArrayList;
import java.util.List;

import utils.DictEntity.Entity;

public class Stats {
    
    public List<Entity> getAppearedEntities(List<Entity> dictionary) {
        List<Entity> entities = new ArrayList<>();
        for (Entity entity : dictionary) {
            if(entity.getAppearanceCount() > 0) {
                entities.add(entity);
            }
        }
        return entities;
    }

    //TODO: Se asume que dictionary tiene solo las entidades que aparecieron.
    //Devuelve en una lista las categorias y tópicos que aparecieron.
    public List<String> getCategories(List<Entity> dictionary) {
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

    //Se asume que el diccionario es el que tiene todas las entidades que aparecieron.
    //Devuelve en una lista las entidades que aparecieron y que tienen la categoria especificada.
    public List<Entity> getEntitiesFromCategory(List<Entity> dictionary, String category) {
        List<Entity> entities = new ArrayList<>();
        for (Entity entity : dictionary) {
            if(entity.getCategory().equals(category)) {
                entities.add(entity);
            }
        }
        return entities;
    }

    //Se asume que el diccionario es el que tiene todas las entidades que aparecieron.
    //Devuelve en una lista las entidades que aparecieron y que tienen el tópico especificado.
    public List<Entity> getEntitiesFromTopic(List<Entity> dictionary, String topic) {
        List<Entity> entities = new ArrayList<>();
        for (Entity entity : dictionary) {
            if(entity.getTopics() != null) {
                if(entity.getTopics().contains(topic)) {
                    entities.add(entity);
                }
            }
        }
        return entities;
    }

    //TODO
    public void printStatsByMode(List<Entity> dictionary, String mode) {
        //List<Entity> entities = new ArrayList<>();
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
