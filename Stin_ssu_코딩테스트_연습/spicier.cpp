#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = -1;
    priority_queue <int, vector<int>, greater<int> > pq;
    
    for(int i=0; i<scoville.size(); i++){
        pq.push(scoville[i]);
    }
    int cnt = 0;
    
    while(!pq.empty()){
        if(pq.size() == 1){
            if(pq.top() >= K)
                answer = cnt;
            break;
        }
        if(pq.top() >= K){
            answer = cnt;
            break;
        }
        else{
            int first = pq.top();
            pq.pop();
            int second = pq.top();
            pq.pop();
            int newin = first + second*2;
            pq.push(newin);
        }
        cnt++;
    }
 
    return answer;
}