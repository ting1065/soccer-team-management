package soccerteam;

/**
 * This interface represents the extra operations offered by a player that is in the starting lineup
 * compared to one that is in the team list.
 */
public interface GamePosition {

  /**
   * return the player's position in the starting lineup.
   *
   * @return the player's position in the starting lineup.
   */
  Position getGamePosition();

}
