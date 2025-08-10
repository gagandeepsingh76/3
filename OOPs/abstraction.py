# Abstraction Example
# Demonstrates: Abstract base classes, hiding implementation details, simple interfaces

from abc import ABC, abstractmethod

class Database(ABC):
    """Abstract base class for database operations"""
    
    @abstractmethod
    def connect(self):
        """Abstract method to connect to database"""
        pass
    
    @abstractmethod
    def disconnect(self):
        """Abstract method to disconnect from database"""
        pass
    
    @abstractmethod
    def execute_query(self, query):
        """Abstract method to execute a query"""
        pass
    
    @abstractmethod
    def fetch_data(self):
        """Abstract method to fetch data"""
        pass

class MySQLDatabase(Database):
    """Concrete implementation of MySQL database"""
    
    def __init__(self, host, port, username, password, database):
        self.host = host
        self.port = port
        self.username = username
        self.password = password
        self.database = database
        self.connection = None
    
    def connect(self):
        """Connect to MySQL database"""
        # Simulating complex connection logic
        print(f"Connecting to MySQL at {self.host}:{self.port}")
        print(f"Authenticating user: {self.username}")
        print("Establishing secure connection...")
        self.connection = "MySQL_Connection_Object"
        return "Connected to MySQL successfully"
    
    def disconnect(self):
        """Disconnect from MySQL database"""
        if self.connection:
            print("Closing MySQL connection...")
            print("Cleaning up resources...")
            self.connection = None
            return "Disconnected from MySQL"
        return "No active connection"
    
    def execute_query(self, query):
        """Execute MySQL query"""
        if not self.connection:
            return "Error: Not connected to database"
        
        print(f"Executing MySQL query: {query}")
        print("Query optimization in progress...")
        print("Executing query with MySQL engine...")
        return f"Query executed successfully: {query}"
    
    def fetch_data(self):
        """Fetch data from MySQL"""
        if not self.connection:
            return "Error: Not connected to database"
        
        print("Fetching data from MySQL...")
        print("Processing result set...")
        return ["row1", "row2", "row3"]  # Simulated data

class PostgreSQLDatabase(Database):
    """Concrete implementation of PostgreSQL database"""
    
    def __init__(self, host, port, username, password, database):
        self.host = host
        self.port = port
        self.username = username
        self.password = password
        self.database = database
        self.connection = None
    
    def connect(self):
        """Connect to PostgreSQL database"""
        # Simulating complex connection logic
        print(f"Connecting to PostgreSQL at {self.host}:{self.port}")
        print(f"Authenticating user: {self.username}")
        print("Establishing secure connection...")
        self.connection = "PostgreSQL_Connection_Object"
        return "Connected to PostgreSQL successfully"
    
    def disconnect(self):
        """Disconnect from PostgreSQL database"""
        if self.connection:
            print("Closing PostgreSQL connection...")
            print("Cleaning up resources...")
            self.connection = None
            return "Disconnected from PostgreSQL"
        return "No active connection"
    
    def execute_query(self, query):
        """Execute PostgreSQL query"""
        if not self.connection:
            return "Error: Not connected to database"
        
        print(f"Executing PostgreSQL query: {query}")
        print("Query optimization in progress...")
        print("Executing query with PostgreSQL engine...")
        return f"Query executed successfully: {query}"
    
    def fetch_data(self):
        """Fetch data from PostgreSQL"""
        if not self.connection:
            return "Error: Not connected to database"
        
        print("Fetching data from PostgreSQL...")
        print("Processing result set...")
        return ["record1", "record2", "record3"]  # Simulated data

# Abstraction with Vehicle example
class Vehicle(ABC):
    """Abstract base class for vehicles"""
    
    def __init__(self, brand, model, year):
        self.brand = brand
        self.model = model
        self.year = year
    
    @abstractmethod
    def start_engine(self):
        """Abstract method to start engine"""
        pass
    
    @abstractmethod
    def stop_engine(self):
        """Abstract method to stop engine"""
        pass
    
    def get_info(self):
        """Common method for all vehicles"""
        return f"{self.year} {self.brand} {self.model}"

class Car(Vehicle):
    """Concrete implementation of Car"""
    
    def __init__(self, brand, model, year, fuel_type):
        super().__init__(brand, model, year)
        self.fuel_type = fuel_type
        self.engine_running = False
    
    def start_engine(self):
        """Start car engine"""
        if not self.engine_running:
            print("Inserting key...")
            print("Turning ignition...")
            print("Engine starting...")
            print("Checking fuel level...")
            self.engine_running = True
            return f"{self.get_info()} engine started"
        return "Engine is already running"
    
    def stop_engine(self):
        """Stop car engine"""
        if self.engine_running:
            print("Turning off ignition...")
            print("Engine stopping...")
            print("Removing key...")
            self.engine_running = False
            return f"{self.get_info()} engine stopped"
        return "Engine is already stopped"

class Motorcycle(Vehicle):
    """Concrete implementation of Motorcycle"""
    
    def __init__(self, brand, model, year, engine_size):
        super().__init__(brand, model, year)
        self.engine_size = engine_size
        self.engine_running = False
    
    def start_engine(self):
        """Start motorcycle engine"""
        if not self.engine_running:
            print("Kicking starter...")
            print("Engine starting...")
            print("Checking oil level...")
            self.engine_running = True
            return f"{self.get_info()} engine started"
        return "Engine is already running"
    
    def stop_engine(self):
        """Stop motorcycle engine"""
        if self.engine_running:
            print("Turning off engine...")
            print("Engine stopping...")
            self.engine_running = False
            return f"{self.get_info()} engine stopped"
        return "Engine is already stopped"

# Testing abstraction
print("=== Abstraction Example ===")

# Database abstraction
print("Database Abstraction:")
databases = [
    MySQLDatabase("localhost", 3306, "user", "pass", "mydb"),
    PostgreSQLDatabase("localhost", 5432, "user", "pass", "mydb")
]

for db in databases:
    print(f"\n{db.__class__.__name__}:")
    print(db.connect())
    print(db.execute_query("SELECT * FROM users"))
    print(db.fetch_data())
    print(db.disconnect())

# Vehicle abstraction
print("\nVehicle Abstraction:")
vehicles = [
    Car("Toyota", "Camry", 2022, "Gasoline"),
    Motorcycle("Honda", "CBR600", 2021, "600cc")
]

for vehicle in vehicles:
    print(f"\n{vehicle.__class__.__name__}:")
    print(vehicle.get_info())
    print(vehicle.start_engine())
    print(vehicle.stop_engine())

# Simple interface example
print("\n=== Simple Interface Example ===")

class Calculator:
    """Simple calculator interface"""
    
    def add(self, a, b):
        """Simple addition interface"""
        return a + b
    
    def subtract(self, a, b):
        """Simple subtraction interface"""
        return a - b
    
    def multiply(self, a, b):
        """Simple multiplication interface"""
        return a * b
    
    def divide(self, a, b):
        """Simple division interface with error handling"""
        if b == 0:
            return "Error: Division by zero"
        return a / b

# Using the simple interface
calc = Calculator()
print(f"5 + 3 = {calc.add(5, 3)}")
print(f"10 - 4 = {calc.subtract(10, 4)}")
print(f"6 * 7 = {calc.multiply(6, 7)}")
print(f"15 / 3 = {calc.divide(15, 3)}")
print(f"10 / 0 = {calc.divide(10, 0)}") 