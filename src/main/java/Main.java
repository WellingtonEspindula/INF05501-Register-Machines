public class Main {

    public static void main(String[] args) {
        /*try {
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
        }*/

        try {
            int x = 2;
            Dna dna = new Dna();
            codificaX(x, dna);
            System.out.println(dna);

            incX(dna);
            System.out.println(dna);

            incY(dna);
            System.out.println(dna);
            incY(dna);
            System.out.println(dna);
            incY(dna);
            System.out.println(dna);

            incX(dna);
            System.out.println(dna);

            decY(dna);
            System.out.println(dna);

            decX(dna);
            System.out.println(dna);

            System.out.println("X=0: " + teste0X(dna));
            System.out.println("Y=0: " + teste0Y(dna));

            decY(dna);
            System.out.println(dna);
            System.out.println("Y=0: " + teste0Y(dna));

            decY(dna);
            System.out.println(dna);
            System.out.println("Y=0: " + teste0Y(dna));

            decX(dna);
            decX(dna);
            decX(dna);
            System.out.println(dna);
            System.out.println("X=0: " + teste0X(dna));
            System.out.println("Y=0: " + teste0Y(dna));

            incY(dna);
            incY(dna);
            incY(dna);
            incX(dna);
            decX(dna);
            System.out.println(dna);
            System.out.println("X=0: " + teste0X(dna));

            int y = decodificaY(dna);
            System.out.println(y);

        } catch (Exception e) {
            e.printStackTrace();
        }

/*        try {
            Dna dna = new Dna();

            dna.insere('$');

            while (!dna.is('$')) {
                if (dna.is('A')) {
                    dna.insere('T');
                    dna.del();
                } else if (dna.is('C')) {
                    dna.insere('C');
                    dna.del();
                } else if (dna.is('G')) {
                    dna.insere('G');
                    dna.del();
                } else {
                    dna.insere('A');
                    dna.del();
                }
            }

            System.out.println(dna);
            System.out.println(dna.sai().isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    private static void codificaX(int x, Dna dna) throws Exception {
        dna.insere('$');
        for (int i = 0; i < x; i++) {
            dna.insere('A');
        }
    }

    private static void incX(Dna dna) throws Exception {
        dna.insere('A');
    }

    private static void incY(Dna dna) throws Exception {
        revertDnaOrder(dna);
        dna.insere('T');
        revertDnaOrder(dna);
    }

    private static void revertDnaOrder(Dna dna) throws Exception {
        dna.insere('$');
        while (!dna.is('$')) {
            dna.insere(dna.del());
        }
        dna.del();
    }

    private static void decX(Dna dna) throws Exception {
        revertDnaOrder(dna);
        dna.del();
        revertDnaOrder(dna);
    }

    private static void decY(Dna dna) throws Exception {
        dna.del();
    }

    private static boolean teste0X(Dna dna) throws Exception {
        revertDnaOrder(dna);
        boolean teste = dna.is('$');
        revertDnaOrder(dna);

        return teste;
    }

    private static boolean teste0Y(Dna dna) throws Exception {
        return dna.is('$');
    }

    private static int decodificaY(Dna dna) throws Exception {
        int y = 0;
        while (!dna.is('$')) {
            dna.del();
            y++;
        }

        return y;
    }


}
