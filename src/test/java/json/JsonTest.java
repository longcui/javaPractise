package json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;


public class JsonTest {

    @Test
    public void testJsonParser() throws ParseException {
        String price = "167757";
        String json = "{  \"price\": " + price + ",  \"cabinName\": \"PLUS\"}";
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(json);
        Assert.assertEquals(Long.parseLong(price), jsonObject.get("price"));
    }
}
