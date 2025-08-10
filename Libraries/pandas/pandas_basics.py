# Pandas Basics Example
# Demonstrates: DataFrame creation, data manipulation, file I/O, basic operations

import pandas as pd
import numpy as np

print("=== Pandas Basics Example ===\n")

# 1. Creating DataFrames
print("1. Creating DataFrames:")
print("-" * 30)

# From dictionary
data_dict = {
    'Name': ['Alice', 'Bob', 'Charlie', 'Diana', 'Eve'],
    'Age': [25, 30, 35, 28, 32],
    'City': ['New York', 'Los Angeles', 'Chicago', 'Houston', 'Phoenix'],
    'Salary': [50000, 60000, 70000, 55000, 65000],
    'Department': ['IT', 'HR', 'IT', 'Marketing', 'Finance']
}

df = pd.DataFrame(data_dict)
print("DataFrame from dictionary:")
print(df)
print(f"Shape: {df.shape}")
print(f"Columns: {list(df.columns)}")
print(f"Data types:\n{df.dtypes}")

# From list of lists
data_list = [
    ['Product A', 100, 10.99],
    ['Product B', 50, 25.50],
    ['Product C', 200, 5.99],
    ['Product D', 75, 15.75]
]

df_products = pd.DataFrame(data_list, columns=['Product', 'Quantity', 'Price'])
print("\nDataFrame from list:")
print(df_products)

# 2. Reading and Writing Files
print("\n2. Reading and Writing Files:")
print("-" * 30)

# Create sample data for file operations
sample_data = {
    'Date': pd.date_range('2024-01-01', periods=10, freq='D'),
    'Sales': np.random.randint(1000, 10000, 10),
    'Profit': np.random.uniform(100, 1000, 10),
    'Region': ['North', 'South', 'East', 'West'] * 2 + ['North', 'South']
}

df_sales = pd.DataFrame(sample_data)

# Write to CSV
df_sales.to_csv('Libraries/pandas/sales_data.csv', index=False)
print("Data written to sales_data.csv")

# Read from CSV
df_read = pd.read_csv('Libraries/pandas/sales_data.csv')
print("Data read from CSV:")
print(df_read.head())

# 3. Basic Data Operations
print("\n3. Basic Data Operations:")
print("-" * 30)

# Selecting columns
print("Selecting specific columns:")
print(df[['Name', 'Age', 'Salary']].head())

# Filtering data
print("\nFiltering data (Age > 30):")
print(df[df['Age'] > 30])

print("\nFiltering data (Department == 'IT'):")
print(df[df['Department'] == 'IT'])

# Sorting data
print("\nSorting by Age (descending):")
print(df.sort_values('Age', ascending=False))

print("\nSorting by multiple columns:")
print(df.sort_values(['Department', 'Salary'], ascending=[True, False]))

# 4. Statistical Operations
print("\n4. Statistical Operations:")
print("-" * 30)

print("Basic statistics:")
print(df.describe())

print("\nGroup by Department:")
dept_stats = df.groupby('Department').agg({
    'Age': ['mean', 'min', 'max'],
    'Salary': ['mean', 'sum', 'count']
})
print(dept_stats)

print("\nCorrelation between Age and Salary:")
print(df['Age'].corr(df['Salary']))

# 5. Data Cleaning and Manipulation
print("\n5. Data Cleaning and Manipulation:")
print("-" * 30)

# Create data with missing values
df_missing = df.copy()
df_missing.loc[1, 'Age'] = np.nan
df_missing.loc[3, 'Salary'] = np.nan
df_missing.loc[2, 'City'] = None

print("Data with missing values:")
print(df_missing)

print("\nCheck for missing values:")
print(df_missing.isnull().sum())

print("\nFill missing values:")
df_cleaned = df_missing.fillna({
    'Age': df_missing['Age'].mean(),
    'Salary': df_missing['Salary'].median(),
    'City': 'Unknown'
})
print(df_cleaned)

# 6. Adding and Modifying Columns
print("\n6. Adding and Modifying Columns:")
print("-" * 30)

# Add new column
df['Salary_Range'] = df['Salary'].apply(lambda x: 'High' if x > 60000 else 'Low')
print("Added Salary_Range column:")
print(df[['Name', 'Salary', 'Salary_Range']])

# Conditional column
df['Age_Group'] = np.where(df['Age'] < 30, 'Young', 
                          np.where(df['Age'] < 35, 'Middle', 'Senior'))
print("\nAdded Age_Group column:")
print(df[['Name', 'Age', 'Age_Group']])

# 7. Index Operations
print("\n7. Index Operations:")
print("-" * 30)

# Set index
df_indexed = df.set_index('Name')
print("DataFrame with Name as index:")
print(df_indexed)

# Reset index
df_reset = df_indexed.reset_index()
print("\nReset index:")
print(df_reset)

# 8. Data Aggregation
print("\n8. Data Aggregation:")
print("-" * 30)

# Group by with multiple aggregations
agg_results = df.groupby('Department').agg({
    'Age': ['mean', 'std', 'count'],
    'Salary': ['mean', 'sum', 'min', 'max']
}).round(2)

print("Aggregated results by department:")
print(agg_results)

# Pivot table
pivot_table = df.pivot_table(
    values='Salary',
    index='Department',
    columns='Age_Group',
    aggfunc='mean',
    fill_value=0
)
print("\nPivot table (Salary by Department and Age Group):")
print(pivot_table)

print("\n=== Pandas Basics Complete ===") 