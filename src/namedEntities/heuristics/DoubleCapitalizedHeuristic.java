/*
Esta heurística busca filtrar exclusivamente nombres de personas, ya que estos casi siempre aparecen en formato
nombre-apellido. Para eso, se busca en el texto palabras que comiencen con mayúscula y tengan una o más palabras
seguidas comenzadas con mayúscula. Notar que esto debe dejar afuera nombres de lugares como "La Paz" o "Puerto Stanley".
*/

package namedEntities.heuristics;
import java.text.Normalizer;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoubleCapitalizedWordHeuristic {

    public List<String> extractPersonNames(String text) {
        List<String> candidates = new ArrayList<>();
        text = text.replaceAll("[-+.^:,\"]", "");
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("\\p{M}", "");
        //Se agregan a los candidatos solo palabras que comiencen con mayúscula y tengan una o más palabras seguidas comenzadas con mayúscula.
        //Se ignora todo lo que comience con alguna de las palabras del conjunto de negación.
        Pattern pattern = Pattern.compile("\\b(?!La\\b|El\\b|The\\b|San\\b|Lago\\b|Puerto\\b|Río\\b|Monte\\b|República\\b)[A-Z][a-z]+\\s[A-Z][a-z]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            names.add(matcher.group());
        }
        return names;
    }
}