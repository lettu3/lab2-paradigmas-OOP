/*
 * Esta heuristica busca filtrar el nombre de instituciones u organizaciones
 * Muchas veces se utilizan los conectores "de/del" para referirse al lugar de operaciones de dicha organizacion 
 * Ej: Universidad Nacional de Córdoba
*/
package namedEntities.heuristics;

import java.text.Normalizer;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//instituciones, empiezan con "Instituto", "Centro", "Fundacion", "Banco", "Corporacion", "..."
// les puede seguir un conector en minuscula "de" o "del" y habria que tomar todas las palabras en mayusculas hasta que no se encuentre
// otro conector, es decir cualquier otra palabra en minsucula

public class ThirdHeuristic {
  
    public List<String> extractX (String text) {
        List<String> candidates = new ArrayList<>();

        //se eliminan caracteres sin sentido para analizar
        text = text.replaceAll("[-+.^:,\"]", "");
        //elimina tildes
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("\\p{M}", "");

        //que hago aca?
        Pattern pattern = ?;
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            candidates.add(matcher.group());
        }

        return candidates;
    }
}
