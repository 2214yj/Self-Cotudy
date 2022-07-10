n = int(input())
c = (n // 10 + n % 10)%10
new = 10 * (n%10) + c
count = 1
while n != new:
    c = (new // 10 + new % 10)%10
    new = 10 * (new % 10) + c
    count += 1


print(count)