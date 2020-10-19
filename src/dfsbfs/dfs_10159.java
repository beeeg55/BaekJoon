package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_10159 {

	private static int[][] arr;
	private static boolean[] visit;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			arr[a][b] = 1; 
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			visit = new boolean[N];
			cmpBig(i);
			cmpSmall(i);
			for (int j = 0; j < N; j++) {
				if(!visit[j]) {
					cnt++;
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void cmpBig(int start) {
		visit[start]= true;
		for (int i = 0; i < N; i++) {
			if(arr[start][i]>0&&!visit[i]) {
				cmpBig(i);
			}
		}
		
	}
	private static void cmpSmall(int start) {
		visit[start]= true;
		for (int i = 0; i < N; i++) {
			if(arr[i][start]>0&&!visit[i]) {
				cmpSmall(i);
			}
		}
		
	}

}
