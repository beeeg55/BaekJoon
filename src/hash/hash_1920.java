package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class hash_1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		HashMap<String,Integer> map = new HashMap<String,Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		for(int i=0;i<n;i++){
			map.put(st.nextToken(),1);
		}
		int m = Integer.parseInt(br.readLine());
		s = br.readLine();
		st = new StringTokenizer(s," ");
		for(int i=0;i<m;i++){
			if(map.containsKey(st.nextToken())==true){
                System.out.println(1);
            }else{
            	System.out.println(0);
            }
		}
	}

}
