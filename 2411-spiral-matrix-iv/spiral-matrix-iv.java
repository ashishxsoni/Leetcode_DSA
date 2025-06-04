/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int r=0;
        int c=0;
        int rowS=0;
        int colS=0;
        int rowE=m-1;
        int colE=n-1;

        int[][] arr=new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
                arr[i][j]=-1;
        }

        while(head != null){

			for(;c<=colE && head!=null;c++) {
        	  arr[r][c]=head.val;
			 head=head.next;
        	}
        	c=colE;
        	rowS++;
        	r=rowS;
        	
        	for(;r<=rowE && head!=null;r++) {
        	 
	          arr[r][c]=head.val;
			 head=head.next;

        	}
        	
        	r=rowE;
        	colE--;
        	c=colE;
        	
        	for(;c>=colS  && head!=null;c--) {
        	   arr[r][c]=head.val;
			 head=head.next;

        	}
        	c=colS;
        	rowE--;
        	r=rowE;
        	
        	for(;r>=rowS && head!=null;r--) {
          arr[r][c]=head.val;
			 head=head.next;
        	}
        	 r=rowS;
        	 colS++;
        	 c=colS;
				}

        return arr;
    }
}