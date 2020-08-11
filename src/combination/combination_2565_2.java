package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class combination_2565_2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr= new int[N][3];
		StringTokenizer st;
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if(arr[i][1]>arr[j][1]) {
					arr[i][2]++;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][2]);
		}
		
		
	}

}
