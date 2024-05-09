import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.net.MalformedURLException;

import feed.*;
import namedEntities.NamedEntity;
import utils.Config;
import utils.DictEntity;
import utils.FeedsData;
import utils.JSONParser;
import utils.UserInterface;

public class App {

    public static void main(String[] args) throws IOException {

        List<FeedsData> feedsDataArray = new ArrayList<>();
        try {
            feedsDataArray = JSONParser.parseJsonFeedsData("src/data/feeds.json");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        UserInterface ui = new UserInterface();
        Config config = ui.handleInput(args);

        if(args.length == 0 || config.getPrintHelp()){
            printHelp(feedsDataArray);
            System.exit(0);
        }
        // Parseo del diccionario
        DictEntity dictEntity = new DictEntity();
        dictEntity = JSONParser.parseJsonDictEntity("src/data/dictionary.json");
        dictEntity.print();

        try {
            run(config, feedsDataArray);
        }
        catch (Exception e){ // atrapa todas las excepciones
            e.printStackTrace();
        }
    }

    // TODO: Change the signature of this function if needed
    private static void run(Config config, List<FeedsData> feedsDataArray) throws MalformedURLException, IOException, Exception {

        if (feedsDataArray == null || feedsDataArray.size() == 0) {
            System.out.println("No feeds data found");
            return;
        }

        List<Article> allArticles = new ArrayList<>();
        String feedKey = config.getFeedKey();
        try {
            for(FeedsData feed : feedsDataArray){
                if (feedKey.equals("all") || feed.getLabel().equals(feedKey)){
                    String urlXML = FeedParser.fetchFeed(feed.getUrl());
                    FeedParser.fetchFeed(feed.getUrl());
                    allArticles = FeedParser.parseXML(urlXML);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        
        // TODO: Populate allArticles with articles from corresponding feeds

        if (config.getPrintFeed()) {
            System.out.println("Printing feed(s) ");
            for(FeedsData feedData : feedsDataArray){
                feedData.print();
            }
        }

        if (config.getComputeNamedEntities()) {
            System.out.println("Computing named entities using ");
            System.out.println(config.getHeuristic());

            // TODO: compute named entities using the selected heuristic
            // Now, parsing in use is parseFromHeuristicCap
            NamedEntity ent = new NamedEntity();
            for(Article art : allArticles){
                ent.parseFromHeuristicCap(art);
            }
            ent.print();
            // TODO: Print stats
            System.out.println("\nStats: ");
            System.out.println("-".repeat(80));
        }
    }

    // TODO: Maybe relocate this function where it makes more sense
    private static void printHelp(List<FeedsData> feedsDataArray) {
        System.out.println("Usage: make run ARGS=\"[OPTION]\"");
        System.out.println("Options:");
        System.out.println("  -h, --help: Show this help message and exit");
        System.out.println("  -f, --feed <feedKey>:                Fetch and process the feed with");
        System.out.println("                                       the specified key");
        System.out.println("                                       Available feed keys are: ");
        for (FeedsData feedData : feedsDataArray) {
            System.out.println("                                       " + feedData.getLabel());
        }
        System.out.println("  -ne, --named-entity <heuristicName>: Use the specified heuristic to extract");
        System.out.println("                                       named entities");
        System.out.println("                                       Available heuristic names are: ");
        // TODO: Print the available heuristics with the following format
        System.out.println("                                       <name>: <description>");
        System.out.println("  -pf, --print-feed:                   Print the fetched feed");
        System.out.println("  -sf, --stats-format <format>:        Print the stats in the specified format");
        System.out.println("                                       Available formats are: ");
        System.out.println("                                       cat: Category-wise stats");
        System.out.println("                                       topic: Topic-wise stats");
    }

}
