class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int rs =0 , re=mat.length-1 , cs = 0 , ce = mat[0].length-1;
        List<Integer> li = new ArrayList<>();
        while(rs<=re && cs<=ce){

            if(rs>re || cs>ce) break;
            for( int i =cs; i<=ce ; i++)
                li.add(mat[rs][i]);
            rs++;
            if(rs>re || cs>ce) break;
            for(int i = rs; i<=re ; i++)
                li.add(mat[i][ce]);
            ce--;
            if(rs>re || cs>ce) break;
            for(int i = ce; i>=cs ; i--)
            li.add(mat[re][i]);
            re--;
            if(rs>re || cs>ce) break;
            for(int i =re ; i>=rs; i--)
            li.add(mat[i][cs]);
            cs++;
        }
        return li;
       
    }
}