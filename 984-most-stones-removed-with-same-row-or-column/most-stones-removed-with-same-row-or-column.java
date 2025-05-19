class Solution {
    public int removeStones(int[][] stones) {
          int n = stones.length;
        if (n <= 1) {
            return 0;
        }


      
        DSU ds = new DSU(n);
        int totalRemoved=0;

        for (int i = 0; i < n; i++) {
            int[] u = stones[i];
            for (int j = i+1; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int[] v = stones[j];
                if (u[0] == v[0] || u[1] == v[1]) {
                   totalRemoved+= ds.union(i ,j);
                }
            }
        }
        return totalRemoved;
    }
}


class DSU {
    int[] par ;
    int[] size ;
    public DSU(int n) {
    	par = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i]=1;
        }
    }

    public int findUPar(int node) {
        if (node == par[node]) {
            return node;
        }
        int ulp = findUPar(par[node]);
        par[node]=ulp;
        return par[node];
   
    }

 

    public int union(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return 0;
        if (size[ulp_u] < size[ulp_v]) {
            par[ulp_u]= ulp_v;
            size[ulp_v]= size[ulp_v] + size[ulp_u];
        } else {
            par[ulp_v]= ulp_u;
            size[ulp_u]= size[ulp_u] + size[ulp_v];
        }
        return 1;
    }
}