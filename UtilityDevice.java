public class UtilityDevice extends SmartHome {
    private int powerUsage;

    public UtilityDevice(String name, String color, int yearMade, int powerUsage) {
        super(name, color, yearMade);
        this.powerUsage = powerUsage;  
    }

    public int getPowerUsage() {
        return powerUsage;
    }

    public void setPowerUsage(int powerUsage) throws DeviceNotOn {
        
        // Device off, deny access
        if(!getIsOn())
        {
            throw new DeviceNotOn("Failed to change power usage: Device is OFF");
        }
        // working normally
        this.powerUsage = powerUsage;
    }

    @Override
    public boolean isOn() {
        return getIsOn();
    }

    @Override
    public boolean isExpired() {
        return getIsExpired();
    }

    @Override
    public String toString() {
        return super.toString() + "Power Usage: " + powerUsage + " watts\n";
    }
}
