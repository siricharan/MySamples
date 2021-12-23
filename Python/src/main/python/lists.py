import copy

def main():
    '''
    "Show how to index into sequence"
       0   1   2    3    4      5
      -6  -5  -4    -3   -2    -1
    '''
    s = "Show how to index into sequence".split()
    print(s)


    a = s[0:3]
    print(a)
    a = s[0:-3]
    print(a)

    a = s[2:]
    print(a)
    a = s[:2]
    print(a)
    a = s[:]
    print(a)
    t=s
    print((t is s)) # True

    t=s[:]
    print((t is s)) # False

def copy_shallow():
    a = [[1,2], [3,4]]
    b= a[:] # same behavior for 3 cases
    # b= a.copy()
    # b= list(a)
    print((a is b)) # False
    print((a[0] is b[0])) # True

    a[0] = [0,1,2]
    print(a)   # [[0, 1, 2], [3, 4]]
    print(b)   # [[1, 2], [3, 4]]

    a[1].append(5)
    print(a)  # [[0,1, 2], [3, 4, 5]]
    print(b)  # [[1, 2], [3, 4, 5]]

    c= copy.copy(a)
    # c= copy.deepcopy(a)
    print(a)  # [[0,1, 2], [3, 4, 5]]
    print(c)  # [[1, 2], [3, 4, 5]]
    print((a[0] is c[0])) # True

    a[1].append(6)
    print(a)  # [[0,1, 2], [3, 4, 5, 6]]
    print(c)  # [[1, 2], [3, 4, 5, 6]]

def copy_deep():
    print("Deep copy......")
    a = [[1,2], [3,4]]
    c= copy.deepcopy(a)
    print(a)  # [[0,1, 2], [3, 4]]
    print(c)  # [[1, 2], [3, 4]]
    print((a[0] is c[0])) # True

    a[1].append(6)
    print(a)  # [[0,1, 2], [3, 4, 5, 6]]
    print(c)  # [[1, 2], [3, 4, 5, 6]]

if __name__ == 'tuples':
    main()

if __name__ == '__main__':
    copy_shallow()
    copy_deep()
    main()