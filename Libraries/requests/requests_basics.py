# Requests Library Basics Example
# Demonstrates: HTTP requests, API calls, web scraping, error handling

import requests
import json
import time
from urllib.parse import urlencode

print("=== Requests Library Basics Example ===\n")

# 1. Basic GET Request
print("1. Basic GET Request:")
print("-" * 30)

try:
    # Simple GET request
    response = requests.get('https://httpbin.org/get')
    print(f"Status Code: {response.status_code}")
    print(f"Response Headers: {dict(response.headers)}")
    print(f"Response Content (first 200 chars): {response.text[:200]}")
    
    # Check if request was successful
    response.raise_for_status()
    print("✅ Request successful!")
    
except requests.exceptions.RequestException as e:
    print(f"❌ Request failed: {e}")

# 2. GET Request with Parameters
print("\n2. GET Request with Parameters:")
print("-" * 30)

try:
    # Parameters for the request
    params = {
        'name': 'John Doe',
        'age': 30,
        'city': 'New York'
    }
    
    # GET request with parameters
    response = requests.get('https://httpbin.org/get', params=params)
    
    if response.status_code == 200:
        data = response.json()
        print("Request URL:", data['url'])
        print("Request Args:", data['args'])
        print("✅ Request with parameters successful!")
    
except requests.exceptions.RequestException as e:
    print(f"❌ Request failed: {e}")

# 3. POST Request
print("\n3. POST Request:")
print("-" * 30)

try:
    # Data to send
    post_data = {
        'username': 'testuser',
        'email': 'test@example.com',
        'message': 'Hello from Python requests!'
    }
    
    # POST request
    response = requests.post('https://httpbin.org/post', data=post_data)
    
    if response.status_code == 200:
        data = response.json()
        print("Sent Data:", data['form'])
        print("✅ POST request successful!")
    
except requests.exceptions.RequestException as e:
    print(f"❌ Request failed: {e}")

# 4. POST Request with JSON
print("\n4. POST Request with JSON:")
print("-" * 30)

try:
    # JSON data
    json_data = {
        'title': 'Sample Post',
        'body': 'This is the body of the post',
        'userId': 1
    }
    
    # POST request with JSON
    response = requests.post('https://httpbin.org/post', json=json_data)
    
    if response.status_code == 200:
        data = response.json()
        print("Sent JSON:", data['json'])
        print("✅ POST request with JSON successful!")
    
except requests.exceptions.RequestException as e:
    print(f"❌ Request failed: {e}")

# 5. Custom Headers
print("\n5. Custom Headers:")
print("-" * 30)

try:
    # Custom headers
    headers = {
        'User-Agent': 'Python Requests Example/1.0',
        'Accept': 'application/json',
        'Authorization': 'Bearer dummy-token-12345'
    }
    
    # Request with custom headers
    response = requests.get('https://httpbin.org/headers', headers=headers)
    
    if response.status_code == 200:
        data = response.json()
        print("Request Headers:", data['headers'])
        print("✅ Request with custom headers successful!")
    
except requests.exceptions.RequestException as e:
    print(f"❌ Request failed: {e}")

# 6. Session Management
print("\n6. Session Management:")
print("-" * 30)

try:
    # Create a session
    session = requests.Session()
    
    # Set default headers for the session
    session.headers.update({
        'User-Agent': 'Python Session Example/1.0',
        'Accept': 'application/json'
    })
    
    # Multiple requests using the same session
    print("Making multiple requests with session...")
    
    # First request
    response1 = session.get('https://httpbin.org/get')
    print(f"Request 1 - Status: {response1.status_code}")
    
    # Second request (session maintains cookies and headers)
    response2 = session.get('https://httpbin.org/cookies/set?session_id=12345')
    print(f"Request 2 - Status: {response2.status_code}")
    
    # Third request to check cookies
    response3 = session.get('https://httpbin.org/cookies')
    if response3.status_code == 200:
        cookies = response3.json()
        print("Session Cookies:", cookies['cookies'])
    
    print("✅ Session management successful!")
    
except requests.exceptions.RequestException as e:
    print(f"❌ Request failed: {e}")

# 7. Error Handling
print("\n7. Error Handling:")
print("-" * 30)

# Test different types of errors
test_urls = [
    'https://httpbin.org/status/404',  # 404 error
    'https://httpbin.org/status/500',  # 500 error
    'https://httpbin.org/delay/3',     # Timeout
    'https://invalid-url-that-does-not-exist.com'  # Connection error
]

for url in test_urls:
    try:
        print(f"\nTesting: {url}")
        response = requests.get(url, timeout=5)
        response.raise_for_status()
        print("✅ Request successful")
        
    except requests.exceptions.HTTPError as e:
        print(f"❌ HTTP Error: {e}")
    except requests.exceptions.ConnectionError as e:
        print(f"❌ Connection Error: {e}")
    except requests.exceptions.Timeout as e:
        print(f"❌ Timeout Error: {e}")
    except requests.exceptions.RequestException as e:
        print(f"❌ Request Exception: {e}")

# 8. File Download
print("\n8. File Download:")
print("-" * 30)

try:
    # Download a small file
    url = "https://httpbin.org/bytes/1024"  # 1KB of random data
    response = requests.get(url, stream=True)
    
    if response.status_code == 200:
        # Save the file
        filename = "Libraries/requests/downloaded_file.bin"
        with open(filename, 'wb') as f:
            for chunk in response.iter_content(chunk_size=8192):
                f.write(chunk)
        
        print(f"✅ File downloaded successfully: {filename}")
        print(f"File size: {len(response.content)} bytes")
    
except requests.exceptions.RequestException as e:
    print(f"❌ Download failed: {e}")

# 9. API Example (JSONPlaceholder)
print("\n9. API Example (JSONPlaceholder):")
print("-" * 30)

try:
    # Get posts from JSONPlaceholder API
    response = requests.get('https://jsonplaceholder.typicode.com/posts')
    
    if response.status_code == 200:
        posts = response.json()
        print(f"✅ Retrieved {len(posts)} posts from API")
        
        # Display first 3 posts
        for i, post in enumerate(posts[:3]):
            print(f"\nPost {i+1}:")
            print(f"  Title: {post['title']}")
            print(f"  Author ID: {post['userId']}")
            print(f"  Body: {post['body'][:100]}...")
    
except requests.exceptions.RequestException as e:
    print(f"❌ API request failed: {e}")

# 10. Rate Limiting and Delays
print("\n10. Rate Limiting and Delays:")
print("-" * 30)

try:
    print("Making requests with delays to be respectful...")
    
    for i in range(3):
        response = requests.get('https://httpbin.org/get')
        print(f"Request {i+1}: Status {response.status_code}")
        
        if i < 2:  # Don't sleep after the last request
            print("Waiting 1 second...")
            time.sleep(1)
    
    print("✅ Rate-limited requests completed!")
    
except requests.exceptions.RequestException as e:
    print(f"❌ Request failed: {e}")

# 11. Response Object Properties
print("\n11. Response Object Properties:")
print("-" * 30)

try:
    response = requests.get('https://httpbin.org/get')
    
    print("Response Properties:")
    print(f"  Status Code: {response.status_code}")
    print(f"  Reason: {response.reason}")
    print(f"  URL: {response.url}")
    print(f"  Encoding: {response.encoding}")
    print(f"  Content Type: {response.headers.get('content-type', 'Not specified')}")
    print(f"  Content Length: {len(response.content)} bytes")
    print(f"  Elapsed Time: {response.elapsed.total_seconds():.3f} seconds")
    
    # Check if response is JSON
    if 'application/json' in response.headers.get('content-type', ''):
        print("  Is JSON: Yes")
        data = response.json()
        print(f"  JSON Keys: {list(data.keys())}")
    else:
        print("  Is JSON: No")
    
    print("✅ Response properties displayed!")
    
except requests.exceptions.RequestException as e:
    print(f"❌ Request failed: {e}")

print("\n=== Requests Library Basics Complete ===")
print("All examples demonstrate proper error handling and best practices") 