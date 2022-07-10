str = input()
dial = ["1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"]
result = 0
for i in str:
    for j,v in enumerate(dial):
        if i in v:
            result += (j+2)
            break
print(result)