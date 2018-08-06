package designPattern.decoratorDesignPattern;

public class BasicCar implements Car{
    protected String name;
        protected String properties;

        public BasicCar(String name) {
            this.name = name;
            this.properties = "is a basic car.";
        }

        public BasicCar(BasicCar basicCar) {
            this.name = basicCar.name;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    @Override
        public String whoami() {
            return "is a basic car.";
        }
    }