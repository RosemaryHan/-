    //结果如下： 全部正确 内存： 1088   KB    耗时： 25  ms
    #include<cstdio>
    #include<algorithm>
    using namespace
    std;
const
    int MAXN = 100005;
    int dis[MAXN],a[MAXN];

    int main() {
        int sum = 0, query, n, left, right;
        scanf("%d", & n);
        for (int i = 1; i <= n; i++) {
            scanf("%d", & a[i]);
            sum += a[i];
            dis[i] = sum;
        }
        scanf("%d", & query);
        for (int i = 0; i < query; i++) {
            scanf("%d%d", & left,&right);
            if (left > right) swap(left, right);
            int temp = dis[right - 1] - dis[left - 1];
            printf("%d\n", min(temp, sum - temp));
        }
    }