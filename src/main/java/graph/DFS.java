package graph;

/*
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
