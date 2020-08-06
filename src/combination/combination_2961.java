package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class combination_2961 {
	static int[][] input;
	static int[] result;
	static int R;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		input = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			R = i;
			result = new int[R];
			combination(0,0);
		}
		System.out.println(answer);
	}
	private static void combination(int cnt, int start) { // cnt: 현재까지 뽑은 순열의 갯수, start: 조합에 시작점으로 시도할 인덱스 
		if(cnt==R) {
			int S = 1;
			int B = 0;
			for (int i = 0; i < result.length; i++) {
				S *= input[result[i]][0];
				B += input[result[i]][1];
			}
			int temp = Math.abs(S - B);
			if(answer>temp) answer = temp;
			return;
		}
		
		for (int i = start; i < input.length; i++) {
			result[cnt] = i;
			combination(cnt+1,i+1);
		}
		
	}
}
