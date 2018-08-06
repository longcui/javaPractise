package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by long on 14.06.2017.
 */
public class FileTest {

    @Test
    public void testSpaceInDir() throws IOException, URISyntaxException {
        File file = new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0");
        for (File file1 : file.listFiles()) {
            System.out.println(file1.getCanonicalPath());
        }

        URL url = file.toURI().toURL();
        System.out.println(url.toString());


    }
}
