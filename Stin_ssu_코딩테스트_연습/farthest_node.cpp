#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
#include <queue>

using namespace std;
bool *check;
unordered_map<int, vector<int> > um;
unordered_map<int, int> count;
void bfs(int start){
    queue<int> q;
    q.push(start);
    check[start] = true;
    
    while(!q.empty()){
        int front = q.front();
        q.pop();
        for(int i=0; i<um[front].size(); i++){
            int next = um[front][i];
            if(check[next]!=true){
                q.push(next);
                check[next] = true;
                count[next] = count[front] + 1;
            }
        }
    }
}
int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    check = new bool[n];
    for(int i=0; i<n; i++){
        vector<int> tmp;
        um[i]=tmp;
        count[i] = 0;
    }
    for(int i=0; i<edge.size(); i++){
        um[edge[i][0]-1].push_back(edge[i][1]-1);
        um[edge[i][1]-1].push_back(edge[i][0]-1);
    }
    bfs(0);
    
    int max = 0;
    for(pair<int, int> it: count){
        if(it.second > max){
            max = it.second;
        }
        //cout<<it.first<<" "<<it.second<<endl;
    }
    
    for(pair<int, int> it: count){
        if(it.second == max){
            answer++;
        }
    }
    cout<<answer<<endl;
    return answer;
}