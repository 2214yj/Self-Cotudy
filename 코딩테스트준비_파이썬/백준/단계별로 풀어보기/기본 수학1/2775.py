
n = int(input())
for _ in range(n):
    array = []
    k = int(input())
    n = int(input())
    array.append([i for i in range(n+1)])
    for j in range(0,k):
        array.append([sum(array[j][:k+1]) for k,v in enumerate(array[j])])
    print(array[k][n])