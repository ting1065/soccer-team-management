package soccerteam;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * GUI Implementation of the TeamView interface.
 */
public class TeamViewImpl extends JFrame implements TeamView {

  private JPanel panel;
  private JLabel inputInstruction;
  private JTextField inputField;
  private JLabel notice;
  private JButton addPlayerButton;
  private JButton createTeamButton;
  private JButton createStartButton;
  private JButton exitButton;
  private JTextArea playerPoolBoard;
  private JTextArea teamListBoard;
  private JTextArea startListBoard;


  /**
   * Initialize the window.
   *
   * @param caption caption for the window.
   */
  public TeamViewImpl(String caption) {

    super(caption);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel(new GridBagLayout());
    setLocation(200, 200);
    panel.setPreferredSize(new Dimension(1200, 600));
    setResizable(false);
    GridBagConstraints constraints = new GridBagConstraints();

    //Row 1, a label of instruction asking user to enter the player's information.
    inputInstruction = new JLabel("<html>Enter a player's information:<br>"
                                       + "(format: firstname lastname birthdate"
                                       + " skillLevel preferredPosition)<br>"
                                       + "(e.g. 'david beckham 2015/12/31 3 midfielder')</html>");
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weightx = 1;
    constraints.weighty = 0.01;
    constraints.anchor = GridBagConstraints.WEST;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridwidth = 4;
    panel.add(inputInstruction, constraints);

    //Row 2, a JTextField for user to enter the player's info.
    inputField = new JTextField(60);
    constraints.gridx = 0;
    constraints.gridy = 1;
    //constraints.anchor = GridBagConstraints.WEST;
    panel.add(inputField, constraints);

    //Row 3, a label of notice telling the user the status of the current operation.
    notice = new JLabel("\n");
    constraints.gridx = 0;
    constraints.gridy = 2;
    panel.add(notice, constraints);

    //Row 4, four buttons.
    addPlayerButton = new JButton("add player");
    createTeamButton = new JButton("create team");
    createStartButton = new JButton("create starting lineup");
    exitButton = new JButton("exit");
    constraints.gridwidth = 1;
    constraints.gridx = 0;
    constraints.gridy = 3;
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.fill = GridBagConstraints.NONE;
    panel.add(addPlayerButton, constraints);
    constraints.gridx = 1;
    panel.add(createTeamButton, constraints);
    constraints.gridx = 2;
    panel.add(createStartButton, constraints);
    constraints.gridx = 3;
    panel.add(exitButton, constraints);

    //Row 5, three JTextArea to display the corresponding lists.
    playerPoolBoard = new JTextArea("player pool:\n(firstname, lastname, birthdate,"
                                    + " skill level, preferred position)\n\n");
    teamListBoard = new JTextArea("team list:\n(firstname, lastname, jersey number)\n\n");
    startListBoard = new JTextArea("starting lineup:\n(firstname, lastname,"
                                   + " jersey number, position)\n\n");
    playerPoolBoard.setEditable(false);
    teamListBoard.setEditable(false);
    startListBoard.setEditable(false);

    constraints.gridx = 0;
    constraints.gridy = 4;
    constraints.weighty = 1.0;
    constraints.fill = GridBagConstraints.VERTICAL;
    JScrollPane playerPoolBoardScrollPane = new JScrollPane(playerPoolBoard);
    playerPoolBoardScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    playerPoolBoardScrollPane.setPreferredSize(new Dimension(410, 400));
    panel.add(playerPoolBoardScrollPane, constraints);

    constraints.gridx = 1;
    JScrollPane teamListBoardScrollPane = new JScrollPane(teamListBoard);
    teamListBoardScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    teamListBoardScrollPane.setPreferredSize(new Dimension(255, 400));
    panel.add(teamListBoardScrollPane, constraints);

    constraints.gridx = 2;
    JScrollPane startListBoardScrollPane = new JScrollPane(startListBoard);
    startListBoardScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    startListBoardScrollPane.setPreferredSize(new Dimension(320, 400));
    panel.add(startListBoardScrollPane, constraints);

    add(panel);
    pack();
    setVisible(true);
  }

  @Override public void addFeatures(TeamFeatures teamFeatures) {
    addPlayerButton.addActionListener(evt -> teamFeatures.addPlayer());
    createTeamButton.addActionListener(evt -> teamFeatures.createTeam());
    createStartButton.addActionListener(evt -> teamFeatures.createStartingLineup());
    exitButton.addActionListener(evt -> teamFeatures.exitProgram());
  }

  @Override public String getInputString() {
    return inputField.getText();
  }

  @Override public void clearInputString() {
    inputField.setText("");
  }

  @Override public void displayPlayerPoolList(String str) {
    playerPoolBoard.setText("player pool:\n(firstname, lastname, birthdate,"
                            + " skill level, preferred position)\n\n");
    playerPoolBoard.append(str);
  }

  @Override public void displayTeamList(String str) {
    teamListBoard.setText("team list:\n(firstname, lastname, jersey number)\n\n");
    teamListBoard.append(str);
  }

  @Override public void displayStartList(String str) {
    startListBoard.setText("starting lineup:\n(firstname, lastname, jersey number, position)\n\n");
    startListBoard.append(str);
  }

  @Override public void displayNotice(String noticeInString, boolean isError) {
    notice.setText("  " + noticeInString);
    if (isError) {
      notice.setForeground(Color.red);
    } else {
      notice.setForeground(Color.green);
    }
  }

}