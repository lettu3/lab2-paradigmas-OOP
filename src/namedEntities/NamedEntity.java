package namedEntities;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import namedEntities.heuristics.CapitalizedWordHeuristic;
import namedEntities.heuristics.DoubleCapitalizedWordHeuristic;
import namedEntities.heuristics.ThirdHeuristic;
import feed.Article;
import java.util.ArrayList;
import java.util.List;

public class NamedEntity {
    public List <String>  listNamedEntities;
    public NamedEntity() {
        listNamedEntities = new ArrayList<>();        
    }

    public void parseFromHeuristicCap(Article art) {
        CapitalizedWordHeuristic heuristic = new CapitalizedWordHeuristic();
        // Añadimos los candidadtos a listNamedEntities. Cada entrada es un string.
        listNamedEntities.addAll(heuristic.extractCandidates(art.getTitle()));
    }

    public void parseFromDoubleHeuristicCap(Article art) {
        DoubleCapitalizedWordHeuristic heuristic = new DoubleCapitalizedWordHeuristic();
        // Añadimos los candidadtos a listNamedEntities. Cada entrada es un string.
        listNamedEntities.addAll(heuristic.extractPersonNames(art.getTitle()));
    }

    public void parseFromCorporationCap(Article art) {
        ThirdHeuristic heuristic = new ThirdHeuristic();
        // Añadimos los candidadtos a listNamedEntities. Cada entrada es un string.
        listNamedEntities.addAll(heuristic.extractX(art.getTitle()));
    }

    public void print() {
            System.out.println("Entidades nombradas: ");
            System.out.println(listNamedEntities);
    }

//Los ifs estan comentados para que compile, porque los chequeos no estan implementados todavía.
List<NamedEntity> classifiedEntities = new ArrayList<>();

}