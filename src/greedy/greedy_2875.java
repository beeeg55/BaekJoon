package greedy;

import java.util.Scanner;

public class greedy_2875 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		int team = 0;
		int rest=0;
		
		if(n/2>m){
			team = m;
			rest = n-2*m;
		}
		else{
			team = n/2;
			rest = m-n/2+n%2;
		}
		
		while(rest<k){
			team=team-1;
			rest=rest+3;
		}
		System.out.println(team);
	}

}
