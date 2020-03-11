package implement;

import java.util.Arrays;
import java.util.Scanner;

public class implement_5543 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int burger[] = new int[3];
		int drink[] = new int[2];
		
		for(int i=0;i<3;i++){
			burger[i]=in.nextInt();
		}
		Arrays.sort(burger);
		for(int i=0;i<2;i++){
			drink[i]=in.nextInt();
		}
		Arrays.sort(drink);
		
		System.out.println(burger[0]+drink[0]-50);
	}

}
