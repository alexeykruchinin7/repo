import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int now_pos = 0;

        String result = "";
        
        while ((now_pos + m - 1) % n != 0) {
            result += Integer.toString(now_pos + 1);
            now_pos = (now_pos + m - 1) % n;
        }

        System.out.println(result + Integer.toString(now_pos + 1));
    }
}
