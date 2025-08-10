num1=int(input("Enter the number one:")) 
num2=int(input("Enter the number two:")) 
num3=int(input("Enter the number three:")) 
if num2 and num3 < num1:
 print("Num1 is the greater",num1) 
elif num3 and num1 > num2: 
 print("Num2 is the greater",num2) 
elif num1 and num2 < num3: 
 print("Num3 id the greater",num3) 
else:
 print("numbers are equal")