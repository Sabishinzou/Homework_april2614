/**
 * Created by Sabishinzou on 03.05.14.
 */
public class StructRecord {
    String word;
    int num;

    public StructRecord() {}

    public StructRecord(String s, int n) {
        this.setRecord(s,n);
    }

    public void setRecord(String s, int n) {
        this. word = s;
        this.num = n;
    }

    @Override
    public String toString() {
        return this.word + " " + this.num;
    }
}
