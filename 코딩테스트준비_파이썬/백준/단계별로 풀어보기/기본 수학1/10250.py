T = int(input())
result = []
for _ in range(T):
    H, W, N = map(int, input().split())
    result.append(f'{(N % H==0 and H or N % H )}{((N-1) // H + 1):02d}')

print(*result, sep="\n")