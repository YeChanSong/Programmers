#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool compare(int a, int b){
	return a>b;
}

int main(){
	int a[10] = {9,3,5,4,1,10,8,6,7,2};
	vector<int> v;
	for(int i=0; i< 10; i++){
		v.push_back(a[i]);
	}
	sort(v.begin(), v.end(), compare);

	for(int i=0; i<10; i++){
		cout<<v[i]<<endl;
	}

}