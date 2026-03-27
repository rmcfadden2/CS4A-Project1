public class Thermostat extends ComfortDevice {
    private int temperatureSetting;

    public Thermostat(String name, String color, int yearMade, int temperatureSetting) {
        super(name, color, yearMade);
        this.temperatureSetting = temperatureSetting;
    }

    public int getTemperatureSetting() {
        return temperatureSetting;
    }

    public void setTemperatureSetting(int temperatureSetting) throws DeviceNotOn
    {
        // Device off, deny access
        if(!getIsOn())
        {
            throw new DeviceNotOn("Failed to change temperature: device is OFF.");
        }
        // Working normally
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public String toString() 
    {
        return super.toString() + "Temperature Setting: " + temperatureSetting + " F\n";
    }
}
