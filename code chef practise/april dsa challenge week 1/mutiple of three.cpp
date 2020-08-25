#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int T,d0,d1;
	long K;
	while(T-->0)
	{
	    cin>>K;
	    cin>>d0>>d1;
	    if((d0+d1)%3==0)
	        cout<<"YES"<<endl;
	    else
	        cout<<"NO"<<endl;
	}
	return 0;
}
