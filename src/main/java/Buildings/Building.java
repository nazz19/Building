package Buildings;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Building {
    private String name;
    private List<Room> rooms = new ArrayList();
    private Logger logger = LogManager.getLogger();

    public Building(String name) {
        this.name = name;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoom(String roomName) {
        Room myRoom = null;
        for (Room room : rooms) {
                if (room.getName().equals(roomName)) {
                    myRoom = room;
                    return myRoom;
                }
        }
        return myRoom;
    }

    @Override
    public String toString() {
        return "Здание " +
                name + '\n'
                ;
    }

    public void describe() {
        for (Room room : rooms) {
            logger.info(name+"\n"+room);
        }

    }
}