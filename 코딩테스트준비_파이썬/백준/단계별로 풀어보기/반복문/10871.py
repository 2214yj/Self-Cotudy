N,X = map(int, input().split())
order = map(int, input().split())
print(*[i for i in order if i < X])