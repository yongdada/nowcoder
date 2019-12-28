package class_05_Hash_UnionFind;

/**
 * 岛问题 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右 四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
 * 矩阵中有多少个岛？
 * 
 * @author Administrator
 *
 */
public class Code_03_Islands {

	/**
	 * 深度优先遍历 DFS
	 * @param m
	 * @return
	 */
	public static int countIslands(int[][] m) {
		if (m == null || m[0] == null) {
			return 0;
		}
		int N = m.length;
		int M = m[0].length;
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] == 1) {
					res++;
					infect(m, i, j, N, M);
				}
			}
		}

		return res;
	}

	public static void infect(int[][] m, int i, int j, int N, int M) {
		if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
			return;
		}
		m[i][j] = 2;
		infect(m, i + 1, j, N, M);
		infect(m, i - 1, j, N, M);
		infect(m, i, j + 1, N, M);
		infect(m, i, j - 1, N, M);
	}

	public static void main(String[] args) {
		int[][] m1 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m1));

		int[][] m2 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m2));

	}

	//=====================================================
	/**
	 * 200. 岛屿数量
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0] == null) {
			return 0;
		}
		
		int X = grid.length;
		int Y = grid[0].length;
		int res = 0;
		for(int i=0; i<X; i++) {
			for(int j=0; j<Y; j++) {
				if(grid[i][j] == '1') {
					res++;
					dfs(grid, i, j, X, Y);
				}
			}
		}
		return res;
	}
	private void dfs(char[][] grid, int i, int j, int x, int y) {
		if(i<0 || i>=x || j<0 || j>=y || grid[i][j]!='1') {
			return;
		}
		grid[i][j] = '2';
		dfs(grid, i+1, j, x, y);
		dfs(grid, i-1, j, x, y);
		dfs(grid, i, j+1, x, y);
		dfs(grid, i, j-1, x, y);
	}
	/**
	 * 用并查集的解法
	 * @author Administrator
	 *
	 */
	class Solution {
		class UnionFind {
			int count; // # of connected components
			int[] parent;
			int[] rank;

			public UnionFind(char[][] grid) { // for problem 200
				count = 0;
				int m = grid.length;
				int n = grid[0].length;
				parent = new int[m * n];
				rank = new int[m * n];
				for (int i = 0; i < m; ++i) {
					for (int j = 0; j < n; ++j) {
						if (grid[i][j] == '1') {
							parent[i * n + j] = i * n + j;
							++count;
						}
						rank[i * n + j] = 0;
					}
				}
			}

			public int find(int i) { // path compression
				if (parent[i] != i)
					parent[i] = find(parent[i]);
				return parent[i];
			}

			public void union(int x, int y) { // union with rank
				int rootx = find(x);
				int rooty = find(y);
				if (rootx != rooty) {
					if (rank[rootx] > rank[rooty]) {
						parent[rooty] = rootx;
					} else if (rank[rootx] < rank[rooty]) {
						parent[rootx] = rooty;
					} else {
						parent[rooty] = rootx;
						rank[rootx] += 1;
					}
					--count;
				}
			}

			public int getCount() {
				return count;
			}
		}

		public int numIslands(char[][] grid) {
			if (grid == null || grid.length == 0) {
				return 0;
			}

			int nr = grid.length;
			int nc = grid[0].length;
			//int num_islands = 0;
			UnionFind uf = new UnionFind(grid);
			for (int r = 0; r < nr; ++r) {
				for (int c = 0; c < nc; ++c) {
					if (grid[r][c] == '1') {
						grid[r][c] = '0';
						if (r - 1 >= 0 && grid[r - 1][c] == '1') {
							uf.union(r * nc + c, (r - 1) * nc + c);
						}
						if (r + 1 < nr && grid[r + 1][c] == '1') {
							uf.union(r * nc + c, (r + 1) * nc + c);
						}
						if (c - 1 >= 0 && grid[r][c - 1] == '1') {
							uf.union(r * nc + c, r * nc + c - 1);
						}
						if (c + 1 < nc && grid[r][c + 1] == '1') {
							uf.union(r * nc + c, r * nc + c + 1);
						}
					}
				}
			}

			return uf.getCount();
		}
	}

}
