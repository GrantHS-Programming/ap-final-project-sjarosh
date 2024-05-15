import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Story implements ActionListener{


    JFrame map = new JFrame("Map");
    JButton rightButton = new JButton("→");
    JButton leftButton =  new JButton("←");
    JButton upButton =  new JButton("↑");
    JButton downButton = new JButton("↓");
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

        /*for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {

            }

        }*/

        map.setVisible(true);


    }

    public void buildMap() {
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
        //walls [9][5] = "┗";

        walls [13][9] = "┏";


    }

    public void actionPerformed(ActionEvent e){

    }
}
