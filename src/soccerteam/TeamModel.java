package soccerteam;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This interface represents all the operations offered by a U10 soccer team. Operations include
 * adding player, generating and getting player list, team list, starting lineup list. And their
 * string version.
 */
public interface TeamModel {

  /**
   * add player to the playList.
   *
   * @param firstName         first name of the player.
   * @param lastName          last name of the player.
   * @param birthDay          the player's birthday.
   * @param skillLevel        the player's skillLevel.
   * @param preferredPosition the player's preferred position.
   *
   * @throws IllegalArgumentException if the player is already in the pool.
   */
  void addPlayer(String firstName, String lastName, LocalDate birthDay, int skillLevel,
      Position preferredPosition) throws IllegalArgumentException;

  /**
   * Return a copy of the current player list sorted by skill level.
   *
   * @return a copy of the current player list.
   */
  ArrayList<InPoolPlayer> getPlayerList();

  /**
   * return a String with the information of all players in the player pool.
   * each player's information includes first name, last name,
   * birthdate, skill level, and preferred position.
   *
   * @return a string as described above.
   */
  String getPlayerListString();

  /**
   * Generate and save a team list according to the player list that is sorted by skill level. Each
   * player gets a random jersey number in the range of [1, 20].
   *
   * @throws IllegalStateException if there are less than 10 players in player list.
   */
  void generateTeamList() throws IllegalStateException;

  /**
   * return a copy of the current team list sorted by last name alphabetically.
   *
   * @return a copy of the current team list.
   */
  ArrayList<InTeamPlayer> getTeamList();

  /**
   * return a String with the information of all players in the team list. Each player's information
   * includes first name, last name, jersey number. Sorted in alphabetical order (last name).
   *
   * @return a string as described above.
   */
  String getTeamListString();

  /**
   * Generate and save a starting lineup list.
   *
   * @throws IllegalStateException if the team list is null.
   */
  void generateStartList() throws IllegalStateException;

  /**
   * return a copy of the current starting lineup list sorted by position and last name(if same
   * position).
   *
   * @return a copy of the current starting lineup list.
   */
  ArrayList<StartPlayer> getStartList();

  /**
   * return a String with the information of all players in the starting lineup. each player's
   * information includes first name, last name, jersey number, and position. sorted by position
   * (goalie, defender, midfielder, forward). players with the same position should be ordered
   * alphabetically.
   *
   * @return a string as described above.
   */
  String getStartListString();

}