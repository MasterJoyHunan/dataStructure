package unionfind;

import java.util.Random;

public class Test {

    public long test(UnionFind uf, int operationTimes) {

        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < operationTimes; i++) {
            uf.union(random.nextInt(uf.getSize()),random.nextInt(uf.getSize()));
        }


        for (int i = 0; i < operationTimes; i++) {
            uf.find(random.nextInt(uf.getSize()),random.nextInt(uf.getSize()));
        }
        long endTime = System.nanoTime();

        return endTime - startTime;
    }



    public static void main(String[] args) {
        Test test = new Test();
        double t;
        int size = 10000000;
        int m = 1000000;
//        t = test.test(new UnionFind1(100000), 100000);
//        System.out.println(t / 1000000000.0);
        t = test.test(new UnionFind2(size), m);
        System.out.println(t / 1000000000.0);
        t = test.test(new UnionFind3(size), m);
        System.out.println(t / 1000000000.0);
        t = test.test(new UnionFind4(size), m);
        System.out.println(t / 1000000000.0);
        t = test.test(new UnionFind5(size), m);
        System.out.println(t / 1000000000.0);
    }
}
