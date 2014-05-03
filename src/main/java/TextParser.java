/**
 * Created by Sabishinzou on 03.05.14.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class TextParser {
//здесь почти ничего не менял, только изменил метод writer и добавил вызов методов сортировки для dictionary в методе work
//так что самое интересное в классе Sorter
    BufferedReader reader;

    PrintWriter writerNum, writerLex;

    HashMap<String, Integer> dictionary = new HashMap<String, Integer>();

    public TextParser(BufferedReader reader, PrintWriter writer1, PrintWriter writer2) {
        this.reader = reader;
        this.writerNum = writer1;
        this.writerLex = writer2;
    }

    public void work() throws IOException {
        long a = System.currentTimeMillis();
        read();
        write(writerNum, Sorter.sortNum(this.dictionary));
        write(writerLex, Sorter.sortLex(this.dictionary));
        long b = System.currentTimeMillis();
        System.out.println(b - a);
    }

    private void read() throws IOException {
        String s = reader.readLine();
        while (s != null) {
            parse(s);
            s = reader.readLine();
        }
        reader.close();
    }

    private void write(PrintWriter writer, LinkedList<String> list) {
        while (!list.isEmpty()) {
            writer.println(list.peek() + " " + dictionary.get(list.pop()));
        }
        writer.close();
    }

    private void add(String s) {
        int currentCount = 0;
        if (dictionary.containsKey(s)) {
            currentCount = dictionary.get(s);
        }
        dictionary.put(s, currentCount + 1);
    }

    private void parse(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s);
        while (tokenizer.hasMoreTokens()) {
            add(tokenizer.nextToken());
        }
    }
}