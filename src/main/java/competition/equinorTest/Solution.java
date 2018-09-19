package competition.equinorTest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Solution {
    /*
     * Complete the function below.
     */
    static int getNumberOfMovies(String substr) {
        /*
         * Endpoint: "https://jsonmock.hackerrank.com/api/movies/search/?Title=substr"
         */
        String endPoint = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr;
        try {
            InputStream inputStream = new URL(endPoint).openStream();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader(inputStream));
            JsonObject rootObj = root.getAsJsonObject();
            return rootObj.get("total").getAsInt();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
