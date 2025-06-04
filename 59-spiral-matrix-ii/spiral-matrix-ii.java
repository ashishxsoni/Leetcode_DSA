class Solution {
    public int[][] generateMatrix(int n) {
        int r=0;
        int c=0;
        int rowS=0;
        int colS=0;
        int rowE=n-1;
        int colE=rowE;
        int i=1;

				 int[][] arr=new int[n][n];

        while(i<=n*n){
         
        	for(;c<=colE && i<=n*n;c++) {
        		arr[r][c]=i++;
        	}
        	c=colE;
        	rowS++;
        	r=rowS;
         if(i>n*n) break;
        	for(;r<=rowE;r++) {
        		arr[r][c]=i++;
        	}
        	
        	r=rowE;
        	colE--;
        	c=colE;
  
        	for(;c>=colS;c--) {
        	arr[r][c]=i++;
        	}
        	c=colS;
        	rowE--;
        	r=rowE;
        	

        	
        	for(;r>=rowS;r--) {
        		arr[r][c]=i++;
        	}
        	 r=rowS;
        	 colS++;
        	 c=colS;
        
        } 
				return arr;
    }
}