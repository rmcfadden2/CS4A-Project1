public class ComfortDevice extends SmartHome {

    private int temperatureSetting;
    private int rpm;
    private int channel;

    public ComfortDevice(String name, String color, int yearMade, int temperatureSetting, int rpm, int channel) {
        super(name, color, yearMade);
        this.temperatureSetting = temperatureSetting;
        this.rpm = rpm;
        this.channel = channel;
    }

    public int getTemperatureSetting() {
        return temperatureSetting;
    }

        public int getRpm() {
        return rpm;
    }

    public int getChannel() {
        return channel;
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

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public void setChannel(int channel) {
        this.channel = channel;
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
               "Temperature Setting: " + temperatureSetting + " F\n" +
               "Fan Speed Setting: " + rpm + " rpm\n" +
               "TV Channel: " + channel + "\n";
    }
}
