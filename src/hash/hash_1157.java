package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class hash_1157 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
	
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++){
			char temp = s.charAt(i);
			if(temp>'Z'){
				temp=(char) (temp-32);
			}
			hm.put(temp, hm.getOrDefault(temp, 0) + 1);
		}
		Collection values = hm.values();
		Set set = hm.keySet();
		int count = 0;
		char answer = ' ';
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			  char key = (char)iterator.next();
			  if(hm.get(key).equals(Collections.max(values))){
				  answer= key;
				  count++;
			  }
		}
		if(count==1){
			System.out.println(answer);
		}else{
			System.out.println('?');
		}
		
	}

}
