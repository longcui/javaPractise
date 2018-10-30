package java7;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;

public class TryWithResourceTest {
    @Test
    public void test() {
        String TRY_WITH_RESOURCE_TEST = "TryWithResourceTest";
        URL url = getClass().getClassLoader().getResource(TRY_WITH_RESOURCE_TEST);

        LocalDateTime now = LocalDateTime.now();

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(url.getFile())))) {
            objectOutputStream.writeObject(now);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream objectInputStream = new ObjectInputStream(url.openStream())) {
            Object readObject = objectInputStream.readObject();
            Assert.assertEquals(now, readObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
