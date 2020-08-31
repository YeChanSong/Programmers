#include <string>
#include <vector>
#include <unordered_set>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    vector<int> v;
    v.push_back(triangle[0][0]);
    
    for(int i=0; i<triangle.size()-1; i++){
        vector<int> tmp(triangle[i+1].size(),0);
        for(int j=0; j<v.size(); j++){
            if(tmp[j] < v[j]+triangle[i+1][j]){
                tmp[j] = v[j]+triangle[i+1][j];
            }
            
            if(tmp[j+1] < v[j]+triangle[i+1][j+1])
                tmp[j+1] = v[j]+triangle[i+1][j+1];
            
        }
        v = tmp;
    }
    
    
    sort(v.begin(), v.end());
    answer = v[v.size()-1];
    
    return answer;
}