#include <string>
#include <vector>
#include <iostream> 

using namespace std;

void print(vector< vector <int> > v){
    for(int i=0; i<v.size(); i++){
        for(int j=0; j<v[i].size(); j++){
            cout<<v[i][j]<<" ";
        }
        cout<<endl;
    }
}

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    vector< vector<int> > v;
    
    for(int i=0; i<n; i++){
        vector<int> tmp(m,-1);
        v.push_back(tmp);
    }
    
    for(int i=0 ; i<n; i++){
        if(i==0){
            for(int j=0; j<m; j++){
                v[i][j] = 1;
            }
        }
        else{
            for(int j=0; j<m; j++){
                if(j == 0){
                    v[i][j]=1;
                }
            }
        }
    }
    for(int i=0; i<puddles.size(); i++){
        if(puddles[i][0]-1 == 0){
            for(int j = puddles[i][1]-1; j<n; j++){
                v[j][0] = 0;
            }
        }
        else if(puddles[i][1]-1 == 0){
            for(int j=puddles[i][0]-1; j<m; j++){
                v[0][j] = 0;
            }
        }
        else{
            v[puddles[i][1]-1][puddles[i][0]-1] = 0;
        }
    }
    
    for(int i=1; i<n; i++){
        for(int j= 1; j<m; j++){
            if(v[i][j] == -1){
                v[i][j] = (v[i-1][j] + v[i][j-1]) % 1000000007; // 이렇게 해야 size overflow 가 생기지 않음
            }
        }
    }
    //print(v);
    answer = v[n-1][m-1];
    return answer;
}