package graph;

/*
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
