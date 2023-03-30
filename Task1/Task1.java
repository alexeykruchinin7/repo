import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try
        {
            Scanner in = new Scanner(System.in);
            String filename = in.next();

            File file1 = new File(filename);
            FileReader fr1 = new FileReader(file1);
            BufferedReader reader1 = new BufferedReader(fr1);

            String line1[] = reader1.readLine().split(" ");
            int n = Integer.parseInt(line1[0]), m = Integer.parseInt(line1[1]);

            int now_pos = 0;

            String result = "";
            
            while ((now_pos + m - 1) % n != 0) {
                result += Integer.toString(now_pos + 1);
                now_pos = (now_pos + m - 1) % n;
            }

            System.out.println(result + Integer.toString(now_pos + 1));
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
