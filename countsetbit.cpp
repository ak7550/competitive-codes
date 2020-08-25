#include<iostream>
using namespace std;
int main()
{
    int n;
    cout<<"Enter the number: ";
    cin>>n;
    int res=0;
    while(n>0)
    {
        if(n%2==1)
            res++;
        n/=2;
    }
    cout<<"the number of set bits are: "<<res;
    return 0;
}
