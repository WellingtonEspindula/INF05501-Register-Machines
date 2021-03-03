import org.junit.Test;

public class MultisetTest {

    @Test
    public void function() throws Exception {
        Multiset mm = new Multiset(0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1);
        System.out.println(mm);
        if (mm.hasMoreZerosThanOnes()) {
            return1(mm);
        } else {
            if (mm.hasLessZerosThanOnes()) {
                return0(mm);
            } else {
                removeAll(mm);
            }
        }
        System.out.println(mm);
    }

    @Test
    public void function2() throws Exception {
        Multiset mm = new Multiset(0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1);

        if (mm.hasMoreZerosThanOnes()) {
            while (mm.hasMoreZerosThanOnes() && !mm.onlyOs()) {
                mm.delete(1);
            }

            System.out.println(mm);
            while (mm.onlyOs() || mm.only1s()) {
                mm.delete(0);
                mm.delete(1);
                System.out.println(mm);
            }

            mm.insert(0);
        } else {
            if (mm.hasLessZerosThanOnes()) {
                while (mm.hasLessZerosThanOnes() && !mm.only1s()) {
                    mm.delete(0);
                }

                System.out.println(mm);
                while (mm.onlyOs() || mm.only1s()) {
                    mm.delete(0);
                    mm.delete(1);
                    System.out.println(mm);
                }

                mm.insert(1);
            } else {
                while (true) {
                    while (mm.hasMoreZerosThanOnes() || mm.hasLessZerosThanOnes()) {
                        mm.delete(0);
                        mm.delete(1);
                    }
                    mm.delete(0);
                    if (!mm.hasMoreZerosThanOnes() && !mm.hasLessZerosThanOnes()) {
                        break;
                    }
                }
            }
        }
        System.out.println(mm);
    }


//    private static void removeAll(Multiset mm) throws Exception {
//        while (true) {
//            while (mm.hasMoreZerosThanOnes() || mm.hasLessZerosThanOnes()) {
//                mm.delete(0);
//                mm.delete(1);
//            }
//            mm.delete(0);
//            if (!mm.hasMoreZerosThanOnes() && !mm.hasLessZerosThanOnes()) {
//                break;
//            }
//        }
//
//        while (mm.only1s() || mm.onlyOs()) {
//            mm.delete(0);
//            mm.delete(1);
//        }
//    }

    private static void removeAll(Multiset mm) throws Exception {
        while (true) {
            while (mm.hasMoreZerosThanOnes() || mm.hasLessZerosThanOnes()) {
                mm.delete(0);
                mm.delete(1);
            }
            mm.delete(0);
            if (!mm.hasMoreZerosThanOnes() && !mm.hasLessZerosThanOnes()) {
                break;
            }
        }
    }

    public static void return1(Multiset mm) throws Exception {
        removeAll(mm);
        mm.insert(0);
    }


    public static void return0(Multiset mm) throws Exception {
        removeAll(mm);
        mm.insert(1);
    }


}
