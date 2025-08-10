str="Hello Im Kshama Mishra"
print(len(str))
print(type(str))
tupp=("hello", "world", 1, 2, 3, 4, 5)
li=[2, 3, 4, 5]
for i in tupp:
    li.append(i)
print(li)
for i in reversed(tupp):
    li.append(i)
print(li)
a = int(input("Enter an integer: "))
str_converted = str(a)
print(type(str_converted))
b = int(str_converted)
print(type(b))
