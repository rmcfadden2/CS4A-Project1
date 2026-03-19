import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // this is a test
        ArrayList<SmartHome> smartDevices = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int menuInput, deviceInput, deviceOption;

        smartDevices.add(new SecurityDevice("Door Sensor", "White", 2025, true, "Front Door"));
        smartDevices.add(new SecurityDevice("Camera",      "White", 2016, false,"Backyard"));

        smartDevices.add(new UtilityDevice("Light Bulb"   , "Yellow", 2005,8));
        smartDevices.add(new UtilityDevice("Smart Fridge" , "Grey"  , 2018,300));

        smartDevices.add(new ComfortDevice("Smart Thermostat"  , "Light Grey", 2014,66));
        smartDevices.add(new ComfortDevice("Smart Ceiling Fan" , "White"     , 2017,68));

        // for(SmartHome device : smartDevices)
        // {
        //     if(device instanceof Permissions p)
        //     {
        //         p.showPermissions();

        //         System.out.println("Enter user to add: ");
        //         String user = input.nextLine();
        //         System.out.println("Adding new user " + user + "...");
        //         p.addPermission(user);

        //         p.showPermissions();

        //          // Error handling for removing a user
        //         // that d.n.e
        //         try
        //         {
        //             System.out.println("Enter user to remove: ");
        //             String user2 = input.nextLine();
        //             System.out.println("Removing " + user2 + "...");
        //             p.removePermission(user2);
        //         }
        //         catch(InvalidPermission e)
        //         {
        //             System.out.println(e.getMessage());
        //         } 
        //         p.showPermissions();
        //     }
        // }

        do
        {
            System.out.println("-------------------------------------------------------");
            System.out.println("Control Panel Options: \n1. Security Devices\n2. Utility Devices\n3. Comfort Devices");

            System.out.println("\n\'0\' to exit.");
            System.out.print("Enter option: ");
            menuInput = input.nextInt() - 1;

            System.out.println("-------------------------------------------------------");

            switch(menuInput)
            {
                case 0:
                    System.out.println("Security Devices: \n1. Door Sensor\n2. Camera");
                    System.out.print("Which security device do you wish to change?: ");
                    
                    try
                    {
                        deviceInput = input.nextInt() - 1;

                        if(deviceInput < 1 || deviceInput > 2)
                        {
                            throw new Exception("Exiting...");
                        }

                        System.out.println("\nDevice Functions: \n1. Toggle Power - "           +                 (smartDevices.get(deviceInput).getIsOn() ? "On" : "Off") +
                                                               "\n2. Toggle system armed - "    + ((SecurityDevice)smartDevices.get(deviceInput)).isArmed()                + 
                                                               "\n3. Toggle motion detected - " + ((SecurityDevice)smartDevices.get(deviceInput)).getMotionDetected()      +
                                                               "\n4. Detect Motion" +
                                                               "\n5. Show Information" +
                                                               "\n6. Show Permissions" +
                                                               "\n7. Add Permissions"  +
                                                               "\n8. Remove Permissions");
                        
                        System.out.print("Enter option number: ");

                        deviceOption = input.nextInt() - 1;

                        switch(deviceOption)
                        {
                            case 0:
                                smartDevices.get(deviceInput).setIsOn(!smartDevices.get(deviceInput).getIsOn());
                            break;

                            case 1:
                                if(((SecurityDevice)smartDevices.get(deviceInput)).isArmed())
                                {
                                    ((SecurityDevice)smartDevices.get(deviceInput)).disarmSystem();
                                }
                                else
                                {
                                    ((SecurityDevice)smartDevices.get(deviceInput)).armSystem();
                                }
                            break;

                            case 2:
                                ((SecurityDevice)smartDevices.get(deviceInput)).setIsOn(!((SecurityDevice)smartDevices.get(deviceInput)).getMotionDetected());
                            break;

                            case 3:
                                try 
                                {
                                    System.out.println("\nAttempting to detect motion...");
                                    ((SecurityDevice)smartDevices.get(deviceInput)).detectMotion(); 
                                } 
                                catch (DeviceNotOn e) 
                                {
                                    System.out.println(e.getMessage());
                                }
                            break;

                            case 4:
                                System.out.println((SecurityDevice)smartDevices.get(deviceInput));
                            break;

                            case 5:
                                ((SecurityDevice)smartDevices.get(deviceInput)).showPermissions();
                            break;

                            case 6:
                                System.out.print("Enter user to add: ");
                                String user = input.nextLine();
                                System.out.println("Adding new user " + user + "...");
                                ((SecurityDevice)smartDevices.get(deviceInput)).addPermission(user);
                            break;

                            case 7:
                                try
                                {
                                    System.out.print("Enter user to remove: ");
                                    String user2 = input.nextLine();
                                    System.out.println("Removing " + user2 + "...");
                                    ((SecurityDevice)smartDevices.get(deviceInput)).removePermission(user2);
                                }
                                catch(InvalidPermission e)
                                {
                                    System.out.println(e.getMessage());
                                } 
                            break;

                            default:
                                try 
                                {
                                    if(deviceOption < 0 || deviceOption > 6)
                                    {
                                        throw new Exception("Exiting...");
                                    }
                                } 
                                catch (Exception e) 
                                {
                                    System.out.println(e.getMessage());
                                }
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                break;

                case 1:
                    System.out.println("Utility Devices: \n1. Light Bulb\n2. Smart Fridge");
                    System.out.print("Which utility device do you wish to change?: ");

                    try
                    {
                        deviceInput = input.nextInt() + 1;

                        if(deviceInput < 3 || deviceInput > 4)
                        {
                            throw new Exception("Exiting...");
                        }

                        System.out.println("\nDevice Functions: \n1. Toggle Power - "    +                (smartDevices.get(deviceInput).getIsOn() ? "On" : "Off") +
                                                               "\n2. Set Power Usage - " + ((UtilityDevice)smartDevices.get(deviceInput)).getPowerUsage()          + 
                                                               "\n3. Show Information");
                        
                        System.out.print("Enter option number: ");

                        deviceOption = input.nextInt() - 1;

                        switch(deviceOption)
                        {
                            case 0:
                                smartDevices.get(deviceInput).setIsOn(!smartDevices.get(deviceInput).getIsOn());
                            break;

                            case 1:
                                System.out.print("Enter power usage: ");
                                int power = input.nextInt();
                                System.out.println("Changing power usage to" + power);
                                ((UtilityDevice)smartDevices.get(deviceInput)).setPowerUsage(power);
                            break;

                            case 2:
                                System.out.println(smartDevices.get(deviceInput));
                            break;

                            default:
                                try 
                                {
                                    if(deviceOption < 0 || deviceOption > 2)
                                    {
                                        throw new Exception("Exiting...");
                                    }
                                } 
                                catch (Exception e) 
                                {
                                    System.out.println(e.getMessage());
                                }
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                break;

                case 2:
                    System.out.println("Comfort Devices: \n1. Smart Thermostat\n2. Smart Ceiling Fan");
                    System.out.print("Which comfort device do you wish to change?: ");

                    try
                    {
                        deviceInput = input.nextInt() + 3;

                        if(deviceInput < 5 || deviceInput > 6)
                        {
                            throw new Exception("Exiting...");
                        }

                        System.out.println("\nDevice Functions: \n1. Toggle Power - "            +                (smartDevices.get(deviceInput).getIsOn() ? "On" : "Off") +
                                                               "\n2. Set Temperature Setting - " + ((ComfortDevice)smartDevices.get(deviceInput)).getTemperatureSetting()  + 
                                                               "\n3. Show Information");
                        
                        System.out.print("Enter option number: ");

                        deviceOption = input.nextInt() - 1;

                        switch(deviceOption)
                        {
                            case 0:
                                smartDevices.get(deviceInput).setIsOn(!smartDevices.get(deviceInput).getIsOn());
                            break;

                            case 1:
                                System.out.print("Enter temperature: ");
                                int temperature = input.nextInt();
                                System.out.println("Changing temperature to" + temperature);
                                ((ComfortDevice)smartDevices.get(deviceInput)).setTemperatureSetting(temperature);
                            break;

                            case 2:
                                System.out.println(smartDevices.get(deviceInput));
                            break;

                            default:
                                try 
                                {
                                    if(deviceOption < 0 || deviceOption > 2)
                                    {
                                        throw new Exception("Exiting...");
                                    }
                                } 
                                catch (Exception e) 
                                {
                                    System.out.println(e.getMessage());
                                }
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                break;

                default:
                    try
                    {
                        if(menuInput < 0 || menuInput > 2)
                        {
                            throw new Exception("Invalid menu input");
                        }
                        else
                        {
                            System.out.println("Logging Off...");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
            }

        } while (menuInput != -1);

        System.out.println(smartDevices.get(0));

        // --- DeviceNotOn ---
        // SmartHome to SecurityDevice
        // for SecurityDevice Methods
        SecurityDevice doorSensor = (SecurityDevice) smartDevices.get(0);
        SecurityDevice camera     = (SecurityDevice) smartDevices.get(1);

        UtilityDevice  lightbulb  = (UtilityDevice)  smartDevices.get(2);
        UtilityDevice  fridge     = (UtilityDevice)  smartDevices.get(3);

        ComfortDevice  thermostat = (ComfortDevice)  smartDevices.get(4);
        ComfortDevice  ceilingFan = (ComfortDevice)  smartDevices.get(5);

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
        System.out.println(camera);         // Prints object referenced by camera
        System.out.println(lightbulb);      // Prints object referenced by light bulb
        System.out.println(fridge);         // Prints object referenced by fridge
        System.out.println(thermostat);     // Prints object referenced by thermostat
        System.out.println(ceilingFan);     // Prints object referenced by ceiling fan

        input.close();
    }
}
