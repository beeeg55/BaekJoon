package kakao;

import java.util.LinkedList;

public class 캐시 {
	public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize>cities.length||cacheSize==0){
            return cities.length*5;
        }
        LinkedList<String> cache = new LinkedList<>();
        int i = 0;
        for (i = 0; i < cities.length; i++) {
        	String city = cities[i].toUpperCase();
			if(!cache.contains(city)) {
				cache.add(city);
				answer += 5;
				if(cache.size()== cacheSize) break;
			}else {
				cache.remove(city);
				cache.add(city);
				answer++;
			}
		}
        for (int j = i+1; j < cities.length; j++) {
        	String city = cities[j].toUpperCase();
        	if(!cache.contains(city)) {
        		cache.remove(0);
				cache.add(city);
				answer += 5;
			}else {
				cache.remove(city);
				cache.add(city);
				answer++;
			}
		}
        
        return answer;
    }
}
