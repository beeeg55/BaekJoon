package string;

import java.io.*;
import java.util.*;

public class string_9935_2 {
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] org = br.readLine().toCharArray(); // 문자열 
        char[] bomb = br.readLine().toCharArray(); // 폭발 문자열 
        char[] result = new char[org.length]; // 결과 문자열 
        int index = 0;
        for (int i = 0; i < org.length; i++) {
            result[index++] = org[i];
            if (index < bomb.length) continue; // bomb.length까지는 확인 필요 ㄴㄴ 
            if (org[i] == bomb[bomb.length - 1]) { 
                boolean flag = true;
                for (int j = 0; j <= bomb.length - 1; j++) {  // 끝글자가일치할때만 확인
                    if (result[index - bomb.length + j] != bomb[j]) { 
                    	flag = false;
                    	break;
                    }
                }
                if (flag) { 
                    index = index - bomb.length; // 인덱스 폭팔 문자열만큼 줄여주기 
                }
            }
        }
        if (index == 0) System.out.println("FRULA");
        else {
            for (int i = 0; i < index; i++) {
                sb.append(result[i]);
            }
            System.out.println(sb);
        }
    }
}