package designPattern;

import designPattern.decoratorDesignPattern.BasicCar;
import designPattern.decoratorDesignPattern.LuxuryCar;
import designPattern.decoratorDesignPattern.SportCar;
import org.junit.Test;

public class DecoratorDesignPatternExampleTest {

    @Test
    public void test() {
        LuxuryCar luxuryCar = new LuxuryCar(new SportCar(new BasicCar("telsa")));
        System.out.println(luxuryCar.getProperties());

    }

}