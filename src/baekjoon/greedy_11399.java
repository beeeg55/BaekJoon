package baekjoon;

import java.util.Scanner;
import java.util.Arrays;

public class greedy_11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int sum = 0;
		int[] P = new int[num];
		
		for(int i=0; i<num; i++){
			P[i] = input.nextInt();
		}
		Arrays.sort(P);
		
		for(int i=0; i<num; i++){
			for(int j=0; j<i+1; j++){
				sum += P[j];
			}
		}
		System.out.println(sum);
	}

}
