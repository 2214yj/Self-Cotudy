h,m = map(int, input().split())
time = int(input())
print( (h+((m+time)//60)) % 24, (m+time) % 60 )