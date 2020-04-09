package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class string_1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int num=0;
		
		for(int i=0;i<n;i++){
			LinkedList<Character> li = new LinkedList<>();
			String w =br.readLine();
			Character c = w.charAt(0);
			li.add(w.charAt(0));
			boolean b = true;
			for(int j=0;j<w.length();j++){
				if(c!=w.charAt(j)){
					if(li.contains(w.charAt(j))){
						b=false;
						break;
					}else{
						li.add(w.charAt(j));
						c=w.charAt(j);
					}
				}
			}
			if(b==true) num++;
		}
		System.out.println(num);
	}

}
