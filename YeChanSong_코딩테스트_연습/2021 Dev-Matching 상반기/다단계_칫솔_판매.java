import java.util.*;

class Solution {
    static HashMap<String, Integer> profit = new HashMap<>();
    static HashMap<String, String> ref = new HashMap<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        for(String s: enroll)
            profit.put(s, 0);
            
        for(int i=0;i<referral.length;i++)
            ref.put(enroll[i],referral[i]);
        
        for(int i=0;i<seller.length;i++){
            moneyFlow(seller[i], amount[i]*100);
        }
        for(String s: enroll)
            ans.add(profit.get(s));
        answer = ans.stream().mapToInt(a->a).toArray();
        return answer;
    }
    public void moneyFlow(String seller, int money){
        if(money == 0 || seller.equals("-"))
            return;
        int nxt = (int)(money*0.1);
        profit.put(seller, profit.get(seller)+money-nxt);
        moneyFlow(ref.get(seller),nxt);
    }
}