package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
public class String_2800 {
	static int L;
	private static int[][] store;
	static int[] select;
	private static String s;
	static LinkedList<String> li = new LinkedList<>();
	private static int index;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		index = 0;
		store = new int[10][2];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(') {
				st.push(i);
			}else if(s.charAt(i)==')'){
				store[index][0] = st.pop();
				store[index][1] = i;
				index++;
			}
		}
		/*
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(') {
				store[index][0] = i;
				index++;
				count++;
			}else if(s.charAt(i)==')'){
				index--;
				store[index][1] = i;
				index++;
			}
		}*/
		for (int i = 1; i < index+1; i++) {
			L = 2*i;
			select = new int[L];
			combination(0,0);
		}
		Collections.sort(li);
		Iterator<String> iter = li.iterator();
		while (iter.hasNext()) {
		    System.out.print(iter.next() + "\n");
		}
		
	}
	private static void combination(int cnt, int start) { 
		if(cnt==L) {
			String answer = "";
			int searchIndex = 0;
			Arrays.sort(select);
			for (int i = 0; i < s.length(); i++) {
				if(searchIndex<=L-1&&i==select[searchIndex]) {
					searchIndex++;
				}else {
					answer += s.charAt(i);
				}
			}
			if(!li.contains(answer)) {
				li.add(answer);
			}
			return;
		}
		
		for (int i = start; i < index; i++) {
			select[cnt] = store[i][0];
			select[cnt+1] = store[i][1];
			combination(cnt+2,i+1);
		}
		
	}

}
