/*
 * Esta heuristica hace ___
 * 
 * 
*/
package namedEntities.heuristics;

import java.text.Normalizer;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
