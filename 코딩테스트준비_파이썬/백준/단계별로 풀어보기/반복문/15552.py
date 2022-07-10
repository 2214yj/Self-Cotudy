import sys
n = sys.stdin.readline().rstrip()
for _ in range(int(n)):
    print(sum(map(int,sys.stdin.readline().rstrip().split())))