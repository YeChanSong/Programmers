import java.util.*;
class Solution {
    public int[] solution(String[] ops) {
        int[] answer;
        String[] tmp;
        int i;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(String str: ops){
            tmp = str.split(" ");
            if(tmp[0].charAt(0) == 'I'){
                i=Integer.parseInt(tmp[1]);
                maxHeap.offer(i);
                minHeap.offer(i);
            }else if(maxHeap.size()!=0){
                
                if(tmp[1].charAt(0) == '1'){
                    minHeap.remove(maxHeap.poll());
                }else{
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        if(maxHeap.size()==0){
            answer = new int[]{0,0};
        }else{
            answer = new int[]{maxHeap.poll(),minHeap.poll()};
        }
        
        return answer;
    }
}