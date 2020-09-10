package backjoon.segmenttree.p2042;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 2042번 - 구간 합 구하기
https://www.acmicpc.net/problem/2042
 */
public class Main {
	static int n,m,k;
	static long[] numbers, segmentTree;
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		numbers = new long[n+1];
		segmentTree = new long[4*n];
		for (int i = 1; i <= n; i++) {
			numbers[i] = Long.parseLong(br.readLine());
		}

		initSegmentTree(1, n, 1);
//		System.out.println(Arrays.toString(segmentTree));
		for (int i = 0; i < k+m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1) {
				update(b,c,1,1,n);
				continue;
			}
			if(a == 2) {
				System.out.println(querySum(b,(int)c,1,1,n));
				continue;
			}
		}
	}


	/*
	left : numbers 배열 범위의 왼쪽
	right : numbers 배열 범위의 오른쪽
	node : segmentTree 배열 상의 노드(인덱스)

	numbers 배열의 구간 합을 segmentTree에 저장.
	*/
	private static long initSegmentTree(int left, int right, int node) {
		if(left == right) return segmentTree[node] = numbers[left];

		int mid = (left + right)/2;
		long leftSum = initSegmentTree(left, mid, 2*node);
		long rightSum = initSegmentTree(mid+1, right, 2*node+1);

		return segmentTree[node] = leftSum + rightSum;
	}

	/*
	targetLeft : 부분합을 찾기 위한 원본 배열 범위의 왼쪽 경계
	targetLeft : 부분합을 찾기 위한 원본 배열 범위의 오른쪽 경계
	node : 구간트리 배열의 노드(인덱스)
	nodeLeft : 노드에 해당하는 원본 배열 범위의 왼쪽 경계
	nodeRight : 노드에 해당하는 원본 배열 범위의 오른쪽 경계
	 */
	private static long querySum(int targetLeft, int targetRight,
	                            int node, int nodeLeft, int nodeRight) {
		//두 구간이 겹치지 않으면 무시한다.
		if(targetRight < nodeLeft || targetLeft > nodeRight) return 0;
		//node가 표현하는 범위가 target의 범위에 완전히 포함되는 경우
		if(targetLeft <= nodeLeft  && nodeRight <= targetRight) return segmentTree[node];

		//겹치지만 완전히 포함하지 않는 경우
		int mid = (nodeLeft+nodeRight)/2;
		long leftSum = querySum(targetLeft, targetRight, 2*node, nodeLeft, mid);
		long rightSum = querySum(targetLeft, targetRight, 2*node+1, mid+1, nodeRight);

		return leftSum + rightSum;
	}
	/*
	index : 수정하려고 하는 원본 배열 요소의 인덱스
	newVal : 새로운 값
	node : 구간 트리의 노드 인덱스
	nodeLeft : 구간 트리 노드에 해당하는 원본 배열 범위의 왼쪽 경계
	nodeLeft : 구간 트리 노드에 해당하는 원본 배열 범위의 오른쪽 경계
	
	 */
	private static long update(int index, long newVal,
	                          int node, int nodeLeft, int nodeRight) {
		if(index < nodeLeft || index > nodeRight) return segmentTree[node];

		if(nodeLeft == nodeRight) return segmentTree[node] = newVal;
		int mid = (nodeLeft+nodeRight)/2;
		long leftSum = update(index, newVal, 2*node, nodeLeft, mid);
		long rightSum = update(index, newVal, 2*node+1, mid+1, nodeRight);
		return segmentTree[node] = leftSum + rightSum;
	}
}

