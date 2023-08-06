package soccerteam;

import java.time.LocalDate;

/**
 * This interface represents all the operations offered by a player. Operations include get first
 * name, last name, birthdate, skill level, and preferred position.
 */
public interface Player {

  /**
   * Return the first name of the player.
   *
   * @return the first name of the player.
   */
  String getFirstName();

  /**
   * Return the last name of the player.
   *
   * @return the last name of the player.
   */
  String getLastName();

  /**
   * Return the birthdate of the player.
   *
   * @return a Date object, the birthdate of the player.
   */
  LocalDate getBirthDate();

  /**
   * return the player's skill level. an integer in the range of [1, 5].
   *
   * @return the player's skill level.
   */
  int getSkillLevel();

  /**
   * return the player's preferred position which is an enum constant.
   *
   * @return return the player's preferred position.
   */
  Position getPreferredPos();
}
