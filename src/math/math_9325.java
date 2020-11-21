package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_9325 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			int sum = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int q = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				sum += p*q;
			}
			System.out.println(sum);
		}
	}

}
