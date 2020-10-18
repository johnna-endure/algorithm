package codechallenge.p2;

public class Solution {
	static int one=0, zero=0;

	public int[] solution(int[][] arr) {
		solve(0, arr.length-1, 0, arr[0].length-1, arr);
		int[] ret = {zero, one};
		return ret;
	}
	public void solve(int rowLeft, int rowRight, int colLeft, int colRight, int[][] arr) {
		if(rowLeft == rowRight && colLeft == colRight) {
			if(arr[rowLeft][colLeft] == 0) zero++;
			else one++;
			return;
		}
		if(canCompress(rowLeft, rowRight, colLeft, colRight, arr)) {
			if(arr[rowLeft][colLeft] == 0) zero++;
			else one++;
			return;
		}

		int rowMid = (rowLeft + rowRight)/2;
		int colMid = (colLeft + colRight)/2;

		solve(rowLeft, rowMid, colMid+1, colRight, arr);
		solve(rowLeft, rowMid, colLeft, colMid,arr);
		solve(rowMid+1, rowRight, colLeft, colMid,arr);
		solve(rowMid+1, rowRight, colMid+1, colRight, arr);

	}

	private boolean canCompress(int rowLeft, int rowRight, int colLeft, int colRight, int[][] arr) {
		int firstVal = arr[rowLeft][colLeft];
		for (int i = rowLeft; i <= rowRight; i++) {
			for (int j = colLeft; j <= colRight; j++) {
				if(firstVal != arr[i][j]) return false;
			}
		}
		return true;
	}
}
