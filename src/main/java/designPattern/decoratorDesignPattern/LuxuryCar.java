package designPattern.decoratorDesignPattern;

public class LuxuryCar extends BasicCar {

        public LuxuryCar(BasicCar basicCar) {
            super(basicCar);
            this.setProperties(basicCar.getProperties() + " is a luxury car.");
        }

        @Override
        public String whoami() {
            return             super.whoami() + " is a luxury car.";
        }
    }