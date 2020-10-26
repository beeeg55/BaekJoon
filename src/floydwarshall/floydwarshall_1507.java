package floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class floydwarshall_1507 {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int [n][n];
		int[][] result = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					result[i][j] = arr[i][j];
			}
		}
		
		
		boolean flag = false;
		for (int k = 0; k < arr.length; k++) {
			for (int start = 0; start < arr.length; start++) {
				for (int end = 0; end < arr.length; end++) {
					if(start == k) continue;
					if(end == k) continue;
					if(start == end) continue;
					if(arr[start][end] == arr[start][k]+arr[k][end]) {
//						flag = true;
						result[start][end] = 0;
						result[end][start] = 0;
					}
					if(arr[start][end] > arr[start][k]+arr[k][end]) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
//		if(!flag) {
//			System.out.println(-1);
//			System.exit(0);
//		}
		int sum = 0;
		for (int i = 0; i < result.length; i++) {
			for (int j = i+1; j < result.length; j++) {
					sum += result[i][j];
			}
		}
		System.out.println(sum);
		
	}

}
