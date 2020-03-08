package etc;

import java.util.Scanner;

public class star_2442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		for(int i=0;i<n;i++){
			for(int j=0;j<4-i;j++){
				System.out.print(" ");
			}
			for(int j=0;j<2*i+1;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

