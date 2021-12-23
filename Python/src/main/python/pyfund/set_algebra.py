blue_eyes = {'olivia', 'Harry', 'Lilly', 'Jack', 'Amelia'}
blond_hair = { 'Harry', 'Jack', 'Amelia', 'Mia', 'Joshua'}
smell_hcn = {'Harry',  'Amelia'}
taste_ptc = {'Harry', 'Lilly', 'Amelia', 'Lola'}
o_blood = {'Mia', 'Joshua', 'Lilly', 'olivia'}
b_blood = {'Amelia', 'Jack'}
a_blood = {'Harry'}
ab_blood = {'Joshua', 'Lola'}


blue_eyes_blond_hair = blue_eyes.union(blond_hair)  #{'Mia', 'Jack', 'Amelia', 'Joshua', 'Lilly', 'olivia', 'Harry'}
print(blue_eyes_blond_hair)

blue_eyes_and_blond_hair = blue_eyes.intersection(blond_hair) #{'Jack', 'Amelia', 'Harry'}
print(blue_eyes_and_blond_hair)

blond_hair_no_blue_eyes = blond_hair.difference(blue_eyes) #non-commutative       #{'Joshua', 'Mia'}
print(blond_hair_no_blue_eyes)

only_blond_hair_only_blue_eyes = blond_hair.symmetric_difference(blue_eyes) #commutative       #{'olivia', 'Lilly', 'Mia', 'Joshua'}
print(only_blond_hair_only_blue_eyes)


print(';'.join(['red', 'blue', 'white'])) #red;blue;white
# blue_eyes.union
# blue_eyes.intersection
# blond_hair.difference
# blond_hair.symmetric_difference()
# blond_hair.issubset()
# blond_hair.issubset()
# blond_hair.isdisjoint()


