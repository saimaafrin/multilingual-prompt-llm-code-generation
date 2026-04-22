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
        
        def due(self):
            """
            计算应用折扣后的最终支付金额。
            :return: float，最终支付金额
            """
            total = sum(item['quantity'] * item['price'] for item in self.cart)
            discount = self.promotion(self)
            return total - discount
        
        @staticmethod
        def FidelityPromo(order):
            """为积分为1000或以上的顾客提供5%折扣"""
            if order.customer['fidelity'] >= 1000:
                total = sum(item['quantity'] * item['price'] for item in order.cart)
                return total * 0.05
            return 0
        
        @staticmethod
        def BulkItemPromo(order):
            """单个商品为20个或以上时提供10%折扣"""
            discount = 0
            for item in order.cart:
                if item['quantity'] >= 20:
                    discount += item['quantity'] * item['price'] * 0.10
            return discount
        
        @staticmethod
        def LargeOrderPromo(order):
            """订单中的不同商品达到10个或以上时提供7%折扣"""
            distinct_items = len(order.cart)
            if distinct_items >= 10:
                total = sum(item['quantity'] * item['price'] for item in order.cart)
                return total * 0.07
            return 0