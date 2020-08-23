#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    queue<pair<int, int> > q;
    
    int btotal = bridge_length;
    int bweight = weight;
    int turn = 0;
    int time = 0;
    
    while(1){
        
        if(turn == truck_weights.size() && q.size()==0)
            break;
        if(q.size() > 0){
            if(time - q.front().first == btotal){
                pair<int, int> tmp_p;
                tmp_p = q.front();
                q.pop();
                cout<<time<<" "<<tmp_p.second<<endl;
                bweight += tmp_p.second;
            }
        }
        
        if(turn < truck_weights.size()){
            if(q.size() < btotal){
                if(bweight >= truck_weights[turn]){
                    pair <int, int> tmp_p;
                    tmp_p = make_pair(time, truck_weights[turn]);
                    q.push(tmp_p);
                    bweight -= truck_weights[turn];
                    turn++;
                }
            }
        }
        
        
        time++;
    }
    answer = time;
    return answer;
}