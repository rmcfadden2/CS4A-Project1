import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // this is a test
        ArrayList<SmartHome> smartDevices = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int menuInput, deviceInput, deviceOption;

        smartDevices.add(new SecurityDevice("Door Sensor", "White", 2025, true,  "Front Door"));
        smartDevices.add(new SecurityDevice("Camera",      "White", 2016, false, "Backyard"));

        smartDevices.add(new Lightbulb("Smart Lightbulb" , "Yellow"  , 2011, 30, 100));
        smartDevices.add(new Vacuum(   "Smart Vacuum"    , "Black"   , 2018, 300, false));

        smartDevices.add(new Thermostat("Smart Thermostat"   , "Light Grey", 2014, 70));  
        smartDevices.add(new CeilingFan("Smart Ceiling Fan"  , "White",      2014, 120));                                                                                                                     
        smartDevices.add(new Television("Smart TV" ,           "Black"     , 2024, 68));

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
                        if(!input.hasNextInt())
                        {
                            input.next();
                            throw new Exception("Exiting...");
                        }
                        deviceInput = input.nextInt() - 1;

                        if(deviceInput < 0 || deviceInput > 1)
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

                        deviceOption = input.nextInt();

                        switch(deviceOption)
                        {
                            case 1:
                                smartDevices.get(deviceInput).setIsOn(!smartDevices.get(deviceInput).getIsOn());
                            break;

                            case 2:
                                if(((SecurityDevice)smartDevices.get(deviceInput)).isArmed())
                                {
                                    ((SecurityDevice)smartDevices.get(deviceInput)).disarmSystem();
                                }
                                else
                                {
                                    ((SecurityDevice)smartDevices.get(deviceInput)).armSystem();
                                }
                            break;

                            case 3:
                                ((SecurityDevice)smartDevices.get(deviceInput)).setIsOn(!((SecurityDevice)smartDevices.get(deviceInput)).getMotionDetected());
                            break;

                            case 4:
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

                            case 5:
                                System.out.println((SecurityDevice)smartDevices.get(deviceInput));
                            break;

                            case 6:
                                ((SecurityDevice)smartDevices.get(deviceInput)).showPermissions();
                            break;

                            case 7:
                                input.nextLine();           // Clears buffer (clears \n from) after integer 7 input is read.
                                System.out.print("Enter user to add: ");
                                String user = input.nextLine();
                                System.out.println("Adding new user " + user + "...");
                                ((SecurityDevice)smartDevices.get(deviceInput)).addPermission(user);
                            break;

                            case 8:
                                try
                                {
                                    input.nextLine();       // Clears buffer after integer 8 input is read
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
                                throw new Exception("Exiting...");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                break;

                case 1:
                    System.out.println("Utility Devices: \n1. Light Bulb\n2. Smart Vacuum");
                    System.out.print("Which utility device do you wish to change?: ");

                    try
                    {
                        deviceInput = input.nextInt() + 1; // offset because it is also used as an index for the array list

                        switch(deviceInput)
                        {
                            case 2: // Lightbulb
                                System.out.println("\nDevice Functions: \n1. Toggle Power - "    +                 (smartDevices.get(deviceInput).getIsOn() ? "On" : "Off") +
                                                                       "\n2. Set Power Usage - " +  ((UtilityDevice)smartDevices.get(deviceInput)).getPowerUsage()          +
                                                                       "\n3. Set Brightness  - " +      ((Lightbulb)smartDevices.get(deviceInput)).getBrightness()          +
                                                                       "\n4. Show Information");

                                System.out.print("Enter option number: ");

                                deviceOption = input.nextInt();

                                switch(deviceOption)
                                {
                                    case 1:
                                        smartDevices.get(deviceInput).setIsOn(!smartDevices.get(deviceInput).getIsOn());
                                    break;

                                    case 2:
                                        System.out.print("Enter power usage: ");
                                        int power = input.nextInt();
                                        System.out.println("Changing power usage to" + power);
                                        ((UtilityDevice)smartDevices.get(deviceInput)).setPowerUsage(power);
                                    break;

                                    case 3:
                                        System.out.print("Enter brightness: ");
                                        int brightness = input.nextInt();

                                        try
                                        {
                                            // Set temp while device off
                                            ((Lightbulb)smartDevices.get(deviceInput)).setBrightness(brightness);
                                            System.out.println("Changing brightness to " + brightness);
                                        }
                                        catch(DeviceNotOn e) // Exception is met, and caught here
                                        {
                                            System.out.println(e.getMessage());     // Prints error message
                                        }
                                    break;

                                    case 4:
                                        System.out.println(smartDevices.get(deviceInput));
                                    break;

                                    default:
                                        throw new Exception("Exiting...");
                                }
                            break;

                            case 3: // Vacuum
                                System.out.println("\nDevice Functions: \n1. Toggle Power - "    +                 (smartDevices.get(deviceInput).getIsOn() ? "On" : "Off")                    +
                                                                       "\n2. Set Power Usage - " +  ((UtilityDevice)smartDevices.get(deviceInput)).getPowerUsage()                             +
                                                                       "\n3. Toggle Cleaning - " +        (((Vacuum)smartDevices.get(deviceInput)).getIsClean() ? "Cleaning" : "Not Cleaning") +  
                                                                       "\n4. Show Information");

                                System.out.print("Enter option number: ");

                                deviceOption = input.nextInt();

                                switch(deviceOption)
                                {
                                    case 1:
                                        smartDevices.get(deviceInput).setIsOn(!smartDevices.get(deviceInput).getIsOn());
                                    break;

                                    case 2:
                                        System.out.print("Enter power usage: ");
                                        int power = input.nextInt();
                                        System.out.println("Changing power usage to  " + power);
                                        ((UtilityDevice)smartDevices.get(deviceInput)).setPowerUsage(power);
                                    break;

                                    case 3:
                                        ((Vacuum)smartDevices.get(deviceInput)).setIsClean(!((Vacuum)smartDevices.get(deviceInput)).getIsClean());
                                    break;

                                    case 4:
                                        System.out.println(smartDevices.get(deviceInput));
                                    break;

                                    default:
                                        throw new Exception("Exiting...");
                                }
                            break;

                            default:
                                throw new Exception("Exiting...");
                        }
                    } 
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                break;

                case 2:
                    System.out.println("Comfort Devices: \n1. Smart Thermostat\n2. Smart Ceiling Fan\n3. Smart TV");
                    System.out.print("Which comfort device do you wish to change?: ");

                    try
                    {
                        deviceInput = input.nextInt() + 3; // offset because it is also used as an index for the array list

                        switch(deviceInput)
                        {
                            case 4: // Thermostat
                                System.out.println("\nDevice Functions: \n1. Toggle Power - "    +             (smartDevices.get(deviceInput).getIsOn() ? "On" : "Off") +
                                                                       "\n2. Set Temperature - " + ((Thermostat)smartDevices.get(deviceInput)).getTemperatureSetting()  + 
                                                                       "\n3. Show Information");  

                                System.out.print("Enter option number: ");

                                deviceOption = input.nextInt();

                                switch(deviceOption)
                                {
                                    case 1:
                                        smartDevices.get(deviceInput).setIsOn(!smartDevices.get(deviceInput).getIsOn());
                                    break;

                                    case 2:
                                        System.out.print("Enter new temperature: ");
                                        int temperature = input.nextInt();
                                        try
                                        {
                                            // Set temp while device off
                                            ((Thermostat)smartDevices.get(deviceInput)).setTemperatureSetting(temperature);
                                            System.out.println("Changing temperature to " + temperature);
                                        }
                                        catch(DeviceNotOn e) // Exception is met, and caught here
                                        {
                                            System.out.println(e.getMessage());     // Prints error message
                                        }
                                    break;

                                    case 3:
                                        System.out.println(smartDevices.get(deviceInput));
                                    break;

                                    default:
                                        throw new Exception("Exiting...");
                                }
                            break;

                            case 5: // Ceiling fan
                                System.out.println("\nDevice Functions: \n1. Toggle Power - "            +             (smartDevices.get(deviceInput).getIsOn() ? "On" : "Off") +
                                                                       "\n2. Set Rpm - "                 + ((CeilingFan)smartDevices.get(deviceInput)).getRpm()                 + 
                                                                       "\n3. Show Information");  
                                
                                System.out.print("Enter option number: ");

                                deviceOption = input.nextInt();

                                switch(deviceOption)
                                {
                                    case 1:
                                        smartDevices.get(deviceInput).setIsOn(!smartDevices.get(deviceInput).getIsOn());
                                    break;

                                    case 2:
                                        System.out.print("Enter rpm: ");
                                        int rpm = input.nextInt();

                                        try
                                        {
                                            // Set temp while device off
                                            ((CeilingFan)smartDevices.get(deviceInput)).setRpm(rpm);
                                            System.out.println("Changing rpm to " + rpm);
                                        }
                                        catch(DeviceNotOn e) // Exception is met, and caught here
                                        {
                                            System.out.println(e.getMessage());     // Prints error message
                                        }
                                    break;

                                    case 3:
                                        System.out.println(smartDevices.get(deviceInput));
                                    break;

                                    default:
                                        throw new Exception("Exiting...");
                                }
                            break;

                            case 6: // TV
                                System.out.println("\nDevice Functions: \n1. Toggle Power - "            +             (smartDevices.get(deviceInput).getIsOn() ? "On" : "Off") +
                                                                       "\n2. Set Channel - "             + ((Television)smartDevices.get(deviceInput)).getChannel()             +
                                                                       "\n3. Show Information");
                                
                                System.out.print("Enter option number: ");

                                deviceOption = input.nextInt();

                                switch(deviceOption)
                                {
                                    case 1:
                                        smartDevices.get(deviceInput).setIsOn(!smartDevices.get(deviceInput).getIsOn());
                                    break;

                                    case 2:
                                        System.out.print("Enter channel: ");
                                        int channel = input.nextInt();

                                        try
                                        {
                                            // Set temp while device off
                                            ((Television)smartDevices.get(deviceInput)).setChannel(channel);
                                            System.out.println("Changing channel to " + channel);
                                        }
                                        catch(DeviceNotOn e) // Exception is met, and caught here
                                        {
                                            System.out.println(e.getMessage());     // Prints error message
                                        }
                                    break;

                                    case 3:
                                        System.out.println(smartDevices.get(deviceInput));
                                    break;

                                    default:
                                        throw new Exception("Exiting...");
                                }
                            break;

                            default:
                                throw new Exception("Exiting...");
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