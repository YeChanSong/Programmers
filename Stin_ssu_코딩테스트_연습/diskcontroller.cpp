#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <algorithm>
#include <utility>

using namespace std;

int solution(vector<vector<int>> jobs) {
    int answer = 0;
    priority_queue <pair<int,int>, vector<pair<int,int> >, greater<pair<int, int> > >pq;
    
    int done = 0;
    int idx = 0;
    
    for(int i=0; i<jobs.size(); i++){
        pq.push(make_pair(jobs[i][0],jobs[i][1]));
    }
    
    int time = pq.top().first;
    vector<int> result;
    int cnt = 0;
    while(1){
        if(cnt == jobs.size())
            break;
        vector<pair<int, int> > tmp; 
        pair<int, int> p_tmp;
        int sf = pq.top().first;
        int small_s = pq.top().second;
        while(!pq.empty()){
            
            if(pq.top().first <= time){
                //cout<<pq.top().first<<endl;
                if(small_s >= pq.top().second){
                    if(small_s == pq.top().second){
                        if(sf >= pq.top().first){
                            small_s = pq.top().second;
                            sf = pq.top().first;
                            p_tmp = pq.top();
                        }
                    }
                    else{
                        small_s = pq.top().second;
                        sf = pq.top().first;
                        p_tmp = pq.top();
                    }
                }
                tmp.push_back(pq.top());
                pq.pop();
            }
            else{
                break;
            }
        }
        // cout<<"queue size: "<<pq.size()<<endl;
        //cout<<p_tmp.first<<" "<<p_tmp.second<<endl;
        int time_re = time - p_tmp.first + p_tmp.second;
        result.push_back(time_re);
        time += p_tmp.second;
        //cout<<"time : "<<time<<endl;
        cnt++;
        //cout<<"tmp size : "<<tmp.size()<<endl;
        for(int i=0; i<tmp.size(); i++){
            if(tmp[i].first == p_tmp.first && tmp[i].second == p_tmp.second)
                continue;
            else
                pq.push(tmp[i]);
        }
        
        if(pq.top().first > time)
            time = pq.top().first;
        //cout<<"after queue size: "<<pq.size()<<endl;
    }
    
    
    for(int i=0; i<result.size(); i++){
        //cout<<result[i]<<endl;
        answer += result[i];
    }
    answer = answer/jobs.size();
    return answer;
}