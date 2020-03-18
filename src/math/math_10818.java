package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class math_10818 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		int num[] = new int[n];
		for(int i = 0;i<n;i++){
				num[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		System.out.println(num[0]+" "+num[n-1]);
	}

}
