package recursion;

import java.util.Scanner;

public class recursion_10870 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(fib(n));
	}
	public static int fib(int i){
		if(i==0) return 0;
		if(i==1) return 1;
		return fib(i-1)+fib(i-2);
	}
}
