#include <string>
#include <vector>
#include <iostream>
#include <math.h>
#include <utility>
#include <algorithm>

using namespace std;

string solution(vector<int> numbers) {
    string answer = "";
    vector<pair<int,vector<int> > > v;
   
    for(int i=0; i< numbers.size(); i++){
        vector<int> tmp;
        pair<int, vector<int> > p; // first = 총자리수 second = 한자리수 
        int num = numbers[i];
        int cnt = 0;
        while(num!=0){
            int num_temp = num%10;
            tmp.push_back(num_temp);
            num = num/10;
            cnt++;
        }
        reverse(tmp.begin(), tmp.end());
        
        for(int j=0; j<4-cnt; j++){
            tmp.push_back(tmp[tmp.size()-1]);
        }
        
        p = make_pair(cnt, tmp);
        v.push_back(p);
    }
    /*for(int i=0; i<v.size(); i++){
        for(int j=0; j<v[i].second.size(); j++){
            cout<<v[i].second[j];
            //answer+=to_string(v[i].second[j]);
        }
        cout<<endl;
    }
    cout<<endl;*/
    
    for(int i=0; i<v.size(); i++){
        for(int j=i+1; j<v.size(); j++){
            if(v[i].second[0] < v[j].second[0]){
                swap(v[i], v[j]);
            }
            else if(v[i].second[0] == v[j].second[0]){
                for(int k =1; k<4 ; k++){
                    if(v[i].second[k] < v[j].second[k]){
                        swap(v[i],v[j]);
                        break;
                    }
                }
            }
        }
    }
    for(int i=0; i<v.size(); i++){
        for(int j=0; j<v[i].first; j++){
            //cout<<v[i].second[j];
            answer+=to_string(v[i].second[j]);
        }
        cout<<endl;
    }
    
    
    return answer;
}

int main(){
    vector<int> v1;
    int arr[5] = {3324, 3332, 3346, 335, 336};

    for(int i =0; i<5; i++){
        v1.push_back(arr[i]);
    }

    cout<<solution(v1)<<endl;

}