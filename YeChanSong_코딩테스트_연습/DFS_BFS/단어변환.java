import java.util.*;
import java.io.*;
class Solution {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] dist;
    public int solution(String begin, String target, String[] word) {
        int answer = 0, start=-1, end=-1, cnt=0;
        adj = new ArrayList<>();
        dist = new int[word.length+1];
        String[] words = new String[word.length+1];
        for(int i=0;i<word.length;i++){
            words[i] = word[i];
            if(word[i].equals(target))
                end=i;
        }
        if(end==-1)
            return 0;
        words[word.length] = begin;
        start = word.length;
        words[word.length] = begin;
        Arrays.fill(dist,-1);
        for(int i=0;i<words.length;i++){
            
            adj.add(new ArrayList<>());
            for(int j=0;j<words.length;j++){
                cnt=0;
                for(int k=0;k<words[i].length();k++){
                    if(words[i].charAt(k)!=words[j].charAt(k))
                        cnt++;
                }
                if(cnt==1)
                    adj.get(i).add(j);
            }
        }
        answer = bfs(start, end);
        return answer;
    }
    public int bfs(int start, int end){
        Queue<Integer> q= new LinkedList<>();
        dist[start] = 0;
        q.offer(start);
        int itm=0;
        while(!q.isEmpty()){
            itm=q.poll();
            if(itm==end)
                break;
            
            for(int i=0;i<adj.get(itm).size();i++){
                if(dist[adj.get(itm).get(i)]!=-1)
                    continue;
                q.offer(adj.get(itm).get(i));
                dist[adj.get(itm).get(i)] = dist[itm]+1;
            }
        }
        if(dist[end]==-1)
            return 0;
        return dist[end];
    }
}