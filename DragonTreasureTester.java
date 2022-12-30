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
 * This class makes a dragon tester only which contains a main method It calls and checks methods of
 * classes Room, Player,Dragon
 * 
 * @author vardaan kapoor
 *
 */
public class DragonTreasureTester {
  /**
   * checks all instance methods of Room class we make private helper methods to check methods in
   * group
   * 
   * @return true if all methods work properly
   */
  public static boolean testRoomInstanceMethods() {
    try {
      boolean check1 = testConIdDesTyp();
      boolean check2 = testSetTypeAndGetType();
      boolean check3 = testAddToAdjacentRoomsAndGetAdjacentRoomsAndIsAdjacent();
      return check1 && check2 && check3;// checking 3 conditions and returning combined true/false
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * checks all static methods of Room class we make private helper methods to check methods in
   * group
   * 
   * @return true if all methods are working good
   */
  public static boolean testRoomStaticMethods() {
    boolean check1 = testAssignTeleportAndGetTeleport();
    boolean check2 = testGetPortalAndGetTreasureWarning();
    return check1 && check2;
  }

  /**
   * private helper to check if Player class's constructor and getCurrentRoom() are working good
   * 
   * @return true if methods are working good
   */
  private static boolean testPlayerConstructorAndGetCurrentRoom() {
    Room r1 = new Room(6, "This is Room6");
    Player p1 = new Player(r1);
    return p1.getCurrentRoom() == r1;// checking condition and returning simultaneously

  }

  /**
   * checks if one method of player lass can work properly
   * 
   * @return true if no error exists in processing of the function
   */
  public static boolean testPlayerCanMoveTo() {
    // made some rooms for checking
    Room r1 = new Room(5, "This is Room5");
    Room r2 = new Room(6, "This is Room6");
    Room r3 = new Room(7, "This is Room7");
    Room r4 = new Room(10, "This is Room10");
    Room r5 = new Room(11, "This is Room11");

    if (!r1.getAdjacentRooms().contains(r2)) {
      r1.addToAdjacentRooms(r2);
    }
    if (!r1.getAdjacentRooms().contains(r3)) {
      r1.addToAdjacentRooms(r3);
    }
    if (!r1.getAdjacentRooms().contains(r4)) {
      r1.addToAdjacentRooms(r4);
    }
    Player p1 = new Player(r1);
    return p1.canMoveTo(r2) && p1.canMoveTo(r3) && p1.canMoveTo(r4) && !p1.canMoveTo(r5);


  }

  /**
   * private helper to test getPortal and getTreasure warning methods
   * 
   * @return true if both work properly
   */
  private static boolean testGetPortalAndGetTreasureWarning() {
    return Room.getPortalWarning().equals("You feel a distortion in space nearby.\n")
        && Room.getTreasureWarning().equals("You sense that there is treasure nearby.\n");
  }

  /**
   * private helper which checks working of assign and get teleport location methods
   * 
   * @return true if both work properly
   */
  private static boolean testAssignTeleportAndGetTeleport() {
    // checking similar methods at same time
    int id = 9;
    if (Room.getTeleportationRoom() == 0) {
      Room.assignTeleportLocation(id);
      return Room.getTeleportationRoom() == id;
    }
    return false;
  }

  /**
   * private helper which checks constructor,getid,getdescription, and get type methods of class
   * Room
   * 
   * @return true if all 4 of these methods work
   */
  private static boolean testConIdDesTyp() {
    // checking 4 methods-getters and setters
    String s = "This is Room10";
    int id = 10;
    Room r = new Room(id, s);

    if (r.getID() == id && r.getRoomDescription().equals(s) && r.getAdjacentRooms() != null
        && r.getAdjacentRooms().size() == 0 && r.getType() == RoomType.NORMAL)

    {
      return true;
    }


    return false;
  }

  /**
   * private helper which checks if add, get, and is adjacent rooms methods of class Rooms work
   * 
   * @return true if all 3 of these work
   */
  private static boolean testAddToAdjacentRoomsAndGetAdjacentRoomsAndIsAdjacent() {
    Room r1 = new Room(5, "This is Room5");
    int ID = 6;
    int prev_size = r1.getAdjacentRooms().size();
    Room r2 = new Room(ID, "This is Room6");
    r1.addToAdjacentRooms(r2);
    return r1.isAdjacent(r2) && r1.getAdjacentRooms().size() == prev_size + 1
        && r1.getAdjacentRooms().get(prev_size).getID() == ID;// checking if change appeared in
                                                              // arraylist

  }

  /**
   * private helper which checks correctness of set and get type methods of class Room
   * 
   * @return true if both work properly
   */
  private static boolean testSetTypeAndGetType() {
    Room r = new Room(5, "This is Room5");
    RoomType p = r.getType();
    r.setRoomType(RoomType.START);
    if (p == RoomType.NORMAL && r.getType() == RoomType.START) {
      return true;
    }
    return false;
  }

  /**
   * checks correctness of isPortalNearby and isTreausreNearby methods are working properly
   * 
   * @return true if both are good
   */
  public static boolean testPlayerDetectNearbyRooms() {
    Room r1 = new Room(9, "This is Room9");
    Room r2 = new Room(3, "This is room3");
    Room r3 = new Room(11, "This is room11");
    r3.setRoomType(RoomType.PORTAL);
    Room r4 = new Room(1, "This is Room1");
    r4.setRoomType(RoomType.TREASURE);
    r1.addToAdjacentRooms(r2);
    r1.addToAdjacentRooms(r3);
    r1.addToAdjacentRooms(r4);
    Player p1 = new Player(r1);
    boolean check1 = p1.isPortalNearby();
    boolean check2 = p1.isTreasureNearby();
    Room r5 = new Room(10, "This is Room10");
    r1.getAdjacentRooms().set(2, r5);// removing r4 and putting r5
    boolean check3 = p1.isTreasureNearby();
    Room r6 = new Room(6, "This is Room6");
    r1.getAdjacentRooms().set(1, r6);// replace r3 with r6
    boolean check4 = p1.isPortalNearby();
    return check1 && check2 && !check3 && !check4;// giving combined true/false
  }

  /**
   * private helper to check if changeRoom method works
   * 
   * @return true if it is good
   */
  private static boolean testChangeRoom() {
    // change room method of player is checked
    Room r1 = new Room(1, "This is Room1");
    Room r2 = new Room(12, "This is Room12");
    Player p1 = new Player(r1);
    Room r = p1.getCurrentRoom();
    p1.changeRoom(r2);
    return r.equals(r1) && p1.getCurrentRoom().equals(r2);
  }



  /**
   * checks correctness of shouldTeleport method
   * 
   * @return true if it does
   */
  public static boolean testPlayerShouldTeleport() {
    Room r1 = new Room(6, "This is Room6");
    Room r2 = new Room(12, "This is Room12");
    r1.setRoomType(RoomType.PORTAL);
    r2.setRoomType(RoomType.TREASURE);
    Player p1 = new Player(r1);
    Player p2 = new Player(r2);
    return r1.getType() == RoomType.PORTAL && r2.getType() == RoomType.TREASURE
        && p1.shouldTeleport() && !p2.shouldTeleport();// checking if player teleports to correct
                                                       // type room only
  }

  /**
   * checks correctness of changeRooms method of dragon class
   * 
   * @return
   */
  public static boolean testDragonChangeRooms() {
    Room r1 = new Room(1, "This is Room1");
    Room r2 = new Room(12, "This is Room12");
    Room r3 = new Room(11, "This is Room11");
    Room r4 = new Room(13, "This is Room13");
    Room r5 = new Room(7, "This is Room7");
    r2.setRoomType(RoomType.PORTAL);
    r1.addToAdjacentRooms(r2);
    r1.addToAdjacentRooms(r3);
    r1.addToAdjacentRooms(r5);
    Dragon d = new Dragon(r1);
    d.changeRooms();
    return r1.getAdjacentRooms().size() == 3 && d.getCurrentRoom() != r2 && d.getCurrentRoom() != r1
        && d.getCurrentRoom() != r4 && r1.isAdjacent(d.getCurrentRoom())
        && !(d.getCurrentRoom().getType() == RoomType.PORTAL) && !(d.getCurrentRoom().equals(r1));
  }

  /**
   * main function calls all our public methods
   * 
   * @param args stores nothing if no input is given
   */
  public static void main(String[] args) {
    // calling all testers
    System.out.println(testRoomInstanceMethods());
    System.out.println(testRoomStaticMethods());
    System.out.println(testPlayerCanMoveTo());
    System.out.println(testPlayerConstructorAndGetCurrentRoom());
    System.out.println(testPlayerShouldTeleport());
    System.out.println(testPlayerDetectNearbyRooms());
    System.out.println(testChangeRoom());
    System.out.println(testDragonChangeRooms());

  }

}
