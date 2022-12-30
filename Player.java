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
 * this class makes a Player who plays the game-it is an instantiable class
 * 
 * @author vardaan kapoor
 *
 */
public class Player {
  private Room currentRoom;

  /**
   * constructor of class Player
   * 
   * @param currentRoom takes in argument value of currentRoom when we make an object of this class
   */
  public Player(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  /**
   * gives currentRoom value-accessor
   * 
   * @return returns current room
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }

  /**
   * mutator which changes currentRoom's value
   * 
   * @param newRoom takes in new room's value as argument
   */
  public void changeRoom(Room newRoom) {
    currentRoom = newRoom;
  }

  /**
   * checks if player can move to its adjacent room
   * 
   * @param destination takes argument of a room and checks if that room is adjacent to current room
   * @return true if argument room is adjacent to current room
   */
  public boolean canMoveTo(Room destination) {
    // Room ob1=new Room(000,"hello");//i gave any random values to parameterized constructor
    if (currentRoom.isAdjacent(destination)) {
      return true;
    }
    return false;
  }

  /**
   * checks if player can teleport t a room or not
   * 
   * @return true if player can do
   */
  public boolean shouldTeleport() {
    return checkPortal(currentRoom);
  }

  /**
   * gives us the list of adjacent rooms to the current room
   * 
   * @return array list storing all adjacent rooms
   */
  public ArrayList<Room> getAdjacentRoomsToPlayer() {
    return currentRoom.getAdjacentRooms();
  }

  /**
   * checks if dragon is nearby
   * 
   * @param d takes in a dragon class object
   * @return true if dragon is in an adjacent room
   */
  public boolean isDragonNearby(Dragon d) {
    ArrayList<Room> nearbyRooms = currentRoom.getAdjacentRooms();
    if (nearbyRooms.contains(d.getCurrentRoom())) {
      // checks if dragon's current location is not in adjacent rooms
      return true;
    }
    return false;// do it after completing dragon class
  }

  /**
   * checks if portal is nearby
   * 
   * @return true if it does
   */
  public boolean isPortalNearby() {
    ArrayList<Room> takePortal = getAdjacentRoomsToPlayer();
    for (int i = 0; i < takePortal.size(); i++) {
      if (checkPortal(takePortal.get(i)))// calling private helper
      {
        return true;
      }
    }
    return false;
  }

  /**
   * private helper to help check if portal is nearby
   * 
   * @param r takes in a room object with a particular type
   * @return true if argument room is a portal
   */
  private boolean checkPortal(Room r)// helper method-private declared
  {
    if (r.getType() == RoomType.PORTAL)// we get enum value by classname.enumvalue
    {
      return true;
    }
    return false;
  }

  /**
   * checks if treasure is nearby
   * 
   * @return true if it does
   */
  public boolean isTreasureNearby() {
    ArrayList<Room> takeTreasure = getAdjacentRoomsToPlayer();
    for (int i = 0; i < takeTreasure.size(); i++) {
      if (checkTreasure(takeTreasure.get(i)))// calling private helper
      {
        return true;
      }
    }
    return false;
  }

  /**
   * private helper to check if room is a treasure room type
   * 
   * @param r takes in a room object
   * @return true if room is treasure room
   */
  private boolean checkTreasure(Room r) {
    if (r.getType() == RoomType.TREASURE) {
      return true;

    }
    return false;
  }
}
