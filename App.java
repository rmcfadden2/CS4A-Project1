import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // this is a test
        ArrayList<SmartHome> smartDevices = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        smartDevices.add(new SecurityDevice("Door Sensor", "White", 2025, 
                            true, "Front Door"));

        for(SmartHome device : smartDevices)
        {
            if(device instanceof Permissions p)
            {
                p.showPermissions();

                System.out.println("Enter user to add: ");
                String user = input.nextLine();
                System.out.println("Adding new user " + user + "...");
                p.addPermission(user);

                p.showPermissions();

                 // Error handling for removing a user
                // that d.n.e
                try
                {
                    System.out.println("Enter user to remove: ");
                    String user2 = input.nextLine();
                    System.out.println("Removing " + user2 + "...");
                    p.removePermission(user2);
                }
                catch(InvalidPermission e)
                {
                    System.out.println(e.getMessage());
                } 
                p.showPermissions();
            }
        }

        System.out.println(smartDevices.get(0));
        // --- DeviceNotOn ---
        // SmartHome to SecurityDevice
        // for SecurityDevice Methods
        SecurityDevice doorSensor = (SecurityDevice) smartDevices.get(0);

        // Device OFF => triggers exception
        doorSensor.turnOff();
        try {
            System.out.println("\nAttempting to detect motion while device is OFF...");
            doorSensor.detectMotion();  // Will throw DeviceNotOn
        } catch (DeviceNotOn e) {
            System.out.println(e.getMessage());
        }

        // Device ON => works normally
        // catch ignored
        doorSensor.turnOn();
        try {
            System.out.println("\nAttempting to detect motion while device is ON...");
            doorSensor.detectMotion();  // Should succeed
        } catch (DeviceNotOn e) {
            System.out.println(e.getMessage());
        }

        // Final device status
        System.out.println("\nFinal device status:");
        System.out.println(doorSensor);     // Prints object referenced by door sensor

        input.close();
    }
}
