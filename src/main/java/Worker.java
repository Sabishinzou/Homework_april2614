/**
 * Created by Sabishinzou on 03.05.14.
 */
import java.io.*;
import java.util.Random;

public class Worker {

    public static void main(String[] args) throws FileNotFoundException, IOException {
    /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("data\\input3.txt")));
        PrintWriter writer1 = new PrintWriter(new File("data\\outputNum3.txt"));
        PrintWriter writer2 = new PrintWriter(new File("data\\outputLex3.txt"));
        TextParser textParser = new TextParser(reader, writer1, writer2);
        textParser.work();
        */
        PrintWriter writerRandom = new PrintWriter(new File("data\\outputRandom.txt"));
        RandomAnalizer r = new RandomAnalizer(writerRandom);
        r.reportRandom();
    }


}