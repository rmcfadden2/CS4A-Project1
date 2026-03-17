import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // this is a test
        ArrayList<SmartHome> smartDevices = new ArrayList<>();

        smartDevices.add(new SecurityDevice("Door Sensor", "White", 2025, 
                            true, "Front Door"));

        for(SmartHome device : smartDevices)
        {
            if(device instanceof Permissions p)
            {
                p.showPermissions();

                p.addPermission("Robert McFadden");

                p.showPermissions();
            }
        }

        System.out.println(smartDevices.get(0));
    }
}
