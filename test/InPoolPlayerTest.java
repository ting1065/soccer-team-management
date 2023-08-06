import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import soccerteam.InPoolPlayer;
import soccerteam.Position;

/**
 * tests for InPoolPlayer class.
 */
public class InPoolPlayerTest {

  private InPoolPlayer testPlayer;
  private InPoolPlayer testBetterPlayer;
  private InPoolPlayer testEqualPlayer;

  /**
   * setting up regular object for test.
   */
  @Before public void setUp() {
    testPlayer = new InPoolPlayer("san", "zhang", LocalDate.of(2014, 4, 1), 3, Position.FORWARD);
    testBetterPlayer = new InPoolPlayer("SI", "lI", LocalDate.of(2015, 8, 31), 5, Position.GOALIE);
    testEqualPlayer = new InPoolPlayer("Wu", "wAng", LocalDate.of(2016, 1, 2), 3,
        Position.DEFENDER);
  }

  /**
   * test if exception is thrown when the player is too old.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTooOldPlayer() {
    new InPoolPlayer("san", "zhang", LocalDate.of(1960, 4, 1), 3, Position.FORWARD);
  }

  /**
   * test if exception is thrown when the player is not born yet.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUnbornPlayer() {
    new InPoolPlayer("san", "zhang", LocalDate.of(3023, 4, 1), 3, Position.FORWARD);
  }

  /**
   * test if exception is thrown when the player has a skill level less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNoSkillPlayer() {
    new InPoolPlayer("san", "zhang", LocalDate.of(2016, 4, 1), 0, Position.FORWARD);
  }

  /**
   * test if exception is thrown when the player has a skill level more than 5.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testOverSkilledPlayer() {
    new InPoolPlayer("san", "zhang", LocalDate.of(2016, 4, 1), 6, Position.FORWARD);
  }

  /**
   * test if getFirstName() works as expected.
   */
  @Test public void testGetFirstName() {
    assertEquals("San", testPlayer.getFirstName());
    assertEquals("Si", testBetterPlayer.getFirstName());
  }

  /**
   * test if getLastName() works as expected.
   */
  @Test public void testGetLastName() {
    assertEquals("Zhang", testPlayer.getLastName());
    assertEquals("Li", testBetterPlayer.getLastName());
  }

  /**
   * test if testGetBirthDate() works as expected.
   */
  @Test public void testGetBirthDate() {
    assertEquals(2014, testPlayer.getBirthDate().getYear());
    assertEquals(4, testPlayer.getBirthDate().getMonthValue());
    assertEquals(1, testPlayer.getBirthDate().getDayOfMonth());
    assertEquals(2015, testBetterPlayer.getBirthDate().getYear());
    assertEquals(8, testBetterPlayer.getBirthDate().getMonthValue());
    assertEquals(31, testBetterPlayer.getBirthDate().getDayOfMonth());
  }

  /**
   * test if getSkillLevel() works as expected.
   */
  @Test public void testGetSkillLevel() {
    assertEquals(3, testPlayer.getSkillLevel());
    assertEquals(5, testBetterPlayer.getSkillLevel());
  }

  /**
   * test if getPreferredPos() works as expected.
   */
  @Test public void testGetPreferredPos() {
    assertEquals(Position.FORWARD, testPlayer.getPreferredPos());
    assertEquals(Position.GOALIE, testBetterPlayer.getPreferredPos());
  }

  /**
   * test if compareTo() works as expected.
   */
  @Test public void testCompareTo() {
    assertTrue(testPlayer.compareTo(testBetterPlayer) < 0);
    assertEquals(0, testPlayer.compareTo(testEqualPlayer));
    assertTrue(testBetterPlayer.compareTo(testEqualPlayer) > 0);
  }
}