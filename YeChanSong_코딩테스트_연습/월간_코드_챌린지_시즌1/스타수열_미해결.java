import java.util.*;

class Solution {
    public int solution(int[] a) {
        if(a.length<2)
            return 0;
        int answer = 0, lim = a.length;
        int[] cntr=new int[lim];
        int bef=a[0], cnt=0;
        boolean flag = true;
        ArrayList<Integer> _a = new ArrayList<>();
        for(int i=0;i<lim;i++){
            if(bef == a[i]){
                cnt++;
            }else{
                if(cnt>2)
                    cnt=2;
                for(int j=0;j<cnt;j++)
                    _a.add(bef);
                bef = a[i];
                cnt=1;
            }
        }
        _a.add(bef);
        if(_a.get(0) == _a.get(1))
            _a.remove(0);
        for(int i: _a){ // _a
            cntr[i]++;
        }
        int max=0;
        for(int i=0;i<lim;i++){
            if(max<cntr[i]){
                max=cntr[i];
            }
        }
        ArrayList<Integer> pivot = new ArrayList<>();
        for(int i=0;i<lim;i++){
            if(max==cntr[i]){
                pivot.add(i);
            }
        }
        // lim = _a.size();
        for(int idx: pivot){
            int walker=0, ans=0;
            for(int i=0;i<lim;i++){
                if(a[i] == idx){
                    // 왼쪽에서 짝을 찾지 못하는 경우
                    if(walker == i){
                        while(walker<lim && a[i]==a[walker]){
                            walker++;
                        }
                        if(walker==lim)
                            break;
                        ans+=2;
                        i=walker;
                        walker++;
                    }else{
                        walker = i+1;
                        ans+=2;
                    }
                }
            }
            answer = Math.max(answer,ans);
        }
        return answer;
    }
}