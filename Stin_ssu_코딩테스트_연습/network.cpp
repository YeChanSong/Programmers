#include <unordered_map>
#include <iostream>
#include <string>
#include <vector>
#include <stack>

using namespace std;
unordered_map<int, vector<int> >um;
bool *check;
int node_num;
int cnt = 0;
void dfs(int start){
    stack<int> s;
    s.push(start);
    check[start] = true;
    while(!s.empty()){
        int top = s.top();
        s.pop();
        for(int i=0; i<um[top].size(); i++){
            int next = um[top][i];
            if(check[next] == false){
                s.push(top);
                s.push(next);
                check[next] = true;
                cnt++;
                break;
            }
        }
    }
    
    for(int i=0; i<node_num; i++){
        if(check[i] != true){
            dfs(i);
        }
    }
}
int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    check = new bool[n];
    node_num = n;
    for(int i=0; i<n; i++){
        vector<int> tmp;
        um[i] = tmp;
        check[i] = false;
    }
    
    for(int i=0; i< computers.size(); i++){
        for(int j=0; j<computers[i].size(); j++){
            if(i != j){
                if(computers[i][j] == 1)
                    um[i].push_back(j);
            }
        }
    }
    
    dfs(0);
    answer = n-cnt;
    return answer;
}