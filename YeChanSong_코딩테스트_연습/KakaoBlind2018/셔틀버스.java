import java.util.*;

class Solution {
	static ArrayList<Integer> parsedtable = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> busSeats = new ArrayList<>();
	static ArrayList<Integer> busTimes = new ArrayList<>();
	
	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		for(int i=0;i<n;i++)
			busSeats.add(new ArrayList<>());
		int time = 540;
		for(int i=0;i<n;i++){
			busTimes.add(time);
			time+=t;
		}
		int[] tmp;
		for(String s: timetable){
			tmp = Arrays.stream(s.split(":")).mapToInt(Integer::parseInt).toArray();
			parsedtable.add(tmp[0]*60+tmp[1]);
		}
		Collections.sort(parsedtable);
		int idx=0;
		for(int i=0;i<n;i++){
			for(;idx<parsedtable.size();idx++){
				if(parsedtable.get(idx) <= busTimes.get(i) && busSeats.get(i).size()<m){
					busSeats.get(i).add(parsedtable.get(idx));
				}else{
					break;
				}
			}
			
		}
		ArrayList<Integer> lastBus = busSeats.get(busSeats.size()-1);
		int ans=0, comp=0;
		boolean flag = false;
		
		if(lastBus.size() < m){
			ans = busTimes.get(n-1);
		}else{
			ans = lastBus.get(lastBus.size()-1)-1;
		}
		answer = convTime(ans);
		return answer;
	}
	public String convTime(int min){
		StringBuilder sb = new StringBuilder();
		if((min/60)<10){
			sb.append(0).append(min/60);
		}else{
			sb.append(min/60);
		}
		sb.append(':');
		if((min%60)<10){
			sb.append(0).append(min%60);
		}else{
			sb.append(min%60);
		}
		return sb.toString();
	}
}