package designPattern.decoratorDesignPattern;

public class SportCar extends BasicCar {

        public SportCar(BasicCar basicCar) {
            super(basicCar);
            this.setProperties(basicCar.getProperties() + " is a sport car.");
        }

        @Override
        public String whoami() {
            return super.whoami() + " is a sport car.";
        }
    }