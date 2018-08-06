import org.apache.log4j.BasicConfigurator;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;

/**
 * Created by long on 30.01.2017.
 */
public class ExceptionPractice {
    Logger logger = LoggerFactory.getLogger(ExceptionPractice.class);


    @Test
    public void test() {
        BasicConfigurator.configure();      //this is used for log4j conf

        try {
            String a = null;
            logger.info("a value is: " + a);
            String b = a.trim();
        } catch (Exception e){
            Assert.assertEquals("java.lang.NullPointerException", e.toString());
//            e.printStackTrace();
        }
    }

    @Test
    public void testSpeed() {
        String a = "aa";
        Date b = new Date();
        int c = 0;
        UUID uuid = UUID.randomUUID();

        int i = 0;

        i = 0;
        c = 0;
        long l = System.currentTimeMillis();
        while(i ++ < 1000000){
            logger.info("a : {}, b: {}, c: {}, uuid: {}", a, b, c, uuid);
            c ++;
            b = new Date();
        }
        long time2 = System.currentTimeMillis() - l;

        i = 0;
        c = 0;
        l = System.currentTimeMillis();
        while(i ++ < 1000000){
            logger.info("a : " + a + ", b: " + b + ", c: " + c + ", uuid: " + uuid);
            c ++;
            b = new Date();
        }
        long time1 = System.currentTimeMillis() - l;
        logger.info("time1: " + time1);
        logger.info("time2: " + time2);


    }


}
