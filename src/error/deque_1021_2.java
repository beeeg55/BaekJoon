package error;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class deque_1021_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer st1 = new StringTokenizer(s," ");
		
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for(int i=1;i<11;i++){
			dq.addFirst(i);
		}
		
	}

}
