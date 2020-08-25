#include<iostream>
using namespace std;
bool checkKthBit(int n, int k){
    if(n&(1<<(k-1))!=0)
        return true;
    else
        return false;    
}
int main()
{
    cout<<checkKthBit(4,2);
    return 0;
}