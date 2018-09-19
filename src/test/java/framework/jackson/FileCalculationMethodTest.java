package framework.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;

public class FileCalculationMethodTest {

    @Test
    public void testGson() {
        System.out.println(new Gson().toJson(FileCalculationMethod.values()));
    }

    @Test
    public void testJackson() throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(FileCalculationMethod.values()));
    }

}