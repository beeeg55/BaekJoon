package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class permutation_15649 {

	private static int N,M;
	private static int[] result;
	private static boolean[] visit;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		visit = new boolean[N+1];
		permutation(0);
		System.out.println(sb.toString());
		
	}

	private static void permutation(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i < N+1; i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[cnt] = i;
				
				permutation(cnt+1);
				visit[i] = false;
			}
		}
	}

}
