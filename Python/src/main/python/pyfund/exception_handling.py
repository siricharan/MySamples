'''
 module for demonstrating the exception
'''
import sys
from math import log

def convert1(s):
    '''Convert to an integer.'''
    try:
        x = int(s)
    except ValueError:
        pass
    except TypeError:
        print('Conversion failed!')
        x = -1
    return x

def convert(s):
    '''Convert to an integer.'''
    x = -1
    try:
        x = int(s)
    except (ValueError, TypeError) as e:
        # print('Conversion failed!')
        # pass
        print("Conversion Failed. Cause: {}"
              .format(str(e)),
              file = sys.stderr)
        raise

    return x

def string_log(s):
    v= convert(s)
    return log(v)


def print_converted(a):
    print(convert(a))


def sqrt(x):
    '''Computes the square root using the method of Heron of Alexandria.

    Args:
        x: The number which square roor is to be calculated.

    Returns:
        The square root of x.

    Raises:
        ValueError if x is negative
    '''

    if x < 0:
        raise ValueError("Cannot compute square root "
                         "of negative number {}".format(x))
    guess = x
    i = 0
    try:
        while guess * guess != x and i < 20:
            guess = (guess + x / guess) / 2.0
            i += 1
    except ZeroDivisionError:
        raise ValueError()
    finally:
        print("From finally")
    return guess



def main():
    try:
        print(sqrt(9))
        print(sqrt(2))
        print(sqrt(-1))
    except ValueError as e:
        print(e, file=sys.stderr)


if __name__ == '__main__':
    # print_converted(1)
    # print_converted('10')
    # print_converted('1h')
    # print_converted([1,2,1])

    # string_log(1)
    # string_log('1h')

    main()