import java.util.*;

class Solution {
    static int[] timestamp;
    static int ptime, stime;
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int ptime = timeToSec(play_time);
        int atime = timeToSec(adv_time);
        timestamp = new int[ptime+1];
        int s=0, e = 0; String[] tmp;
        for(String log: logs){
            tmp = log.split("-");
            s = timeToSec(tmp[0]);
            e = timeToSec(tmp[1]);
            for(int i=s;i<e;i++)
                timestamp[i]++;
        }
        int start=0;
        long max=0, slide =0;
        s=0; int end=atime;
        
        for(int i=start;i<end;i++)
            slide+=timestamp[i];
        max = slide;
        
        for(int i=end;i<=ptime;i++){
            slide-=timestamp[start++];
            slide+=timestamp[end++];
            if(slide>max){
                max = slide;
                s= start;
            }
        }
        StringBuilder sb = new StringBuilder();
        int h,m;
        h = s/3600;
        s%=3600;
        m = s/60;
        s%=60;
        if(h<10)
            sb.append(0).append(h);
        else
            sb.append(h);
        sb.append(':');
        if(m<10)
            sb.append(0).append(m);
        else
            sb.append(m);
        sb.append(':');
        if(s<10)
            sb.append(0).append(s);
        else
            sb.append(s);
        
        answer = sb.toString();
        return answer;
    }
    public int timeToSec(String time){
        int[] hms = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return hms[0]*3600+hms[1]*60+hms[2];
    }
}