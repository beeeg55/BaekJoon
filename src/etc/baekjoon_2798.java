package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_2798 {

	private static int[] input;
	private static int result;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		combination(0,0,0);
		System.out.println(result);
		
	}
	public static void combination(int start, int cnt, int sum) {
		if(cnt == 3) {
			if(sum <= M && sum > result) {
				result = sum;
			}
			return;
		}
		for (int i = start; i < input.length; i++) {
			if(sum+input[i] > M) break;
			combination(i + 1, cnt + 1, sum+input[i]);
		}
	}
	
}
