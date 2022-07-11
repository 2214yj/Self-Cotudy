n = int(input())
for i in range(n + 1):
    if (3 * (i * i) + (3 * i) + 1) >= n:
        print(i + 1)
        break
