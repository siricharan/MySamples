s = "Show how to index into sequence".split()
print(s)

print(s[-6])
'''
"Show how to index into sequence"
   0   1   2    3    4      5
  -6  -5  -4    -3   -2    -1
'''
a = s[0:3]
print(a)

a = s[1:-3]
print(a)  # ['how', 'to']

a = s[:3]
print(a)  # ['Show', 'how', 'to']

a = s[3:]
print(a)  # ['index', 'into', 'sequence']

a = s[:]  # copy whole list
print(a)  # ['Show', 'how', 'to', 'index', 'into', 'sequence']
print(a is s)  # False
print(a == s)  # True

a = s[1:-1]  # excludes first and last
print(a)  # ['how', 'to', 'index', 'into']

a = s[:]  # excludes first and last
print(a)  # ['how', 'to', 'index', 'into']

# copy ways - Shallow copy
a = s[:]
c = s.copy()
l = list(s)


# List comprehensions
words = "Show how to index into sequence".split()
comp_words = [len(word) for word in words]
print(words)
print(comp_words)

print(id(s))
print(id(a))
print(id(c))
print(id(l))
