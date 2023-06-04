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

package adg.graph;/*
 * Created by 0x1nbetw33n on 12. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.*;

final class BFS extends Search {

	// TODO: add basic logic for BFS in javadoc
	/**
	 * Implementation of Breadth First Search (BFS) for a given graph represented by adjLists.
	 * @param adjLists the adjacency lists of the graph
	 * @return the list of node in the order they were visited
	 */
	protected List<Object> sort(final AdjLists adjLists) {
		final LinkedList<Object> unvisited = new LinkedList<>(adjLists.get_keys());
		final Map<Object, Boolean> map = new LinkedHashMap<>();
		while (!unvisited.isEmpty()) {
			map.put(unvisited.pop(), false);
			while (map.containsValue(false)) {
				Object current = map.keySet()
					.stream()
					.filter(key -> map.get(key).equals(false))
					.findFirst().orElse(null);
				map.put(current, true);
				if (adjLists.get_values(current) == null) {
					continue;
				}
				for (Object o : adjLists.get_values(current)) {
					if (!map.containsKey(o)) {
						map.put(o, false);
						unvisited.remove(o);
					}
				}
			}
		}
		return new LinkedList<>(map.keySet());
	}


}
