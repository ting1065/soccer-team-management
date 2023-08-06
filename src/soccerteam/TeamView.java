package soccerteam;

/**
 * the interface for the view part of our soccer team.
 */
public interface TeamView {

  /**
   * Add the controller to the view.
   *
   * @param teamFeatures the implementation of our controller.
   */
  void addFeatures(TeamFeatures teamFeatures);

  /**
   * Get the string from the text field and return it.
   *
   * @return the string from the text field.
   */
  String getInputString();

  /**
   * Clear the text field.
   */
  void clearInputString();

  /**
   * Display the list of players in the pool.
   *
   * @param str the list of players in the pool in String.
   */
  void displayPlayerPoolList(String str);

  /**
   * Display the list of players in the team.
   *
   * @param str the list of players in the team in String.
   */
  void displayTeamList(String str);

  /**
   * Display the list of players in the starting lineup.
   *
   * @param str the list of players in the starting lineup in String.
   */
  void displayStartList(String str);

  /**
   * Display the given notice to the user.
   *
   * @param noticeInString the notice in String.
   * @param isError if the notice is about an error or illegal operation.
   */
  void displayNotice(String noticeInString, boolean isError);

}
