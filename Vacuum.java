public class Vacuum extends UtilityDevice 
{
    private boolean isClean;

    public Vacuum(String name, String color, int yearMade, int powerUsage, boolean isClean) 
    {
        super(name, color, yearMade,powerUsage);
        this.isClean = isClean;
    }

    public boolean getIsClean() 
    {
        return isClean;
    }

    public void setIsClean(boolean isClean) throws DeviceNotOn
    {
        // Device off, deny access
        if(!getIsOn())
        {
            throw new DeviceNotOn("Failed to change cleaning setting: Device is OFF");
        }
        
        this.isClean = isClean;
    }

    @Override
    public String toString() 
    {
        return super.toString() + "Cleaning Status: " + (isClean ? "Cleaned" : "Not Cleaned");
    }
}
