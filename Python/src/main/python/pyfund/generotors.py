def gen123():
    yield 1
    yield 2
    yield 3

h= gen123()
print(type(h))
print(next(h))
print(next(h))
print(next(h))
#print(next(h)) # StopIteration

def gen246():
    print("About to yield 2")
    yield 2
    print("About to yield 4")
    yield 4
    print("About to yield 6")
    yield 6
    print("About to Return")


g= gen246()
print(next(g))
print(next(g))
print(next(g))
#print(next(g)) #About to Return and StopIteration