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
 * Created by 0x1nbetw33n on 22. Feb   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import misc.util.Array_Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

abstract sealed class Sort permits Bubble, Insertion, Merge, Selection {

        private final List<Object[]> states = new ArrayList<>();


        /**
         * Framework for all sorting algorithms so that they can be used in the same way.<br>
         * Every sublass will implement its own sort method.
         * @param comp the comparator that is used to compare the elements
         * @param data the data that will be sorted
         */
        protected abstract <T> void sort(final Comparator<? super T> comp, final T[] data);

        /**
         * Calls {@link #sort(Comparator, Object[])} with {@link Comparator#naturalOrder()} as comparator.
         * @param data the data that will be sorted
         */
        protected <T extends Comparable<? super T>> void sort(final T[] data) {
                sort(Comparator.naturalOrder(), data);
        }

        /**
         * swaps two elements in an array in place (without an auxiliary data structure)
         * @param data the data whose elements will be swapped
         * @param i the index of the first element
         * @param j the index of the second element
         */
        protected <T> void swap(final int i, final int j, final T[] data) {
                final T tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
        }

        /**
         * Writes the current state of the data to {@link #states} {@code (List<String>)}.
         */
        protected final <T> void write_current_state(final T[] data) {
                states.add(Arrays.copyOf(data, data.length));
        }

        /**
         * Parses {@link #states} {@code (List<String>)} to an Object[][].
         * @return states as Object[][]
         */
        protected Object[][] get_states() {
                return states.toArray(Object[][]::new);
        }

        protected void print_states() {
                var sb = new StringBuilder("{").append(System.lineSeparator());
                for (var i = 0; i < states.size(); i++) {
                        if (i < states.size() - 1) {
                                sb.append(Array_Parser.to_string(states.get(i))).append(",").append(System.lineSeparator());
                        } else {
                                sb.append(Array_Parser.to_string(states.get(i))).append(System.lineSeparator()).append("}");
                        }
                }
                System.out.println(sb);
        }


}
