import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Dna {
    Queue<Character> memory;

    public Dna(Character... values) throws Exception {
        for (char value : values) {
            if (value != 'A' && value != 'C' && value != 'G' && value != 'T') {
                throw new Exception("Value "+value+" is not valid in DNA machine");
            }
        }
        this.memory = new LinkedList<>(Arrays.asList(values));
    }

    public Dna(String values) throws Exception {
        char[] oldValues = values.toCharArray();
        Character[] newValues = new Character[values.length()];
        for (int i = 0; i < values.length(); i++) {
            newValues[i] = oldValues[i];
        }

//        this(newValues);
    }

    private void assertDnaValueValid(char value) throws Exception {
        if (value != 'A' && value != 'C' && value != 'G' &&
                value != 'T' && value != '$') {
            throw new Exception("Value "+value+" is not valid in DNA machine");
        }
    }

    public void insere(char x) throws Exception {
        assertDnaValueValid(x);
        memory.add((Character) x);
    }

    public Character del() throws Exception {
        return memory.poll();
    }

    public boolean is(char x) throws Exception {
        assertDnaValueValid(x);
        char lastElement = memory.element();
        return lastElement == x;
    }

    @Override
    public String toString() {
        return "Dna{" +
                "memory=" + memory +
                '}';
    }
}
