#include<iostream>
using namespace std;
class Stack
{
	char *arr;
	int n,top;
	public:
	Stack(int size=100)
	{
		top=-1;
		n=size;
		arr=new char[n];
	}
	void push(char a)
	{
		arr[++top]=a;
	}
	char pop()
	{
		char a=arr[top--];
		return a;
	}
};
int main() {
	char str[10000];
	cin>>str;
	bool flag=true;
	Stack s(sizeof(str));
	for(int i=0;str[i]!='\0';i++)
	{
		if(str[i]=='('||str[i]=='{'||str[i]=='[')
			s.push(str[i]);
		else if(str[i]==')')
		{
			char as=s.pop();
			if(as!='(')
			{
				flag=false;
				break;
			}
			else
				continue;
		}
		else if(str[i]=='}')
		{
			char as=s.pop();
			if(as!='{')
			{
				flag=false;
				break;
			}
			else
			continue;
		}
		else if(str[i]==']')
		{
			char as=s.pop();
			if(as!='[')
			{
				flag=false;
				break;
			}
			else
			continue;
		}
	}
	if(flag)
		cout<<"Yes";
	else
		cout<<"No";
	return 0;
}