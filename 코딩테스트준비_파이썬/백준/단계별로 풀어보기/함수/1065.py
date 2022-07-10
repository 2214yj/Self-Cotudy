n = int(input())
if n < 100:
    print(n)
else:
    result = 99
    for i in range(100, n + 1):
        li = list(map(int, str(i)))
        if (li[0] - li[1]) == (li[1] - li[2]):
            result += 1

    print(result)