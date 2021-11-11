package edu.wou.cs361.sorting;

public class Analyzer implements IAnalyzer {
    /**
     * Analyze sorting data
     *
     * @param sizes An Array of values containing the sizes used in sorting
     * @param compares The corresponding Array containing the number of compares measured for each size
     * @return Returns an Analysis object containing the analysis data
     * @throws IllegalArgumentException if the argument is null
     */
    @Override
    public Analysis analyze(int[] sizes, long[] compares) {
        if (sizes.length != compares.length) throw new IllegalArgumentException();

        double[] sizesDoubles = new double[sizes.length];
        for(var i = 0; i < sizes.length; ++i){
            sizesDoubles[i] = sizes[i];
        }

        // #1 ---- check O(N)
        var ratios1 = new double[sizes.length];
        double error1 = 0.0000;
        double total1 = 0.0000;
        for(var i = 0; i < sizes.length; ++i){
            ratios1[i] = (compares[i] / sizes[i]);
            total1 += ratios1[i];
        }
        double average1 = total1 / sizes.length;
        var errors1 = new double[sizes.length];
        for(var i = 0; i < sizes.length; ++i){
            errors1[i] = Math.abs(ratios1[i] - average1) / average1;
        }
        for(var i = 0; i < sizes.length; ++i){
            error1 += errors1[i];
        }
        var finalError1 = error1 / sizes.length;
        var analysis1 = new Analysis(ratios1, finalError1, "O(N)");


        // #2 ---- check O(N^3)
        var ratios2 = new double[sizes.length];
        double error2 = 0.0000;
        double total2 = 0.0000;
        for(var i = 0; i < sizes.length; ++i){
            ratios2[i] = (compares[i] / (Math.pow(sizes[i], 3)));
            total2 += ratios2[i];
        }
        double average2 = total2 / sizes.length;
        var errors2 = new double[sizes.length];
        for(var i = 0; i < sizes.length; ++i){
            errors2[i] = Math.abs(ratios2[i] - average2) / average2;
        }
        for(var i = 0; i < sizes.length; ++i){
            error2 += errors2[i];
        }
        error2 = error2 / sizes.length;
        var analysis2 = new Analysis(ratios2, error2, "O(N^3)");


        // #3 ---- check O(N^2)
        var ratios3 = new double[sizes.length];
        double error3 = 0.0000;
        double total3 = 0.0000;
            for(var i = 0; i < sizes.length; ++i){
            ratios3[i] = (compares[i] / (Math.pow(sizes[i], 2)));
            total3 += ratios3[i];
        }
        double average3 = total3 / sizes.length;
        var errors3 = new double[sizes.length];
            for(var i = 0; i < sizes.length; ++i){
            errors3[i] = Math.abs(ratios3[i] - average3) / average3;
        }
            for(var i = 0; i < sizes.length; ++i){
            error3 += errors3[i];
        }
        error3 = error3 / sizes.length;
        var analysis3 = new Analysis(ratios3, error3, "O(N^2)");


        // #4 ---- check O(log N)
        var ratios4 = new double[sizes.length];
        double error4 = 0.0000;
        double total4 = 0.0000;
        for(var i = 0; i < sizes.length; ++i){
            ratios4[i] = (compares[i] / (Math.log(sizes[i])));
            total4 += ratios4[i];
        }
        double average4 = total4 / sizes.length;
        var errors4 = new double[sizes.length];
        for(var i = 0; i < sizes.length; ++i){
            errors4[i] = Math.abs(ratios4[i] - average4) / average4;
        }
        for(var i = 0; i < sizes.length; ++i){
            error4 += errors4[i];
        }
        error4 = error4 / sizes.length;
        var analysis4 = new Analysis(ratios4, error4, "O(log N)");



        // #5 ---- check O(1)
        var ratios5 = new double[sizes.length];
        double error5 = 0.0000;
        double total5 = 0.0000;
        for(var i = 0; i < sizes.length; ++i){
            ratios5[i] = (compares[i] / 1 );
            total5 += ratios5[i];
        }
        double average5 = total5 / sizes.length;
        var errors5 = new double[sizes.length];
        for(var i = 0; i < sizes.length; ++i){
            errors5[i] = Math.abs(ratios5[i] - average5) / average5;
        }
        for(var i = 0; i < sizes.length; ++i){
            error5 += errors5[i];
        }
        error5 = error5 / sizes.length;
        var analysis5 = new Analysis(ratios5, error5, "O(1)");



        // #6 ---- check O(N log N)
        var ratios6 = new double[sizes.length];
        double error6 = 0.0000;
        double total6 = 0.0000;
        for(var i = 0; i < sizes.length; ++i){
            ratios6[i] = (compares[i] / (sizes[i] * Math.log(sizes[i])));
            total6 += ratios6[i];
        }
        double average6 = total6 / sizes.length;
        var errors6 = new double[sizes.length];
        for(var i = 0; i < sizes.length; ++i){
            errors6[i] = Math.abs(ratios6[i] - average6) / average6;
        }
        for(var i = 0; i < sizes.length; ++i){
            error6 += errors6[i];
        }
        error6 = error6 / sizes.length;
        var analysis6 = new Analysis(ratios6, error6, "O(N log N)");



        // #7 ---- check O(2^N)
        var ratios7 = new double[sizes.length];
        double error7 = 0.0000;
        double total7 = 0.0000;
        for(var i = 0; i < sizes.length; ++i){
            ratios7[i] = (compares[i] / (Math.pow(2, sizes[i])));
            total7 += ratios7[i];
        }
        double average7 = total7 / sizes.length;
        var errors7 = new double[sizes.length];
        for(var i = 0; i < sizes.length; ++i){
            errors7[i] = Math.abs(ratios7[i] - average7) / average7;
        }
        for(var i = 0; i < sizes.length; ++i){
            error7 += errors7[i];
        }
        error7 = error7 / sizes.length;
        var analysis7 = new Analysis(ratios7, error7, "O(2^N)");


        Analysis[] choosing = {analysis1, analysis2, analysis3, analysis4, analysis5, analysis6, analysis7};
        var minValue = 10.0;
        int minIndex = 0;
        for(var i = 0; i < choosing.length; ++i){
            if(choosing[i].getError() < minValue){
                minValue = choosing[i].getError();
                minIndex = i;
            }
        }
        return choosing[minIndex];
    }




}

