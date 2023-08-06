package soccerteam;

import java.time.LocalDate;

/**
 * this class represents a player in the starting lineup.
 * each player in the starting lineup(start list) has an extra field which is the player's actual
 * position than a player in the team(team list).
 */
public class StartPlayer extends InTeamPlayer implements GamePosition {

  protected final Position gamePosition;

  /**
   * Construct a player in player pool.
   *
   * @param firstName         this player's first name.
   * @param lastName          this player's last name.
   * @param birthDate         this player's birthdate.
   * @param skillLevel        this player's skill level.
   * @param preferredPosition this player's preferred position.
   * @param jerseyNum         this player's jersey number.
   * @param gamePosition      the player's position in the start lineup.
   * @throws IllegalArgumentException when the player is over 10 years old, the skill level is out
   *                                  of the range [1, 5], or the jersey number if out of the
   *                                  range[1, 20].
   */
  public StartPlayer(String firstName, String lastName, LocalDate birthDate, int skillLevel,
      Position preferredPosition, int jerseyNum, Position gamePosition) {
    super(firstName, lastName, birthDate, skillLevel, preferredPosition, jerseyNum);
    this.gamePosition = gamePosition;
  }

  @Override public Position getGamePosition() {
    return this.gamePosition;
  }

  @Override public int compareTo(Player other) {
    int positionComparison = this.gamePosition.compareTo(((StartPlayer) other).getGamePosition());

    if (positionComparison == 0) {
      return this.lastName.compareTo(other.getLastName());
    } else {
      return positionComparison;
    }
  }

}