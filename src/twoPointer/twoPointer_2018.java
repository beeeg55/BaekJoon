package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class twoPointer_2018 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		
		int count = 0;
		int start = 1;
		int end = 1;
		int sum = 0;
		while (start <= M) {
			while (M > sum&&end<=M) {
				sum += end;
				end++;
			}
			if(sum == M) {
				count++;
			}
			start += 1;
			end = start;
			sum = 0;
			
		}
		System.out.println(count);
	}

}
