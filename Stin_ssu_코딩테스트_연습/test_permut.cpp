#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> result;
vector<int> temp;
vector<int> s;
bool *check;
int num[9] =  {1,2,3,4,5,6,7,8,9};

void combination(int index, int max){
    if(index == max){
    	for(int i=0; i<3; i++){
    		result.push_back(temp[i]);
    	}
        
        return;
    }
    else{
        for(int i=0; i<9; i++){
            if(check[i] != true){
                check[i] = true;
                temp.push_back(num[i]);
                combination(index+1, max);
                temp.pop_back();
                check[i] = false;
            }
        }
    }
}

int main(){
	check = new bool[9];
	
	int a = 899;
	cout<<a/100<<endl;
	
	// for(int i=0; i<result.size(); i++){
	// 	cout<<result[i]<<" ";
	// }
}