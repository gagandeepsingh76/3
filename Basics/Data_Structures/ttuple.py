colours=("red","yellow","blue") 
#single element in the tuple (use of the , after element) 
fruite=("apple") 
fruit=tuple("apple") 

#checking the type of the tuple 
print(type(colours)) 
print(type(fruite)) 
print(type(fruit)) 

#Length of tuple 
print(len(colours)) 
print(len(fruite)) 

#accessing items in tuple 
print(colours[0]) 
print(colours[1]) 
print(colours[2]) 
print(colours[-1]) 
print(colours[-2]) 
print(colours[-3])
print(colours[0:3]) 
print(colours[-3:-1]) 
print(colours[-3:])#if we just tell starting point and no enf jitna tuple hai

#Want to check that there is time is in the list or not 
if "blue" in colours: 
 print("blue is there") 
if "orange" not in colours: 
 print("orange is not there!") 

#Traverse a the tuble 
for i in colours: 
 print(i)

#concatenate the tuple 
new_colurs=("magenta","creame") 
print(colours+new_colurs)

#unpacking a tuple 
colour1,colour2,colour3=colours 
print(colour1,colour2,colour3,sep="->") 

#reverse() 
"""it iterate through a sequence through a sequence in reverse order""" 
tp=('z','a','d','f','g','e','e','k') 
print(", ".join(reversed(tp)))

tp=('z','a','d','f','g','e','e','k') 
li=[] 
for i in reversed(tp): 
 li.append(i) 
print(tuple(li)) 

tp=(10,11,12,13,14,15) 
li=[] 
for i in reversed(tp): 
 li.append(i) 
print(tuple(li))