package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class combination_15655 {

	private static int N;
	private static int M;
	private static int[] arr;
	private static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		input = new int[M];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		combination(0,0);
	}

	private static void combination(int start, int cnt) {
		if(cnt==M) {
			for (int i = 0; i < input.length; i++) {
				System.out.print(input[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < arr.length; i++) {
			input[cnt] = arr[i];
			combination(i+1,cnt+1);
		}
		
	}

}
