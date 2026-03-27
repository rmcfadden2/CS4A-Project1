public class ComfortDevice extends SmartHome {

    public ComfortDevice(String name, String color, int yearMade) {
        super(name, color, yearMade);
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
        return super.toString();
    }
}
