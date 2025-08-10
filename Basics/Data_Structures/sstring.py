#Array-like indexing in string 
text="hello, world!" 
print(text[0]) 
print(text[4]) 
print(text[6])
print(text[12])
print(text[-1]) 
print(text[-2])

#Traversing a string 
for i in text: 
 print(i) 

#Also can find the length of the string 
print(len(text))

#Find a char or sub string in the string 
name1="hello world"
print(name1.find('h')) # it will give the index of the first occurrence
print(name1.find('l')) # it will give the index of the first occurrence
print(name1.find('l'))
print(name1.find('a')) # it will give the -1 if the letter is not there
print(name1.find('9')) # it will  give the -1 if the letter is not there

#we can also find the substring ! 
print(text.find('hel')) # it will tell where the starting index of the substring 

#Slicing a string [start:end] 
a='gagan' 
print(a[2:4])

#Slicing from the start 
str='abcdef' 
print(str[:3]) 
#Slicing from the end 
print(str[3:])
#Negative indexing 
print(str[-3:]) # means "give me the last 3 characters of the string." It starts at the third character from the end and goes to the end of the string.
print(str[-3:-1]) # means "start from the third character from the end and go up to (but not including) the last character." Negative indexing is used to count backward.
#Step count
print(str[2:5:2])#skip the no.

#upper() 
na="gagan" 
ma=na.upper() 
print(ma) 

#lower()
s1=ma.lower() 
print(s1) 

#capitalize()
s2=s1.capitalize() 
print(s2) 

#title()
s3=s2.title()

#strip() for striping/removeig any trailing whitespaces 
str="    hello world!" 
print(str.strip())
print(str.lstrip())
print(str.rstrip()) 

#replace() str.replace(old_substring,new_string,count) 
str="kanpur belongs to Delhi to Delhi" 
print(str.replace("Delhi","uttar pradesh")) # here we not give the count so it will replace all the delhi
# but if we given the count then it will replace as per the count 
tr="kanpur belongs to Delhi to Delhi" 
print(str.replace("Delhi","uttar pradesh",1))  

#concatenation in the string 
str1="hello world!" 
str2="how are you" 
print(str1+str2) 

#format()
fruit1="mango" 
fruit2="apple" 
str="I have fruits {f1} and {f2}".format(f1=fruit1,f2=fruit2) 
print(str)

#count and end with and start with
str="I am a coder"
str.endWith("er")
str.count("am")
str.startWith("i")

w="I am Kshama"
print(w.reverse())



 