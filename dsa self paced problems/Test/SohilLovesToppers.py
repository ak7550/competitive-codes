def takeMarks(length):
    arr = input()
    arr = arr.split(' ')
    arr = list(map(int, arr))
    print(arr)
    return arr


def doTheStuff():
    studetnsR1 = int(input())
    studetnsR2 = int(input())
    marksR1 = takeMarks(studetnsR1)
    marksR2 = takeMarks(studetnsR2)
    if sum(marksR1) > sum(marksR2):
        print("C1")
    else:
        print("C2")


testCases = int(input())
while testCases > 0:
    doTheStuff()
    testCases -= 1

