package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class deque_10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque<Integer>();
		int p = 0;
		for(int i=0;i<num;i++){
			String s = br.readLine();
			StringTokenizer w = new StringTokenizer(s," ");
			switch(w.nextToken()){
				case "push_front":
					q.addFirst(Integer.parseInt(w.nextToken()));
					break;
				case "push_back":
					q.addLast(Integer.parseInt(w.nextToken()));
					break;
				case "pop_front":
					p = q.isEmpty()? -1: q.pollFirst();
					bw.write(String.valueOf(p));
					bw.newLine();
					bw.flush();
					break;
				case "pop_back":
					p = q.isEmpty()? -1: q.pollLast();
					bw.write(String.valueOf(p));
					bw.newLine();
					bw.flush();
					break;
				case "front":
					p = q.isEmpty()? -1: q.peekFirst();
					bw.write(String.valueOf(p));
					bw.newLine();
					bw.flush();
					break;
				case "back":
					p = q.isEmpty()? -1: q.peekLast();
					bw.write(String.valueOf(p));
					bw.newLine();
					bw.flush();
					break;
				case "empty":
					p = q.isEmpty()? 1: 0;
					bw.write(String.valueOf(p));
					bw.newLine();
					bw.flush();
					break;
				case "size":
					p = q.size();
					bw.write(String.valueOf(p));
					bw.newLine();
					bw.flush();
					break;
			}	
		}
		br.close();
		bw.close();
	}
}
