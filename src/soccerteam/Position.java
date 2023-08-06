package soccerteam;

/**
 * enum Position, can be GOALIE, DEFENDER, MIDFIELDER, or FORWARD.
 */
public enum Position implements Comparable<Position> {
  GOALIE {
    @Override public String toString() {
      return "Goalie";
    }
  }, DEFENDER {
    @Override public String toString() {
      return "Defender";
    }
  }, MIDFIELDER {
    @Override public String toString() {
      return "Midfielder";
    }
  }, FORWARD {
    @Override public String toString() {
      return "Forward";
    }
  }

}