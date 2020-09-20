package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class implement_2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> li = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			li.add(Integer.parseInt(st.nextToken()),i);
		}
		for (int i = li.size()-1; i >= 0 ; i--) {
			System.out.print(li.get(i)+" ");
		}
	}

}
