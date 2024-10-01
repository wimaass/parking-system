package entity;

public class ParkingSlot {
    private int slot;
    private Vehicle vehicle;
    private boolean isAvailable;

    public ParkingSlot(int slot, Vehicle vehicle, boolean isAvailable) {
        this.slot = slot;
        this.vehicle = vehicle;
        this.isAvailable = isAvailable;
    }

    public ParkingSlot() {
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean getisAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
