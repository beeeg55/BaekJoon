package baekjoon;

import java.util.Scanner;
//¹Ì¿Ï·á
public class graph_4963 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(true){
			int w = in.nextInt();
			int h = in.nextInt();
			
			if(w==0&&h==0){
				break;
			}
			
			int arr[][] = new int[w][h];
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					arr[w][h]=in.nextInt();
				}
			}
			
			
		}
	}

}
