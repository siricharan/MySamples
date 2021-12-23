import sys

Digit_map = { "zero": '0',
              "One": '1',
              "Two": '2',
              "Three": '3',
              "Four": 4,
              "Five": '5',
              "Six": '6',
              "Seven": '7',
              "Eight": '8',
              "Nine": '9',
              }


def convert(s):
    number = ''
    try:
        for token in s:
            number += Digit_map[token]

        result = int(number)
    except KeyError:
        result = 0
    except TypeError:
        result = 1
    return result

def linux_Only():
    try:
        assert('linux' in sys.platform), "This code runs only in Linux"
    except AssertionError as e:
        print(e)
        pass

def fileopen():
    try:
        # with open('first.py') as f:
        f = open('first.py')
        data = f.read()
        print(data)
    except FileNotFoundError as e:
        print(e)
        pass
        # raise e
    else:
        print("No Exception")
    finally:
        print("Finally....")


def main():
    fileopen()
    a= convert("One Two Three Four".split())
    print(a)

    a= convert("One Two Three Fourq".split())
    print(a)

    a= convert("One Two Three Four".split())
    print(a)

if __name__ == "__main__":
    main()