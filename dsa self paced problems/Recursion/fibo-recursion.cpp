#include<iostream>
using namespace std;
int fibo(int n)
{
    if(n==1||n==0)
        return 1;
    int a=fibo(n-1),b=fibo(n-2);
    cout<<a+b<<" ";
    return a+b;
}
int main()
{
    int n;
    cout<<"Enter the limit: ";
    cin>>n;
    cout<<"Last result of the Fibbonacci series is: "<<fibo(n);
    return 0;
}