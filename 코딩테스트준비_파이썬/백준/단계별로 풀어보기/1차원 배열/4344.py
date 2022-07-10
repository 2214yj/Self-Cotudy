n = int(input())
for _ in range(n):
    str = input()
    m, test = int(str.split()[0]), list(map(int, str.split()[1:]))
    avg = sum(test) / m
    print('%.3f%%' % (sum([1 for i in test if i > avg]) / m * 100))
