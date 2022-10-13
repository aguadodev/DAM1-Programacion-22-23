# Indicar al usuario que ingrese una palabra
# y asignarlo a la variable user_word.
user_word = input("Palabra:")
user_word = user_word.upper()

for letter in user_word:
    if letter in "AEIOU":
       continue
    print(letter)
        