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



//TODO: ver distintas formas de chequear a que clase deberia pertenecer cada entidad
//Preguntarle al profe si es una buena aproximación.
//Los ifs estan comentados para que compile, porque los chequeos no estan implementados todavía.
List<NamedEntity> classifiedEntities = new ArrayList<>();

/*

for (String entity : listNamedEntities) {
    if (isLocationEntity(entity)) {
        classifiedEntities.add(new LocationEntity(entity));
    } else if (isOrganizationEntity(entity)) {
        classifiedEntities.add(new OrganizationEntity(entity));
    } else if (isPersonEntity(entity)) {
        classifiedEntities.add(new PersonEntity(entity));
    } else {
        classifiedEntities.add(new OtherEntity(entity));
    }
}
*/
}