package implement;

import java.util.Scanner;

public class implement_2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int H = in.nextInt();
		int M = in.nextInt();
		
		M=M-45;
		if(M>0){
			System.out.println(H+" "+M);
		}
		else{
			if(H!=0)
				System.out.println(H-1+" "+ (M+60));
			else
				System.out.println("23 "+ (M+60));
		}
	}

}
