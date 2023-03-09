# Divide and Conquer
Suppose you are given two sets of n points, one set {p1, p2, . . . , pn} on the line y = 0 and the other set {q1, q2, . . . , qn} on the line y = 1. Create a set of n line segments by connecting each point pi to the corresponding point qi. The goal is to develop an algorithm to determine how many pairs of these line segments intersect. The algorithm should take the 2n points as input, and return the number of intersections. Using divide-and-conquer, I developed an algorithm that runs in O(n log n) time.

# Input:
Read in from stdin. The first line will be the number of instances. For each instance, the first line will contain the number of pairs of points (n). The next n lines each contain the location x of a point qi on the top line. Followed by the final n lines of the instance each containing the location x of the corresponding point pi on the bottom line.

**Constraints:**
- 1 ≤ n ≤ 106
- For each point, its location x is a positive integer such that 1 ≤ x ≤ 106
- No two points are placed at the same location on the top line, and no two points are placed at the
same location on the bottom line.

# Sample:
**Input:**\
2\
4\
1\
10\
8\
6\
6\
2\
5\
1\
5\
9\
21\
1\
5\
18\
2\
4\
6\
10\
1\

**Output:**\
4\
7