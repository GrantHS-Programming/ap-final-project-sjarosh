import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Story implements ActionListener{

    int posX = 9;
    int posY = 13;

    int roomPos = 0;
    int weapon = 0;

    String room;
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
    JLabel scroll = new JLabel("<html> 'The water rises. We cannot stop it and we have made our peace... Those who could have already left, " +
            "while we, the Historians remain to preserve what we can. <s>Please</s> If you are reading this, there is time to turn back yet. Soon" +
            " it will be too late. The beast wakens...' <br><br> You stare at the message with a sinking feeling in your stomach. But the orders are" +
            " clear. You must press on.");
    boolean scRead = false;

    //armory
    JFrame armoryMsg =  new JFrame("Arm Yourself");
    JLabel armory = new JLabel("<html> You open the chest and find that it is full of weapons. Some are corroded and rusty - exactly as you would expect" +
            " at the bottom of the ocean. Others though, look as though they were polished just this morning. Moreover, while most of the weapons are in line" +
            " with what your archeologists knew of the Nymstravt, others look strange and otherworldly. They look like they have no business being here in" +
            " a forgotten corner of a drowned civilization. Which weapon do you chose (axe/ sword/ pistol)?");

    JFrame ghost1Msg = new JFrame ("A Strange Encounter");
    JLabel ghosty1 =  new JLabel ("<html> A sudden cold spell set you shivering. You whip around and find yourself face to face with a translucent, floating" +
            " <i> thing </i>. It's dressed strangely, archaic diving suit ripped and face plate shattered to reveal a rictus grin. Its voice is ragged, half-drowned. " +
            "<br><br> <i> I see you have not heeded the warnings... You meddle in things that you do not understand... You wish to know what happened here? Very well. I " +
            "tell you. <br> We were attacked. A vicious attack. Unrelenting. And so we fled, scattered among the stars, all of us, except those few unfortunate souls..." +
            "Now GET OUT!!! </i><br><br> You stumble backwards and when you regain your composure, the ghost is gone. ");
    JFrame ghost1v2Msg = new JFrame ("A Strange Encounter");
    JLabel ghosty1v2 =  new JLabel ("<html> A sudden cold spell set you shivering. You whip around and find yourself face to face with a translucent, floating" +
            " <i> thing </i>. It's dressed strangely, archaic diving suit ripped and face plate shattered to reveal a rictus grin. Its voice is ragged, half-drowned. " +
            "<br><br> <i> You seem to have something that doesn't belong to you, </i> the ghost says, gesturing to the sword gripped in your hand. <i> It is mine, meddler," +
            "and you shall not have it...<br><br></i> You stumble backwards as an icy cold grips your hand. You feel it through your diving suit, colder than the freezing water." +
            "You drop the sword and when you regain your composure the ghost is gone. ");

    boolean armed = false;
    boolean ghost1 = false;
    int health = 100;

    JFrame inventoryMsg = new JFrame("Inventory");
    ArrayList<String> inventoryList =  new ArrayList<>();

    String [] rooms = new String[5];

    JButton [][] board = new JButton[20][20];

    String [][] walls =  new String[20][20];



    public static void main (String[]args){
        new Story();
    }

    public Story() {
        //inventory variables aren't changing :(
        inventoryList.add("You don't have any items yet.");
        if (posX< 6 && posY <8 ){String room1 ="the room you arrived in. Your submersible is tethered a few meters away, its lights illuminating the craggy walls and overgrown " +
                "rock of what seems to have once been a medium sized antechamber. ";
            rooms[0] = room1;
            roomPos = 0;
        }
        else if (posX < 11 && posY >10 ){ String room2 = "the ballroom. The walls are lined with sconces that haven't held a torch in decades. You feel strange whispers and flickers" +
                "at the edges of your senses, but can't find anything concrete. Every once in a while, it sounds like someone is wailing. ";
            rooms[1] = room2;
            roomPos = 1;
        }
        else if (posX < 11 && posX > 8 && posY <5 ){ String room3 = "the armory. Weapons are scattered haphazardly around the room in varying states of decay. A chest is in the " +
                "corner and little fish swim in and out of the visor of suit of armor. ";
            rooms[2] = room3;
            roomPos = 2;
        }
        else if (posX > 13  && posY >9 ){ String room4 = "test";
            rooms[3] = room4;
            roomPos = 3;
        }
        else if (posX > 15  && posY <7 ){ String room5 = "test";
            rooms[4] = room5;
            roomPos = 4;
        }
        else{room = "a hallway";}
        JLabel inventory = new JLabel("<html>You are in " + rooms[roomPos] + "<br><br>" + inventoryList.get(0) + "<br><br> Your health is at " + health + "%");

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
        armoryMsg.setSize(0, 0);
        armory.setBorder(new EmptyBorder(0,10,0,0));
        armoryMsg.add(armory);

        inventoryMsg.setLayout(new BorderLayout());
        inventoryMsg.setSize(400, 200);
        inventory.setBorder(new EmptyBorder(0,10,0,0));
        inventoryMsg.add(inventory);

        ghost1Msg.setLayout(new BorderLayout());
        ghost1Msg.setSize(450, 300);
        ghosty1.setBorder(new EmptyBorder(0,10,0,0));
        ghost1Msg.add(ghosty1);

        ghost1v2Msg.setLayout(new BorderLayout());
        ghost1v2Msg.setSize(450, 300);
        ghosty1v2.setBorder(new EmptyBorder(0,10,0,0));
        ghost1v2Msg.add(ghosty1v2);

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

        //arraylist / array with rooms, room pos variable to change in jlabel.

    }

    public void actionPerformed(ActionEvent e){

        if (e.getSource().equals(rightButton)){
            if (walls[posX][posY +1].equals(" ")){
                walls[posX][posY] = " ";
                board[posX][posY].setText(" ");
                posY = posY+1;
                board[posX][posY].setText("★");
            }
        } // right

        if (e.getSource().equals(leftButton)){
            if (walls[posX][posY -1].equals(" ")){
                walls[posX][posY] = " ";
                board[posX][posY].setText(" ");
                posY = posY-1;
                board[posX][posY].setText("★");
            }
        } // left

        if (e.getSource().equals(upButton)){
            if (walls[posX -1][posY].equals(" ")){
                walls[posX][posY] = " ";
                board[posX][posY].setText(" ");
                posX = posX-1;
                board[posX][posY].setText("★");
            }
        } // up

        if (e.getSource().equals(downButton)){
            if (walls[posX+1][posY].equals(" ")){
                walls[posX][posY] = " ";
                board[posX][posY].setText(" ");
                posX = posX+1;
                board[posX][posY].setText("★");
            }
        } // down

        if (posX == 2 && posY == 5 && !scRead){
            scrollMsg.setVisible(true);
            scRead = true;
        } // scroll

        if (posX == 10 && posY == 2 && !armed){

            String choiceA = JOptionPane.showInputDialog(armory, "As your flashlight beam slices through the shadows of the small room, something flashes. Bright. Reflective.\n" +
                    "Like metal. You approach it gingerly. You job is to document, to record, but surely a little hands on investigation wouldn't hurt. \n" +
                    "A metal chest lies slightly open, the hilt of a sword is just visible. Do you open it (y/n)?", "Arm Yourself", JOptionPane.OK_CANCEL_OPTION);
            if (choiceA.equals("y")){
                armoryMsg.setVisible(true);
                String choiceB = JOptionPane.showInputDialog(armory, "You open the chest and find that it is full of weapons. Some are corroded and rusty - exactly as you would expect\n" +
                        " at the bottom of the ocean. Others though, look as though they were polished just this morning. Moreover, while most of the weapons are in line\n" +
                        " with what your archeologists knew of the Nymstravt, others look strange and otherworldly. They look like they have no business being here in \n" +
                        " a forgotten corner of a drowned civilization. Which weapon do you chose (axe/ sword/ pistol)?", "Arm Yourself", JOptionPane.OK_CANCEL_OPTION);
                if (choiceB.equals("axe")){
                    inventoryList.add(0,"You have an axe");
                    weapon = 1;
                }
                if (choiceB.equals("sword")){
                    inventoryList.add(0, "You have a sword");
                    weapon = 2;
                }
                if (choiceB.equals("pistol")){
                    inventoryList.add(0, "You have a pistol");
                    weapon = 3;
                }
            }
            armed = true;
        } // armory

        if (posX == 8 && posY == 13 && !ghost1){
            if (weapon == 2){
                ghost1v2Msg.setVisible(true);
                health -= 20;
            }
            else{
                ghost1Msg.setVisible(true);
            }
            ghost1 = true;
        } //ghost 1

        if (e.getSource().equals(board[posX][posY])){
            inventoryMsg.setVisible(true);
        } // inventory
    }
}
