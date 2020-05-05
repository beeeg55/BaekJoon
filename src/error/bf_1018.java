package error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bf_1018 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int p1 = 0;
		int p2 = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++){
			s = br.readLine();
			for(int j=0;j<m;j++){
				if((j+i)%2==0){
					if(s.charAt(j)=='W'){
						p1++;
					}else{
						p2++;
					}
				}else{
					if(s.charAt(j)=='B'){
						p1++;
					}else{
						p2++;
					}
				}
			}
			System.out.println(p1);
		}
		System.out.println("----------------");
		System.out.println(p1);
		System.out.println(p2);
		if(p1>p2){
			System.out.println(n*m-p1);
		}else{
			System.out.println(n*m-p2);
		}
	}

}
