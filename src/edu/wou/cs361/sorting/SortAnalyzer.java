package edu.wou.cs361.sorting;

public class SortAnalyzer {

    private static ISort[] sorts = {
            new InsertionSort(),
            new SelectionSort(),
            new MergeSort(),
            new QuickSort()
    };

    private static final int[] sizes = {
            100, 200, 400, 800, 1600
    };

    private static final String[] types = {
            "SORTED",
            "REVERSE",
            "RANDOM"
    };

    private static String[] names = {
            "INSERTION",
            "SELECTION",
            "MERGE",
            "QUICK"
    };

    private static final int INSERTION = 0;
    private static final int SELECTION = 1;
    private static final int MERGE = 2;
    private static final int QUICK = 3;
    private static final int SORTED = 0;
    private static final int REVERSE = 1;
    private static final int RANDOM = 2;


    private static Comparable[][][] makeData(String[] types, int[] sizes) {
        var data = new Comparable[types.length][][];
        var random = new java.util.Random(0);
        for (var type = 0; type < types.length; ++type) {
            data[type] = new Comparable[sizes.length][];
            for (var size = 0; size < sizes.length; ++size) {
                data[type][size] = new Integer[sizes[size]];
                for (var i = 0; i < sizes[size]; ++i)
                    switch (type) {
                        case SORTED:
                            data[type][size][i] = i;
                            break;
                        case REVERSE:
                            data[type][size][i] = sizes[size] - i;
                            break;
                        case RANDOM:
                            data[type][size][i] =
                                    random.nextInt(sizes[size]);
                            break;
                        default:
                            break;
                    }
            }
        }
        return data;
    }

    private static void checkSort(Comparable[][] arrays) {
        for (var i = 0; i < arrays.length; ++i) {
            for (var j = 0; j < arrays[i].length - 1; ++j)
                if (arrays[i][j].compareTo(arrays[i][j + 1]) > 0) {
                    System.out.println("array not sorted array[" + j + "]=" +
                            arrays[i][j] + " array[" + (j + 1) +
                            "]=" + arrays[i][j + 1]);
                    failed();
                }
        }
    }

    private static void checkData(long[] expected, long[] actual) {
        for (var i = 0; i < expected.length; ++i) {
            if (expected[i] != actual[i]) {
                System.out.println("At size: " + sizes[i]);
                System.out.println("expected: " + expected[i]);
                System.out.println("actual: " + actual[i]);
                failed();
            }
        }
    }


    private static void testSorts() {
        for (var sort = 0; sort < sorts.length; sort++) {
            var data = makeData(types, sizes);
            for (var type = 0; type < types.length; ++type) {
                System.out.println("");
                System.out.println(names[sort] + " sort with " +
                        types[type] + " data");

                System.out.print("Sizes: ");
                for (var size = 0; size < sizes.length; ++size) {
                    //System.out.println("Sizes: ");
                    System.out.print(" " + sizes[size] + " ");
                }

                System.out.println("");
                System.out.print("Compares: ");
                var compares = new long[sizes.length];

                for (var size = 0; size < sizes.length; ++size) {
                    compares[size] = sorts[sort].sort(data[type][size]);
                    System.out.print(" " + compares[size] + " ");
                }

                var analyzer = new Analyzer();
                System.out.println("");
                System.out.print("ratios: ");
                var analysis = analyzer.analyze(sizes, compares);
                var printRatios = analysis.getRatios();
                for (var size = 0; size < sizes.length; ++size) {
                    System.out.print(" " + String.format("%.3f", printRatios[size]) + " ");
                }
                System.out.print(" " + analysis.getBigO() + " ");
                System.out.print(" error " + String.format("%.3f",analysis.getError()) + " ");

                checkSort(data[type]);
                checkData(TestDriver.compares[type][sort], compares);
                System.out.println("");
            }
            System.out.println();
        }
    }


    private static void run() {
        testSorts();
    }

    private static void failed() {
        System.out.println("\t\tFAILED");
        System.exit(0);
    }

    public static void main(String[] args) {
        run();
    }
}
