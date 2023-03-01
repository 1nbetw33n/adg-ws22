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

package adg.sorting;/*
 * Created by 0x1nbetw33n on 28. Feb   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.Arrays;
import java.util.Comparator;

final class Array_Comparer {

    /**
     * Private constructor to prevent instantiation.
     */
    private Array_Comparer() {}

    /**
     * Calls {@link #compare(Comparator, Comparable[], Comparable[])} with {@link Comparator#naturalOrder} as default comparator.
     * @param exp expected T[]
     * @param actual actual T[]
     * @return 0 if both arrays are equal, otherwise something else != 0<br>
     */
    public static <T extends Comparable<? super T>> int compare(final T[] exp, final T[] actual) {
        return compare(Comparator.naturalOrder(), exp, actual);
    }

        /**
         * Compares two T[] with a given comparator.
         * @param comp comparator to use
         * @param exp expected T[]
         * @param actual actual T[]
         * @return 0 if both arrays are equal, otherwise something else != 0<br>
         * @see Arrays#compare(Object[], Object[], Comparator)
         */
    public static <T extends Comparable<? super T>> int compare(final Comparator<T> comp, final T[] exp, final T[] actual) {
        if (exp.length != actual.length) {
            return exp.length - actual.length;
        }
        return Arrays.compare(exp, actual, comp);
    }

    /**
     * Compares two T[][] with a given comparator using {@link #compare(Comparable[], Comparable[])} to compare each row (effectively using {@link Comparator#naturalOrder} as comparator).
     * @param exp expected T[][]
     * @param actual actual T[][]
     * @return 0 if both arrays are equal, otherwise something else != 0<br>
     */
    public static <T extends Comparable<? super T>> int compare_2D(final T[][] exp, final T[][] actual) {
        if (exp.length != actual.length) {
            return exp.length - actual.length;
        } else if (exp[0].length != actual[0].length) {
            return exp[0].length - actual[0].length;
        }
        for (var i = 0; i < exp.length; i++) {
            if (compare(exp[i], actual[i]) != 0) {
                return compare(exp[i], actual[i]);
            }
                }
        return 0;
    }


}
