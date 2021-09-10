import java.util.*;


class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<String> ans = new ArrayList<>();
    static int lim;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        StringBuilder sb;
        ArrayList<String> order = new ArrayList<>();
        char[] tmp;
        for(String str: orders){
            sb = new StringBuilder();
            tmp = str.toCharArray();
            Arrays.sort(tmp);
            sb.append(tmp);
            order.add(sb.toString());
        }
        ArrayList<Map.Entry<String, Integer>> arlist;
        int mxValue=-1;
        String keyValue;
        for(int i: course){
            lim = i;
            for(String str: order){
                recur(-1, 0, str, new StringBuilder());
            }
            sb = new StringBuilder();
            arlist = new ArrayList<>(map.entrySet());
            arlist.sort((a, b)->Integer.compare(b.getValue(), a.getValue()));
            if(arlist.size()>0)
                mxValue = arlist.get(0).getValue();
            for(Map.Entry<String,Integer> entry: arlist){
                if(entry.getValue()<mxValue || entry.getValue()<2)
                    break;
                ans.add(entry.getKey());
            }
            map = new HashMap<>();
        }
        Collections.sort(ans);
        answer = ans.stream().toArray(String[]::new);
        return answer;
    }
    public void recur(int idx, int cnt, String target, StringBuilder sb){
        if(cnt == lim){
            String tmp = sb.toString();
            if(map.get(tmp) != null){
                map.put(tmp, map.get(tmp)+1);
            }else{
                map.put(tmp,1);
            }
            return;
        }
        StringBuilder nxtsb;
        for(int i=idx+1;i<target.length();i++){
            nxtsb = new StringBuilder(sb);
            nxtsb.append(target.charAt(i));
            recur(i,cnt+1,target,nxtsb);
        }
        
    }
}