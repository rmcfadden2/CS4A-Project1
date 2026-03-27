public class UtilityDevice extends SmartHome {

    private int powerUsage;
    private int brightness;
    private boolean isClean;

    public UtilityDevice(String name, String color, int yearMade, int powerUsage, int brightness, boolean isClean) {
        super(name, color, yearMade);
        this.powerUsage = powerUsage;
        this.brightness = brightness;
        this.isClean = isClean;
        
    }

    public int getPowerUsage() {
        return powerUsage;
    }

    public int getBrightness() {
        return brightness;
    }

    public boolean getIsClean() {
        return isClean;
    }


    public void setPowerUsage(int powerUsage) {
        this.powerUsage = powerUsage;
    }

    public void setBrightness(int brightness) throws DeviceNotOn{
        // Device off, deny access
        if(!getIsOn())
        {
            throw new DeviceNotOn("Failed to change brightness: Device is OFF");
        }
        // working normally
        this.brightness = brightness;
    }

    public void setIsClean(boolean isClean) {
        this.isClean = isClean;
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
        return super.toString() + 
               "Power Usage: " + powerUsage + " watts\n" +
               "Brightness: " + brightness + " lumens\n" +
               "Cleaning Status: " + (isClean ? "Cleaned" : "Not Cleaned");
    }
}
