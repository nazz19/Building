package Buildings;

public class Items implements Furniture {
    private String nameF;
    private int areaF;

    public Items(String nameF, int areaF) {
        this.nameF = nameF;
        this.areaF = areaF;
    }

    @Override
    public String toString() {
        return "Items{" +
                "nameF='" + nameF + '\'' +
                ", areaF=" + areaF +
                '}';
    }

    public String furnitureName() {
        return nameF;
    }

    public int furnitureArea() {
        return areaF;
    }

    public void setFurnitureName(String furnitureName) {
        this.nameF = furnitureName;

    }

    public void setFurnitureArea(int furnitureArea) {
        this.areaF = furnitureArea;
    }
}
