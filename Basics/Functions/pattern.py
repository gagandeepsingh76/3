# This program prints a pattern of stars in the shape of a rectangle.
n=int(input("Enter the number of the rows:")) 
for i in range(n): 
 print("*"*5) 

# This program prints a pattern of numbers in the shape of a rectangle.
n=int(input("Enter the number of the rows:")) 
for _ in range(n): 
 for i in range(1, n+1): 
    print(i, end=" ") 
 print()  # Ensure a new line after each row

# This program prints a pattern of numbers in the shape of a right-angled triangle.
n = int(input("Enter the number of rows: ")) 
for i in range(1, n+1): 
    for j in range(1, i+1):  
        print(j, end=" ") 
    print()  # Ensure a new line after each row

# This program prints a pattern of alphabets in the shape of a right-angled triangle.
n = int(input("Enter the number of rows: ")) 
for i in range(1, n+1): 
    for j in range(65, 65 + i): 
        print(chr(j), end=" ") 
    print()  # Ensure a new line after each row

n=int(input("Enter the number of the rows:")) 
for i in range(1, n): 
    print(" " * (n - i), end="") 
    for j in range(1, 2 * i): 
        print(j, end="") 
    print()    