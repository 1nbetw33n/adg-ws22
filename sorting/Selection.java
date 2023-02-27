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
 * Created by 0x1nbetw33n on 27. Feb   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.Comparator;

final class Selection extends Sort {

    protected <T extends Comparable<? super T>> void sort(final Comparator<T> comp, final T[] data){
        for (var i = 0; i < data.length -1; i++) {
            swap(i, minPos(i, data), data);
        }
    }


    private <T extends Comparable<? super T>> int minPos(final int i,  final T[] data) {
        return minPos(Comparator.naturalOrder(), i, data);
    }

    /**
     *
     * @param comp
     * @param i
     * @param data
     * @return
     * @param <T>
     */
    private <T extends Comparable<? super T>> int minPos(final Comparator<T> comp, final int i, final T[] data){
        var pos = i;
        for (var j = i + 1; j < data.length; j++) {
            if (comp.compare(data[pos], data[j]) > 0) {pos = j;}
        }
        return pos;
    }
    
    
}
    