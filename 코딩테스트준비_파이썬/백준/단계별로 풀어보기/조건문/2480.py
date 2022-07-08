a, b, c = map(int, input().split())
count = len({a, b, c})
if count == 3:
    print(max(a, b, c) * 100)
elif count == 2:
    if a == b:
        print(1000 + a * 100)
    else:
        print(1000 + c * 100)
else:
    print(10000 + a * 1000)
