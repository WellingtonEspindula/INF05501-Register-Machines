import java.util.BitSet;

public class Main {

    public static void main(String[] args) {
        try {
            Multiset multisetMachine = new Multiset(1, 1, 0, 0);
            System.out.println(multisetMachine);

            multisetMachine.insert(1);
            System.out.println(multisetMachine);

            multisetMachine.delete(0);
            System.out.println(multisetMachine);

            System.out.println(multisetMachine.hasMoreZerosThanOnes());
            System.out.println(multisetMachine.hasLessZerosThanOnes());


            multisetMachine.insert(1);
            System.out.println(multisetMachine);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
