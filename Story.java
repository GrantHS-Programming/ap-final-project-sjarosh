import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Story implements ActionListener{

    int posX = 3;
    int posY = 3;
    JFrame map = new JFrame("Map");
    JButton rightButton = new JButton("→");
    JButton leftButton =  new JButton("←");
    JButton upButton =  new JButton("↑");
    JButton downButton = new JButton("↓");

    //start message
    JFrame startMsg = new JFrame("Wakey Wakey!");
    JLabel start = new JLabel("<html>You wake up dazed and disoriented. All but the emergency lights have been  turned off in your submersible " +
                                    "and you don't know how long you have been asleep. The water is dark and heavy around you. Indiscernible " +
                                    "shapes just out at you from the darkness. But the mission must be completed. You must explore these ruins " +
                                    "and find out what happened before your world meets the same watery fate. Just be sure to take care...");

    //scroll
    JFrame scrollMsg = new JFrame("A Message for Those Who Remain...");
    JLabel scroll = new JLabel("<html> 'The water rises. We cannot stop it and we have made our peace... Those who could have already left" +
            "while we, the Historians remain to preserve what we can. <s>Please</s> If you are reading this, there is time to turn back yet. Soon" +
            "it will be too late. The beast wakens...' <br><br> You stare at the message with a sinking feeling in your stomach. But the orders are" +
            "clear. You must press on.");
    boolean scRead = false;

    //armory
    JFrame armoryMsg =  new JFrame("Arm Yourself");
    JLabel armory = new JLabel("<html>As your flashlight beam slices through the shadows of the small room something flashes. Bright. Reflective. " +
            "Like metal. You approach it gingerly. You job is to document, to record, but surely a little hands on investigation wouldn't hurt. " +
            "A metal chest is slightly open, the hilt of a sword is just visible. Do you open it (y/n)?");
    boolean armed = false;


    JButton [][] board = new JButton[20][20];

    String [][] walls =  new String[20][20];

    public static void main (String[]args){
        new Story();
    }

    public Story() {
        map.setLayout(new BorderLayout());
        map.setSize(800,800);
        map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container rightContainer =  new Container();
        Container downContainer =  new Container();
        Container upContainer =  new Container();
        Container leftContainer =  new Container();
        Container boardContainer = new Container();
        rightContainer.setLayout(new GridLayout(1,1));
        leftContainer.setLayout(new GridLayout(1,1));
        downContainer.setLayout(new GridLayout(1,1));
        upContainer.setLayout(new GridLayout(1,1));
        boardContainer.setLayout(new GridLayout(20,20));

        rightButton.addActionListener(this);
        leftButton.addActionListener(this);
        downButton.addActionListener(this);
        upButton.addActionListener(this);
        rightContainer.add(rightButton);
        leftContainer.add(leftButton);
        upContainer.add(upButton);
        downContainer.add(downButton);



        buildMap();

        for (int row = 0; row <board.length; row++){
            for (int col = 0; col<board[0].length; col++){
                board[row][col] =  new JButton(walls[row][col]);
                board[row][col].addActionListener(this);
                boardContainer.add(board[row][col]);
                board[row][col].setForeground(Color.blue);
            }
        }


        map.add(rightContainer, BorderLayout.EAST);
        map.add(leftContainer, BorderLayout.WEST);
        map.add(upContainer, BorderLayout.NORTH);
        map.add(downContainer, BorderLayout.SOUTH);
        map.add(boardContainer, BorderLayout.CENTER);

        map.setVisible(true);

        startMsg.setLayout(new BorderLayout());
        startMsg.setSize(400, 200);
        start.setBorder(new EmptyBorder(0,10,0,0));
        startMsg.add(start);
        startMsg.setVisible(true);

        scrollMsg.setLayout(new BorderLayout());
        scrollMsg.setSize(400, 200);
        scroll.setBorder(new EmptyBorder(0,10,0,0));
        scrollMsg.add(scroll);

        armoryMsg.setLayout(new BorderLayout());
        armoryMsg.setSize(400, 200);
        armory.setBorder(new EmptyBorder(0,10,0,0));
        armoryMsg.add(armory);



    }


    public void buildMap() {
        startMsg.setVisible(true);


        //main border
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (j == 0 || j == 19) {
                    walls[i][j] = "║";
                } else if (i == 0 || i == 19) {
                    walls[i][j] = "==";
                } else {
                    walls[i][j] = " ";
                }
            }
        }

        //person
        walls [posX][posY] = "★";

        //room 1
        for(int i = 1; i<9; i++){
                walls[6][i] = "⎯";
        }
        for(int i = 1; i<3; i++){
            walls[i][8] = "|";
        }

        walls [6][2] = "┓";
        walls [6][3] = " ";
        walls [6][4] = "┏";
        walls [6][8] = " ┛";

        walls [3][8] = "┗";
        walls [4][8] = " ";
        walls [5][8] = "┏";

        //room 2
        for(int i = 1; i<19; i++){
            walls[11][i] = "⎯";
        }
        for(int i = 1; i<9; i++){
            walls[i][10] = "|";
        }

        walls [5][10] = "┓";
        walls [4][10] = " ";
        walls [3][10] = " ┛";
        walls [9][10] = " ┛";

        walls [11][14] = "┓";
        walls [11][16] = "┏";
        walls [11][15] = " ";

        //room 3
        for (int i = 8; i <11 ; i++) {
            walls[i][1] = "|";
        }

        walls [8][5] = "┓";
        walls [8][3] = " ";
        walls [8][2] = " ┛";
        walls [10][5] = " ";
        walls [8][4] = "┗";
        walls [9][5] = "┗";
        walls [11][1] = "┗";
        walls [8][1] = "┏";

        //room 4
        for (int i = 9; i <19; i++) {
            walls[13][i] = "⎯";
        }
        for (int i = 13; i <19; i++) {
            walls[i][9] = "|";
        }

        walls [18][9] = "┓";
        walls [13][15] = " ";
        walls [13][14] = " ┛";
        walls [17][9] = " ";
        walls [13][16] = "┗";
        walls [16][9] = "┛";
        walls [13][9] = "┏";

        //room 5
        for (int i = 1; i <8; i++) {
            walls[14][i] = "⎯";
        }

        for (int i = 14; i <19; i++) {
            walls[i][7] = "|";
            }

        walls [14][7] = "┓";
        walls [16][7] = "┗";
        walls [18][7] = "┏";
        walls [17][7] = " ";

        //halls
        walls [7][2] = "|";
        walls [7][4] = "|";
        walls [12][14] = "|";
        walls [12][16] = "|";

        walls [3][9] = "⎯";
        walls [5][9] = "⎯";
        walls [16][8] = "⎯";
        walls [18][8] = "⎯";

        for (int i = 6; i <11; i++) {
            walls[9][i] = "⎯";
        }
    }

    public void actionPerformed(ActionEvent e){

        if (e.getSource().equals(rightButton)){
            if (walls[posX][posY +1].equals(" ")){
                walls[posX][posY] = " ";
                board[posX][posY].setText(" ");
                posY = posY+1;
                board[posX][posY].setText("★");
            }
        }

        if (e.getSource().equals(leftButton)){
            if (walls[posX][posY -1].equals(" ")){
                walls[posX][posY] = " ";
                board[posX][posY].setText(" ");
                posY = posY-1;
                board[posX][posY].setText("★");
            }
        }

        if (e.getSource().equals(upButton)){
            if (walls[posX -1][posY].equals(" ")){
                walls[posX][posY] = " ";
                board[posX][posY].setText(" ");
                posX = posX-1;
                board[posX][posY].setText("★");
            }
        }
        if (e.getSource().equals(downButton)){
            if (walls[posX+1][posY].equals(" ")){
                walls[posX][posY] = " ";
                board[posX][posY].setText(" ");
                posX = posX+1;
                board[posX][posY].setText("★");
            }
        }
        if (posX == 2 && posY == 5 && !scRead){
            scrollMsg.setVisible(true);
            scRead = true;
        }
        if (posX == 10 && posY == 2 && !armed){
            armoryMsg.setVisible(true);
            armed = true;
        }

    }
}
