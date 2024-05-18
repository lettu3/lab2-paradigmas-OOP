package namedEntities;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import namedEntities.heuristics.CapitalizedWordHeuristic;
import namedEntities.heuristics.DoubleCapitalizedWordHeuristic;
import feed.Article;
import java.util.ArrayList;
import java.util.List;

public class NamedEntity {
    public List <String>  listNamedEntities;
    public NamedEntity() {
        listNamedEntities = new ArrayList<>();        
    }

    // TODO: Creo que deberíamos crear la clase Heuristic, y tomar 
    // algo del tipo Heuristic, hardcodeo a Capitalized

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

    public void print() {
            System.out.println("Entidades nombradas: ");
            System.out.println(listNamedEntities);
    }



//TODO: ver distintas formas de chequear a que clase deberia pertenecer cada entidad
//Preguntarle al profe si es una buena aproximación.
//Los ifs estan comentados para que compile, porque los chequeos no estan implementados todavía.
List<NamedEntity> classifiedEntities = new ArrayList<>();

/*
public boolean isLocationEntity(String entity) {
    try {
        // Read the JSON file into a string
        String json = new String(Files.readAllBytes(Paths.get("dictionary.json")));
        // Parse the JSON string into a list of maps
        Gson gson = new Gson();
        Type type = new TypeToken<List<Map<String, String>>>(){}.getType();
        List<Map<String, String>> dictionary = gson.fromJson(json, type);

        // Iterate over the dictionary entries and check if the entity matches a location
        for (Map<String, String> entry : dictionary) {
            String label = entry.get("label");
            String category = entry.get("category");
            if (label.equals(entity) && category.equals("Location")) {
                return true;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return false;
}
 

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