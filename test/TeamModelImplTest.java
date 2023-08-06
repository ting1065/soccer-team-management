import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import soccerteam.Position;
import soccerteam.TeamModel;
import soccerteam.TeamModelImpl;

/**
 * tests for TeamModelImpl class.
 */
public class TeamModelImplTest {

  private TeamModel testTeam;

  /**
   * set up a team and add 9 players.
   */
  @Before public void setUp() {
    testTeam = new TeamModelImpl();
    testTeam.addPlayer("yi", "lIu", LocalDate.of(2016, 1, 1), 1, Position.DEFENDER);
    testTeam.addPlayer("er", "cHEN", LocalDate.of(2016, 2, 2), 2, Position.GOALIE);
    testTeam.addPlayer("san", "zhanG", LocalDate.of(2016, 3, 3), 3, Position.GOALIE);
    testTeam.addPlayer("si", "li", LocalDate.of(2016, 4, 4), 4, Position.DEFENDER);
    testTeam.addPlayer("wu", "wang", LocalDate.of(2016, 5, 5), 5, Position.MIDFIELDER);
    testTeam.addPlayer("lIu", "zHao", LocalDate.of(2016, 6, 6), 1, Position.FORWARD);
    testTeam.addPlayer("qi", "sun", LocalDate.of(2016, 7, 7), 2, Position.DEFENDER);
    testTeam.addPlayer("ba", "zhou", LocalDate.of(2016, 8, 8), 3, Position.GOALIE);
    testTeam.addPlayer("jiu", "Wu", LocalDate.of(2016, 9, 9), 3, Position.GOALIE);
  }

  /**
   * test that teams cannot be created when they have less than 10 players.
   */
  @Test(expected = IllegalStateException.class)
  public void testCreatTeamFail() {
    testTeam.generateTeamList();
  }

  /**
   * verifies that the list of all the players in the team is sorted alphabetically by last name.
   */
  @Test public void testTeamListOrder() {
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 10), 4, Position.FORWARD);
    testTeam.generateTeamList();
    String str = testTeam.getTeamListString();
    assertEquals(
        "Er Chen 1\n" + "Si Li 3\n" + "Yi Liu 5\n" + "Qi Sun 11\n" + "Wu Wang 4\n" + "Jiu Wu 16\n"
            + "San Zhang 12\n" + "Liu Zhao 18\n" + "Shi Zheng 6\n" + "Ba Zhou 17\n", str);
  }

  /**
   * test that the list of the team's starting lineup is sorted by position (and alphabetically for
   * the same position).
   */
  @Test public void testStartListOrder() {
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 10), 4, Position.FORWARD);
    testTeam.generateTeamList();
    testTeam.generateStartList();
    String str = testTeam.getStartListString();
    assertEquals("San Zhang 12 Goalie\n" + "Er Chen 1 Defender\n" + "Si Li 3 Defender\n"
        + "Wu Wang 4 Midfielder\n" + "Jiu Wu 16 Midfielder\n" + "Ba Zhou 17 Midfielder\n"
        + "Shi Zheng 6 Forward\n", str);
  }

  /**
   * test if the weakest players are dropped when generating team list and there are more than 20
   * players in the pool.
   */
  @Test public void testDropWeakest() {
    testTeam.addPlayer("test", "test", LocalDate.of(2016, 10, 1), 1, Position.FORWARD);
    testTeam.addPlayer("test", "test", LocalDate.of(2016, 10, 2), 1, Position.FORWARD);
    testTeam.addPlayer("test", "test", LocalDate.of(2016, 10, 3), 1, Position.FORWARD);
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 10), 4, Position.FORWARD);
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 11), 4, Position.FORWARD);
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 12), 4, Position.FORWARD);
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 13), 4, Position.FORWARD);
    testTeam.addPlayer("test", "test", LocalDate.of(2016, 10, 4), 1, Position.FORWARD);
    testTeam.addPlayer("test", "test", LocalDate.of(2016, 10, 5), 1, Position.FORWARD);
    testTeam.addPlayer("test", "test", LocalDate.of(2016, 10, 6), 1, Position.FORWARD);
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 14), 4, Position.FORWARD);
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 15), 4, Position.FORWARD);
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 16), 4, Position.FORWARD);
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 17), 4, Position.FORWARD);
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 18), 4, Position.FORWARD);
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 19), 4, Position.FORWARD);
    testTeam.addPlayer("shi", "zheng", LocalDate.of(2016, 10, 20), 4, Position.FORWARD);
    testTeam.addPlayer("test", "test", LocalDate.of(2016, 10, 7), 1, Position.FORWARD);
    testTeam.addPlayer("test", "test", LocalDate.of(2016, 10, 8), 1, Position.FORWARD);
    testTeam.addPlayer("test", "test", LocalDate.of(2016, 10, 9), 1, Position.FORWARD);
    testTeam.addPlayer("test", "test", LocalDate.of(2016, 10, 21), 1, Position.FORWARD);
    testTeam.generateTeamList();
    String str = testTeam.getTeamListString();
    assertEquals(
        "Er Chen 20\n" + "Si Li 3\n" + "Yi Liu 10\n" + "Qi Sun 8\n" + "Wu Wang 4\n" + "Jiu Wu 13\n"
            + "San Zhang 19\n" + "Liu Zhao 15\n" + "Shi Zheng 6\n" + "Shi Zheng 12\n"
            + "Shi Zheng 17\n" + "Shi Zheng 16\n" + "Shi Zheng 1\n" + "Shi Zheng 11\n"
            + "Shi Zheng 5\n" + "Shi Zheng 18\n" + "Shi Zheng 14\n" + "Shi Zheng 2\n"
            + "Shi Zheng 7\n" + "Ba Zhou 9\n", str);
  }
}