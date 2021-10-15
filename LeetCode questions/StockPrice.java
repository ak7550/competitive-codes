import java.util.*;

public class StockPrice {
    TreeMap<Integer, Integer> tm;
    TreeSet<Integer> price;


    public StockPrice() {
        tm = new TreeMap<>();
        price = new TreeSet<>();
    }

    public void update(int time, int pr) {
        if(tm.containsKey(time))
            price.remove(tm.get(time));

        tm.put(time, pr);
        price.add(pr);

    }

    public int current() {
        return tm.lastEntry().getValue();
    }

    public int maximum() {
        return price.last();
    }

    public int minimum() {
        return price.first();
    }
}
