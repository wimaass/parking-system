package service;

import entity.EVehicleType;
import entity.ParkingSlot;
import entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingSlotService {
    private static List<ParkingSlot> parkingLot = new ArrayList<>();

    public void createParkingLot(int sizeParkingLot) {
        parkingLot = new ArrayList<>(sizeParkingLot);
        for (int i = 0; i < sizeParkingLot; i++) {
            parkingLot.add(new ParkingSlot(i+1, null, true));
        }
        System.out.println("Created a parking lot with " + sizeParkingLot+" slots");
        System.out.println();
    }

    public void park(String registrationNo, String color, String type) {
        ParkingSlot parkingSlot = parkingLot.stream().filter(parkingSlot1 -> parkingSlot1.getisAvailable()== true).findFirst().orElse(null);
        try{
            EVehicleType vehicleType = EVehicleType.valueOf(type.toUpperCase());
            if(parkingSlot !=null && (vehicleType == EVehicleType.MOBIL || vehicleType == EVehicleType.MOTOR)){
                parkingSlot.setVehicle(new Vehicle(registrationNo, vehicleType, color.toUpperCase()));
                parkingSlot.setAvailable(false);
                System.out.println("Allocated slot number "+ parkingSlot.getSlot());
                System.out.println();
            } else {
                System.out.println("Parking lot is not available");
                System.out.println();
            }
        } catch (IllegalArgumentException e){
            System.out.println("Invalid vehicle type");
            System.out.println();
        }
    }

    public void leaveSlot(int slotNo){
        ParkingSlot parkingSlot = parkingLot.stream().filter(parkingSlot1 -> parkingSlot1.getSlot() == slotNo).findFirst().orElse(null);
        if(parkingSlot != null && !parkingSlot.getisAvailable()){
            parkingSlot.setAvailable(true);
            parkingSlot.setVehicle(null);
            System.out.println("Slot number "+ parkingSlot.getSlot()+" is free");
        } else {
            System.out.println("Parking slot is empty");
        }
    }

    public void displayStatus(){
        System.out.println("Slot\tRegistration No\t\tType\t\tColor");
        for (ParkingSlot parkingSlot : parkingLot) {
            if(!parkingSlot.getisAvailable()){
                Vehicle vehicle = parkingSlot.getVehicle();
                System.out.println(parkingSlot.getSlot()+"\t\t"+vehicle.getRegistrationNumber()+"\t\t\t"+vehicle.getType()+"\t\t"+vehicle.getColor());
            }
        }
        System.out.println();
    }

    public void reportVehicleByType(String type){
        try{
            EVehicleType vehicleType = EVehicleType.valueOf(type.toUpperCase());
            long count = parkingLot.stream().filter(p -> !p.getisAvailable() && p.getVehicle().getType() == vehicleType).count();
            System.out.println(count);
            System.out.println();
        } catch (IllegalArgumentException e){
            System.out.println("Invalid vehicle type");
            System.out.println();
        }
    }

    public void reportOddPlates(){
        List<String> oddPlates = new ArrayList<>();
        for (ParkingSlot parkingSlot : parkingLot) {
            if(!parkingSlot.getisAvailable() && Integer.parseInt(parkingSlot.getVehicle().getRegistrationNumber().split("-")[1])% 2!=0) {
                oddPlates.add(parkingSlot.getVehicle().getRegistrationNumber());
            }
        }
        System.out.println(String.join(", ", oddPlates));
        System.out.println();
    }

    public void reportEvenPlates(){
        List<String> evenPlates = new ArrayList<>();
        for (ParkingSlot parkingSlot : parkingLot) {
            if(!parkingSlot.getisAvailable() && Integer.parseInt(parkingSlot.getVehicle().getRegistrationNumber().split("-")[1])% 2==0) {
                evenPlates.add(parkingSlot.getVehicle().getRegistrationNumber());
            }
        }
        System.out.println(String.join(", ", evenPlates));
        System.out.println();
    }

    public void reportByColor(String color){
        List<String> vehiclePlates = new ArrayList<>();
        for (ParkingSlot parkingSlot : parkingLot) {
            if(!parkingSlot.getisAvailable() && parkingSlot.getVehicle().getColor().equals(color.toUpperCase())){
                vehiclePlates.add(parkingSlot.getVehicle().getRegistrationNumber());
            }
        }
        System.out.println(String.join(", ", vehiclePlates));
        System.out.println();
    }

    public void findSlotByColor(String color){
        for (ParkingSlot parkingSlot : parkingLot) {
            if(!parkingSlot.getisAvailable() && parkingSlot.getVehicle().getColor().equals(color.toUpperCase())){
                System.out.println("Slot No "+parkingSlot.getSlot());
            }
        }
        System.out.println();
    }

    public void findSlotByRegNo(String regNo){
        ParkingSlot parkingSlot = parkingLot.stream().filter(p->!p.getisAvailable() && p.getVehicle().getRegistrationNumber().equals(regNo)).findFirst().orElse(null);
        if(parkingSlot != null){
            System.out.println("Slot No "+parkingSlot.getSlot());
            System.out.println();
        } else {
            System.out.println("Not found");
            System.out.println();
        }

    }
}
