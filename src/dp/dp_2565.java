package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class dp_2565 {
	static int n;
	
	static int dp[], arr[][];
	
	
	public static void main(String[] args) throws IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		dp = new int[n+1];
		arr = new int[n+1][2]; // A, B 전봇대 배열
		
		StringTokenizer st;
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<2;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0])); 
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) { // LIS를 구하는 과정
			dp[i] =1;
			for(int j=1;j<i;j++) {
				if(arr[i][1]>arr[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int max =Integer.MIN_VALUE; // 최댓값이 설치할 수 있는 전긴줄의 최대 개수
		for(int j=1;j<=n;j++) {
			if(dp[j]>max)
				max = dp[j];
		}
		
		System.out.println(n-max); // 최대 개수만큼 설치하면 동시에 최소 개수를 자르는 것이므로 N-MAX를 수행
		
		
	}
	
}