package soccerteam;

import java.time.LocalDate;

/**
 * Controller of the soccer team.
 * Implementation of the TeamFeatures interface.
 */
public class TeamControllerImpl implements TeamFeatures {

  private final TeamModel model;
  private TeamView view;

  public TeamControllerImpl(TeamModel m) {
    this.model = m;
  }

  @Override public void setView(TeamView v) {
    this.view = v;
    v.addFeatures(this);
  }

  @Override public void addPlayer() {
    String playerInfo = view.getInputString();
    String[] playerInfoPieces = playerInfo.split(" ");
    if (playerInfoPieces.length != 5) {
      view.displayNotice("invalid input: there must be exactly 5 pieces of information"
                         + " separated by single white spaces", true);
      view.clearInputString();
      return;
    }

    String firstName = playerInfoPieces[0];
    String lastName = playerInfoPieces[1];

    String[] birthDatePieces = playerInfoPieces[2].split("/");
    if (birthDatePieces.length != 3) {
      view.displayNotice("invalid input: the birthdate must be exactly"
                         + " 3 integers separated by '/'", true);
      view.clearInputString();
      return;
    }

    int year;
    int month;
    int day;
    try {
      year = Integer.parseInt(birthDatePieces[0]);
      month = Integer.parseInt(birthDatePieces[1]);
      day = Integer.parseInt(birthDatePieces[2]);
    } catch (NumberFormatException e) {
      view.displayNotice("invalid input: the birthdate must be integers separated by '/'", true);
      view.clearInputString();
      return;
    }

    int skillLevel;
    try {
      skillLevel = Integer.parseInt(playerInfoPieces[3]);
    } catch (NumberFormatException e) {
      view.displayNotice("invalid input: the skill level must be an integer", true);
      view.clearInputString();
      return;
    }

    Position preferredPosition;
    try {
      preferredPosition = Position.valueOf(playerInfoPieces[4].toUpperCase());
    } catch (IllegalArgumentException e) {
      view.displayNotice("invalid input: the preferred position must"
                         + " be a Position instance", true);
      view.clearInputString();
      return;
    }

    try {
      model.addPlayer(firstName, lastName, LocalDate.of(year, month, day),
                      skillLevel, preferredPosition);
      view.displayNotice("successfully added " + firstName + " " + lastName, false);
      view.displayPlayerPoolList(model.getPlayerListString());
    } catch (IllegalArgumentException e) {
      view.displayNotice("error: " + e.getMessage(), true);
    }

    view.clearInputString();
  }

  @Override public void createTeam() {

    try {
      model.generateTeamList();
      view.displayTeamList(model.getTeamListString());
      view.displayNotice("successfully created team", false);
    } catch (IllegalStateException e) {
      view.displayNotice("error: " + e.getMessage(), true);
    }

  }

  @Override public void createStartingLineup() {

    try {
      model.generateStartList();
      view.displayStartList(model.getStartListString());
      view.displayNotice("successfully created starting lineup", false);
    } catch (IllegalStateException e) {
      view.displayNotice("error: " + e.getMessage(), true);
    }

  }

  @Override public void exitProgram() {
    System.exit(0);
  }
}