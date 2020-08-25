#include<iostream>
using namespace std;
int fibo(int n)
{
    int a=0,b=1,sum;
    for (int i = 1; i < n; i++)
    {
        sum=a+b;
        a=b;
        b=sum;
        cout<<sum<<endl;
    }
    return sum;
}
int fiboRecursion(int n)
{
    if(n==2||n==1)
        return 1;
    return fiboRecursion(n-1)+fiboRecursion(n-2);
}
int main()
{
    int n;
    cout<<"Enter the limit: ";
    cin>>n;
    cout<<n<<"th fibonacci number is: "<<fibo(n);
    cout<<"Using Recursion: "<<fiboRecursion(n);
    return 0;
}