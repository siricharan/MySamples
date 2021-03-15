"""
This module to demonstrate the Stateful Generators

"""
def take (count, iterable):
    """Take first count elements

    Args:
        count: The maximum number of items to retrieve
        iterable: The source series

         Yields:
             At most 'count' items from the 'iterable'

    """
    counter = 0
    for item in iterable:
        if counter == count:
            return
        counter += 1
        yield item


def distinct(iterable):
    """Returns unique items by eliminating duplicates.

    Args:
        iterable: The source series

         Yields:
             unique items in order from 'iterable'.
    """
    seen = set()
    for item in iterable:
        if item in seen:
            continue
        yield item
        seen.add(item)

def run_take():
    items = [2,4,6,8,10]
    for item in take(3, items):
        print(item)

def run_distinct():
    items = [5,7,7,6,5,5]
    for item in distinct(items):
        print(item)

def run_pipeline():
    items = [3,6,6,2,1,1]
    for item in take(3, distinct(items)):
        print(item)

if __name__ == '__main__':
    print("With take: count 3 in [2,4,6,8,10]")
    run_take()

    print("With distinct in [5,7,7,6,5,5]")
    run_distinct()


    print("With distinct 3 in [3,6,6,2,1,1]")
    run_pipeline()

    # Generator expresion
    squares = (x*x for x in range(1,5))
    print(squares)
    print(list(squares)) #prints: [1, 4, 9, 16]
    print(list(squares)) #prints: []

    sum_num = sum((x*x for x in range(1,5)))
    sum_num = sum(x*x for x in range(1,5)) # functions parentheses also serves the generator purpose
    print(sum_num)
    print(sum_num)


