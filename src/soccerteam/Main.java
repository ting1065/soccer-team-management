package soccerteam;

/**
 * asker the user to enter player's info one by one.
 * create team and starting lineup accordingly and print the result.
 */
public class Main {

  /**
   * asker the user to enter player's info one by one. create team and starting lineup accordingly
   * and print the result.
   *
   * @param args no argument.
   */
  public static void main(String[] args) {

    TeamModel model = new TeamModelImpl();
    TeamControllerImpl controller = new TeamControllerImpl(model);
    TeamView view = new TeamViewImpl("U10 Soccer Team");
    controller.setView(view);
  }

}