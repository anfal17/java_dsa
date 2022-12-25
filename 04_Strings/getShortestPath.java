import java.util.*;

public class javabasics {

    public static double getShortestPath(String path) {
        int x =0, y = 0;

        for (int i = 0; i < path.length(); i++) {
            
            char direction = path.charAt(i);
            
            if (direction == 'N') {
                y++;
            }
            else if (direction == 'S') {
                y--;
            }
            else if (direction == 'W') {
                x--;
            }
            else {
                x++;
            }
        }

        int x2 =x*x;
        int y2 = y*y;

        return Math.sqrt(x2 + y2);
    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getShortestPath(path));
    }
}
