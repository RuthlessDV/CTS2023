public class Vehicle {
    public double calculateValue(double a){
        return a;
    }

    public double getValue(double a){
        return a;
    }

}

class Car extends Vehicle{
    public double calculateValue() {
        return this.getValue(calculateValue()) * 0.8;
    }
}

class Truck extends Vehicle{
    public double calculateValue() {
        return this.getValue(calculateValue()) * 0.9;
    }
}
