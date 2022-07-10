n = int(input())
str = ['0' + input() + '0' for _ in range(n)]
result = 0
isGroup = True
for i in str:
    isGroup = True
    for j in set(i):
        if len(i.replace(j, ' ').split()) > 2:
            isGroup = False
            break
    if isGroup:
        result += 1
print(result)
