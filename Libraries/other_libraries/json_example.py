# JSON Library Example
# Demonstrates: JSON serialization, deserialization, file operations, custom encoders

import json
import datetime
from decimal import Decimal
from typing import Dict, List, Any

print("=== JSON Library Example ===\n")

# 1. Basic JSON Operations
print("1. Basic JSON Operations:")
print("-" * 30)

# Python dictionary to JSON string
python_dict = {
    "name": "John Doe",
    "age": 30,
    "city": "New York",
    "is_student": False,
    "grades": [85, 92, 78, 96],
    "address": {
        "street": "123 Main St",
        "zipcode": "10001"
    }
}

# Serialize to JSON string
json_string = json.dumps(python_dict, indent=2)
print("Python dict to JSON string:")
print(json_string)

# Deserialize JSON string to Python object
parsed_dict = json.loads(json_string)
print(f"\nJSON string back to Python dict: {type(parsed_dict)}")
print(f"Name: {parsed_dict['name']}")
print(f"Age: {parsed_dict['age']}")

# 2. JSON File Operations
print("\n2. JSON File Operations:")
print("-" * 30)

# Write JSON to file
with open('Libraries/other_libraries/data.json', 'w') as f:
    json.dump(python_dict, f, indent=2)
print("✅ JSON data written to file")

# Read JSON from file
with open('Libraries/other_libraries/data.json', 'r') as f:
    loaded_data = json.load(f)
print("✅ JSON data loaded from file")
print(f"Loaded data type: {type(loaded_data)}")
print(f"Name from file: {loaded_data['name']}")

# 3. Complex Data Types
print("\n3. Complex Data Types:")
print("-" * 30)

# Complex data structure
complex_data = {
    "users": [
        {
            "id": 1,
            "name": "Alice",
            "email": "alice@example.com",
            "preferences": {
                "theme": "dark",
                "notifications": True,
                "language": "en"
            }
        },
        {
            "id": 2,
            "name": "Bob",
            "email": "bob@example.com",
            "preferences": {
                "theme": "light",
                "notifications": False,
                "language": "es"
            }
        }
    ],
    "metadata": {
        "total_users": 2,
        "created_at": "2024-01-01T00:00:00Z",
        "version": "1.0.0"
    }
}

# Serialize complex data
complex_json = json.dumps(complex_data, indent=2)
print("Complex data serialized:")
print(complex_json[:300] + "...")

# 4. Custom JSON Encoder
print("\n4. Custom JSON Encoder:")
print("-" * 30)

class CustomEncoder(json.JSONEncoder):
    """Custom JSON encoder for special types"""
    
    def default(self, obj):
        if isinstance(obj, datetime.datetime):
            return obj.isoformat()
        elif isinstance(obj, Decimal):
            return float(obj)
        elif hasattr(obj, '__dict__'):
            return obj.__dict__
        return super().default(obj)

# Data with custom types
custom_data = {
    "timestamp": datetime.datetime.now(),
    "price": Decimal("19.99"),
    "items": ["item1", "item2", "item3"]
}

# Serialize with custom encoder
custom_json = json.dumps(custom_data, cls=CustomEncoder, indent=2)
print("Custom types serialized:")
print(custom_json)

# 5. JSON with Different Formats
print("\n5. JSON with Different Formats:")
print("-" * 30)

# Compact format (no indentation)
compact_json = json.dumps(python_dict, separators=(',', ':'))
print("Compact JSON:")
print(compact_json)

# Pretty format with custom separators
pretty_json = json.dumps(python_dict, indent=4, separators=(',', ': '))
print("\nPretty JSON:")
print(pretty_json)

# 6. JSON Schema Validation (simulated)
print("\n6. JSON Schema Validation:")
print("-" * 30)

def validate_user_data(data: Dict[str, Any]) -> bool:
    """Simple validation function"""
    required_fields = ['name', 'age', 'email']
    
    for field in required_fields:
        if field not in data:
            print(f"❌ Missing required field: {field}")
            return False
    
    if not isinstance(data['age'], int) or data['age'] < 0:
        print("❌ Age must be a positive integer")
        return False
    
    if '@' not in data['email']:
        print("❌ Invalid email format")
        return False
    
    print("✅ Data validation passed")
    return True

# Test validation
valid_user = {
    "name": "Jane Doe",
    "age": 25,
    "email": "jane@example.com"
}

invalid_user = {
    "name": "John Doe",
    "age": -5,
    "email": "invalid-email"
}

print("Testing valid user:")
validate_user_data(valid_user)

print("\nTesting invalid user:")
validate_user_data(invalid_user)

# 7. JSON Array Operations
print("\n7. JSON Array Operations:")
print("-" * 30)

# Array of objects
users_array = [
    {"id": 1, "name": "Alice", "role": "admin"},
    {"id": 2, "name": "Bob", "role": "user"},
    {"id": 3, "name": "Charlie", "role": "user"}
]

# Serialize array
array_json = json.dumps(users_array, indent=2)
print("Users array as JSON:")
print(array_json)

# Parse array
parsed_array = json.loads(array_json)
print(f"\nParsed array type: {type(parsed_array)}")
print(f"Number of users: {len(parsed_array)}")

# Filter array
admin_users = [user for user in parsed_array if user['role'] == 'admin']
print(f"Admin users: {admin_users}")

# 8. JSON with Unicode
print("\n8. JSON with Unicode:")
print("-" * 30)

# Data with Unicode characters
unicode_data = {
    "message": "Hello, 世界! 🌍",
    "emoji": "🚀 Python is awesome! 🐍",
    "special_chars": "áéíóú ñ ü"
}

# Serialize with Unicode support
unicode_json = json.dumps(unicode_data, indent=2, ensure_ascii=False)
print("Unicode JSON:")
print(unicode_json)

# 9. JSON Error Handling
print("\n9. JSON Error Handling:")
print("-" * 30)

# Invalid JSON strings
invalid_json_strings = [
    '{"name": "John", "age": 30,}',  # Trailing comma
    '{"name": "John", "age": "30"}',  # Valid but age as string
    '{"name": "John", age: 30}',      # Missing quotes
    '{"name": "John", "age": 30'      # Missing closing brace
]

for i, invalid_json in enumerate(invalid_json_strings, 1):
    try:
        parsed = json.loads(invalid_json)
        print(f"✅ JSON {i} parsed successfully: {parsed}")
    except json.JSONDecodeError as e:
        print(f"❌ JSON {i} decode error: {e}")

# 10. JSON Performance Example
print("\n10. JSON Performance Example:")
print("-" * 30)

import time

# Large data structure
large_data = {
    "items": [
        {
            "id": i,
            "name": f"Item {i}",
            "description": f"Description for item {i}",
            "price": round(i * 1.5, 2),
            "category": f"Category {i % 5}"
        }
        for i in range(1000)
    ]
}

# Measure serialization time
start_time = time.time()
large_json = json.dumps(large_data)
serialization_time = time.time() - start_time

# Measure deserialization time
start_time = time.time()
parsed_large_data = json.loads(large_json)
deserialization_time = time.time() - start_time

print(f"Serialization time: {serialization_time:.4f} seconds")
print(f"Deserialization time: {deserialization_time:.4f} seconds")
print(f"JSON size: {len(large_json)} characters")
print(f"Number of items: {len(large_data['items'])}")

# 11. JSON Configuration Example
print("\n11. JSON Configuration Example:")
print("-" * 30)

# Configuration data
config = {
    "database": {
        "host": "localhost",
        "port": 5432,
        "name": "myapp",
        "user": "admin",
        "password": "secret123"
    },
    "server": {
        "host": "0.0.0.0",
        "port": 8000,
        "debug": True,
        "timeout": 30
    },
    "logging": {
        "level": "INFO",
        "file": "app.log",
        "max_size": "10MB"
    }
}

# Save configuration
with open('Libraries/other_libraries/config.json', 'w') as f:
    json.dump(config, f, indent=2)
print("✅ Configuration saved to file")

# Load configuration
with open('Libraries/other_libraries/config.json', 'r') as f:
    loaded_config = json.load(f)
print("✅ Configuration loaded from file")

# Access configuration values
db_host = loaded_config['database']['host']
server_port = loaded_config['server']['port']
log_level = loaded_config['logging']['level']

print(f"Database host: {db_host}")
print(f"Server port: {server_port}")
print(f"Log level: {log_level}")

print("\n=== JSON Library Example Complete ===")
print("All JSON operations demonstrated successfully") 