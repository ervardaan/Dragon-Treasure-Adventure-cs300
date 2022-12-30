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
 * this class makes a room -instantiable class-has some static methods are members as well
 * 
 * @author vardaan kapoor
 *
 */
public class Room {
  /*
   * private RoomType type; private String roomDescription; private ArrayList<Room> adjRooms = new
   * ArrayList<Room>();// array list to store adjacent rooms private final int ID; private static
   * int teleportLocationID; private static final String PORTAL_WARNING =
   * "You feel a distortion in space nearby.\n";// constant private static final String
   * TREASURE_WARNING = "You sense that there is treasure nearby.\n";
   */
  private RoomType type; // one of the four types a room could be
  private String roomDescription; // a brief description of the room
  private ArrayList<Room> adjRooms; // arraylist that holds the rooms adjacent
  private final int ID; // unique ID for each room to identify it
  private static int teleportLocationID; // place where all portal rooms will go to
  private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
  private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";

  /**
   * constructor of room class
   * 
   * @param id              takes in id-initializes them to some values
   * @param roomDescription takes in description of room
   */
  public Room(int id, String roomDescription) {
    this.ID = id;
    this.roomDescription = roomDescription;
    this.type = RoomType.NORMAL;
    this.adjRooms = new ArrayList<Room>();


  }

  /**
   * gets the room type
   * 
   * @return the room type
   */
  public RoomType getType() {
    return type;
  }

  /**
   * accessor method
   * 
   * @return gets id of room
   */
  public int getID() {
    return ID;
  }

  /**
   * accessor method
   * 
   * @return array list of adjacent rooms to the current room
   */
  public ArrayList<Room> getAdjacentRooms() {
    return adjRooms;
  }

  /**
   * mutator method-changes array list to add another room which is adjacent to current room
   * 
   * @param toAdd takes in the next room to be added
   */
  public void addToAdjacentRooms(Room toAdd)

  {


    adjRooms.add(toAdd);


  }

  /**
   * mutator method-sets room type of room to new type
   * 
   * @param newType takes in new room type
   */
  public void setRoomType(RoomType newType) {
    this.type = newType;
  }

  /**
   * mutator- assigns new teleport id location room
   * 
   * @param teleportID takes in new location of teleport room
   */
  public static void assignTeleportLocation(int teleportID) {
    teleportLocationID = teleportID;// no use of "this" keyword for static field
  }

  /**
   * accessor
   * 
   * @return the portal warning
   */
  public static String getPortalWarning() {
    return PORTAL_WARNING;
  }

  /**
   * accessor
   * 
   * @return treasure warning
   */
  public static String getTreasureWarning() {
    return TREASURE_WARNING;
  }

  /**
   * accessor
   * 
   * @return teleport room location
   */
  public static int getTeleportationRoom() {
    return teleportLocationID;
  }

  /**
   * checks if room r is adjacent to room
   * 
   * @param r takes in room r to be checked for adjacency
   * @return true if room r is adjacent
   */
  public boolean isAdjacent(Room r) {
    if (adjRooms.contains(r)) {
      // check if room is adjacent or not
      return true;
    }
    return false;
  }

  /**
   * accessor
   * 
   * @return description of room
   */
  public String getRoomDescription() {
    return roomDescription;
  }

  /**
   * checks if one room is equal to other room-overridden
   * 
   * @return if both are equal
   */
  /*
   * public boolean equals(Object other) { // we take an object of superclass Object-then convert it
   * to object of class room if (other instanceof Room) { Room otherRoom = (Room) other; return
   * this.ID == otherRoom.ID;// checks rooms by id } return false; }
   */
  /**
   * Determines if the given object is equal to this room. They are equal if other is a Room and
   * their IDs are the same.
   * 
   * @param other, another object to check if it is equal to this
   * @return true if the two rooms are equal, false otherwise
   * @author Michelle
   */
  public boolean equals(Object other) {
    if (other instanceof Room) {
      Room otherRoom = (Room) other;
      return this.ID == otherRoom.ID;
    }
    return false;
  }

  /**
   * overridden method-prints contents of room
   */
  /*
   * public String toString() { String s = this.ID + ": " + this.roomDescription + " (" + type +
   * ")\n Adjacent Rooms: "; for (int i = 0; i < adjRooms.size(); i++) { s += adjRooms.get(i).ID +
   * " ";
   * 
   * } return s; }
   * 
   */
  /**
   * Returns a String representation of this room.
   * 
   * @return the string representation of this room and its object data field values
   * @author Michelle
   */
  @Override
  public String toString() {
    String s = this.ID + ": " + this.roomDescription + " (" + type + ")\n Adjacent Rooms: ";
    for (int i = 0; i < adjRooms.size(); i++) {
      s += adjRooms.get(i).ID + " ";
    }
    return s;
  }

}


