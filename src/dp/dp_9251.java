package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_9251 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int s1Size = s1.length();
		int s2Size = s2.length();
		int max = 0;
		
		int[][] lcs = new int[s1Size+1][s2Size+1];
		
		for (int i = 1; i < s1Size + 1; i++) {  
			for (int j = 1; j < s2Size + 1; j++) { 
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1]+1;
				}else {
					lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
				}
				
			}
		}
		System.out.println(lcs[s1Size][s2Size]);
	}

}
