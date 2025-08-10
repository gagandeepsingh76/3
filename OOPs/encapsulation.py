# Encapsulation Example
# Demonstrates: Data hiding, private attributes, getters and setters

class BankAccount:
    """Bank account class demonstrating encapsulation"""
    
    def __init__(self, account_holder, initial_balance=0):
        # Private attributes (encapsulation)
        self.__account_holder = account_holder
        self.__balance = initial_balance
        self.__account_number = self.__generate_account_number()
        self.__transactions = []
    
    def __generate_account_number(self):
        """Private method to generate account number"""
        import random
        return f"ACC{random.randint(10000, 99999)}"
    
    # Getter methods (public interface)
    def get_balance(self):
        """Public method to get balance"""
        return self.__balance
    
    def get_account_holder(self):
        """Public method to get account holder name"""
        return self.__account_holder
    
    def get_account_number(self):
        """Public method to get account number"""
        return self.__account_number
    
    def get_transactions(self):
        """Public method to get transaction history"""
        return self.__transactions.copy()  # Return copy to prevent external modification
    
    # Setter methods with validation
    def deposit(self, amount):
        """Public method to deposit money with validation"""
        if amount > 0:
            self.__balance += amount
            self.__transactions.append(f"Deposit: +${amount}")
            return f"Deposited ${amount}. New balance: ${self.__balance}"
        else:
            return "Invalid deposit amount. Amount must be positive."
    
    def withdraw(self, amount):
        """Public method to withdraw money with validation"""
        if amount > 0 and amount <= self.__balance:
            self.__balance -= amount
            self.__transactions.append(f"Withdrawal: -${amount}")
            return f"Withdrawn ${amount}. New balance: ${self.__balance}"
        elif amount > self.__balance:
            return "Insufficient funds!"
        else:
            return "Invalid withdrawal amount. Amount must be positive."
    
    def display_info(self):
        """Public method to display account information"""
        print(f"Account Holder: {self.__account_holder}")
        print(f"Account Number: {self.__account_number}")
        print(f"Current Balance: ${self.__balance}")
        print(f"Number of Transactions: {len(self.__transactions)}")

class Employee:
    """Employee class with encapsulated salary information"""
    
    def __init__(self, name, position, salary):
        self.__name = name
        self.__position = position
        self.__salary = salary
        self.__bonus = 0
    
    # Getter methods
    def get_name(self):
        return self.__name
    
    def get_position(self):
        return self.__position
    
    def get_salary(self):
        return self.__salary
    
    def get_total_compensation(self):
        return self.__salary + self.__bonus
    
    # Setter methods with validation
    def set_salary(self, new_salary):
        """Set salary with validation"""
        if new_salary >= 0:
            self.__salary = new_salary
            return f"Salary updated to ${new_salary}"
        else:
            return "Invalid salary amount"
    
    def add_bonus(self, bonus_amount):
        """Add bonus with validation"""
        if bonus_amount >= 0:
            self.__bonus += bonus_amount
            return f"Bonus of ${bonus_amount} added"
        else:
            return "Invalid bonus amount"
    
    def display_info(self):
        """Display employee information"""
        print(f"Name: {self.__name}")
        print(f"Position: {self.__position}")
        print(f"Base Salary: ${self.__salary}")
        print(f"Bonus: ${self.__bonus}")
        print(f"Total Compensation: ${self.get_total_compensation()}")

# Testing encapsulation
print("=== Encapsulation Example ===")

# Bank Account Example
print("Bank Account:")
account = BankAccount("John Doe", 1000)
account.display_info()

print(f"\nDeposit: {account.deposit(500)}")
print(f"Withdraw: {account.withdraw(200)}")
print(f"Invalid Withdraw: {account.withdraw(2000)}")

print(f"\nCurrent Balance: ${account.get_balance()}")
print(f"Account Number: {account.get_account_number()}")

# Employee Example
print("\nEmployee:")
employee = Employee("Jane Smith", "Software Engineer", 75000)
employee.display_info()

print(f"\n{employee.set_salary(80000)}")
print(f"{employee.add_bonus(5000)}")
employee.display_info()

# Demonstrate that private attributes cannot be accessed directly
print(f"\nTrying to access private attribute: {employee.get_name()}")
# This would cause an error: print(employee.__salary) 