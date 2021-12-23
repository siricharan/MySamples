def main():
    d = {'a':1, 'b':2, 'c':3}
    print(type(d), d)

    d = {('a',11), ('b',22), ('c',33)}
    print(type(d), d) # set
    d = dict(d)
    print(type(d), d)

    d = {('a',11,111), ('b',22,222), ('c',33,333)}
    print(type(d), d) # set
    # d = dict(d) # ValueError
    print(type(d), d)



if __name__ == 'tuples':
    main()

if __name__ == '__main__':
    main()