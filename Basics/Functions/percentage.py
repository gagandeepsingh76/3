per=float(input("Enter the percentage the of the student:")) 
if per <= 100 and per >= 81: 
 print("Very good") 
elif per <= 80 and per >= 61: 
 print("Good") 
elif per <= 60 and per >= 41: 
 print("Average") 
elif per <= 40 and per >= 0: 
 print("Fail") 
else: 
 print("Invalid Percentage")