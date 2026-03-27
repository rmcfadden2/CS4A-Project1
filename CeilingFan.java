public class CeilingFan extends ComfortDevice {
    private int rpm;

    public CeilingFan(String name, String color, int yearMade, int rpm) {
        super(name, color, yearMade);
        this.rpm = rpm;
    }

    public int getRpm() 
    {
        return rpm;
    }

    public void setRpm(int rpm) throws DeviceNotOn
    {
        // Device off, deny access
        if(!getIsOn())
        {
            throw new DeviceNotOn("Failed to change rpm: device is OFF.");
        }

        this.rpm = rpm;
    }

    @Override
    public String toString() 
    {
        return super.toString() + "Fan Speed Setting: " + rpm + " rpm\n";
    }
}
