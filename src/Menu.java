import service.ParkingSlotService;
import util.InputHandler;

import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    private static final ParkingSlotService parkingSlotService = new ParkingSlotService();
    private static final InputHandler inputHandler = new InputHandler();

    public static void menu() {
        System.out.println("Menu Parking System");
        System.out.println("1. Create Parking Lot");
        System.out.println("2. Park");
        System.out.println("3. Leave");
        System.out.println("4. Status");
        System.out.println("5. Count Vehicle By Type");
        System.out.println("6. Get Registration Number By Odd Number Plate");
        System.out.println("7. Get Registration Number By Even Number Plate");
        System.out.println("8. Get Registration Number By Vehicle Color");
        System.out.println("9. Get Slot By Color");
        System.out.println("10. Get Slot By Registration Number");
        System.out.println("11. Exit");
    }

    public static void run() {
        while (true) {
            menu();
            int choice = inputHandler.getInt("Please enter your choice: ");
            switch (choice) {
                case 1:
                    createParkingLot();
                    break;
                case 2:
                    park();
                    break;
                case 3:
                    leave();
                    break;
                case 4:
                    parkingSlotService.displayStatus();
                    break;
                case 5:
                    countVehicleByType();
                    break;
                case 6:
                    parkingSlotService.reportOddPlates();
                    break;
                case 7:
                    parkingSlotService.reportEvenPlates();
                    break;
                case 8:
                    getRegisNoByColor();
                    break;
                case 9:
                    getSlotByColor();
                    break;
                case 10:
                    getSlotByNumber();
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid command");

            }
        }
    }

    public static void createParkingLot() {
        int sizeOfParkingLot = inputHandler.getInt("Insert size of parking lot: ");
        parkingSlotService.createParkingLot(sizeOfParkingLot);
    }

    public static void park() {
        String registrationNo = inputHandler.getString("Please enter registration number: ");
        String color = inputHandler.getString("Please enter color: ");
        String vehicleType = inputHandler.getString("Please enter vehicle type: ");
        parkingSlotService.park(registrationNo, color, vehicleType);
    }

    public static void leave() {
        int slotNo = inputHandler.getInt("Please enter slot number: ");
        parkingSlotService.leaveSlot(slotNo);
    }

    public static void countVehicleByType() {
        String vehicleType = inputHandler.getString("Please enter vehicle type: ");
        parkingSlotService.reportVehicleByType(vehicleType);
    }

    public static void getRegisNoByColor() {
        String color = inputHandler.getString("Please enter color: ");
        parkingSlotService.reportByColor(color);
    }

    public static void getSlotByColor() {
        String color = inputHandler.getString("Please enter color: ");
        parkingSlotService.findSlotByColor(color);
    }

    public static void getSlotByNumber() {
        String regNo = inputHandler.getString("Please enter registration number: ");
        parkingSlotService.findSlotByRegNo(regNo);
    }
}
