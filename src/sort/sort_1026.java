package sort;

import java.util.Arrays;
import java.util.Scanner;

public class sort_1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		int A[] = new int[num];
		int B[] = new int[num];
		for(int i=0;i<num;i++){
			A[i]= in.nextInt();
		}
		Arrays.sort(A);
		
		for(int i=0;i<num;i++){
			B[i]= in.nextInt();
		}
		Arrays.sort(B);
		
		int sum =0;
		for(int i=0;i<num;i++){
			sum += A[i]*B[num-i-1];
		}
		System.out.println(sum);
	}

}
