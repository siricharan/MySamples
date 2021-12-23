"""
This is example of tuple

"""

def first():
    """
    This is first tuples method

    @:arg no arguments
    @:return None
    """
    t= ('a', 2, 3.0)
    print(t)
    print(t[0]) #a
    print(t + (1,2,3))
    t1= (('a', 'b', 'c'), (1, 2, 3.0), ('x', 'y', 'z'))
    print(t1)
    print(t1 + (1,2,3))
    print(t1[2][1]) #y

    t2= 1,2,3
    print(type(t2))

    (a, (b, (c, d))) = (4, (3, (2, 1)))
    print(a,b,c,d)

    lower, upper = minmax([1, 3, 6, 7, 8])
    print(lower,upper)

    t3 = tuple([2, 2, 3, 5])
    print(t3)
    t4 = tuple("hai")
    print(t4)

def minmax(items):
    return min(items), max(items)

def main():
   first()
   p = minmax([21,12,57,3,89,56])
   print(type(p), p)

if __name__ == 'tuples':
    main()

if __name__ == '__main__':
    main()