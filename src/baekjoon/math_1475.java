package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class math_1475 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		int count = 1;
		int count69= 0;
		
		for(int i=0;i<s.length();i++){
			count69 = 0;
			ListIterator<Integer> iter = list.listIterator();
			int temp = Character.getNumericValue(s.charAt(i));
			boolean find = false;
			while (iter.hasNext()) { //리스트에 temp와 같은 요소가 있는지 확인
			    if(temp==6||temp==9){
			    	int num = iter.next();
			    	if(num==6||num==9){
				    	count69++;
				    	find = true;
				    }
			    }
			    else{
			    	int num = iter.next();
			    	if(num==temp){
			    		count++;
			    		find = true;
			    		break;
			    	}
		    	}	
			}
			if(find==false){
				list.add(temp);
			}
			if(count69%2==0&&count69!=0){
				count++;
			}
			if(count69>0){
				list.add(temp);
			}
		}
		System.out.println(count);
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int arr[] = new int[10];
		Arrays.fill(arr, 0);
		for(int i=0;i<s.length();i++){
			int temp = Character.getNumericValue(s.charAt(i));
			arr[temp] += 1;
		}
		
		int count69 = (arr[6]+arr[9]+1)/2;
		arr[6]=0;
		arr[9]=0;
		Arrays.sort(arr);
		int countOther = arr[9];
		if(count69<=countOther){
			System.out.println(countOther);
		}
		else{
			System.out.println(count69);
		}
		
	}

}
