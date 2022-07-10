n = int(input())
li = list(map(int, input().split()))
print(sum([((i / max(li)) * 100) for i in li]) / n)
