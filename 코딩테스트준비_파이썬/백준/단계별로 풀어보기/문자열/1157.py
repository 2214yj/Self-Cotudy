str = input().upper()
str_set = list(set(str))
str_cnt = list(map(str.count, str_set))
max_cnt = max(str_cnt)
if str_cnt.count(max_cnt) == 1:
    print(str_set[str_cnt.index(max_cnt)])
else:
    print('?')
