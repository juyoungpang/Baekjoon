package S1;

public class p1931_greedy_wrong {
    public static void main(String[] args) {

    }

    static class Meeting implements Comparable{
        int startingTime;
        int endTime;

        @Override
        public int compareTo(Object o) {
            Meeting m = (Meeting)o;
            return this.endTime-m.endTime;
        }
    }
}

