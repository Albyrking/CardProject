import java.util.Comparator;

public class ComparatorType implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if (o1.type > o2.type) {
            return 1;
        } else if (o1.type == o2.type) {
            return 0;
        }
        return -1;
    }
}
