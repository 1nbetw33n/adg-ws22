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

import java.util.Comparator;

final class Bubble extends Sort{

        /**
         * Implementation of bubble sort.<br>
         * The Algorithm is <a href="https://www.geeksforgeeks.org/stable-and-unstable-sorting-algorithms/?type=article&id=10109">stable</a>
         * and <a href="https://www.geeksforgeeks.org/adaptive-and-non-adaptive-sorting-algorithms/">adaptive</a>
         * and <a href="https://en.wikipedia.org/wiki/In-place_algorithm/">in-place</a>.<br>
         * Basic logic:<br>
         * The algorithm iterates over the data and compares {@code i} and {@code i+1}.<br>
         * If {@code i} is greater than {@code i+1}, the elements are swapped.<br>
         * So the largest element is bubbled to the end of the array in each iteration.<br>
         * The algorithm iterates over the data until no swaps are made anymore.<br>
         * @param data the data that will be sorted
         * @param comp the comparator that is used to compare the elements
         */
        protected <T extends Comparable<? super T>> void sort(final Comparator<T> comp, final T[] data) {
                var pos = data.length - 1;
                while (pos > 0) {
                        var border = pos;
                        pos = 0;
                        write_current_state(data);
                        for (var i = 0; i < border; i++) {
                                if (comp.compare(data[i], data[i + 1]) > 0) {
                                        swap(i, i + 1, data);
                                        pos = i;
                                }
                        }
                }
                write_current_state(data);
                print_states();
        }


}