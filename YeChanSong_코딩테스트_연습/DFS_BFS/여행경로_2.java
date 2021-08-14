import java.util.*;

class Solution {
    static HashMap<String, ArrayList<String>> adj = new HashMap<>();
    static ArrayList<String> hist = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer;
        Arrays.sort(tickets, (String[] a, String[] b) -> {
            if(a[0].equals(b[0])) return b[1].compareTo(a[1]);
            else return b[0].compareTo(a[0]);
        });
        
        for(String[] ticket: tickets){
                if(adj.get(ticket[0])==null)
                    adj.put(ticket[0],new ArrayList<>());
                if(adj.get(ticket[1])==null)
                    adj.put(ticket[1], new ArrayList<>());
                adj.get(ticket[0]).add(ticket[1]);
        }
        dfs("ICN");
        answer = new String[hist.size()];
        for(int i=0;i<hist.size();i++){
            answer[i] = hist.get(hist.size()-1-i);
        }
        return answer;
    }
    public void dfs(String src){
        String dest;
        while(adj.get(src).size()!=0){
            dest = adj.get(src).remove(adj.get(src).size()-1);
            dfs(dest);
        }
        hist.add(src);
    }
}