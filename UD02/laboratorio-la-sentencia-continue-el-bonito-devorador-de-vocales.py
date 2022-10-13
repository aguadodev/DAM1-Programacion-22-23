word_without_vowels = ""

# Indicar al usuario que ingrese una palabra
# y asignarlo a la variable user_word.
user_word = input("Palabra:")
user_word = user_word.upper()

for letter in user_word:
    if letter in "AEIOU":
       continue
    word_without_vowels += letter

print(word_without_vowels)
        