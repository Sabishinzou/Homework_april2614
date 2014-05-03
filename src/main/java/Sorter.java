import java.util.*;

/**
 * Created by Sabishinzou on 03.05.14.
 */
public class Sorter {
    /*
         я не совсем понимаю что имеется в в иду под адекватными алгоритмами. Если имется в виду скорость,
         то сама лексикогр. сортировка предполагает, что будет затрачено времени не меньше O(n) (как я думаю)
         и в библиотечных классах коллекциях таких как TreeSet это реализовано лучше всего
         а разбивать исходное на 26 частей(по числу букв)например и т.д  это не очень адекватный алгоритм, это даже не лекс. сортировка.
         вообще, лучший способ - это реализовать лексикографическое дерево для всех слов, но это долго и муторно, а TreeSet и так это делает.
         */

    public static LinkedList<String> sortNum(HashMap<String, Integer> dictionary) {
        HashMap<Integer, SortedSet<String>> sortedMap = new HashMap<Integer, SortedSet<String>>();//ключи - частота, значение - множество слов с такой частотой встречи
        SortedSet<String> sortedSet = null; //множество слов, которые упорядочиваются лекс-ки, аналог лекс-кого дерева
        int max_key = 0;
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            if (sortedMap.get(entry.getValue()) == null) {
                sortedSet = new TreeSet();
                sortedSet.add(entry.getKey());
                sortedMap.put(entry.getValue(), sortedSet);
            }
            else {
                sortedMap.get(entry.getValue()).add(entry.getKey());
            }
            if (entry.getValue() > max_key)
                max_key = entry.getValue();
        }
        LinkedList<String> newDict = new LinkedList<String>();
        for (int i = 1; i <= max_key; i++) { //идем от наибольшего ключа по всем где что-то записано
            if (sortedMap.get(i) != null) {
                sortedSet = sortedMap.get(i);
                while (!sortedSet.isEmpty()){
                    newDict.push(sortedSet.last());
                    sortedSet.remove(sortedSet.last());
                }
            }
        }
        return newDict;
    }

    public static LinkedList<String> sortLex(HashMap<String, Integer> dictionary) {
        SortedSet<String> sortedSet = new TreeSet();
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            sortedSet.add(entry.getKey());
        }
        LinkedList<String> newDict = new LinkedList<String>();
        while (!sortedSet.isEmpty()){
            newDict.push(sortedSet.last());
            sortedSet.remove(sortedSet.last());
        }
        return newDict;
    }

}
