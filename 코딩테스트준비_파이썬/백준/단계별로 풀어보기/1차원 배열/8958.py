m = int(input())
result = []
for _ in range(m):
    str = input()
    count = 0
    n = 0
    for i in str:
        if i == 'O':
            n += 1
            count += n
        else:
            n = 0
    result.append(count)

print(*result)

