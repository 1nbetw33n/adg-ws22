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
 * Created by 0x1nbetw33n on 14. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.*;

final class Top_Sort extends Search{


	/**
	 * Sorts the graph (represented by a list of adjacency lists) topologically in <s>O(n^2)</s> O(n) time (because the variable {@code sorted} is already in ascending order).<br>
	 * <br>
	 * Basic logic:<br>
	 * The nodes of the graph are sorted in a way that all nodes that have an edge to another node are placed before the node they point to.<br>
	 * <br>
	 * This is done by removing all nodes that have no incoming edges and then removing all edges that point to the removed nodes.<br>
	 * This is repeated until all nodes are removed.<br>
	 * <br>
	 * In the end each element of the ordered list is mapped to its position in the sorted list.
	 * <br>
	 * @param adjLists the adjacency lists of the graph
	 * @return the topological order of the nodes mapped to their position in the sorted list
	 */
	protected List<Object> sort(AdjLists adjLists) {
		final List<Object> sorted = adjLists.get_keys();
		final Map<Object, Boolean> no_inc = new LinkedHashMap<>();
		Object current;
		getNodes_with_noIncEdges(adjLists)
			.forEach(key -> no_inc.put(key, false));
		while (!adjLists.get_AdjLists().isEmpty()) {
			if (no_inc.containsValue(false)) { // if there are unmarked nodes in no_inc
				current = get_smallestUnmarked(no_inc);
				no_inc.put(current, true);
				final List<Object> removed_values = adjLists.get_values(current);
				adjLists.get_AdjLists().remove(current);
				if (!removed_values.contains("")) { // only need to check for nodes with no incoming edges if the removed node had outgoing edges
					getNodes_with_noIncEdges(adjLists, removed_values)
						.forEach(key -> no_inc.put(key, false));
				}
			}
		}
		//map no_inc -> position in sorted
		return List.of(map_to_positions(sorted, no_inc)
			.values()
			.toArray());
	}

	/**
	 * # Initial retrieval of all nodes that have no incoming edges #<br>
	 * <br>
	 * Retrieves all nodes that have no incoming edges.
	 * @param adjLists the adjacency lists of the graph
	 * @return a list of nodes that have no incoming edges
	 */
	private List<Object> getNodes_with_noIncEdges(final AdjLists adjLists) {
		final List<Object> no_incEdges = new ArrayList<>();
		adjLists.get_keys()
			.forEach(key -> {
				if (!adjLists.contains_value(key))
					no_incEdges.add(key);
			});
		return no_incEdges;
	}

	/**
	 * # More performant retrieval of all nodes without inc edges #<br>
	 * <br>
	 * Retrieves all nodes that have no incoming edges but only checking the values that were removed in the previous iteration.
	 * @param adjLists the adjacency lists of the graph
	 * @param removed_values the values that were previously removed
	 * @return a list of nodes that have no incoming edges
	 */
	private List<Object> getNodes_with_noIncEdges(final AdjLists adjLists, final List<Object> removed_values) {
		final List<Object> no_incEdges = new ArrayList<>();
		removed_values.forEach(value -> {
			if (!adjLists.contains_value(value))
				no_incEdges.add(value);
		});
		return no_incEdges;
	}

	/**
	 * Retrieves the smallest unmarked node of the nodes without incoming edges.
	 * @param no_inc the nodes that have no incoming edges
	 * @return the smallest unmarked node
	 */
	private Object get_smallestUnmarked(final Map<Object, Boolean> no_inc) {
		return no_inc.keySet()
			.stream()
			.filter(key -> !no_inc.get(key)) // filter out all marked nodes (marked = true)
			.min(Comparator.comparing(Object::toString)) // get the smallest unmarked node
			.orElse(null);
	}

	/**
	 * Maps the nodes to their position in the sorted list (the nodes are sorted by their key (in natural order)).<br>
	 * @param sorted the sorted list of nodes
	 * @param no_inc the topologically sorted list of nodes
	 * @return the nodes mapped to their position in the sorted list
	 */
	private Map<Object, Object> map_to_positions(final List<Object> sorted, final Map<Object, Boolean> no_inc) {
		final Object[] keys = no_inc.keySet()
			.toArray();
		final Map<Object, Object> map = new HashMap<>();
		for (int i = 0; i < sorted.size(); i++) {
			map.put(keys[i], Integer.parseInt((String) sorted.get(i)) + 1);
		}
		return map;
	}


}
