import time
import math

count = 0

def banner(message, border='-'):
    # global count
    count = 200
    line = border * len(message)
    print(line)
    print(message)
    print(line)
    print()

def show_default(arg=time.ctime()):
    print(count)
    print(arg)

def add_spam(menu=[]):
    menu.append('spam')
    return menu

def add_spam1(menu=None):
    if menu is None:
        menu = []
    menu.append('spam')
    return menu


def main():

    print("Pi value is {m.pi:.3f}".format(m=math))
    banner("Hello how are you?")
    banner("Hello how are you????????????", '*')
    banner(border = '.', message ="Hello how are you????????????" )

    show_default()
    global count
    count = 100
    show_default()
    show_default()

    one = [1,2,3]
    a= add_spam(one)
    print(a)

    c= add_spam()
    print(c) #['spam']

    c= add_spam()
    print(c) #['spam', 'spam']


if __name__ == '__main__':
    main()


