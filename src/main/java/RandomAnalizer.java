import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Sabishinzou on 03.05.14.
 */
public class RandomAnalizer {

    PrintWriter writer;

    public RandomAnalizer(PrintWriter writer) {
        this.writer = writer;
    }

    private HashMap<Integer, Integer> randomGeneration(int range, int amount) {
        HashMap<Integer, Integer> randomNumbers = new HashMap<Integer, Integer>();
        Random rand = new Random();
        int r = -1;
        for (int i = 0; i < amount; i++) {
            r = rand.nextInt(range) + 1;
            add(r, randomNumbers);
        }
        return randomNumbers;
    }

    private void add(int i, HashMap<Integer, Integer> map) {
        int currentCount = 0;
        if (map.containsKey(i)) {
            currentCount = map.get(i);
        }
        map.put(i, currentCount + 1);
    }

    public void reportRandom() {
        double d = 0;
        for (int i = 10; i <= 100; i++) {
            writer.println("#" + i + ":");
            for (int j = 1000; j <= 10000000; j = j*10) {
                HashMap<Integer, Integer> map = randomGeneration(i, j);
                d = findD(map, j);
                writer.println(j + " - " + d);
            }
            writer.println();
        }
        writer.close();
    }

    private double findD(HashMap<Integer, Integer> map, int j) {
        //максимальные и минимальные кол-ва вхождений и соответствующие им числа
        int max = 0;
        int min = 2147483640;
        int kmax = -1;
        int kmin = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                kmin = entry.getKey();
            }
            if (entry.getValue() > max) {
                max = entry.getValue();
                kmax = entry.getKey();
            }
        }
        double d = (double)(max - min)/j;
        //double d = (double)(kmax - kmin)/j;
        //вот тут заминка т.к в задании явно условие не сходится с примером хотя бы потому что нет отрицательных заначений d
        //оставил так чтобы было ближе к значениям в примере, может я просто не понял чего-то
        return d;
    }
}
