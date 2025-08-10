# Matplotlib Basics Example
# Demonstrates: Line plots, scatter plots, bar charts, histograms, customization

import matplotlib.pyplot as plt
import numpy as np
import pandas as pd

# Set style for better looking plots
plt.style.use('default')

print("=== Matplotlib Basics Example ===\n")

# 1. Basic Line Plot
print("1. Basic Line Plot:")
print("-" * 30)

# Generate data
x = np.linspace(0, 10, 100)
y = np.sin(x)

# Create figure and axis
fig, ax = plt.subplots(figsize=(10, 6))

# Plot the data
ax.plot(x, y, 'b-', linewidth=2, label='sin(x)')
ax.plot(x, np.cos(x), 'r--', linewidth=2, label='cos(x)')

# Customize the plot
ax.set_xlabel('X-axis', fontsize=12)
ax.set_ylabel('Y-axis', fontsize=12)
ax.set_title('Sine and Cosine Functions', fontsize=14, fontweight='bold')
ax.legend()
ax.grid(True, alpha=0.3)

# Save the plot
plt.savefig('Libraries/matplotlib/line_plot.png', dpi=300, bbox_inches='tight')
print("Line plot saved as 'line_plot.png'")

# 2. Scatter Plot
print("\n2. Scatter Plot:")
print("-" * 30)

# Generate random data
np.random.seed(42)
x_scatter = np.random.randn(50)
y_scatter = 2 * x_scatter + np.random.randn(50) * 0.5

# Create scatter plot
fig, ax = plt.subplots(figsize=(8, 6))
scatter = ax.scatter(x_scatter, y_scatter, c=np.random.rand(50), 
                    s=100, alpha=0.6, cmap='viridis')

ax.set_xlabel('X values')
ax.set_ylabel('Y values')
ax.set_title('Scatter Plot with Color Mapping')
plt.colorbar(scatter, label='Color values')

plt.savefig('Libraries/matplotlib/scatter_plot.png', dpi=300, bbox_inches='tight')
print("Scatter plot saved as 'scatter_plot.png'")

# 3. Bar Chart
print("\n3. Bar Chart:")
print("-" * 30)

# Data for bar chart
categories = ['A', 'B', 'C', 'D', 'E']
values = [23, 45, 56, 78, 32]

fig, ax = plt.subplots(figsize=(8, 6))
bars = ax.bar(categories, values, color=['red', 'blue', 'green', 'orange', 'purple'], alpha=0.7)

# Add value labels on bars
for bar, value in zip(bars, values):
    height = bar.get_height()
    ax.text(bar.get_x() + bar.get_width()/2., height + 1,
            f'{value}', ha='center', va='bottom')

ax.set_xlabel('Categories')
ax.set_ylabel('Values')
ax.set_title('Bar Chart Example')
ax.grid(True, alpha=0.3)

plt.savefig('Libraries/matplotlib/bar_chart.png', dpi=300, bbox_inches='tight')
print("Bar chart saved as 'bar_chart.png'")

# 4. Histogram
print("\n4. Histogram:")
print("-" * 30)

# Generate random data for histogram
data = np.random.normal(0, 1, 1000)

fig, ax = plt.subplots(figsize=(8, 6))
ax.hist(data, bins=30, alpha=0.7, color='skyblue', edgecolor='black')

ax.set_xlabel('Values')
ax.set_ylabel('Frequency')
ax.set_title('Histogram of Normal Distribution')
ax.grid(True, alpha=0.3)

plt.savefig('Libraries/matplotlib/histogram.png', dpi=300, bbox_inches='tight')
print("Histogram saved as 'histogram.png'")

# 5. Subplots
print("\n5. Subplots:")
print("-" * 30)

# Create figure with subplots
fig, ((ax1, ax2), (ax3, ax4)) = plt.subplots(2, 2, figsize=(12, 8))

# Subplot 1: Line plot
x = np.linspace(0, 5, 100)
ax1.plot(x, np.exp(x), 'g-', linewidth=2)
ax1.set_title('Exponential Function')
ax1.grid(True, alpha=0.3)

# Subplot 2: Scatter plot
x_scat = np.random.rand(30)
y_scat = x_scat + np.random.rand(30) * 0.3
ax2.scatter(x_scat, y_scat, alpha=0.6)
ax2.set_title('Scatter Plot')
ax2.grid(True, alpha=0.3)

# Subplot 3: Bar plot
categories = ['X', 'Y', 'Z']
values = [10, 20, 15]
ax3.bar(categories, values, color=['red', 'blue', 'green'])
ax3.set_title('Simple Bar Chart')

# Subplot 4: Pie chart
sizes = [30, 25, 20, 15, 10]
labels = ['A', 'B', 'C', 'D', 'E']
colors = ['gold', 'lightcoral', 'lightblue', 'lightgreen', 'plum']
ax4.pie(sizes, labels=labels, colors=colors, autopct='%1.1f%%', startangle=90)
ax4.set_title('Pie Chart')

plt.tight_layout()
plt.savefig('Libraries/matplotlib/subplots.png', dpi=300, bbox_inches='tight')
print("Subplots saved as 'subplots.png'")

# 6. Custom Styling
print("\n6. Custom Styling:")
print("-" * 30)

# Create a more sophisticated plot
fig, ax = plt.subplots(figsize=(10, 6))

# Generate data
x = np.linspace(0, 4*np.pi, 200)
y1 = np.sin(x)
y2 = np.cos(x)
y3 = np.sin(x + np.pi/4)

# Plot with custom styling
ax.plot(x, y1, 'b-', linewidth=3, label='sin(x)', alpha=0.8)
ax.plot(x, y2, 'r--', linewidth=3, label='cos(x)', alpha=0.8)
ax.plot(x, y3, 'g-.', linewidth=3, label='sin(x + π/4)', alpha=0.8)

# Customize appearance
ax.set_xlabel('X (radians)', fontsize=12, fontweight='bold')
ax.set_ylabel('Y values', fontsize=12, fontweight='bold')
ax.set_title('Trigonometric Functions with Custom Styling', 
             fontsize=14, fontweight='bold', pad=20)

# Add legend with custom styling
ax.legend(loc='upper right', fontsize=11, frameon=True, 
          fancybox=True, shadow=True)

# Add grid
ax.grid(True, linestyle='--', alpha=0.7)

# Set axis limits and ticks
ax.set_xlim(0, 4*np.pi)
ax.set_ylim(-1.5, 1.5)
ax.set_xticks([0, np.pi, 2*np.pi, 3*np.pi, 4*np.pi])
ax.set_xticklabels(['0', 'π', '2π', '3π', '4π'])

# Add text annotation
ax.text(np.pi, 1.2, 'Peak at π', fontsize=10, ha='center',
        bbox=dict(boxstyle="round,pad=0.3", facecolor="yellow", alpha=0.7))

plt.tight_layout()
plt.savefig('Libraries/matplotlib/custom_styling.png', dpi=300, bbox_inches='tight')
print("Custom styled plot saved as 'custom_styling.png'")

# 7. Time Series Plot
print("\n7. Time Series Plot:")
print("-" * 30)

# Generate time series data
dates = pd.date_range('2024-01-01', periods=100, freq='D')
values = np.cumsum(np.random.randn(100)) + 100

fig, ax = plt.subplots(figsize=(12, 6))
ax.plot(dates, values, 'b-', linewidth=2)

ax.set_xlabel('Date')
ax.set_ylabel('Value')
ax.set_title('Time Series Plot')
ax.grid(True, alpha=0.3)

# Rotate x-axis labels for better readability
plt.xticks(rotation=45)

plt.tight_layout()
plt.savefig('Libraries/matplotlib/time_series.png', dpi=300, bbox_inches='tight')
print("Time series plot saved as 'time_series.png'")

print("\n=== Matplotlib Basics Complete ===")
print("All plots have been saved to the Libraries/matplotlib/ directory") 