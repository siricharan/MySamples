# List comprehensions
words = "Show how to index into sequence for the".split()
comp_words = [len(word) for word in words]
print(words)
print(comp_words) #[4, 3, 2, 5, 4, 8, 3, 3]

# Set comprehensions
comp_words = {len(word) for word in words}
print(words)
print(comp_words) #{2, 3, 4, 5, 8} order not guaranteed


# Dict comprehensions
country_to_capital ={'India': 'New Delhi',
                     'UK': 'London',
                     'Brazil': 'Brazilia',
                     'Morocco': 'Rabat',
                     'Sweden': 'Stockholm'}
capital_country = {capital: country for country, capital in country_to_capital.items()}
print(capital_country)
from pprint import pprint as pp
pp(capital_country)

words = {"hi", 'hello', 'foxtrot', 'hotel'}
dict_words= {x[0]: x for x in words}
pp(dict_words)



#Prime numbers
from math import sqrt
def is_prime(x):
    if x < 2:
        return False
    for i in range(2, int(sqrt(x))+1):
        if x % i ==0:
            return False
    return True


prime_list = [x for x in range(101) if  is_prime(x)] # prints prime till 101
print(prime_list)

from itertools import islice, count
islice_prime_list = islice((x for x in count() if  is_prime(x)),1000) # prints prime till 101
print(islice_prime_list)
print(list(islice_prime_list))


