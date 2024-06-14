package namedEntities.heuristics;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWordHeuristic extends Heuristics {

    public CapitalizedWordHeuristic() {
        super();
    }
    
    public List<String> extractCandidates(String text) {
        Pattern pattern = Pattern.compile("[A-Z][a-z]+(?:\\s[A-Z][a-z]+)*");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            candidates.add(matcher.group());
        }
        return candidates;
    }
}
