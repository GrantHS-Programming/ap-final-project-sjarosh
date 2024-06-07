import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Story implements ActionListener{

    int posX = 3;
    int posY = 4;
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
    JLabel scroll = new JLabel("<html> <i>'The water rises. We cannot stop it and we have made our peace... Those who could have already left, " +
            "while we, the Historians remain to preserve what we can. <s>Please</s> If you are reading this, there is time to turn back yet. Soon" +
            " it will be too late. The beast wakens...' </i><br><br> You stare at the message with a sinking feeling in your stomach. But the orders are" +
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
    JFrame fightMsg =  new JFrame("An Unpleasant Encounter");
    JLabel fight =  new JLabel(" ");

    JFrame ghost2Msg = new JFrame("An Illuminating Encounter");
    JLabel ghosty2 = new JLabel("<html>A chill runs down your spine and the hairs on the back of your neck stand up. A moment later something appears in front of" +
            " of you. Its diving suit is ripped in half a dozen places and the face plate is missing. <br<br><i> Are you another invader then? Come to finish the job?" +
            " </i> it asks wryly. <br><br> You stare. <br><br><i> The last ones who were here forced out hand and I would rather suffer death again than give you anything" +
            "else,</i><br><br> With that is vanishes leaving a cold that has nothing to do with the freezing water.");
    JFrame ghost2v2Msg = new JFrame("An Illuminating Encounter");
    JLabel ghosty2v2 = new JLabel("<html>A chill runs down your spine and the hairs on the back of your neck stand up. A moment later something appears in front " +
            "of you. Its diving suit is ripped in half a dozen places and the face plate is missing. <br><br><i> Ah, someone's been grave-robbing, hm? </i> the ghost says " +
            "and suddenly you are being pulled forward and the axe you took is burning against your leg.<br><br><i> That doesn't belong to you, and I won't let anyone else " +
            "invade my home.</i><br><br>You stumble backwards as an icy cold grips your hand. You feel it through your diving suit, colder than the freezing water." +
            "You drop the sword and when you regain your composure the ghost is gone.");

    boolean armed = false;
    boolean ghost1 = false;
    boolean fought = false;
    boolean ghost2 = false;
    //int health = 100;

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
        String room1 ="the room you arrived in. Your submersible is tethered a few meters away, its lights illuminating the craggy walls and overgrown " +
                "rock of what seems to have once been a medium sized antechamber. ";
        rooms[0] = room1;
        String room2 = "the ballroom. The walls are lined with sconces that haven't held a torch in decades. You feel strange whispers and flickers" +
                "at the edges of your senses, but can't find anything concrete. Every once in a while, it sounds like someone is wailing. ";
        rooms[1] = room2;
        String room3 = "the armory. Weapons are scattered haphazardly around the room in varying states of decay. A chest is in the " +
                "corner and little fish swim in and out of the visor of suit of armor. ";
        rooms[2] = room3;
        String room4 = "test";
        rooms[3] = room4;
        String room5 = "the war room. Or at least what used to be the war room. A long table rotted through sits in its center, the remains of chairs surrounding" +
                " it like gravestones. You thing there might have once been paintings on the walls, but its hard to tell.";
        rooms[4] = room5;

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

        fightMsg.setLayout(new BorderLayout());
        fightMsg.setSize(400, 400);
        fight.setBorder(new EmptyBorder(0,10,0,0));
        fightMsg.add(fight);


        ghost1Msg.setLayout(new BorderLayout());
        ghost1Msg.setSize(450, 300);
        ghosty1.setBorder(new EmptyBorder(0,10,0,0));
        ghost1Msg.add(ghosty1);

        ghost1v2Msg.setLayout(new BorderLayout());
        ghost1v2Msg.setSize(450, 300);
        ghosty1v2.setBorder(new EmptyBorder(0,10,0,0));
        ghost1v2Msg.add(ghosty1v2);

        ghost2Msg.setLayout(new BorderLayout());
        ghost2Msg.setSize(450, 300);
        ghosty2.setBorder(new EmptyBorder(0,10,0,0));
        ghost2Msg.add(ghosty2);

        ghost2v2Msg.setLayout(new BorderLayout());
        ghost2v2Msg.setSize(450, 300);
        ghosty2v2.setBorder(new EmptyBorder(0,10,0,0));
        ghost2v2Msg.add(ghosty2v2);

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
        int health = 100;
        inventoryList.add(" "+health);

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

        if (posX == 3 && posY ==12 && !fought){
            fought = true;
            String fightIntro = JOptionPane.showInputDialog(fight, "<html>You feel something snag your shoulder, cold and rasping on the thick fabric of your diving suit." +
                    " Your flashlight illuminates nothing but cold blue water and the occasional rotting wood for meters in all directions. Slowly you turn around to face a - " +
                    "<i> something </i>. It's tall and lanky and doesn't quite seem human. <br><br> <i> Little explorer, </i> it sing-songs, <i> have you been stealing? </i><br><br>" +
                    "What do you say (y/n)?","An Unpleasant Encounter", JOptionPane.OK_CANCEL_OPTION);
            if (fightIntro.equals("y") && (inventoryList.get(0).equals("You have an axe")||(inventoryList.get(0).equals("You have a sword")||(inventoryList.get(0).equals("You have a pistol"))))){
                String drawChoice = JOptionPane.showInputDialog(fight, "<html> <i> Ah, a thief! How delightful! </i> the not-quite-human ghost gushes. It sets your teeth" +
                        " on edge. <br><br> Do you draw your weapon (y/n)?","An unpleasant Encounter", JOptionPane.OK_CANCEL_OPTION);
                if (drawChoice.equals("y") && inventoryList.get(0).equals("You have a pistol")){
                    fight.setText("<html> Shakily you draw the pistol you took from the armory. It was foolish to come here without a weapon, but no on expected to find anything" +
                            "even remotely alive here. For gods' sake, the whole place is buried under tons of water, nothing <i> should</i> be alive. <br><br> <i> Are you going to " +
                            "fight me, little explorer? How exciting! And with the very weapons we used to squash the Nymstravt, very exciting indeed. </i><br><br> You freeze, " +
                            "momentarily forgetting the situation. <i> The Nymstravt were attacked? </i> There's a theory you haven't heard before. <br<br> <i> No, I don't think I'll" +
                            " fight you after all, </i> the ghost says, drawing you back to the present, <i> but that really doesn't belong to you...</i><br><br> A burning cold spreads " +
                            "through you arm and the pistol slips out of grip. You feel woozy as you watch if sink into the darkness. ");
                    fightMsg.setVisible(true);
                    health -= 20;
                    inventoryList.add(" " + health);
                }
                else if (drawChoice.equals("y") && !inventoryList.get(0).equals("You have a pistol")){
                    fight.setText("<html>Shakily, you draw your weapon. It was foolish to come unarmed but no on expected to find anything" +
                            "even remotely alive here. For gods' sake, the whole place is buried under tons of water, nothing <i> should</i> be alive. <br><br> <i> Are you going to " +
                            "fight me, little explorer? How exciting! </i><br><br> Suddenly, the water around it starts to churn angrily. You can't move. <br><br><i> You DARE use those" +
                            "pigs' weapons against me? We squashed them like the bugs that they were! </i><br><br> The water around the " +inventoryList.get(0) + " starts to boil and you" +
                            "drop it quickly. And then there's something reaching <i>inside</i> you. A cold, cold something that makes you feel like you will never be warm again and you" +
                            "look down to find one ghostly hand buried in your chest...");
                    fightMsg.setVisible(true);
                    health -=50;
                    inventoryList.add(" " + health);
                }
            }
            else if (fightIntro.equals("n")&& (inventoryList.get(0).equals("You have an axe")||(inventoryList.get(0).equals("You have a sword")||(inventoryList.get(0).equals("You hava a pistol"))))){
                fight.setText("<html> <i>  I detest liars...<br><br></i>And then there's something reaching <i>inside</i> you. A cold, cold something that makes you feel like you will never be warm again and you " +
                        "look down to find one ghostly hand buried in your chest...");
                fightMsg.setVisible(true);
                health =- 50;
                inventoryList.add(" " + health);
            }
            else{
                fight.setText("<html><i>Hmmm, well that's disappointing. You might want to poke around a bit more...You might find some interesting stuff...</i>");
                fightMsg.setVisible(true);
                health -=10;
                inventoryList.add(" " + health);
            }
        } //ghost fight

        if (posX == 8 && posY == 13 && !ghost1){
            if (weapon == 2){
                ghost1v2Msg.setVisible(true);
                health -= 20;
                inventoryList.add(" " + health);
            }
            else{
                ghost1Msg.setVisible(true);
            }
            ghost1 = true;
        } //ghost 1

        if (posX == 4 && posY == 16 && !ghost2) {
            if (weapon == 3){
                ghost2v2Msg.setVisible(true);
                health -= 20;
                inventoryList.add(" " + health);
            }
            else{
                ghost2v2Msg.setVisible(true);
            }
        } //ghost2

        if (e.getSource().equals(board[posX][posY])){

            if (posX< 6 && posY <8 ){
                roomPos = 0;
            }
            else if (posX < 11 && posY >10 ){
                roomPos = 1;
            }
            else if (posX < 11 && posX > 8 && posY <5 ){
                roomPos = 2;
            }
            else if (posX > 13  && posY >9 ){
                roomPos = 3;
            }
            else if (posX > 15  && posY <7 ){
                roomPos = 4;
            }
            else{room = "a hallway";}

            JLabel inventory = new JLabel();
            inventory.setText(" ");
            String text = "<html>You are in " + rooms[roomPos] + "<br><br>" + inventoryList.get(0) + "<br><br> Your health is at " + inventoryList.get(inventoryList.size()-1) + "%";
            inventory.setText(text);
            inventoryMsg.setLayout(new BorderLayout());
            inventoryMsg.setSize(400, 200);
            inventory.setBorder(new EmptyBorder(0,10,0,0));
            inventoryMsg.add(inventory);
            for (int i = 0; i < inventoryList.size(); i++) {
                System.out.println(inventoryList.get(i));
            }
            inventoryMsg.setVisible(true);
        } // inventory
    }
}