package Buildings;

public class Lamp {
    private int lampLight;

    @Override
    public String toString() {
        return
                " " + lampLight + " лк ";

    }

    public Lamp(int lampLight) {

        this.lampLight = lampLight;
    }


    public int getLampLight() {
        return lampLight;
    }

    public void setLampLight(int lampLight) {
        this.lampLight = lampLight;
    }
}
