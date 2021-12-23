import math

def main():
    l = len('hello')
    print(l)

    colors = ";".join(['#ffffff', '#aaaf45', '#000fad'])
    print(colors)
    color = colors.split(';')
    print(color)

    s= "the age of {0} is {1}".format("'Cherrie'", 33)
    print(s)
    s= "current position is {x} and {y}".format(y=10, x=20)
    print(s)
    s= "current position is {pos[0]} and {pos[1]}".format(pos = [10, 20])
    print(s)
    s= "pi = {m.pi} and e = {m.e}".format(m = math)
    print(s)
    s= "pi = {m.pi:.3f} and e = {m.e:.3f}".format(m = math)
    print(s)

    value = 4*20
    s= "The result is {value} ".format(value =value)
    print(s)

    s= f"The result is {value} " # f string PEP 498
    print(s)


if __name__ == 'strings':
    main()

if __name__ == '__main__':
    main()