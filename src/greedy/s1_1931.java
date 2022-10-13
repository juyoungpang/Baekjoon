package greedy;

public class s1_1931 {
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

