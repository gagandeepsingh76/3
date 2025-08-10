cost_price=float(input("Enter the cost price of the time:")) 
sell_price=float(input("Enter the sell price of the time:")) 
profit=sell_price-cost_price 
loss=cost_price-sell_price 
if sell_price > cost_price: 
 print("The seller make the profit:",profit,"Rs") 
elif sell_price==cost_price: 
 print("No profit , No lose") 
else: 
 print("The seller is made the  loss:",loss,"Rs") 