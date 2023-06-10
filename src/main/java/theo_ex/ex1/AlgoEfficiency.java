package theo_ex.ex1;

/*
 * Created by 0x1nbetw33n on 20. Feb   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.function.Function;

import static java.lang.Math.*;

/**
 * Utility class for comparing the runtime of two algorithms around a given border value.<br>
 * Built to solve an exercise in theo exercise1 of ADG.
 */
final class AlgoEfficiency {

        /**
         * private constructor because utility class
         */
        private AlgoEfficiency() {}

        /**
         * Alters the runtime of the faster algorithm by the given ratio.<br>
         * Then compares the runtime of both algorithms around the given border value (+/- 1) and prints the results.<br>
         * @param algo1 name of algorithm 1
         * @param algo2 name of algorithm 2
         * @param slower the slower algorithm
         * @param faster the faster algorithm
         */
        static void alter_runtime(final double altered_ratio, final int border, final String algo1, final String algo2, final Function<Double, Double> slower, final Function<Double, Double> faster) {
                int n = border - 1;
                double val1;
                double val2;
                while (n <= border + 1) {
                        val1 = slower.apply((double) n);
                        val2 = altered_ratio * faster.apply((double) n);
                        print_comparison(n, algo1, algo2, val1, val2);
                        n++;
                }
                print_ratios(altered_ratio, get_ratio(border, slower, faster));
        }

        /**
         * Calls {@link #alter_runtime(double, int, String, String, Function, Function)}  and passes the slower function as first parameter and the faster function as second parameter<br>(so it doesn't matter what algorithm is passed as last parameter).<br>
         * The faster algorithm is then multiplied with a multiplicative factor in order to slow it down enough to have a slower runtime at the given border value (and below) than the slower algorithm.<br>
         * @param border the border value
         * @param algo1 name of algorithm 1
         * @param algo2 name of algorithm 2
         * @param f1 runtime function of algorithm 1
         * @param f2 runtime function of algorithm 2
         */
        @SuppressWarnings("SameParameterValue")
        static void alter_runtime(final int border, final String algo1, final String algo2, final Function<Double, Double> f1, final Function<Double, Double> f2) {
                final Function<Double, Double> slower = (f1.apply((double) border) < f2.apply((double) border)) ? f2 : f1;
                final Function<Double, Double> faster = (f1.apply((double) border) < f2.apply((double) border)) ? f1 : f2;
                // multiply the ratio with .99 for border=10, .999 for border=100, .9999 for border=1000, etc. to prevent both algorithms from having the same runtime at the border value
                final double altered_ratio = get_ratio(border, f1, f2) * Double.parseDouble("." + "9".repeat((String.valueOf(border)).length()));
                alter_runtime(altered_ratio,border, algo1, algo2, slower, faster);
        }

        /**
         * Calculates how much faster the faster algorithm is than the slower algorithm at the given border value.
         * @param border the border value where the measurement is taken
         * @param f1 runtime function of algorithm 1
         * @param f2 runtime function of algorithm 2
         * @return the ratio
         */
        static double get_ratio(final int border, final Function<Double, Double> f1, final Function<Double, Double> f2) {
                final Double val1 = f1.apply((double) border);
                final Double val2 = f2.apply((double) border);
                return Math.max(val1, val2) / Math.min(val1, val2);
        }

        /**
         * Prints the runtime of two algorithms at a given border value.
         * @param n the current value of n
         * @param algo1 name of algorithm 1
         * @param algo2 name of algorithm 2
         * @param val1 runtime of algorithm 1
         * @param val2 runtime of algorithm 2
         */
        static void print_comparison(final int n, final String algo1, final String algo2, final double val1, final double val2) {
                System.out.println("n = " + n + " :: ");
                System.out.printf("\t\t\t" + algo1 + "\t\t\t::\t%.7fs\n", val1);
                System.out.printf("\t\t\t" + algo2 + "\t::\t%.7fs\n", val2);
                System.out.println("\t\t\tfaster\t\t::\t" + (val1 < val2 ? algo1 : algo2));
        }

        /**
         * Prints both ratios.
         * @param og_ratio the original ratio
         * @param altered_ratio the ratio multiplied with {@code ".999"}, etc.
         */
        private static void print_ratios(final double og_ratio, final double altered_ratio) {
                System.out.println("------------------------------------");
                System.out.println("equal runtime ratio\t\t::\t" + og_ratio);
                System.out.println("altered ratio\t\t\t::\t" + altered_ratio);
        }

        public static void main(String... args) {
                final int border = 100;
                final String algo1 = "n²";
                final String algo2 = "n * log(n)";
                final Function <Double, Double> f1 = n -> n * n;
                final Function <Double, Double> f2 = n -> n * log(n);
                alter_runtime(border, algo1, algo2, f1, f2);
        }


}
