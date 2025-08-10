# Real-World OOP Example: E-commerce System
# Demonstrates: All OOP concepts in a practical application

from abc import ABC, abstractmethod
from datetime import datetime
import uuid

class Product(ABC):
    """Abstract base class for all products"""
    
    def __init__(self, name, price, description):
        self.product_id = str(uuid.uuid4())[:8]
        self.name = name
        self.price = price
        self.description = description
        self.in_stock = True
    
    @abstractmethod
    def get_product_type(self):
        """Abstract method to get product type"""
        pass
    
    def get_info(self):
        """Get product information"""
        return f"{self.product_id}: {self.name} - ${self.price}"
    
    def update_price(self, new_price):
        """Update product price"""
        if new_price >= 0:
            self.price = new_price
            return f"Price updated to ${new_price}"
        return "Invalid price"

class Electronics(Product):
    """Electronics product class"""
    
    def __init__(self, name, price, description, brand, warranty_years):
        super().__init__(name, price, description)
        self.brand = brand
        self.warranty_years = warranty_years
    
    def get_product_type(self):
        return "Electronics"
    
    def get_info(self):
        base_info = super().get_info()
        return f"{base_info} (Brand: {self.brand}, Warranty: {self.warranty_years} years)"

class Clothing(Product):
    """Clothing product class"""
    
    def __init__(self, name, price, description, size, material):
        super().__init__(name, price, description)
        self.size = size
        self.material = material
    
    def get_product_type(self):
        return "Clothing"
    
    def get_info(self):
        base_info = super().get_info()
        return f"{base_info} (Size: {self.size}, Material: {self.material})"

class Customer:
    """Customer class with encapsulation"""
    
    def __init__(self, name, email, address):
        self.__customer_id = str(uuid.uuid4())[:8]
        self.__name = name
        self.__email = email
        self.__address = address
        self.__orders = []
        self.__total_spent = 0
    
    # Getter methods
    def get_customer_id(self):
        return self.__customer_id
    
    def get_name(self):
        return self.__name
    
    def get_email(self):
        return self.__email
    
    def get_address(self):
        return self.__address
    
    def get_total_spent(self):
        return self.__total_spent
    
    def get_orders(self):
        return self.__orders.copy()
    
    # Setter methods
    def update_email(self, new_email):
        if '@' in new_email:
            self.__email = new_email
            return f"Email updated to {new_email}"
        return "Invalid email format"
    
    def update_address(self, new_address):
        self.__address = new_address
        return f"Address updated to {new_address}"
    
    def add_order(self, order):
        """Add order to customer's order history"""
        self.__orders.append(order)
        self.__total_spent += order.get_total()
    
    def get_customer_info(self):
        """Get customer information"""
        return f"Customer ID: {self.__customer_id}\nName: {self.__name}\nEmail: {self.__email}\nAddress: {self.__address}\nTotal Spent: ${self.__total_spent}"

class OrderItem:
    """Order item class"""
    
    def __init__(self, product, quantity):
        self.product = product
        self.quantity = quantity
    
    def get_subtotal(self):
        """Calculate subtotal for this item"""
        return self.product.price * self.quantity
    
    def get_info(self):
        """Get order item information"""
        return f"{self.product.name} x {self.quantity} = ${self.get_subtotal():.2f}"

class Order:
    """Order class"""
    
    def __init__(self, customer):
        self.__order_id = str(uuid.uuid4())[:8]
        self.__customer = customer
        self.__items = []
        self.__order_date = datetime.now()
        self.__status = "Pending"
    
    def add_item(self, product, quantity):
        """Add item to order"""
        if product.in_stock and quantity > 0:
            item = OrderItem(product, quantity)
            self.__items.append(item)
            return f"Added {quantity} {product.name} to order"
        return "Cannot add item (out of stock or invalid quantity)"
    
    def remove_item(self, product_name):
        """Remove item from order"""
        for item in self.__items:
            if item.product.name == product_name:
                self.__items.remove(item)
                return f"Removed {product_name} from order"
        return f"Item {product_name} not found in order"
    
    def get_total(self):
        """Calculate order total"""
        return sum(item.get_subtotal() for item in self.__items)
    
    def get_order_id(self):
        return self.__order_id
    
    def get_status(self):
        return self.__status
    
    def set_status(self, status):
        """Update order status"""
        valid_statuses = ["Pending", "Processing", "Shipped", "Delivered", "Cancelled"]
        if status in valid_statuses:
            self.__status = status
            return f"Order status updated to {status}"
        return "Invalid status"
    
    def get_order_info(self):
        """Get complete order information"""
        info = f"Order ID: {self.__order_id}\n"
        info += f"Customer: {self.__customer.get_name()}\n"
        info += f"Date: {self.__order_date.strftime('%Y-%m-%d %H:%M:%S')}\n"
        info += f"Status: {self.__status}\n"
        info += "Items:\n"
        
        for item in self.__items:
            info += f"  - {item.get_info()}\n"
        
        info += f"Total: ${self.get_total():.2f}"
        return info

class EcommerceSystem:
    """Main e-commerce system class"""
    
    def __init__(self):
        self.__products = []
        self.__customers = []
        self.__orders = []
    
    def add_product(self, product):
        """Add product to system"""
        self.__products.append(product)
        return f"Product {product.name} added to system"
    
    def add_customer(self, customer):
        """Add customer to system"""
        self.__customers.append(customer)
        return f"Customer {customer.get_name()} added to system"
    
    def create_order(self, customer_email):
        """Create new order for customer"""
        customer = self.find_customer_by_email(customer_email)
        if customer:
            order = Order(customer)
            self.__orders.append(order)
            return order
        return None
    
    def find_customer_by_email(self, email):
        """Find customer by email"""
        for customer in self.__customers:
            if customer.get_email() == email:
                return customer
        return None
    
    def find_product_by_name(self, name):
        """Find product by name"""
        for product in self.__products:
            if product.name == name:
                return product
        return None
    
    def get_all_products(self):
        """Get all products"""
        return self.__products.copy()
    
    def get_all_customers(self):
        """Get all customers"""
        return self.__customers.copy()
    
    def get_all_orders(self):
        """Get all orders"""
        return self.__orders.copy()

# Testing the e-commerce system
print("=== Real-World OOP Example: E-commerce System ===")

# Create e-commerce system
ecommerce = EcommerceSystem()

# Create products
laptop = Electronics("Gaming Laptop", 1200, "High-performance gaming laptop", "GamingPro", 2)
shirt = Clothing("Cotton T-Shirt", 25, "Comfortable cotton t-shirt", "L", "Cotton")
phone = Electronics("Smartphone", 800, "Latest smartphone model", "TechCorp", 1)
jeans = Clothing("Blue Jeans", 60, "Classic blue jeans", "32", "Denim")

# Add products to system
ecommerce.add_product(laptop)
ecommerce.add_product(shirt)
ecommerce.add_product(phone)
ecommerce.add_product(jeans)

# Create customers
customer1 = Customer("John Doe", "john@email.com", "123 Main St, City")
customer2 = Customer("Jane Smith", "jane@email.com", "456 Oak Ave, Town")

# Add customers to system
ecommerce.add_customer(customer1)
ecommerce.add_customer(customer2)

# Create and process orders
print("\n=== Processing Orders ===")

# Order 1
order1 = ecommerce.create_order("john@email.com")
if order1:
    print(order1.add_item(laptop, 1))
    print(order1.add_item(shirt, 2))
    print(order1.set_status("Processing"))
    customer1.add_order(order1)
    print("\nOrder 1 Details:")
    print(order1.get_order_info())

# Order 2
order2 = ecommerce.create_order("jane@email.com")
if order2:
    print(f"\n{order2.add_item(phone, 1)}")
    print(order2.add_item(jeans, 1))
    print(order2.set_status("Shipped"))
    customer2.add_order(order2)
    print("\nOrder 2 Details:")
    print(order2.get_order_info())

# Display customer information
print("\n=== Customer Information ===")
for customer in ecommerce.get_all_customers():
    print(f"\n{customer.get_customer_info()}")
    print(f"Number of Orders: {len(customer.get_orders())}")

# Display all products
print("\n=== Product Catalog ===")
for product in ecommerce.get_all_products():
    print(f"{product.get_info()}")

# Demonstrate polymorphism
print("\n=== Polymorphism Example ===")
products = [laptop, shirt, phone, jeans]
for product in products:
    print(f"{product.get_product_type()}: {product.name}")

# Demonstrate encapsulation
print(f"\n=== Encapsulation Example ===")
print(f"Customer 1 total spent: ${customer1.get_total_spent()}")
print(f"Customer 1 email update: {customer1.update_email('john.doe@newemail.com')}")
print(f"Customer 1 new email: {customer1.get_email()}") 