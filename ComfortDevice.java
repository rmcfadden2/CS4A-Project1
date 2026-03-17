public class ComfortDevice extends SmartHome {

    private int temperatureSetting;

    public ComfortDevice(String name, String color, int yearMade, int temperatureSetting) {
        super(name, color, yearMade);
        this.temperatureSetting = temperatureSetting;
    }

    public int getTemperatureSetting() {
        return temperatureSetting;
    }

    public void setTemperatureSetting(int temperatureSetting) {
        this.temperatureSetting = temperatureSetting;
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
               "Temperature Setting: " + temperatureSetting + "\n";
    }
}
