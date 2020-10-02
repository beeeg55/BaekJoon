package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_10409 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		
		int answer = 0;
		int cur = 0;
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < n; i++) {
			int task = Integer.parseInt(st.nextToken());
			if(cur+task>T) break;
			cur += task;
			answer++;
		}
		System.out.println(answer);
	}

}
