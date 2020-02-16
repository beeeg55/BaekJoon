package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_1085 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
	
		int minX=0;
		int minY=0;
		if(x<w-x){
			minX=x;
		}
		else{
			minX=w-x;
		}
		if(y<h-y){
			minY=y;
		}
		else{
			minY=h-y;
		}
		if(minX<minY){
			System.out.println(minX);
		}
		else{
			System.out.println(minY);
		}
	}

}
