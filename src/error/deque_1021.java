package error;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class deque_1021 {

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
		s = br.readLine();
		StringTokenizer st2 = new StringTokenizer(s," ");
		int count =0;
		for(int i=0;i<M;i++){
			int find = Integer.parseInt(st2.nextToken());
			if(i==0){
				if(find-1<10-find){
					while(find-1>0){
						dq.addLast(dq.pollFirst());
						find --;
						count++;
					}
				}else{
					while(10-find>0){
						dq.addFirst(dq.pollLast());
						find ++;
						count++;
					}
				}
				dq.poll();
			}else{
				if(find-1<dq.size()-find){
					while(find-1>0){
						dq.addLast(dq.pollFirst());
						find --;
						count++;
					}
				}else{
					while(dq.size()-find>0){
						dq.addFirst(dq.pollLast());
						find ++;
						count++;
					}
				}
			}
		}
	}

}
