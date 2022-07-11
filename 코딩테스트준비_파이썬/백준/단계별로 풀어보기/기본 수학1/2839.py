n = int(input())
k = n // 5
isCountable = True
for i in range(k, -1, -1):
    if (n - 5 * i) % 3 == 0:
        print(i + ((n - 5 * i) // 3))
        isCountable = False
        break
if isCountable:
    print(-1)
