public class Lightbulb extends UtilityDevice{
    private int brightness;

    public Lightbulb(String name, String color, int yearMade, int powerUsage, int brightness) 
    {
        super(name, color, yearMade,powerUsage);
        this.brightness = brightness;
    }

    public int getBrightness() 
    {
        return brightness;
    }

    public void setBrightness(int brightness) throws DeviceNotOn
    {
        // Device off, deny access
        if(!getIsOn())
        {
            throw new DeviceNotOn("Failed to change brightness: Device is OFF");
        }
        // working normally
        this.brightness = brightness;
    }

    @Override
    public String toString() 
    {
        return super.toString() + "Brightness: " + brightness + " lumens\n";
    }
}
