package Geometric;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class geometric_1002 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			String s = br.readLine();
			StringTokenizer st =new StringTokenizer(s," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
				
			double dis = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
			int c = r1+r2;
			if(x1==x2&&y1==y2){
				if(r1==r2){
					System.out.println(-1);
				}else{
					System.out.println(0);
				}
			}else{
				if(dis<c){
					System.out.println(2);
				}else if(dis==c){
					System.out.println(1);
				}else{
					System.out.println(0);
				}
			}
			
		}
		
	}

}
