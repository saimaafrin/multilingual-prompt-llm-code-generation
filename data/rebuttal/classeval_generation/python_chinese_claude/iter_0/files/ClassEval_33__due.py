class _M:
    def due(self):
        """
        计算应用折扣后的最终支付金额。
        :return: float，最终支付金额
        >>> customer = {'name': 'John Doe', 'fidelity': 1200}
        >>> cart = [{'product': 'product', 'quantity': 14, 'price': 23.5}]
        >>> ds = DiscountStrategy(customer, cart, DiscountStrategy.FidelityPromo)
        >>> ds.due()
        312.55
    
        """
        total = sum(item['quantity'] * item['price'] for item in self.cart)
        discount = self.promotion(self)
        return total - discount
    
    
    class DiscountStrategy:
        def __init__(self, customer, cart, promotion):
            self.customer = customer
            self.cart = cart
            self.promotion = promotion
        
        def total(self):
            return sum(item['quantity'] * item['price'] for item in self.cart)
        
        def due(self):
            """
            计算应用折扣后的最终支付金额。
            :return: float，最终支付金额
            >>> customer = {'name': 'John Doe', 'fidelity': 1200}
            >>> cart = [{'product': 'product', 'quantity': 14, 'price': 23.5}]
            >>> ds = DiscountStrategy(customer, cart, DiscountStrategy.FidelityPromo)
            >>> ds.due()
            312.55
    
            """
            total = sum(item['quantity'] * item['price'] for item in self.cart)
            discount = self.promotion(self)
            return total - discount
        
        @staticmethod
        def FidelityPromo(order):
            """5% discount for customers with 1000 or more fidelity points"""
            return order.total() * 0.05 if order.customer['fidelity'] >= 1000 else 0
        
        @staticmethod
        def BulkItemPromo(order):
            """10% discount for each LineItem with 20 or more units"""
            discount = 0
            for item in order.cart:
                if item['quantity'] >= 20:
                    discount += item['quantity'] * item['price'] * 0.10
            return discount
        
        @staticmethod
        def LargeOrderPromo(order):
            """7% discount for orders with 10 or more distinct items"""
            distinct_items = {item['product'] for item in order.cart}
            if len(distinct_items) >= 10:
                return order.total() * 0.07
            return 0