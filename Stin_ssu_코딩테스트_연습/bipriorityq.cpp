#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

bool desc(int a, int b){
    return a > b;
}

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    vector<int> v;
    priority_queue <int, vector<int>, less<int> > max_pq;
    priority_queue <int, vector<int>, greater<int> > min_pq;
    
    for(int i=0; i<operations.size(); i++){
        if(operations[i][0] == 'I'){
            string tmp = "";
            for(int j=2; j<operations[i].size(); j++){
                tmp += operations[i][j];
            }
            v.push_back(stoi(tmp));
        }
        else if(operations[i][0] == 'D' && operations[i][2] == '-'){
            if(v.size() > 0)
                sort(v.begin(), v.end());
            vector<int> v_tmp;
            //cout<<"D - size: "<<v.size()<<endl;
            if(v.size() == 1 && i == operations.size()-1){
                v_tmp.push_back(0);
            }
            for(int j=1; j<v.size(); j++){
                v_tmp.push_back(v[j]);
            }
            v=v_tmp;
            
        }
        else if(operations[i][0] == 'D'&& operations[i][2] != '-'){
            if(v.size()>0)
                sort(v.begin(), v.end(),desc);
            vector<int> v_tmp;
            //cout<<"D size: "<<v.size()<<endl;
            if(v.size() == 1 && i == operations.size()-1){
                v_tmp.push_back(0);
            }
            for(int j=1; j<v.size(); j++){
                v_tmp.push_back(v[j]);
            }
            v=v_tmp;
        }
    }
    
    if(v.size() == 0){
        v.push_back(0);
    }
    
    sort(v.begin(), v.end());
    answer.push_back(v[v.size()-1]);
    answer.push_back(v[0]);
    
    
    return answer;
}