# Inheritance Example
# Demonstrates: Single inheritance, method overriding, super() function

class Animal:
    """Base class representing an animal"""
    
    def __init__(self, name, species):
        self.name = name
        self.species = species
    
    def make_sound(self):
        """Base method for making sound"""
        return "Some generic animal sound"
    
    def get_info(self):
        """Method to get animal information"""
        return f"{self.name} is a {self.species}"
    
    def sleep(self):
        """Method showing animal sleeping"""
        return f"{self.name} is sleeping"

class Dog(Animal):
    """Dog class inheriting from Animal"""
    
    def __init__(self, name, breed):
        # Call parent class constructor
        super().__init__(name, "Dog")
        self.breed = breed
    
    def make_sound(self):
        """Override the make_sound method"""
        return f"{self.name} says: Woof! Woof!"
    
    def fetch(self):
        """Dog-specific method"""
        return f"{self.name} is fetching the ball"
    
    def get_info(self):
        """Override get_info to include breed"""
        base_info = super().get_info()
        return f"{base_info} (Breed: {self.breed})"

class Cat(Animal):
    """Cat class inheriting from Animal"""
    
    def __init__(self, name, color):
        super().__init__(name, "Cat")
        self.color = color
    
    def make_sound(self):
        """Override the make_sound method"""
        return f"{self.name} says: Meow! Meow!"
    
    def climb(self):
        """Cat-specific method"""
        return f"{self.name} is climbing the tree"
    
    def get_info(self):
        """Override get_info to include color"""
        base_info = super().get_info()
        return f"{base_info} (Color: {self.color})"

# Testing inheritance
print("=== Inheritance Example ===")

# Create instances
my_dog = Dog("Buddy", "Golden Retriever")
my_cat = Cat("Whiskers", "Orange")

# Test inherited methods
print("Dog:")
print(my_dog.get_info())
print(my_dog.make_sound())
print(my_dog.sleep())
print(my_dog.fetch())

print("\nCat:")
print(my_cat.get_info())
print(my_cat.make_sound())
print(my_cat.sleep())
print(my_cat.climb())

# Demonstrate polymorphism
print("\n=== Polymorphism Example ===")
animals = [my_dog, my_cat]

for animal in animals:
    print(f"{animal.name}: {animal.make_sound()}")
    print(f"{animal.name}: {animal.get_info()}")
    print() 