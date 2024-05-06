package utils;

public class Config {
    private boolean printFeed = false;
    private boolean computeNamedEntities = false;
    private String heuristic;
    private String feedKey;
    // TODO: A reference to the used heuristic will be needed here

    public Config(boolean printFeed, boolean computeNamedEntities, String heuristic, String feedKey) {
        this.printFeed = printFeed;
        this.computeNamedEntities = computeNamedEntities;
        this.heuristic = heuristic;
        this.feedKey = feedKey;
    }

    public boolean getPrintFeed() {
        return printFeed;
    }

    public boolean getComputeNamedEntities() {
        return computeNamedEntities;
    }

    public String getHeuristic() {
        return heuristic;
    }

    public String getFeedKey() {
        return feedKey;
    }

}
