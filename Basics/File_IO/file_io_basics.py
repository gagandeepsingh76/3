# File I/O Basics Example
# Demonstrates: Reading/writing text, CSV, JSON, binary files, context managers, error handling

import csv
import json
import os

print("=== File I/O Basics Example ===\n")

# 1. Writing and Reading Text Files
print("1. Writing and Reading Text Files:")
print("-" * 30)

text_file = 'Basics/File_IO/sample.txt'

# Write text to file
with open(text_file, 'w', encoding='utf-8') as f:
    f.write("Hello, world!\n")
    f.write("This is a sample text file.\n")
    f.write("Python file I/O is easy!\n")
print(f"✅ Text written to {text_file}")

# Read text from file
with open(text_file, 'r', encoding='utf-8') as f:
    content = f.read()
print(f"Content of {text_file}:")
print(content)

# Read file line by line
with open(text_file, 'r', encoding='utf-8') as f:
    lines = f.readlines()
print("Lines read from file:")
for i, line in enumerate(lines, 1):
    print(f"  Line {i}: {line.strip()}")

# 2. Appending to a File
print("\n2. Appending to a File:")
print("-" * 30)

with open(text_file, 'a', encoding='utf-8') as f:
    f.write("Appended line.\n")
print(f"✅ Line appended to {text_file}")

# 3. Writing and Reading CSV Files
print("\n3. Writing and Reading CSV Files:")
print("-" * 30)

csv_file = 'Basics/File_IO/sample.csv'

# Data to write
csv_data = [
    ['Name', 'Age', 'City'],
    ['Alice', 25, 'New York'],
    ['Bob', 30, 'Los Angeles'],
    ['Charlie', 35, 'Chicago']
]

# Write CSV
with open(csv_file, 'w', newline='', encoding='utf-8') as f:
    writer = csv.writer(f)
    writer.writerows(csv_data)
print(f"✅ CSV data written to {csv_file}")

# Read CSV
with open(csv_file, 'r', encoding='utf-8') as f:
    reader = csv.reader(f)
    csv_content = list(reader)
print(f"Content of {csv_file}:")
for row in csv_content:
    print(row)

# 4. Writing and Reading JSON Files
print("\n4. Writing and Reading JSON Files:")
print("-" * 30)

json_file = 'Basics/File_IO/sample.json'

json_data = {
    'name': 'Alice',
    'age': 25,
    'city': 'New York',
    'skills': ['Python', 'Data Analysis', 'Machine Learning']
}

# Write JSON
with open(json_file, 'w', encoding='utf-8') as f:
    json.dump(json_data, f, indent=2)
print(f"✅ JSON data written to {json_file}")

# Read JSON
with open(json_file, 'r', encoding='utf-8') as f:
    loaded_json = json.load(f)
print(f"Content of {json_file}:")
print(loaded_json)

# 5. Working with Binary Files
print("\n5. Working with Binary Files:")
print("-" * 30)

binary_file = 'Basics/File_IO/sample.bin'

# Write binary data
with open(binary_file, 'wb') as f:
    f.write(b'\x00\x01\x02\x03\x04\x05')
    f.write(b'Hello in binary!')
print(f"✅ Binary data written to {binary_file}")

# Read binary data
with open(binary_file, 'rb') as f:
    binary_content = f.read()
print(f"Content of {binary_file} (raw bytes):")
print(binary_content)

# 6. Using Context Managers and Error Handling
print("\n6. Using Context Managers and Error Handling:")
print("-" * 30)

try:
    with open('Basics/File_IO/nonexistent.txt', 'r', encoding='utf-8') as f:
        data = f.read()
except FileNotFoundError as e:
    print(f"❌ File not found: {e}")

try:
    with open('Basics/File_IO/sample.txt', 'r', encoding='utf-8') as f:
        for line in f:
            print(f"Read line: {line.strip()}")
except Exception as e:
    print(f"❌ Error reading file: {e}")

# 7. Deleting a File
print("\n7. Deleting a File:")
print("-" * 30)

temp_file = 'Basics/File_IO/temp.txt'
with open(temp_file, 'w', encoding='utf-8') as f:
    f.write("Temporary file for deletion test.")

if os.path.exists(temp_file):
    os.remove(temp_file)
    print(f"✅ {temp_file} deleted successfully.")
else:
    print(f"❌ {temp_file} does not exist.")

print("\n=== File I/O Basics Complete ===")
print("All file operations demonstrated successfully.") 