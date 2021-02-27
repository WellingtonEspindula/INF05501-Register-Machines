import java.util.*;

public class Multiset {

    private List<Integer> values;

    public Multiset(Integer... values) throws Exception {
        for (int value : values) {
            assertZeroOrOne(value);
        }
        this.values = new ArrayList<>(Arrays.asList(values));
    }

    public boolean hasMoreZerosThanOnes() {
        return countZeros() > countOnes();
    }

    public boolean hasLessZerosThanOnes() {
        return countZeros() < countOnes();
    }

    public boolean onlyOs() {
        if (countZeros() > 0) {
            for (int value : values) {
                if (value == 1)
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean only1s() {
        if (countOnes() > 0) {
            for (int value : values) {
                if (value == 0)
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public void insert(int x) throws Exception {
        assertZeroOrOne(x);

        values.add(x);
        if (quantify(x) >  quantify(1-x)) {
            flipValues();
        }
    }

    public void delete(int x) throws Exception {
        assertZeroOrOne(x);

        if (!values.isEmpty()) {
            values.remove((Object) x);
            if (quantify(x) >  quantify(1-x)) {
                flipValues();
            }
        }
    }

    private void assertZeroOrOne(int value) throws Exception {
        if (value != 0 && value != 1) {
            throw new Exception("Input must be 0 or 1");
        }
    }

    private int quantify(int x) {
        if (x == 0) {
            return countZeros();
        } else {
            return countOnes();
        }
    }

    private void flipValues() {
        List reversedList = new ArrayList();

        for (int bit : values) {
            int flippedBit = flipBit(bit);
            reversedList.add(flippedBit);
        }

        this.values = reversedList;
    }

    private Integer flipBit(int bit) {
        if (bit == 0) {
            return 1;
        } else if (bit == 1) {
            return 0;
        } else {
            return null;
        }
    }

    private int countZeros() {
        int zeros = 0;
        for (int bit : values) {
            if (bit == 0)
                zeros++;
        }
        return zeros;
    }

    private int countOnes() {
        int ones = 0;
        for (int bit : values) {
            if (bit == 1)
                ones++;
        }
        return ones;
    }

    @Override
    public String toString() {
        return "Multiset{" +
                "values=" + values +
                '}';
    }
}
