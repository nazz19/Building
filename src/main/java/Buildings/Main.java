package Buildings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "C:\\Users\\User\\IdeaProjects\\Building\\src\\main\\resources\\log4j2.xml");
        Logger logger = LogManager.getLogger();
        Building building = new Building("Здание 1");
        Room room = new Room("Комната 1", 100, 3);
        Room room1 = new Room("Комната 2", 5, 2);
        building.addRoom(room);
        building.addRoom(room1);
        building.getRoom("Комната 1").add(new Lamp(150));
        building.getRoom("Комната 1").add(new Lamp(2500));
        building.getRoom("Комната 1").add(new Table("Стол письменный", 3));
        building.getRoom("Комната 1").add(new Chair("Кресло мягкое и ушистое", 1));
        building.describe();

    }
}
