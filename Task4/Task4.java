import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task4 {

    public static void main(String[] args) {
        try
        {
            File file = new File("input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            List<Integer> mas = new ArrayList<Integer>();
            
            String line = reader.readLine();
            while (line != null) {
                Integer num = Integer.parseInt(line);

                mas.add(num);
                line = reader.readLine();
            }

            mas.sort(null);
            Integer result = 0, median = mas.get(mas.size() / 2);

            for (int i = 0; i < mas.size(); ++i) {
                result += Math.abs(mas.get(i) - median);
            }

            if (mas.size() % 2 == 0) {
                median = mas.get(mas.size() / 2 - 1);
                Integer second_res = 0;

                for (int i = 0; i < mas.size(); ++i) {
                    second_res += Math.abs(mas.get(i) - median);
                }

                result = Math.min(result, second_res);
            }

            System.out.println(result);
            
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }   
    }

    Integer getAnsForNum(List<Integer> mas, Integer num) {
        Integer ans = 0;

        for (int i = 0; i < mas.size(); ++i) {
            ans += Math.abs(num - mas.get(i));
        }

        return ans;
    }
}
