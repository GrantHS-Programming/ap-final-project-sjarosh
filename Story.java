import javax.swing.*;
import java.awt.*;

public class Story {

    JFrame map = new JFrame("Map");
    JButton rightButton = new JButton("→");
    JButton leftButton =  new JButton("←");
    JButton upButton =  new JButton("↑");
    JButton downButton = new JButton("↓");


    String [][] walls =  new String[20][20];


    public static void main(String[] args) {
        new Story();
    }

    public void buildMap(){
        for (int i = 0; i <20; i++){
            for (int j = 0; j<20; j++){
                if (j == 0 || j == 19){
                    walls[i][j] = "|";
                }
                else if (i == 0 || i == 19){
                    walls[i][j] = "-";
                }
                else{
                    walls[i][j] = " ";
                }
            }
        }

        for (int i = 0; i < walls.length; i++) {
            for (int j = 0; j < walls[0].length; j++) {
                System.out.print(walls[i][j] + " ");
            }
            System.out.println();
        }
    }
}
