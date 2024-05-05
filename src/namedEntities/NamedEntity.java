package namedEntities;
import namedEntities.heuristics.CapitalizedWordHeuristic;
import feed.Article;
import java.util.ArrayList;
import java.util.List;


public class NamedEntity {
    private List <String>  listNamedEntities;
    public NamedEntity() {
        listNamedEntities = new ArrayList<>();        
    }

    // TODO: Creo que deberíamos crear la clase Heuristic, y tomar 
    // algo del tipo Heuristic, hardcodeo a Capitalized

    public void parseFromHeuristicCap(Article art) {
        CapitalizedWordHeuristic heuristic = new CapitalizedWordHeuristic();
        // Añadimos los candidadtos a listNamedEntities
        listNamedEntities.addAll(heuristic.extractCandidates(art.getTitle()));
    }

    public void print() {
            System.out.println("Entidades nombradas: ");
            System.out.println(listNamedEntities);
    }
}
