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

package adg.sorting;

import misc.util.String_Parser;
import misc.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Comparator;

/*
 * Created by 0x1nbetw33n on 22. Feb   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

final class SortTest {

        /**
         * Calls {@link #sort_test(Comparator, Sort, Comparable[], Comparable[][])} with {@link Comparator#naturalOrder()} as comparator.
         * @param sort the sorting algorithm that will be tested
         * @param data the data that will be sorted
         */
        private <T extends Comparable<? super T>> void sort_test(final Sort sort, final T[] data, final T[][] exp_states) {
                sort_test(Comparator.naturalOrder(), sort, data, exp_states);
        }

        /**
         * Tests the sorting algorithm with the given inputs and expected outputs.
         * @param comp the comparator that is used to compare the elements
         * @param sort the sorting algorithm that will be tested
         * @param data the data that will be sorted
         */
        private <T extends Comparable<? super T>> void sort_test(final Comparator<T> comp, final Sort sort, final T[] data, final T[][] exp_states) {
                sort.sort(comp, data);
                Assertions.assertEquals(0, Util.compare_2D_arrays(exp_states, sort.get_states()));

        }

        @Test
        void swap_test() {
                Sort bubble_sort = new Bubble();
                var data = new Integer[]{1, 2, 3, 4, 5};
                bubble_sort.swap(0, 1, data);
                assert data[0] == 2;
                bubble_sort.swap(1, 2, data);
                assert data[2] == 1;
        }


        @ParameterizedTest(name = "{2}: {0}")
        @CsvFileSource(resources = "/adg/sorting/bubble.csv", numLinesToSkip = 1, delimiter = ',')
        void bubble_sort_test(final String input, final String exp_states, @SuppressWarnings("unused") final String desc) {
                sort_test(new Bubble(), String_Parser.to_integer_array(input), String_Parser.to_integer_2D_array(exp_states));
        }

        @ParameterizedTest(name = "{2}: {0}")
        @CsvFileSource(resources = "/adg/sorting/selection.csv", numLinesToSkip = 1, delimiter = ',')
        void selection_sort_test(final String input, final String exp_states, @SuppressWarnings("unused") final String desc){
                sort_test(new Selection(), String_Parser.to_integer_array(input), String_Parser.to_integer_2D_array(exp_states));
        }

}
