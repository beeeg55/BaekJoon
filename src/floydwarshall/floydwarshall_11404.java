package floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class floydwarshall_11404 {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] arr = new int [n+1][n+1];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if(i!=j) {
					arr[i][j] = INF;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(w<arr[from][to]) {
				arr[from][to] = w;
			}
		}
		
		for (int k = 1; k < arr.length; k++) {
			for (int start = 1; start < arr.length; start++) {
				for (int end = 1; end < arr.length; end++) {
					if(arr[start][k]==INF||arr[k][end]==INF) continue;
					arr[start][end] = Math.min(arr[start][end], arr[start][k]+arr[k][end]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if(arr[i][j]>=INF) {
					sb.append(0+" ");
				}else {
					sb.append(arr[i][j]+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
