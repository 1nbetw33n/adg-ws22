package graph;

/*
 * Created by 0x1nbetw33n on 12. Mar   2023
 * Virgo Supercluster, Milky Way - Earth A-6847
 */

import java.util.List;

abstract sealed class Search permits BFS, DFS, Top_Sort {

	/**
	 * Framework for graph searching/sorting algorithms.
	 * @param adjLists the adjacency lists of the graph
	 * @return the path from the start node to the end node
	 */
	protected abstract List<Object> sort(final AdjLists adjLists);


}
