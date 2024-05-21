import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Story implements ActionListener{

    int posX = 3;
    int posY = 4;
    JFrame map = new JFrame("Map");
    JButton rightButton = new JButton("→");
    JButton leftButton =  new JButton("←");
    JButton upButton =  new JButton("↑");
    JButton downButton = new JButton("↓");

    JFrame startMsg = new JFrame("Wakey Wakey!");
    //formatting off, use html <br fro line breaks
    JLabel start = new JLabel("You wake up dazed and disoriented. All but he emergency lights have been  turned off in your submersible\n" +
                                    "and you don't know how long you have been asleep. The water is dark and heavy around you. Indiscernible \n" +
                                    "shapes just out at you from the darkness. But the mission must be completed. You must explore these ruins \n" +
                                    "and find out what happened before your world meets the same watery fate. ");
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

        startMsg.setLayout(new BorderLayout());
        startMsg.setSize(400, 400);
        startMsg.add(start);

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

    }
}
