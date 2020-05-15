package Buildings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Room {
    String name;
    int windowNum, area;
    private Logger logger = LogManager.getLogger();
    private List<Items> furniture = new ArrayList();
    private List<Lamp> lamps = new ArrayList();
    static int MAXSPACEPERCENT = 70;
    static int MAXLIGHT = 4000;
    static int WINDOWLIGHT = 700;

    public Room(String name, int area, int windowNum) {
        this.name = name;
        this.windowNum = windowNum;
        this.area = area;
    }

    public void add(Lamp lamp) {
        if (isIlluminanceToomuch(lamp.getLampLight()) == true) {
            lamps.add(lamp);
        } else
            try {
                throw new IlluminanceTooMuchException();
            } catch (IlluminanceTooMuchException e) {
                logger.error("Too much light in room!");
            }
    }

    public int getFreeSpacePercent() {
        int freeSpace = getFreeSpace();
        int notFreeSpace = getOccipiedPlace();
        int roomArea = getArea();
        int freeSpacePercent = 0;

        freeSpacePercent = (100 - ((100 * notFreeSpace) / roomArea));

        return freeSpacePercent;
    }

    @Override
    public String toString() {
        return name + '\n' +
                "Освещеннось = " + (getTotalLightOfLamp() + windowNum * WINDOWLIGHT) +
                " (" + windowNum +
                " окна по " + WINDOWLIGHT + " лк,  " + getAllLamps() +
                '\n' +
                "Площадь " + getArea() +
                " ( занято " + getOccipiedPlace() +
                "м^2, гарантированно свободно " + getFreeSpace() +
                " или " + getFreeSpacePercent() + "% площади)" + '\n'
                + "Мебель " + '\n' + getAllFurniture();
    }

    public void add(Table table) {
        if (isSpaceUsageTooMuch(table.furnitureArea()) == true) {
            furniture.add(table);

        } else
            try {
                throw new SpaceUsageTooMuchException();
            } catch (SpaceUsageTooMuchException e) {
                logger.error("Too little space in room!");
            }

    }

    public void add(Chair chair) {
        if (isSpaceUsageTooMuch(chair.furnitureArea()) == true) {
            furniture.add(chair);
        } else
            try {
                throw new SpaceUsageTooMuchException();
            } catch (SpaceUsageTooMuchException e) {
                logger.error("Too little space in room!");
            }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWindowNum() {
        return windowNum;
    }

    public void setWindowNum(int windowNum) {
        this.windowNum = windowNum;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getAllFurniture() {
        String fAll = "";
        if (!furniture.isEmpty()) {
            for (Items furnitures : furniture) {
                fAll += furnitures.furnitureName() + " (площадь  " + furnitures.furnitureArea() + "м^2)" + '\n';

            }
        } else fAll = "Мебели нет";
        return fAll;
    }

    public StringBuffer getAllLamps() {
        StringBuffer allLamps = new StringBuffer("лампочки ");
        if (!lamps.isEmpty()) {
            for (Lamp lamp : lamps) {
                allLamps.append(lamp + "и");
            }
            allLamps.replace((allLamps.length() - 1), allLamps.length(), ")");
        } else allLamps.replace(0, allLamps.length(), "лампочек нет");
        return allLamps;
    }

    public int getTotalLightOfLamp() {
        int totalLight = 0;
        for (Lamp lamp : lamps) {
            totalLight += lamp.getLampLight();
        }
        return totalLight;
    }

    public int getOccipiedPlace() {

        int totalSpace = 0;
        for (Furniture f : furniture) {
            totalSpace += f.furnitureArea();
        }
        return totalSpace;
    }

    public int getFreeSpace() {
        int freeSpace = 0;
        freeSpace = getArea() - getOccipiedPlace();
        return freeSpace;
    }

    private boolean isSpaceUsageTooMuch(int area) {
        int totalSpace = getOccipiedPlace() + area;
        int roomArea = getArea();
        int x = (totalSpace * 100) / roomArea;
        if (x <= MAXSPACEPERCENT)
            return true;
        return false;
    }

    private boolean isIlluminanceToomuch(int lamp) {
        int totalLight = getTotalLightOfLamp() + lamp;
        int t = totalLight + (getWindowNum() * WINDOWLIGHT);
        if (t <= MAXLIGHT) return true;
        return false;
    }


}
