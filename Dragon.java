//////////////// FILE HEADER //////////////////////////
//
// Title: P03 Dragon Treasure Adventure
// Course: CS 300 Fall 2022
//
// Author: VARDAAN KAPOOR
// Email: VKAPOOR5@WISC.EDU
// Lecturer: (Mouna Kacem, Hobbes LeGault, or Jeff Nyhoff)
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Random;

/**
 * this class makes a dragon and has both static and non static methods
 * 
 * @author vardaan kapoor
 *
 */
public class Dragon {
  private Room currentRoom;
  private Random randGen;
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";// constant

  /**
   * constructor of dragon class-initializes room and random object
   * 
   * @param currentRoom takes in room object and initializes it
   */
  public Dragon(Room currentRoom) {
    randGen = new Random();// initialized object
    this.currentRoom = currentRoom;
  }

  /**
   * accessor
   * 
   * @return current room
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }

  /**
   * accessor
   * 
   * @return dragon warning
   */
  public static String getDragonWarning() {
    return DRAGON_WARNING;
  }

  /**
   * mutator changes room of dragon based on some conditions
   */
  public void changeRooms() {
    boolean y = true;
    while (y) {
      // randomly generated value should be between bounds of size of array which stores all adj
      // rooms
      int r = randGen.nextInt(0, currentRoom.getAdjacentRooms().size());// randomly generate a room
                                                                        // no.

      if (r >= 0) {
        Room randGenerated = currentRoom.getAdjacentRooms().get(r);// get a randomly generated room
        // check portal rooms
        // make a Player class object to access its portal finder method

        // condition 1:is room destination room adjacent to current room
        // condition 2:is destination room a portal room
        if (randGenerated.getType() != RoomType.PORTAL && currentRoom.isAdjacent(randGenerated)) {
          // check if room is adjacent and is not a portal
          currentRoom = randGenerated;
          y = false;
        }
      }
    }
  }
}
