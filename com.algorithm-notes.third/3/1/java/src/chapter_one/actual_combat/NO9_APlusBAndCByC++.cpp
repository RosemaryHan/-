// pat_A+B and C (64bit).cpp : 定义控制台应用程序的入口点。
//
 
#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <cmath>
typedef long long ll;
 
ll a, b, c, res;
 
int main(int argc, char* argv[])
{
	int T,cas=1;
	scanf("%d", &T);
	while (T--)
	{
		int flag=1;
		scanf("%lld%lld%lld", &a, &b, &c);
		res = a + b;
		if (a < 0 && b < 0 && res>=0)//注意res==0也要包括
			flag = 0;
		else if (a>0 && b > 0 && res <=0)//写成res< =0就错？？
			flag = 1;
		else if (res > c)
			flag = 1;
		else
			flag = 0;
		printf("Case #%d: %s\n", cas++, flag == 1 ? "true" : "false");
	}
	return 0;
}
 