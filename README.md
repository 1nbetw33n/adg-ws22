# ADG Algorithms
#### This is a collection of algorithms that I've implemented as part of my exam preparation for the 'Algorithms and Data Structures and Graph Theory' (ADG) during my bachelor's degree in Computer Science.
<br>
<div>
<details>
<summary><h2>Sorting Algorithms</h2></summary>
To use the algorithms you can use <kbd>Main.java</kbd> in :: <kbd>src/main/java/adg/sorting</kbd><br>
The sorting algorithms will produce the different states that occured while performing the algorithm.<br>
for example ::<br>
<kbd>{12, 13, 24, 33, 20, 17, 29, 19, 11, 8}</kbd> with <kbd>merge sort</kbd> will produce the following output ::<br>
<pre>
{
{12, 13, 24, 33, 20, 17, 29, 19, 11, 8},
{12, 13},
{12, 13, 24},
{20, 33},
{12, 13, 20, 24, 33},
{17, 29},
{17, 19, 29},
{8, 11},
{8, 11, 17, 19, 29},
{8, 11, 12, 13, 17, 19, 20, 24, 29, 33}
}
</pre>
The following algorithms are implemented and extensively tested ::<br>
<kbd>Selection Sort</kbd><br>
<kbd>Insertion Sort</kbd><br>
<kbd>Bubble Sort</kbd><br>
<kbd>Merge Sort</kbd><br>
<kbd>Quick Sort</kbd><br>
</details>
<details>
<summary><h2>Graph Algorithms</h2></summary>
To use the algorithms you can use <kbd>Main.java</kbd> in :: <kbd>src/main/java/adg/graph</kbd><br>
The graph algorithms will provide the order in which the nodes are visited.<br>
for example ::<br>
<kbd>The Adjacency List</kbd> 
<pre>
0 -> [1, 3]
1 -> [3, 6]
2 -> [7]
3 -> [2]
4 -> [1, 6]
5 -> [1, 4, 6]
6 -> [2, 3, 7]
7 -> []
</pre>
with <kbd>Top Sort</kbd> will produce the following output ::<br>
<pre>
{1,4,7,6,3,2,5,8}
</pre>
The following algorithms are implemented <strong><em>(and NOT extensively tested)</em></strong> ::<br>
<kbd>Depth First Search (DFS)</kbd><br>
<kbd>Breadth First Search (BFS)</kbd><br>
<kbd>Topological Sort (Top Sort)</kbd><br>
</details>
</div>

