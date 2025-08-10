# Basic Class Example
# Demonstrates: Class definition, object creation, instance methods

class Student:
    """A simple class to represent a student"""
    
    def __init__(self, name, age, grade):
        """Constructor method - initializes student attributes"""
        self.name = name
        self.age = age
        self.grade = grade
    
    def display_info(self):
        """Instance method to display student information"""
        print(f"Name: {self.name}")
        print(f"Age: {self.age}")
        print(f"Grade: {self.grade}")
    
    def study(self, subject):
        """Instance method showing student studying"""
        print(f"{self.name} is studying {subject}")
    
    def get_grade_level(self):
        """Method to determine grade level based on grade"""
        if self.grade >= 90:
            return "A"
        elif self.grade >= 80:
            return "B"
        elif self.grade >= 70:
            return "C"
        else:
            return "D"

# Creating objects (instances) of the Student class
print("=== Basic Class Example ===")
student1 = Student("Alice", 16, 95)
student2 = Student("Bob", 15, 78)

# Using instance methods
print("Student 1:")
student1.display_info()
print(f"Grade Level: {student1.get_grade_level()}")
student1.study("Mathematics")

print("\nStudent 2:")
student2.display_info()
print(f"Grade Level: {student2.get_grade_level()}")
student2.study("Science")

# Accessing instance variables directly
print(f"\nDirect access - {student1.name}'s age: {student1.age}") 