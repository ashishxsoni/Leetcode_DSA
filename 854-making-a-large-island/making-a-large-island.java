class Solution {
     int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int largestIsland(int[][] grid) {

        int max = 0;

        UnionFind uf = new UnionFind(grid);
        int rows = grid.length, cols = grid.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {

                    int id1 = i * cols + j;
                    for (int[] d : dirs) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                            int id2 = x * cols + y;
                            uf.union(id1, id2);
                        }
                    }
                    int ulp_id1 = uf.findUlpParent(id1);
                    max = Math.max(max ,uf.size[ulp_id1] );
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    int sum = 1;
                    HashSet<Integer> seen = new HashSet<>();
                    for (int[] d : dirs) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                            int id2 = x * cols + y;
                            int ulp = uf.findUlpParent(id2);
                            if (seen.add(ulp)) {

                                sum += uf.size[ulp];
                            }
                        }

                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
}

class UnionFind {
    int[] father;
    int[] size;
    int n;

    UnionFind(int[][] grid) {
        n = grid.length;

        father = new int[n * n];
        size = new int[n * n];

        for (int i = 0; i < father.length; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public void union(int node1, int node2) {
        int ulp_1 = findUlpParent(node1);
        int ulp_2 = findUlpParent(node2);
        if (ulp_1 == ulp_2)
            return;
        else if (size[ulp_1] > size[ulp_2]) {

            father[ulp_2] = ulp_1;
            size[ulp_1] += size[ulp_2];
        } else  {

            father[ulp_1] = ulp_2;
            size[ulp_2] += size[ulp_1];
        }
    }

    public int findUlpParent(int node) {
        if (father[node] == node)
            return node;
        return father[node] = findUlpParent(father[node]);
    }
}
