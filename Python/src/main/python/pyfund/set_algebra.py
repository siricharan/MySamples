blue_eyes = {'olivia', 'Harry', 'Lilly', 'Jack', 'Amelia'}
blond_hair = { 'Harry', 'Lilly', 'Amelia', 'Mia', 'Joshua'}
smell_hcn = {'Harry',  'Amelia'}
taste_ptc = {'Harry', 'Lilly', 'Amelia', 'Lola'}
o_blood = {'Mia', 'Joshua', 'Lilly', 'olivia'}
b_blood = {'Amelia', 'Jack'}
a_blood = {'Harry'}
ab_blood = {'Joshua', 'Lola'}


blue_eyes_blond_hair = blue_eyes.union(blond_hair)
print(blue_eyes_blond_hair)

blue_eyes_and_blond_hair = blue_eyes.intersection(blond_hair)
print(blue_eyes_and_blond_hair)

blond_hair_no_blue_eyes = blond_hair.difference(blue_eyes) #non-commutative
print(blond_hair_no_blue_eyes)

print(';'.join(['red', 'blue', 'white']))
# blue_eyes.union
# blue_eyes.intersection
# blond_hair.difference
# blond_hair.symmetric_difference()
# blond_hair.issubset()
# blond_hair.issubset()
# blond_hair.isdisjoint()


