# Datetime Library Example
# Demonstrates: Date/time creation, formatting, calculations, timezones

from datetime import datetime, date, time, timedelta
import time as time_module
import calendar

print("=== Datetime Library Example ===\n")

# 1. Basic Date and Time Creation
print("1. Basic Date and Time Creation:")
print("-" * 30)

# Current date and time
now = datetime.now()
print(f"Current datetime: {now}")
print(f"Current date: {now.date()}")
print(f"Current time: {now.time()}")

# Create specific date and time
specific_date = date(2024, 6, 15)
specific_time = time(14, 30, 45)
specific_datetime = datetime(2024, 6, 15, 14, 30, 45)

print(f"\nSpecific date: {specific_date}")
print(f"Specific time: {specific_time}")
print(f"Specific datetime: {specific_datetime}")

# 2. Date and Time Formatting
print("\n2. Date and Time Formatting:")
print("-" * 30)

# Format datetime objects
formats = [
    "%Y-%m-%d %H:%M:%S",
    "%B %d, %Y",
    "%d/%m/%Y",
    "%Y-%m-%d",
    "%H:%M:%S",
    "%I:%M %p",
    "%A, %B %d, %Y",
    "%Y-%m-%d %H:%M:%S %Z"
]

print("Different date/time formats:")
for fmt in formats:
    try:
        formatted = now.strftime(fmt)
        print(f"  {fmt}: {formatted}")
    except ValueError:
        print(f"  {fmt}: Invalid format")

# Parse string to datetime
date_string = "2024-06-15 14:30:45"
parsed_datetime = datetime.strptime(date_string, "%Y-%m-%d %H:%M:%S")
print(f"\nParsed datetime: {parsed_datetime}")

# 3. Date and Time Calculations
print("\n3. Date and Time Calculations:")
print("-" * 30)

# Adding and subtracting time
tomorrow = now + timedelta(days=1)
yesterday = now - timedelta(days=1)
next_week = now + timedelta(weeks=1)
next_month = now + timedelta(days=30)

print(f"Tomorrow: {tomorrow.date()}")
print(f"Yesterday: {yesterday.date()}")
print(f"Next week: {next_week.date()}")
print(f"Next month: {next_month.date()}")

# Time differences
future_date = datetime(2024, 12, 31)
time_diff = future_date - now
print(f"\nDays until 2024 ends: {time_diff.days}")
print(f"Total seconds until 2024 ends: {time_diff.total_seconds():.0f}")

# 4. Date Components
print("\n4. Date Components:")
print("-" * 30)

print(f"Year: {now.year}")
print(f"Month: {now.month}")
print(f"Day: {now.day}")
print(f"Hour: {now.hour}")
print(f"Minute: {now.minute}")
print(f"Second: {now.second}")
print(f"Microsecond: {now.microsecond}")
print(f"Weekday (0=Monday): {now.weekday()}")
print(f"Weekday (1=Sunday): {now.isoweekday()}")
print(f"Day of year: {now.timetuple().tm_yday}")

# 5. Calendar Operations
print("\n5. Calendar Operations:")
print("-" * 30)

# Check if leap year
year = 2024
is_leap = calendar.isleap(year)
print(f"{year} is leap year: {is_leap}")

# Get month calendar
month_cal = calendar.monthcalendar(year, 6)
print(f"\nCalendar for June {year}:")
for week in month_cal:
    print(f"  {week}")

# Get month name and weekday names
print(f"\nMonth name: {calendar.month_name[6]}")
print(f"Weekday names: {list(calendar.day_name)}")

# 6. Time Arithmetic
print("\n6. Time Arithmetic:")
print("-" * 30)

# Working with timedelta
delta1 = timedelta(days=5, hours=3, minutes=30)
delta2 = timedelta(days=2, hours=1, minutes=45)

print(f"Delta 1: {delta1}")
print(f"Delta 2: {delta2}")
print(f"Delta 1 + Delta 2: {delta1 + delta2}")
print(f"Delta 1 - Delta 2: {delta1 - delta2}")
print(f"Delta 1 * 2: {delta1 * 2}")

# Time calculations
start_time = datetime(2024, 6, 1, 9, 0, 0)
end_time = datetime(2024, 6, 1, 17, 30, 0)
work_duration = end_time - start_time

print(f"\nWork start: {start_time}")
print(f"Work end: {end_time}")
print(f"Work duration: {work_duration}")
print(f"Work hours: {work_duration.total_seconds() / 3600:.2f}")

# 7. Date Ranges and Iteration
print("\n7. Date Ranges and Iteration:")
print("-" * 30)

# Generate date range
start_date = date(2024, 6, 1)
end_date = date(2024, 6, 10)

current_date = start_date
print("Date range:")
while current_date <= end_date:
    print(f"  {current_date.strftime('%Y-%m-%d')} ({current_date.strftime('%A')})")
    current_date += timedelta(days=1)

# 8. Working with Timestamps
print("\n8. Working with Timestamps:")
print("-" * 30)

# Current timestamp
timestamp = time_module.time()
print(f"Current timestamp: {timestamp}")

# Convert timestamp to datetime
dt_from_timestamp = datetime.fromtimestamp(timestamp)
print(f"Datetime from timestamp: {dt_from_timestamp}")

# Convert datetime to timestamp
timestamp_from_dt = now.timestamp()
print(f"Timestamp from datetime: {timestamp_from_dt}")

# 9. Date Validation and Error Handling
print("\n9. Date Validation and Error Handling:")
print("-" * 30)

# Valid dates
valid_dates = [
    "2024-06-15",
    "2024-02-29",  # Leap year
    "2024-12-31"
]

# Invalid dates
invalid_dates = [
    "2024-13-01",  # Invalid month
    "2024-02-30",  # Invalid day for February
    "2023-02-29",  # Not a leap year
    "invalid-date"
]

print("Testing valid dates:")
for date_str in valid_dates:
    try:
        parsed_date = datetime.strptime(date_str, "%Y-%m-%d")
        print(f"  ✅ {date_str}: {parsed_date.date()}")
    except ValueError as e:
        print(f"  ❌ {date_str}: {e}")

print("\nTesting invalid dates:")
for date_str in invalid_dates:
    try:
        parsed_date = datetime.strptime(date_str, "%Y-%m-%d")
        print(f"  ✅ {date_str}: {parsed_date.date()}")
    except ValueError as e:
        print(f"  ❌ {date_str}: {e}")

# 10. Business Day Calculations
print("\n10. Business Day Calculations:")
print("-" * 30)

def is_business_day(dt):
    """Check if date is a business day (Monday-Friday)"""
    return dt.weekday() < 5

def add_business_days(start_date, business_days):
    """Add business days to a date"""
    current_date = start_date
    added_days = 0
    
    while added_days < business_days:
        current_date += timedelta(days=1)
        if is_business_day(current_date):
            added_days += 1
    
    return current_date

# Test business day calculations
start_business = date(2024, 6, 10)  # Monday
print(f"Start date: {start_business} ({start_business.strftime('%A')})")

for days in [1, 3, 5, 10]:
    result = add_business_days(start_business, days)
    print(f"  +{days} business days: {result} ({result.strftime('%A')})")

# 11. Age Calculation
print("\n11. Age Calculation:")
print("-" * 30)

def calculate_age(birth_date):
    """Calculate age from birth date"""
    today = date.today()
    age = today.year - birth_date.year
    
    # Check if birthday has occurred this year
    if today.month < birth_date.month or (today.month == birth_date.month and today.day < birth_date.day):
        age -= 1
    
    return age

# Test age calculation
birth_dates = [
    date(1990, 5, 15),
    date(2000, 12, 25),
    date(1985, 3, 10)
]

for birth_date in birth_dates:
    age = calculate_age(birth_date)
    print(f"Birth date: {birth_date}, Age: {age}")

# 12. Date Formatting Examples
print("\n12. Date Formatting Examples:")
print("-" * 30)

# Different locale-style formats
formats_with_examples = [
    ("%Y-%m-%d", "ISO format"),
    ("%m/%d/%Y", "US format"),
    ("%d/%m/%Y", "European format"),
    ("%B %d, %Y", "Long format"),
    ("%b %d, %Y", "Short month format"),
    ("%Y-%m-%d %H:%M:%S", "Full datetime"),
    ("%I:%M %p", "12-hour time"),
    ("%H:%M", "24-hour time"),
    ("%A, %B %d, %Y", "Full weekday format")
]

print("Format examples:")
for fmt, description in formats_with_examples:
    formatted = now.strftime(fmt)
    print(f"  {description:20}: {formatted}")

print("\n=== Datetime Library Example Complete ===")
print("All datetime operations demonstrated successfully") 