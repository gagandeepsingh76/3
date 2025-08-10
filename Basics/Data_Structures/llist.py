fruits=["apple","mangoes","cherry"] # create a list 
print(fruits) #print the list 
print(type(fruits)) #check the type of the list 
print(len(fruits)) # check the length of the list 

print(fruits[1]) 
print(fruits[-2]) 
print(fruits[0:3])#sublist 
print(fruits[0:4])#print whole list using positive indexing 
# we cannot print the whole list using the negative indexing

# adding elements to the list
num=[1,2,3,4,5] 
num.append(6) 
print(num) 
num.insert(0,0) 
print(num) 
nuum=[7,8] 
num.extend(nuum) 
print(num)

# removing elements from the list
numm=[1,2,3,4,5,6] 
numm.remove(1) 
print(numm) 
# pop off the target element
numm=[1,2,3,4,5,6] 
numm.pop(0) 
print(numm) 
# pop off the last element
numm=[1,2,3,4,5,6] 
numm.pop() 
print(numm) 

# updating an element in the list
li=[1,2,3,4] 
li[3]=8 
print(li) 
li=[1,2,3,4] 
li[0:2]=[3,4] 
print(li) 

#shorting a list 
op=[56,1,67,9,166] 
op.sort() 
print(op) 
op=[56,1,67,9,166] 
op.sort(reverse=True) 
print(op)

#reverse a list
op=[56,1,67,9,166] 
op.reverse 
print(op) 

#using list comprehension want a list of item greater than 22 
l1=[21,22,23,24,25] 
newlist=[] 
for i in l1: 
 if i>22: 
  newlist.append(i) 
print(newlist) 

#using list comprehension want a list of item containing 'a'
fruits=["apple","mangoes","cherry"] 
newlist=[fruits for fruits in fruits if "a" in fruits] 
print(newlist) 

#copy the list in other list 
a = fruits.copy()
print(a)

#we can list add two list 
lst1=[1,2,3,4,5,6,7] 
lst2=[8,9,10,11,12,13] 
print(lst1+lst2) 

#nested list 
nlist=[10,20,[30,40],50,60] 
print(nlist[0]) 
print(nlist[1]) 
print(nlist[2]) 
print(nlist[2][0]) 
print(nlist[2][1]) 
print(nlist[3]) 
print(nlist[4])

#Question 
qlist=[23,65,19,90] 
qlist[-4]=19 
qlist[-2]=23 
print(qlist) 
qlist=[23,65,19,90] 
qlist[0]=19 
qlist[2]=23 
print(qlist)

# qq list
qq=[1,2,3,4,5] 
qq[1]=5 
qq[4]=2 
print(qq) 
qq=[1,2,3,4,5] 
temp=qq[0] 
qq[1]=qq[4] 
qq[4]=temp 
print(qq)