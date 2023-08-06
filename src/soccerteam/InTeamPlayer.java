package soccerteam;

import java.time.LocalDate;

/**
 * this class represents a player in the team list.
 * each player in the team(team list) has an extra field which is jersey number than a player in the
 * pool(player list).
 */
public class InTeamPlayer extends InPoolPlayer implements Jersey {

  protected final int jerseyNum;

  /**
   * Construct a player in player pool.
   *
   * @param firstName         this player's first name.
   * @param lastName          this player's last name.
   * @param birthDate         this player's birthdate.
   * @param skillLevel        this player's skill level.
   * @param preferredPosition this player's preferred position.
   * @param jerseyNum         this player's jersey number.
   * @throws IllegalArgumentException when the player is over 10 years old, the skill level is out
   *                                  of the range [1, 5], or the jersey number if out of the
   *                                  range[1, 20].
   */
  public InTeamPlayer(String firstName, String lastName, LocalDate birthDate, int skillLevel,
      Position preferredPosition, int jerseyNum) throws IllegalArgumentException {
    super(firstName, lastName, birthDate, skillLevel, preferredPosition);
    if (jerseyNum < 1 || jerseyNum > 20) {
      throw new IllegalArgumentException("The jersey number must be in the range of [1, 20].");
    }
    this.jerseyNum = jerseyNum;
  }

  @Override public int getJerseyNum() {
    return this.jerseyNum;
  }

  @Override public int compareTo(Player other) {
    return this.lastName.compareTo(other.getLastName());
  }
}
