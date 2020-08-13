package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_2458 {

	private static boolean[] visit;
	private static ArrayList<Integer>[][] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 학생들의 수 
		int M = Integer.parseInt(st.nextToken()); // 비교횟수 
		
		list = new ArrayList[N+1][2]; //list[N][0] : N보다 작은 학생 , list[N][0] : N보다 큰 학생 
		visit = new boolean[N+1];
		
		// 초기화 
		for (int i = 1; i < N+1; i++) {
			list[i][0] = new ArrayList<Integer>();
			list[i][1] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 list[a][1].add(b); // a보다 큰 사람 리스트에 b 추가 
			 list[b][0].add(a); // b보다 작은 사람 리스트에 a 추가  
		}
		int answer = 0;
		for (int student = 1; student <= N; student++) {
			Arrays.fill(visit, false);
			if(search(student,0)+search(student,1)==N-1) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	// option이 0일땐 나보다 작은사람, 1일땐 나보다 큰사람 카운트 
	public static int search(int i, int option) {
		int cnt = 0;
		Queue<Integer> qu = new LinkedList<>();
		qu.add(i);
		visit[i] = true;
		while(!qu.isEmpty()) {
			int temp = qu.poll();
			Iterator<Integer> iter = list[temp][option].iterator();
			while(iter.hasNext()) {
				int element = iter.next();
				if(!visit[element]) {
					visit[element] = true;
					qu.add(element);
					cnt++;
				}
			}
		}
		return cnt;
	}

}
