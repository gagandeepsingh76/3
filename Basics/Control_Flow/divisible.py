d = int(input("Enter the Number: "))
if d == 0:
    print("Invalid input")
elif d % 5 == 0 or d % 3 == 0:
    if d % 15 != 0:
        print("The digit is divisible by 5 or 3 but not by 15")
    else:
        print("The digit is divisible by 5 or 3 and 15 too")
else:
    print("The digit is not divisible by 5 or 3")