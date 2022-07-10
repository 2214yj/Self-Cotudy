all = set([i for i in range(1, 10001)])
self = set([i+sum(map(int,str(i))) for i in range(1,10001)])
print(*sorted(all-self))