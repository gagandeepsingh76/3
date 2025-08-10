# Seaborn Basics Example
# Demonstrates: Statistical plots, styling, distribution plots, correlation matrices

import seaborn as sns
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd

# Set seaborn style
sns.set_style("whitegrid")
sns.set_palette("husl")

print("=== Seaborn Basics Example ===\n")

# 1. Distribution Plots
print("1. Distribution Plots:")
print("-" * 30)

# Generate sample data
np.random.seed(42)
data1 = np.random.normal(0, 1, 1000)
data2 = np.random.normal(2, 1.5, 1000)

# Create figure with subplots
fig, axes = plt.subplots(2, 2, figsize=(12, 10))

# Histogram with KDE
sns.histplot(data1, kde=True, ax=axes[0,0])
axes[0,0].set_title('Histogram with KDE')

# Box plot
sns.boxplot(data=[data1, data2], ax=axes[0,1])
axes[0,1].set_title('Box Plot')
axes[0,1].set_xticklabels(['Data 1', 'Data 2'])

# Violin plot
sns.violinplot(data=[data1, data2], ax=axes[1,0])
axes[1,0].set_title('Violin Plot')
axes[1,0].set_xticklabels(['Data 1', 'Data 2'])

# KDE plot
sns.kdeplot(data1, label='Data 1', ax=axes[1,1])
sns.kdeplot(data2, label='Data 2', ax=axes[1,1])
axes[1,1].set_title('KDE Plot')
axes[1,1].legend()

plt.tight_layout()
plt.savefig('Libraries/seaborn/distribution_plots.png', dpi=300, bbox_inches='tight')
print("Distribution plots saved as 'distribution_plots.png'")

# 2. Regression Plots
print("\n2. Regression Plots:")
print("-" * 30)

# Generate correlated data
x = np.linspace(0, 10, 100)
y = 2 * x + 1 + np.random.normal(0, 1, 100)

# Create regression plot
fig, ax = plt.subplots(figsize=(10, 6))
sns.regplot(x=x, y=y, ax=ax, scatter_kws={'alpha':0.6})
ax.set_title('Regression Plot with Confidence Interval')
ax.set_xlabel('X values')
ax.set_ylabel('Y values')

plt.savefig('Libraries/seaborn/regression_plot.png', dpi=300, bbox_inches='tight')
print("Regression plot saved as 'regression_plot.png'")

# 3. Categorical Plots
print("\n3. Categorical Plots:")
print("-" * 30)

# Create sample categorical data
categories = ['A', 'B', 'C', 'D'] * 25
values = np.random.normal(0, 1, 100)
groups = np.random.choice(['Group1', 'Group2'], 100)

df_cat = pd.DataFrame({
    'Category': categories,
    'Value': values,
    'Group': groups
})

# Create categorical plots
fig, axes = plt.subplots(2, 2, figsize=(12, 10))

# Bar plot
sns.barplot(data=df_cat, x='Category', y='Value', ax=axes[0,0])
axes[0,0].set_title('Bar Plot')

# Box plot by category
sns.boxplot(data=df_cat, x='Category', y='Value', ax=axes[0,1])
axes[0,1].set_title('Box Plot by Category')

# Violin plot by category and group
sns.violinplot(data=df_cat, x='Category', y='Value', hue='Group', ax=axes[1,0])
axes[1,0].set_title('Violin Plot by Category and Group')

# Swarm plot
sns.swarmplot(data=df_cat, x='Category', y='Value', ax=axes[1,1])
axes[1,1].set_title('Swarm Plot')

plt.tight_layout()
plt.savefig('Libraries/seaborn/categorical_plots.png', dpi=300, bbox_inches='tight')
print("Categorical plots saved as 'categorical_plots.png'")

# 4. Heatmap and Correlation Matrix
print("\n4. Heatmap and Correlation Matrix:")
print("-" * 30)

# Generate correlation data
np.random.seed(42)
data_corr = np.random.randn(100, 5)
df_corr = pd.DataFrame(data_corr, columns=['A', 'B', 'C', 'D', 'E'])

# Calculate correlation matrix
corr_matrix = df_corr.corr()

# Create heatmap
fig, ax = plt.subplots(figsize=(8, 6))
sns.heatmap(corr_matrix, annot=True, cmap='coolwarm', center=0, 
            square=True, ax=ax)
ax.set_title('Correlation Matrix Heatmap')

plt.savefig('Libraries/seaborn/correlation_heatmap.png', dpi=300, bbox_inches='tight')
print("Correlation heatmap saved as 'correlation_heatmap.png'")

# 5. Pair Plot
print("\n5. Pair Plot:")
print("-" * 30)

# Create sample data for pair plot
np.random.seed(42)
df_pair = pd.DataFrame({
    'X1': np.random.normal(0, 1, 100),
    'X2': np.random.normal(0, 1, 100),
    'X3': np.random.normal(0, 1, 100),
    'Category': np.random.choice(['A', 'B', 'C'], 100)
})

# Create pair plot
pair_plot = sns.pairplot(df_pair, hue='Category', diag_kind='kde')
pair_plot.fig.suptitle('Pair Plot with Multiple Variables', y=1.02)
pair_plot.fig.set_size_inches(10, 8)

plt.savefig('Libraries/seaborn/pair_plot.png', dpi=300, bbox_inches='tight')
print("Pair plot saved as 'pair_plot.png'")

# 6. Joint Plot
print("\n6. Joint Plot:")
print("-" * 30)

# Generate data for joint plot
x_joint = np.random.normal(0, 1, 1000)
y_joint = 0.5 * x_joint + np.random.normal(0, 0.5, 1000)

# Create joint plot
joint_plot = sns.jointplot(x=x_joint, y=y_joint, kind='hex', 
                          marginal_kws=dict(bins=30))
joint_plot.fig.suptitle('Joint Plot with Hexagonal Binning', y=1.02)
joint_plot.fig.set_size_inches(8, 8)

plt.savefig('Libraries/seaborn/joint_plot.png', dpi=300, bbox_inches='tight')
print("Joint plot saved as 'joint_plot.png'")

# 7. Facet Grid
print("\n7. Facet Grid:")
print("-" * 30)

# Create sample data for facet grid
np.random.seed(42)
df_facet = pd.DataFrame({
    'X': np.random.randn(200),
    'Y': np.random.randn(200),
    'Category': np.random.choice(['A', 'B'], 200),
    'Group': np.random.choice(['X', 'Y'], 200)
})

# Create facet grid
g = sns.FacetGrid(df_facet, col='Category', row='Group', height=4, aspect=1.2)
g.map_dataframe(sns.scatterplot, x='X', y='Y', alpha=0.6)
g.fig.suptitle('Facet Grid Example', y=1.02)
g.fig.set_size_inches(10, 8)

plt.savefig('Libraries/seaborn/facet_grid.png', dpi=300, bbox_inches='tight')
print("Facet grid saved as 'facet_grid.png'")

# 8. Styling and Themes
print("\n8. Styling and Themes:")
print("-" * 30)

# Create sample data
x_style = np.linspace(0, 10, 100)
y1_style = np.sin(x_style)
y2_style = np.cos(x_style)

# Different themes
themes = ['whitegrid', 'darkgrid', 'white', 'dark', 'ticks']
fig, axes = plt.subplots(2, 3, figsize=(15, 10))

for i, theme in enumerate(themes):
    row = i // 3
    col = i % 3
    
    # Set theme
    sns.set_style(theme)
    
    # Create plot
    axes[row, col].plot(x_style, y1_style, label='sin(x)')
    axes[row, col].plot(x_style, y2_style, label='cos(x)')
    axes[row, col].set_title(f'Theme: {theme}')
    axes[row, col].legend()
    axes[row, col].grid(True)

# Remove the last subplot if not needed
if len(themes) < 6:
    axes[1, 2].remove()

plt.tight_layout()
plt.savefig('Libraries/seaborn/themes.png', dpi=300, bbox_inches='tight')
print("Themes comparison saved as 'themes.png'")

# Reset to default style
sns.set_style("whitegrid")

# 9. Advanced Statistical Plot
print("\n9. Advanced Statistical Plot:")
print("-" * 30)

# Create sample data with multiple groups
np.random.seed(42)
df_advanced = pd.DataFrame({
    'Value': np.concatenate([
        np.random.normal(0, 1, 50),
        np.random.normal(2, 1.5, 50),
        np.random.normal(-1, 0.8, 50)
    ]),
    'Group': ['A'] * 50 + ['B'] * 50 + ['C'] * 50,
    'Category': np.random.choice(['X', 'Y'], 150)
})

# Create advanced statistical plot
fig, axes = plt.subplots(2, 2, figsize=(12, 10))

# Strip plot
sns.stripplot(data=df_advanced, x='Group', y='Value', ax=axes[0,0])
axes[0,0].set_title('Strip Plot')

# Box plot with hue
sns.boxplot(data=df_advanced, x='Group', y='Value', hue='Category', ax=axes[0,1])
axes[0,1].set_title('Box Plot with Hue')

# Violin plot
sns.violinplot(data=df_advanced, x='Group', y='Value', ax=axes[1,0])
axes[1,0].set_title('Violin Plot')

# Point plot
sns.pointplot(data=df_advanced, x='Group', y='Value', hue='Category', ax=axes[1,1])
axes[1,1].set_title('Point Plot')

plt.tight_layout()
plt.savefig('Libraries/seaborn/advanced_statistical.png', dpi=300, bbox_inches='tight')
print("Advanced statistical plot saved as 'advanced_statistical.png'")

print("\n=== Seaborn Basics Complete ===")
print("All plots have been saved to the Libraries/seaborn/ directory") 