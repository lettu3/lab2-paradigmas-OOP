package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {

    static public List<FeedsData> parseJsonFeedsData(String jsonFilePath) throws IOException {
        String jsonData = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        List<FeedsData> feedsList = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(jsonData);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String label = jsonObject.getString("label");
            String url = jsonObject.getString("url");
            String type = jsonObject.getString("type");
            feedsList.add(new FeedsData(label, url, type));
        }
        return feedsList;
    }

    
    static public List<DictEntity> parseJsonDictEntity (String jsonFilePath) throws IOException {
        List<DictEntity> entityList = new ArrayList<>();
        
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(jsonFilePath)));    
            JSONArray jsonArray = new JSONArray(jsonData);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject (i);
                String label = jsonObject.getString("label");
                String category = jsonObject.getString("category");
                List<String> topics = getStringListFromJSONArray(jsonObject.getJSONArray("Topic"));
                List<String> keywords = getStringListFromJSONArray(jsonObject.getJSONArray("keywords"));
 
                entityList.add(new DictEntity(label, category, topics, keywords));
                
            }
 
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        return entityList;
        
    }

    private static List<String> getStringListFromJSONArray (JSONArray jsonArray) {
        List<String> myList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++){
            myList.add(jsonArray.getString(i));
        }

        return myList;
    }

}
