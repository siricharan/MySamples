# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
from developer1
changes
"""
name ="PyhtonBot"
machine="VTBo"
print("Nice to meet you {0}. I am {1}".format(name, machine))

print(f"Nice to meet you {name}. I am {machine}")


print("Nice to meet you \"a//b/b") # "a//b/b
print(r"Nice to meet you \"a//b/b") # \"a//b/b


"""Boolean and None"""

true_bool=True
false_bool=False

if true_bool==False:
    print("Boolean is false")
else:
    print("Boolean is true")

t="f "
if t.strip():
    print("\"t\" has some value")
else:
    print("\"t\" has no value")

none_val=None
if not none_val:
    print("\"none_val\" is none")

if none_val:
    print("\"none_val\" is none")   # Will not be executed

"""Ternary if statements"""

a=1
b=2
c = "\"a\" is bigger" if a>b else "\"b\" is bigger"
print(c)


