package soccerteam;

/**
 * Interface for the controller of a soccer team.
 */
public interface TeamFeatures {

  /**
   * set the view with all the callbacks.
   *
   * @param v the view.
   */
  void setView(TeamView v);

  /**
   * add a player to the player pool according to the input information.
   */
  void addPlayer();

  /**
   * create a team based on the player pool.
   */
  void createTeam();

  /**
   * create a starting line up based on the team.
   */
  void createStartingLineup();

  /**
   * Exit the program.
   */
  void exitProgram();
}
