import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] a = {1,2,3,4,5},b = {2,1,2,3,2,4,2,5},c ={3,3,1,1,2,2,4,4,5,5};
        int[] ans = new int[3];
        int idx = 0;
        for(int i: answers){
            if(a[idx%a.length] == i)
                ans[0]++;
            if(b[idx%b.length] == i)
                ans[1]++;
            if(c[idx%c.length] == i)
                ans[2]++;
            idx++;
        }
        int max =-1;
        for(int i: ans)
            if(max<i){
                max=i;
            }
        ArrayList<Integer> ppl= new ArrayList<>();
        for(int i=0;i<3;i++)
            if(max == ans[i])
                ppl.add(i+1);
        
        ppl.sort((Integer x, Integer y)->Integer.compare(x,y));
        answer = ppl.stream().mapToInt(k->k).toArray();
        return answer;
    }
}