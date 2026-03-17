import java.util.*;

public class SecurityDevice extends SmartHome implements Permissions
{
    private boolean alarmArmed;
    private boolean motionDetected;
    private String location;
    private ArrayList<String> allowedUsers = new ArrayList<>();

    public SecurityDevice()
    {
        super();
        this.alarmArmed = true;
        this.motionDetected = false;
    }

    public SecurityDevice(String name, String color, int yearMade, 
                            boolean alarmArmed, String location)
    {
        super(name, color, yearMade);
        this.alarmArmed = alarmArmed;
        this.motionDetected = false;
        this.location = location;
    }

    public void armSystem()
    {
        this.alarmArmed = true;
    }

    public void disarmSystem()
    {
        this.alarmArmed = false;
    }

    public boolean isArmed()
    {
        return this.alarmArmed;
    }

    public boolean getMotionDetected()
    {
        return this.motionDetected;
    }

    public void setMotionDetected(boolean motionDetected)
    {
        this.motionDetected = motionDetected;
    }

    public String getLocation()
    {
        return this.location;
    }

    public void detectMotion() throws DeviceNotOn
    {
        if(!getIsOn())
        {
            throw new DeviceNotOn("Cannot detect motion because the device is OFF.");
        }
        motionDetected = true;
        if(alarmArmed)
        {
            System.out.println("ALERT: Motion detected at " + this.location);
        }
    }

    public void resetMotion()
    {
        this.motionDetected = false;
    }

    public void turnOn()
    {
        setIsOn(true);
    }

    public void turnOff()
    {
        setIsOn(false);
        disarmSystem();
    }

    @Override
    public boolean isOn()
    {
        return this.getIsOn();
    }

    @Override
    public boolean isExpired()
    {
        return this.getIsExpired();
    }

@Override
public String toString() {
    // 25 => Width of column, %s => String, %n => newline, -  => Left align
    StringBuilder sb = new StringBuilder();
    sb.append("-------------------------------------------------------\n");
    sb.append(String.format("%-25s %s%n", "Device Name:", this.getName()));
    sb.append(String.format("%-25s %s%n", "Location:", this.location));
    sb.append(String.format("%-25s %s%n", "Color:", this.getColor()));
    sb.append(String.format("%-25s %d%n", "Year Made:", this.getYearMade()));
    sb.append(String.format("%-25s %s%n", "Date Added:", this.getDateAdded()));
    sb.append(String.format("%-25s %b%n", "Is the Device On:", this.getIsOn()));
    sb.append(String.format("%-25s %b%n", "Has Warranty Expired:", this.isExpired()));
    sb.append(String.format("%-25s %b%n", "Is the System Armed:", this.isArmed()));
    sb.append(String.format("%-25s %b%n", "Motion Detected:", this.motionDetected));
    sb.append("-------------------------------------------------------\n");
    return sb.toString();
}

    // implementing Permissions interface
    @Override
    public boolean hasPermission(String user)
    {
        if(allowedUsers.isEmpty())
            return false;
        else
        {
            if(allowedUsers.contains(user))
                return true;
            else
                return false;
        }
    }

    @Override
    public void addPermission(String user)
    {
        allowedUsers.add(user);
    }

    @Override
    public void removePermission(String user) throws InvalidPermission
    {
        if(!allowedUsers.contains(user))
        {
            throw new InvalidPermission("Unable to remove. User does not have Permission!");
        }
        allowedUsers.remove(user);
    }

    @Override
    public void showPermissions()
    {
        if(allowedUsers.isEmpty())
            System.out.println("There are no allowed users");
        else
        {
            if(allowedUsers.size() == 1)
            { 
                System.out.println("Allowed users are: ");
                System.out.println(allowedUsers.get(0));
            }
            else
            {
                System.out.println("Allowed users are: ");
                for(int i = 1; i <= allowedUsers.size(); i++)
                {
                    if(i % 10 != 0)
                        System.out.print(allowedUsers.get(i - 1) + ", ");
                    else
                        System.out.println(allowedUsers.get(i - 1) + ",");
                }
            }
        }
    }
}
