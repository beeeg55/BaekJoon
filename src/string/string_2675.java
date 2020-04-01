package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class string_2675 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			int num = Integer.parseInt(st.nextToken());
			String word = st.nextToken();
			for(int j=0;j<word.length();j++){
				for(int k=0;k<num;k++){
					System.out.print(word.charAt(j));
				}
			}
			System.out.println();
		}
		
	}

}
