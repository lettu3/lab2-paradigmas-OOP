package utils;

import java.util.ArrayList;
import java.util.List;

import utils.DictEntity.Entity;

public class Stats {
    
    //TODO: Se asume que dictionary tiene solo las entidades que aparecieron.
    //Devuelve en dos listas las categorias y tópicos que aparecieron.
    public void getCatAndTop(List<Entity> dictionary) {
        List<String> categories = new ArrayList<>();
        List<String> topics = new ArrayList<>();
        for (Entity entity : dictionary) {
            //Agregar las categorias.
            if(!categories.contains(entity.getCategory())) {
                categories.add(entity.getCategory());
            }
            //Agregar los tópicos.
            if(entity.getTopics() != null) {
                for (String topic : entity.getTopics()) {
                    if(!topics.contains(topic)) {
                        topics.add(topic);
                    }
                }
            }
        }
    }

    //Se asume que el diccionario es el que tiene todas las entidades que aparecieron.
    //Devuelve en una lista las entidades que aparecieron y que tienen la categoria especificada.
    public void getEntitiesFromCategory(List<Entity> dictionary, String category) {
        List<Entity> entities = new ArrayList<>();
        for (Entity entity : dictionary) {
            if(entity.getCategory().equals(category)) {
                entities.add(entity);
            }
        }
    }

    //Se asume que el diccionario es el que tiene todas las entidades que aparecieron.
    //Devuelve en una lista las entidades que aparecieron y que tienen el tópico especificado.
    public void getEntitiesFromTopic(List<Entity> dictionary, String topic) {
        List<Entity> entities = new ArrayList<>();
        for (Entity entity : dictionary) {
            if(entity.getTopics() != null) {
                if(entity.getTopics().contains(topic)) {
                    entities.add(entity);
                }
            }
        }
    }

    //TODO
    public void printStatsByMode(List<Entity> dictionary, String mode) {
        if(mode.equals("category")) {
            getCatAndTop(dictionary);
        } else if(mode.equals("topic")) {
            getCatAndTop(dictionary);
        } else {
            System.out.println("Invalid mode");
        }
    }
}
