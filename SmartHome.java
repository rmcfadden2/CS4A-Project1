import java.util.*;

public abstract class SmartHome {
    private boolean isOn;
    private boolean isExpired;
    private String name;
    private String color;
    private int yearMade;
    private Date dateAdded;

    //Set booleans to be default false when a object is constructed, can be changed in subclass constructors / abstract methods, isOn or isExpired
    protected SmartHome() {
        dateAdded = new Date();
        isOn = false;
        isExpired = false;
    }

    protected SmartHome(String name, String color, int yearMade) {
        dateAdded = new Date();
        isOn = false;
        isExpired = false;
        this.name = name;
        this.color = color;
        this.yearMade = yearMade;
    }

    //Public getters and setters for everything but the booleans
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public String getDateAdded() {
        return dateAdded.toString();
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    //Set getters and setters for booleans to be protected so that only the subclasses can alter them.
    protected boolean getIsOn() {
        return this.isOn;
    }

    protected void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    protected boolean getIsExpired() {
        return this.isExpired;
    }

    protected void setIsExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    //Overridden method toString, can be overridden in subclasses to display additional information, feel free to change the format of the output of this method.
    @Override
    public String toString() {
        return "\nDevice Name: " + name + 
                "\nColor: " + color + 
                "\nYearMade: " + yearMade +
                "\nDate Added: " + dateAdded.toString() + 
                "\nIs the Device On: " + isOn + 
                "\nHas Warranty Expired: " + isExpired + 
                "\n";
    }

    //Abstract methods that need to be defined in subclasses
    public abstract boolean isOn();
    public abstract boolean isExpired();
}
