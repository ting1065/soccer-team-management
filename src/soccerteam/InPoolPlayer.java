package soccerteam;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * This class represents a player in the player pool.
 * The player must have a birthdate that indicates an age of younger than 10. Each player has fields
 * of first name, last name, birthdate, skill level and preferred position. Both name can be
 * automatically converted to a uniform format which has the first letter as the only uppercase
 * one.
 */
public class InPoolPlayer implements Player, Comparable<Player> {

  protected final String firstName;
  protected final String lastName;
  protected final LocalDate birthDate;
  protected final int skillLevel;
  protected final Position preferredPosition;

  /**
   * Construct a player in player pool.
   *
   * @param firstName         this player's first name.
   * @param lastName          this player's last name.
   * @param birthDate         this player's birthdate.
   * @param skillLevel        this player's skill level.
   * @param preferredPosition this player's preferred position.
   * @throws IllegalArgumentException when the player is over 10 years old or the skill level is out
   *                                  of the range [1, 5].
   */
  public InPoolPlayer(String firstName, String lastName, LocalDate birthDate, int skillLevel,
      Position preferredPosition) throws IllegalArgumentException {

    LocalDate now = LocalDate.now();
    Period age = Period.between(birthDate, now);
    if (birthDate.isAfter(now)) {
      throw new IllegalArgumentException("the player must already be born");
    }
    if (age.getYears() > 10) {
      throw new IllegalArgumentException("the player must be under 10 years old");
    }
    if (skillLevel < 1 || skillLevel > 5) {
      throw new IllegalArgumentException("the player's skill level must be an integer in [1, 5]");
    }
    this.firstName = toNameCase(firstName);
    this.lastName = toNameCase(lastName);
    this.birthDate = birthDate;
    this.skillLevel = skillLevel;
    this.preferredPosition = preferredPosition;

  }

  /**
   * convert a string to a string with the first letter as uppercase and the rest letters as
   * lowercase.
   *
   * @param str the original string.
   * @return a string converted from the given string with the first letter as uppercase and the
   *         rest letters as lowercase.
   */
  private String toNameCase(String str) {
    String firstLetter = str.substring(0, 1);
    String restLetter = str.substring(1);
    String name = firstLetter.toUpperCase() + restLetter.toLowerCase();
    return name;
  }

  @Override public String getFirstName() {
    return this.firstName;
  }

  @Override public String getLastName() {
    return this.lastName;
  }

  @Override public LocalDate getBirthDate() {
    return this.birthDate;
  }

  @Override public int getSkillLevel() {
    return this.skillLevel;
  }

  @Override public Position getPreferredPos() {
    return this.preferredPosition;
  }

  @Override public int compareTo(Player other) {
    return Integer.compare(this.skillLevel, other.getSkillLevel());
  }

  @Override public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (! (o instanceof Player)) {
      return false;
    }
    Player other = (Player) o;
    return this.firstName.equals(other.getFirstName())
           && this.lastName.equals(other.getLastName())
           && this.birthDate.equals(other.getBirthDate());
  }

  @Override public int hashCode() {
    return Objects.hash(firstName, lastName, birthDate);
  }

}