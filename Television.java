public class Television extends ComfortDevice {
    private int channel;

    public Television(String name, String color, int yearMade, int channel) {
        super(name, color, yearMade);
        this.channel = channel;
    }

    public int getChannel() 
    {
        return channel;
    }

    public void setChannel(int channel) throws DeviceNotOn
    {
        // Device off, deny access
        if(!getIsOn())
        {
            throw new DeviceNotOn("Failed to change channel: device is OFF.");
        }
        
        this.channel = channel;
    }

    @Override
    public boolean isOn() {
        return getIsOn();
    }

    @Override
    public String toString()
    {
        return super.toString() + "TV Channel: " + channel + "\n";
    }
}
