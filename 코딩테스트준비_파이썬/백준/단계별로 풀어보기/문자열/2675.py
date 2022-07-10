m = int(input())
for _ in range(m):
    n,str = input().split()
    for i in str:
        print(i*int(n),end="")
    print()
