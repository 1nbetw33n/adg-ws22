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

package graph;/*
 * Created by 0x1nbetw33n on 12. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.*;

final class DFS extends Search {

	// TODO: add basic logic for DFS to javadoc
	/**
	 * Implementation of Depth First Search algorithm for a given graph represented by adjLists.
	 * @param adjLists adjacency lists of the graph
	 * @return list of nodes in the order they were visited
	 */
	protected List<Object> sort(final AdjLists adjLists) {
		final LinkedList<Object> unvisited = new LinkedList<>(adjLists.get_keys());
		final Deque<Object> stack = new LinkedList<>();
		final List<Object> visited = new ArrayList<>();
		List<Object> adjList;
		while (!unvisited.isEmpty()) {
			stack.addLast(unvisited.poll());
			while (!stack.isEmpty()) {
				Object current = stack.removeFirst();
				visited.add(current);
				unvisited.remove(current);
				if (adjLists.get_values(current) == null) {
					continue; // if node has no neighbours
				}
				adjList = adjLists.get_values(current);
				for (int i = adjList.size() - 1; i >= 0; i--) {
					if (!stack.contains(adjList.get(i)) && !visited.contains(adjList.get(i))) {
						stack.addFirst(adjList.get(i));
					}
				}
			}
		}

		return visited;
	}


}
