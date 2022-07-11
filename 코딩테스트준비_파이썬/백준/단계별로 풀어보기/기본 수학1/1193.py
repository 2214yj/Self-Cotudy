n = int(input())
n_index = 0
for i in range(1, n + 2):
    if ((i * i + i) / 2) >= n:
        n_index = i
        break

k = n - ((n_index-1) * (n_index-1) + (n_index-1)) // 2 - 1
isReverse = 1
if n_index % 2 == 0:
    isReverse = -1

result = [f'{(n_index - j)}/{(j + 1)}' for j in range(n_index)][::isReverse][k]
print(result)
