package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by long on 14.06.2017.
 */
public class FileTest {
    private static String OS = System.getProperty("os.name").toLowerCase();


    @Test
    public void testSpaceInDir() throws IOException {
        if(OS.contains("win")) {
            File file = new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0");
            for (File file1 : file.listFiles()) {
                System.out.println(file1.getCanonicalPath());
            }

            URL url = file.toURI().toURL();
            System.out.println(url.toString());
        }
    }

//    @Test(expected = IOException.class)     //access is denied
    public void testWritePermission() throws IOException {
        if(OS.contains("win")) {
            File file = new File("C:\\price_.xlsx");
            file.createNewFile();
        } else {
            throw new IOException("mock IO exception since it is not a windows sys");
        }
    }
}

