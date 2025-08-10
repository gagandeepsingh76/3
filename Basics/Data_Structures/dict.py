#creating a Dictionary 
phone={ 
"gagan":345678, 
"ritika":87654, 
"dhruv":76543,
}

#printing a dictionary 
print(phone) 

#Checking the type 
print(type(phone)) 

#Checking the length of Dictionary 
print(len(phone)) 

#Access item of dict 
print(phone["gagan"]) 
print(phone["ritika"]) 
print(phone["dhruv"]) 
#or get() 
print(phone.get("gagan"))

#updation value in dict 
phone["gagan"]=12334 
print(phone) 

# add elements in the dict 
phone["kia"]=77777 
print(phone)

# add new dict to a dict 
new_phone={ 
"ram":5432 
} 
phone.update(new_phone) 
print(phone) 

#remove element from the dict 
phone.pop("gagan") 
print(phone) 

# wants to delete the last time (poptime()) 
phone.popitem() 
print(phone) 

#empty the dict 
phone.clear() 
print(phone)

#print all of the value of the dict using the loop 
phone={ 
"gagan":345678, 
"ritika":87654, 
"dhruv":76543, 
}
for x in phone: 
 print((x)) 

#printing the keys as well as values 
for x,y in phone.items(): 
 print(x,y) 

#nester dict 
phone={ 
"area1":{ 
"x":2, 
"y":4, 
"z":0 
}, 
"area2":{ 
"a":9, 
"b":3, 
"c":6 
} 
} 
print(phone["area1"]["y"]) 
print(phone)

#zip() 
l1=[1,2,3,4,5] 
l2=["a","b","c","d","e"] 
dict1=dict(zip(li,li)) 
print(dict1) 