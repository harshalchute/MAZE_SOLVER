import java.util.*;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class MAZE_SOLVER_PROJECT extends JFrame {
    private int[][] maze = {
    //   0 --> 12
        {1,1,1,1,1,1,1,1,1,1,1,1,1}, // 0
        {1,0,1,0,1,0,1,0,0,0,0,0,1}, // 1
        {1,0,1,0,0,0,1,0,1,1,1,0,1}, // 2
        {1,0,1,1,1,1,1,0,0,0,0,0,1}, // 3
        {1,0,0,1,0,0,0,0,1,1,1,0,1}, // 4
        {1,0,1,0,1,1,1,0,1,0,0,0,1}, // 5
        {1,0,1,0,1,0,0,0,1,1,1,0,1}, // 6
        {1,0,1,0,1,1,1,0,1,0,1,0,1}, // 7
        {1,0,0,0,0,0,0,0,0,0,1,9,1}, // 8
        {1,1,1,1,1,1,1,1,1,1,1,1,1}  // 9
    };

    public ArrayList<Integer> path = new ArrayList<>();

    public MAZE_SOLVER_PROJECT(){
        setTitle("Maze Solver"); // Project-Title
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze,1,1,path);
        // System.out.println(path);
    }

    @Override  // We need to change implementation according to our use
    public void paint(Graphics g){
        g.translate(50, 50);
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                Color color;
                switch (maze[i][j]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(30*i,30*j,30,30);
                g.setColor(Color.BLUE);
                g.drawRect(30*i,30*j,30,30);
            }
        }
        for(int i = 0; i < path.size(); i+=2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);
            System.out.println("X-Coordinate : " + pathx + " & Y-Coordinate : " + pathy);

            g.setColor(Color.GREEN);
            g.fillRect(30*pathx,30*pathy,20,20);
        }
    }

    public static void main(String[] args) {
        MAZE_SOLVER_PROJECT view = new MAZE_SOLVER_PROJECT();
        view.setVisible(true);
    }
}