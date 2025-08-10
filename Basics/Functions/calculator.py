c1=int(input("Enter the number one:")) 
c2=int(input("Enter the number two:")) 
sing=input("Enter the operation:") 
match sing: 
 case"+":print("sum:",c1+c2) 
 case"-":print("diff:",c1-c2) 
 case"*":print("mul:",c1*c2) 
 case"/":float(print("divide:",c1/c2)) 
 case"_":print("Enter the valid operator")