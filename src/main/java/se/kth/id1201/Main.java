package se.kth.id1201;

public class Main {
    public static void main( String[] args ){
        benchmarkFixedB();
        benchmarkFixedA();
        benchmarkArrayVsList();
    }


    public static void benchmarkFixedB(){
        int repitition = 1000;
        int fixedLength = 1000;
        long startTime;
        long endTime;
        float linkedMinTime;
        float arrayMinTime;
        long linkedSumTime;
        long arraySumTime;
        int[] array_a;
        int[] array_b;
        
        LinkedList a;
        LinkedList b;

        System.out.printf("#Append b of fixed length 1000 to a of length n, time in ns\n");
        System.out.printf("#%12s%12s%12s\n", "n", "linkedList", "array");
        for(int length = 2; length < 100000; length*=2){
            linkedMinTime = Float.POSITIVE_INFINITY;
            arrayMinTime = Float.POSITIVE_INFINITY;
            linkedSumTime = 0;
            arraySumTime = 0;
            for(int i = 0; i <= repitition; i++){
                a = new LinkedList(length);
                b = new LinkedList(fixedLength);
                startTime = System.nanoTime();
                a.append(b);
                endTime = System.nanoTime();
                linkedSumTime += endTime - startTime;
                if(endTime - startTime < linkedMinTime){
                    linkedMinTime = endTime - startTime;
                }


                array_a = new int[length];
                array_b = new int[fixedLength];
                startTime = System.nanoTime();
                array_a = appendArray(array_a, array_b);
                endTime = System.nanoTime();
                arraySumTime += endTime - startTime;
                if(endTime - startTime < arrayMinTime){
                    arrayMinTime = endTime - startTime;
                }
            }
            System.out.printf("%13d", length);
            //System.out.printf("%12.2f%12.2f\n", (double)linkedSumTime/repitition, (double)arraySumTime/repitition);
            System.out.printf("%12.2f%12.2f\n", linkedMinTime, arrayMinTime);
        }
    }

    public static void benchmarkFixedA(){
        long startTime;
        long endTime;
        int repitition = 1000;
        int fixedLength = 1000;
        float linkedMinTime;
        float arrayMinTime;
        long linkedSumTime;
        long arraySumTime;
        int[] array_a;
        int[] array_b;

        LinkedList a;
        LinkedList b;

        System.out.printf("#Append b of length n to a of length 1000, time in ns\n");
        System.out.printf("#%12s%12s%12s\n", "n", "linkedlist", "array");
        for(int length = 2; length < 100000; length*=2){
            linkedMinTime = Float.POSITIVE_INFINITY;
            arrayMinTime = Float.POSITIVE_INFINITY;
            linkedSumTime = 0;
            arraySumTime = 0;
            for(int i = 0; i <= repitition; i++){
                a = new LinkedList(fixedLength);
                b = new LinkedList(length);
                startTime = System.nanoTime();
                a.append(b);
                endTime = System.nanoTime();
                linkedSumTime += endTime - startTime;
                if(endTime - startTime < linkedMinTime){
                    linkedMinTime = endTime - startTime;
                }

                array_a = new int[fixedLength];
                array_b = new int[length];
                startTime = System.nanoTime();
                array_a = appendArray(array_a, array_b);
                endTime = System.nanoTime();
                arraySumTime += endTime - startTime;
                if(endTime - startTime < arrayMinTime){
                    arrayMinTime = endTime - startTime;
                }
            }
            System.out.printf("%13d", length);
            //System.out.printf("%12.2f%12.2f\n", (double)linkedSumTime/repitition, (double)arraySumTime/repitition);
            System.out.printf("%12.2f%12.2f\n", linkedMinTime, arrayMinTime);
        }
    }

    public static void benchmarkArrayVsList(){
        long startTime;
        long endTime;
        int repitition = 1000;
        float linkedMinTime;
        float arrayMinTime;
        int[] array_a;

        LinkedList a;

        System.out.printf("#Building a list and allocating an array of length n, time in ns\n");
        System.out.printf("#%12s%12s%12s\n", "n", "linkedlist", "array");
        for(int length = 2; length < 100000; length*=2){
            linkedMinTime = Float.POSITIVE_INFINITY;
            arrayMinTime = Float.POSITIVE_INFINITY;
            for(int i = 0; i <= repitition; i++){
                startTime = System.nanoTime();
                a = new LinkedList(length);
                endTime = System.nanoTime();
                if(endTime - startTime < linkedMinTime){
                    linkedMinTime = endTime - startTime;
                }

                startTime = System.nanoTime();
                array_a = new int[length];
                endTime = System.nanoTime();
                if(endTime - startTime < arrayMinTime){
                    arrayMinTime = endTime - startTime;
                }
            }
            System.out.printf("%13d", length);
            System.out.printf("%12.2f%12.2f\n", linkedMinTime, arrayMinTime);
        }
    }


    public static int[] appendArray(int[] a, int[] b){
        int length = a.length + b.length;
        int[] c = new int[length];
        for(int i = 0; i<length; i++){
            if(i<a.length){
                c[i] = a[i];
            }
            else{
                c[i] = b[i-a.length];
            }
        }
        return c;
    }
}