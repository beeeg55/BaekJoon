package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class combination_6603 {

	private static int[] input;
	private static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			int k = Integer.parseInt(st.nextToken());
			if(k==0) {
				break;
			}
			input = new int[k];
			result = new int[6];
			for (int i = 0; i < input.length; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			combination(0,0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void combination(int start, int cnt) {
		if(cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < input.length; i++) {
			result[cnt] = input[i];
			combination(i+1, cnt+1);
		}
	}

}
