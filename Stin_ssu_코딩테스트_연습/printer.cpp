#include <string>
#include <vector>
#include <iostream>
#include <queue> 
#include <utility>
#include <algorithm>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    vector<pair< int, int> > p_v;
    queue <pair<int, int> > wait;
    priority_queue <int, vector<int>, less<int> > pp;
    
    for(int i=0; i<priorities.size(); i++){
        pair<int, int> tmp;
        tmp = make_pair(priorities[i],i);
        wait.push(tmp);
        pp.push(priorities[i]);
    }
    
    int cnt = 0;
    while(!wait.empty()){
        pair<int, int> tmp;
        tmp = wait.front();
        wait.pop();
        
        if(tmp.first==pp.top()){
            pp.pop();
            cnt++;
            if(tmp.second==location){
                answer = cnt;
                break;
            }
        }
        else{
            wait.push(tmp);
        }
        
    }
    
    return answer;
}