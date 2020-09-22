#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
#include <queue>

using namespace std;
unordered_map<string, vector<string> > um;
unordered_map<string, int> r_cnt;
unordered_map<string, bool> check;

int bfs(string begin, string target){
    queue<string> q;
    q.push(begin);
    check[begin] = true;
    
    while(!q.empty()){
        string top = q.front();
        q.pop();
        if(top == target){
            return r_cnt[target];         
        }
        
        for(int i=0; i<um[top].size(); i++){
            string next = um[top][i];
            if(check[next]==false){
                q.push(next);
                r_cnt[next] = r_cnt[top] + 1;
                check[next] = true;
            }
        }
    }
    
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    int w_cnt = 0;
    
    for(int i=0; i<words.size(); i++){
        if(words[i] != target)
            w_cnt++;
    }    
    if(w_cnt == words.size())
        return answer;
    
    for(int i=0; i<words.size()+1; i++){
        vector<string> tmp;
        if(i==words.size()){
            um[begin] = tmp;
            r_cnt[begin] = 0;
            check[begin] = false;
        }
        else{
            um[words[i]] = tmp;
            r_cnt[words[i]] = 0;
            check[words[i]] = false;
        }
    }
    
    for(int i=0; i<words.size(); i++){
        int d_cnt = 0;
        for(int j=0; j<words[i].size(); j++){
            if(begin[j] != words[i][j])
                d_cnt++;
        }
        if(d_cnt == 1){
            um[begin].push_back(words[i]);
        }
    }
    
    for(int i=0; i<words.size(); i++){
        for(int j=0; j<words.size(); j++){
            int d_cnt = 0;
            for(int k=0; k<words[i].size(); k++){
                if(words[i][k] != words[j][k])
                    d_cnt++;
            }
            if(d_cnt==1)
                um[words[i]].push_back(words[j]);
        }
    }
    
    
    answer = bfs(begin, target);
    
    return answer;
}