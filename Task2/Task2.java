import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        try
        {
            File file1 = new File("file1.txt");
            FileReader fr1 = new FileReader(file1);
            BufferedReader reader1 = new BufferedReader(fr1);

            String line1[] = reader1.readLine().split(" ");
            int x = Integer.parseInt(line1[0]), y = Integer.parseInt(line1[1]), r = Integer.parseInt(reader1.readLine());

            
            File file2 = new File("file2.txt");
            FileReader fr2 = new FileReader(file2);
            BufferedReader reader2 = new BufferedReader(fr2);

            String line = reader2.readLine();
            while (line != null) {
                int px = Integer.parseInt(line.split(" ")[0]);
                int py = Integer.parseInt(line.split(" ")[1]);

                if (getDistance(x, y, px, py) > r) {
                    System.out.println(2);
                } else if (getDistance(x, y, px, py) == r) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }

                line = reader2.readLine();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static Double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
