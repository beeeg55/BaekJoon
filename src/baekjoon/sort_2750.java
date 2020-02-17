package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class sort_2750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		int arr[] = new int[num];
		
		for(int i=0;i<num;i++){
			arr[i]= in.nextInt();
		}
		Arrays.sort(arr);
		for(int i=0;i<num;i++){
			System.out.println(arr[i]);
		}
	}

}
