package namedEntities.heuristics;

import java.util.HashMap;

public class Heuristics {
    private static String[] availableHeuristics = {"cap", "doublecap"};
    private static HashMap<String, String> heuristicDescription = new HashMap<>();

    static {
        heuristicDescription.put("cap", "Capitalized Word Heuristic");
        heuristicDescription.put("doublecap", "Double Capitalized Word Heuristic");
    }

    public static String[] getAvailableHeuristics() {
        return availableHeuristics;
    }

    public static String getHeuristicDescription(String heuristic) {
        return heuristicDescription.get(heuristic);
    }
}
