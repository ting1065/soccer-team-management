package soccerteam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * The class represent the model part for a U10 soccer team. It is able to add player, generate and
 * get player list, team list, starting lineup list. And their string version.
 */
public class TeamModelImpl implements TeamModel {

  //a constant used for generating random jersey numbers.
  private static final long RANDOM_SEED = 12345678;
  private final ArrayList<InPoolPlayer> playerList;
  private ArrayList<InTeamPlayer> teamList;
  private ArrayList<StartPlayer> startList;

  /**
   * Construct a team, initialize an empty player list, leave team list and start list as null.
   */
  public TeamModelImpl() {
    this.playerList = new ArrayList<InPoolPlayer>();
  }

  @Override public void addPlayer(String firstName, String lastName, LocalDate birthDay,
      int skillLevel, Position preferredPosition) throws IllegalArgumentException {

    InPoolPlayer newPlayer = new InPoolPlayer(firstName, lastName, birthDay, skillLevel,
        preferredPosition);
    if (this.playerList.contains(newPlayer)) {
      throw new IllegalArgumentException("this player is already in the pool");
    }
    this.playerList.add(newPlayer);

  }

  @Override public ArrayList<InPoolPlayer> getPlayerList() {
    ArrayList<InPoolPlayer> copy = new ArrayList<InPoolPlayer>(this.playerList);
    copy.sort(Comparator.reverseOrder());
    return copy;
  }

  @Override public String getPlayerListString() {
    ArrayList<InPoolPlayer> copy = getPlayerList();
    StringBuilder playerListString = new StringBuilder();
    for (InPoolPlayer o : copy) {
      playerListString.append(o.getFirstName()).append(" ").append(o.getLastName()).append(" ")
          .append(o.getBirthDate().toString()).append(" ").append(o.getSkillLevel()).append(" ")
          .append(o.getPreferredPos()).append("\n");
    }
    return playerListString.toString();
  }

  @Override public void generateTeamList() throws IllegalStateException {

    if (this.playerList.size() < 10) {
      throw new IllegalStateException("not enough players to generate a team, at least 10 needed");
    }

    this.teamList = new ArrayList<InTeamPlayer>();
    ArrayList<InPoolPlayer> playerListCopy = this.getPlayerList();
    Random random = new Random(RANDOM_SEED);
    Set<Integer> helperSet = new HashSet<>();

    for (InPoolPlayer o : playerListCopy) {

      int assignedJerseyNum = -1;
      int flag = 1;
      while (flag == 1) {
        assignedJerseyNum = random.nextInt(20) + 1;
        if (helperSet.add(assignedJerseyNum)) {
          flag = 0;
        }
      }

      InTeamPlayer newInTeamPlayer = new InTeamPlayer(o.getFirstName(), o.getLastName(),
          o.getBirthDate(), o.getSkillLevel(), o.getPreferredPos(), assignedJerseyNum);
      this.teamList.add(newInTeamPlayer);
      if (this.teamList.size() == 20) {
        break;
      }

    }

  }

  @Override public ArrayList<InTeamPlayer> getTeamList() {
    ArrayList<InTeamPlayer> copy = new ArrayList<InTeamPlayer>(this.teamList);
    copy.sort(Comparator.naturalOrder());
    return copy;
  }

  @Override public String getTeamListString() {
    ArrayList<InTeamPlayer> teamListCopy = this.getTeamList();
    StringBuilder teamListString = new StringBuilder();
    for (InTeamPlayer o : teamListCopy) {
      teamListString.append(o.getFirstName()).append(" ").append(o.getLastName()).append(" ")
          .append(o.getJerseyNum()).append("\n");
    }
    return teamListString.toString();
  }

  /**
   * return a list of 7 positions of a start lineup.
   *
   * @return a list of 7 positions of a start lineup.
   */
  private ArrayList<Position> getPositionList() {
    ArrayList<Position> positionList = new ArrayList<Position>();
    positionList.add(Position.FORWARD);
    positionList.add(Position.MIDFIELDER);
    positionList.add(Position.MIDFIELDER);
    positionList.add(Position.MIDFIELDER);
    positionList.add(Position.DEFENDER);
    positionList.add(Position.DEFENDER);
    positionList.add(Position.GOALIE);

    return positionList;
  }

  @Override public void generateStartList() throws IllegalStateException {

    if (this.teamList == null) {
      throw new IllegalStateException(
          "must have a valid team list before generating the starting lineup");
    }

    this.startList = new ArrayList<StartPlayer>();
    //this.teamList is sorted by skill level(descending);
    //this.getTeamList() return what is sorted by last name.
    ArrayList<InTeamPlayer> teamListCopy = new ArrayList<InTeamPlayer>(this.teamList);
    ArrayList<Position> availablePositions = getPositionList();

    for (InTeamPlayer o : teamListCopy) {

      Position assignedPos;
      if (availablePositions.contains(o.getPreferredPos())) {
        assignedPos = o.getPreferredPos();
      } else {
        assignedPos = availablePositions.get(0);
      }
      availablePositions.remove(assignedPos);

      StartPlayer newStartPlayer = new StartPlayer(o.getFirstName(), o.getLastName(),
          o.getBirthDate(), o.getSkillLevel(), o.getPreferredPos(), o.getJerseyNum(), assignedPos);
      this.startList.add(newStartPlayer);
      if (this.startList.size() == 7) {
        break;
      }

    }

  }

  @Override public ArrayList<StartPlayer> getStartList() {
    ArrayList<StartPlayer> copy = new ArrayList<StartPlayer>(this.startList);
    copy.sort(Comparator.naturalOrder());
    return copy;
  }

  @Override public String getStartListString() {
    ArrayList<StartPlayer> startListCopy = this.getStartList();
    StringBuilder startListString = new StringBuilder();
    for (StartPlayer o : startListCopy) {
      startListString.append(o.getFirstName()).append(" ").append(o.getLastName()).append(" ")
          .append(o.getJerseyNum()).append(" ")
          .append(o.getGamePosition()).append("\n");
    }
    return startListString.toString();
  }
}