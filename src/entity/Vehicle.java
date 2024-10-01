package entity;

public class Vehicle {
    private String registrationNumber;
    private EVehicleType type;
    private String color;

    public Vehicle(String registrationNumber, EVehicleType type, String color) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.color = color;
    }

    public Vehicle() {
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public EVehicleType getType() {
        return type;
    }

    public void setType(EVehicleType type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
