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
import utils.Stats;
import utils.UserInterface;

public class App {

    public static void main(String[] args) throws IOException {

        // Configuración del input
        UserInterface ui = new UserInterface();
        Config config = ui.handleInput(args);

        // Parseo de todos los feeds disponibles
        List<FeedsData> feedsDataArray = new ArrayList<>();
        try {
            feedsDataArray = JSONParser.parseJsonFeedsData("src/data/feeds.json");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        

        if(args.length == 0 || config.getPrintHelp()){
            UserInterface.printHelp();
            System.exit(0);
        }
        // Parseo del diccionario
        DictEntity dictEntity = new DictEntity();
        dictEntity = JSONParser.parseJsonDictEntity("src/data/dictionary.json");

        try {
            run(config, feedsDataArray, dictEntity);
        }
        catch (Exception e){ // atrapa todas las excepciones
            e.printStackTrace();
        }
    }

    private static void run(Config config, List<FeedsData> feedsDataArray, DictEntity dictEntity) throws MalformedURLException, IOException, Exception {

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

        if (config.getPrintFeed()) {
            System.out.println("Printing feed(s) ");
            for(FeedsData feedData : feedsDataArray){
                if (feedKey.equals("all") || feedData.getLabel().equals(feedKey)){
                    feedData.print();
            }
        }
    }

        if (config.getComputeNamedEntities()) {
            System.out.println("Computing named entities using ");
            System.out.println(config.getHeuristic());
            // Now, parsing in use is parseFromHeuristicCap
            NamedEntity ent = new NamedEntity();
            for(Article art : allArticles){
                if(config.getHeuristic().equals("cap")) {
                    ent.parseFromHeuristicCap(art);
                } else if(config.getHeuristic().equals("doublecap")) {
                    ent.parseFromDoubleHeuristicCap(art);
                } else if(config.getHeuristic().equals("corp")) {
                    ent.parseFromCorporationCap(art);
                }   
                else {
                    System.out.println("Heuristic not found");
                    System.exit(1);
                }
                // TODO: imprimir artículos?
                //art.printArticle();
            }
            ent.print();

            for (String s : ent.listNamedEntities){
                String label = dictEntity.getLabelFromKeyword(s);
                if(label != null){
                    dictEntity.increaseAppearanceCount(label); 
                }
            }
            dictEntity.print();

            //Create an instance of each Entity class for each entity that appeared in the articles.
            List<NamedEntity> entitiesForClass = Stats.objectCreator(Stats.getAppearedEntities(dictEntity.dictionary));

            System.out.println("-".repeat(80));
            System.out.println(entitiesForClass.size() + " objetos creados.");
            System.out.println("\nStats: ");
            Stats stats = new Stats();
            stats.printStatsByMode(Stats.getAppearedEntities(dictEntity.dictionary), config.getMode());
        }
    }
}


