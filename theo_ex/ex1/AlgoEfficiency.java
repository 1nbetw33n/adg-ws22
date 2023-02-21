/*
 *
 * Copyright (c) 2022 1nbetw33n
 * Virgo Supercluster, Milky Way - Earth A-6847
 *
 * I dont give a fuck about copyright - this code is free to use for everybody - EXCEPTION:
 *      - entities that support:
 *          > queer hostility
 *          > any kind of religion
 *          > authoritarianism
 *          > sexism
 *          > racism
 *          > ableism
 *      - (most) boomer
 *      - conservatives
 *      - nazis
 *      - TERFs
 *      - TWERFs
 *      - SWERFs
 *      - MAPs
 *   -will be extended if necessary-
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * -will be extended if necessary-
 */

package adg.theo_ex.ex1;/*
 * Created by 0x1nbetw33n on 20. Feb   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.function.Function;

import static java.lang.Math.log;

final class AlgoEfficiency {

        /**
         * private constructor because utility class
         */
        private AlgoEfficiency() {}

        /**
         * method to get the ratio that needs to be applied to a constant in order to make the runtime of two algorithms equal at a given border value
         * so that below the border value the first algorithm is faster and above the border value the second algorithm is faster
         * @param border the border value where the runtime of the two algorithms shall be equal
         * @param f1 algorithm 1
         * @param f2 algorithm 2
         */
        static void compare_runtime(final int border, final String algo1, final String algo2, final Function<Double, Double> f1, final Function<Double, Double> f2) {
                var n = border - 1;
                var c1 = 1.;
                var c2 = 1.;
                //multiply the ratio with .99 for border=10, .999 for border=100, .9999 for border=1000, etc. to prevent both algorithms from having the same runtime at the border value
                var ratio = get_ratio(border, f1, f2) * Double.parseDouble("." + "9".repeat(("" + border).length()));
                var val1 = 0.;
                var val2 = 0.;
                if (f1.apply((double) border) < f2.apply((double) border)) {
                        c1 *= ratio;
                } else {
                        c2 *= ratio;
                }
                while (n <= border + 1) {
                        val1 = c1 * f1.apply((double) n);
                        val2 = c2 * f2.apply((double) n);
                        System.out.println("n = " + n + " :: ");
                        System.out.printf("\t\t\t" + algo1 + "\t\t\t::\t%.7fs\n", val1);
                        System.out.printf("\t\t\t" + algo2 + "\t::\t%.7fs\n", val2);
                        System.out.println("\t\t\tfaster\t\t::\t" + (val1 < val2 ? algo1 : algo2));
                        n++;
                }
                System.out.println("------------------------------------");
                System.out.println("ratio = " + get_ratio(border, f1, f2));
        }

        /**
         * Calculates the ratio that needs to be applied to a constant in order to make the runtime of two algorithms equal at the given border value
         * @param border the border value where the runtime of the two algorithms is equal
         * @param f1 algorithm 1
         * @param f2 algorithm 2
         * @return the ratio
         */
        static double get_ratio(final int border, final Function<Double, Double> f1, final Function<Double, Double> f2) {
                var c1 = 1.;
                var c2 = 1.;
                if (f1.apply((double) border) > f2.apply((double) border)) {
                        c1 = f1.apply((double) border) / f2.apply((double) border);
                } else {
                        c2 = f2.apply((double) border) / f1.apply((double) border);
                }
                return Math.max(c1, c2);
        }

        public static void main(String... args) {
                var border = 100;
                var algo1 = "n²";
                var algo2 = "n * log(n)";
                Function <Double, Double> f1 = n -> n * n;
                Function <Double, Double> f2 = n -> n * log(n);
                compare_runtime(border, algo1, algo2, f1, f2);
        }


}
