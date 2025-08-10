# simple palindrome program
text="mama" 
a=text[0:] 
if text==text[::-1]:
 # here we are using slicing to reverse the string 
 print("The given string is palindrome,") 
else: 
 print("The given string is not palindrome") 

# function palindrome
def palindrome(text,a): 
 if text==text[::-1]: 
  p="palindrome" 
  return p 
 else: 
  g="string is not palindrome" 
  return g 
 
text="mama" 
a=text[0:] 
print(palindrome(text,a))