import java.util.*;

class Solution {
    static HashMap<String, LinkedList<String>> adj = new HashMap<>();
    static ArrayList<String> hist = new ArrayList<>();
    public String[] solution(String[][] init) {
        String[] answer;
        Arrays.sort(init, (String[] a, String[] b)->{
            if(a[0].equals(b[0]))
                return a[1].compareTo(b[1]);
            else
                return a[0].compareTo(b[0]);
        });
        for(String[] str: init){
            if(adj.get(str[0]) == null)
                adj.put(str[0], new LinkedList<>());
            if(adj.get(str[1]) == null)
                adj.put(str[1], new LinkedList<>());
            adj.get(str[0]).add(str[1]);
        }
        dfs("ICN");
        answer = new String[hist.size()];
        for(int i=0;i<hist.size();i++)
            answer[i] = hist.get(hist.size()-1-i);
        return answer;
    }
    public void dfs(String start){
        
        String tmp;
        while(!adj.get(start).isEmpty()){
            tmp = adj.get(start).poll();
            dfs(tmp);
        }
        hist.add(start);
    }
}