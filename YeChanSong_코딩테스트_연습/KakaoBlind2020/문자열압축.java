import java.util.*;

class Solution {
	static StringBuilder before = new StringBuilder();
	static StringBuilder next = new StringBuilder();
    static StringBuilder compStr = new StringBuilder();
	static int ans=0, cnt=1;
	public int solution(String s) {
		int answer = 987654321;
		int lim = s.length();
		boolean flag = false;
		if(lim == 1)
			return 1;
		for(int i=lim/2;i>=1;i--){
			before = new StringBuilder();
            compStr = new StringBuilder();
			cnt=1;
			for(int t=0;t<i;t++)
				before.append(s.charAt(t));
			for(int j=i;j<lim;j++){
				int k=0;
				next = new StringBuilder();
				while(k<i && k+j<lim){
					next.append(s.charAt(k+j));
					k++;
				}
				j+=k-1;
				if(before.compareTo(next)==0){
					flag = true;
					cnt++;
				}else{
					if(flag){
						// ans+=before.length()+String.valueOf(cnt).length();
                        compStr.append(cnt).append(before);
					}else{
						// ans+=before.length();
                        compStr.append(before);
					}
					flag = false;
					before = new StringBuilder(next);
					cnt=1; 
				}
			}
			if(flag){
				// ans+=before.length()+String.valueOf(cnt).length();
                compStr.append(cnt).append(before);
			}else{
				// ans+=before.length();
                compStr.append(before);
			}
            ans = compStr.length();
			answer = Math.min(ans,answer);
			ans=0;
            flag = false;
		}
		return answer;
	}
}