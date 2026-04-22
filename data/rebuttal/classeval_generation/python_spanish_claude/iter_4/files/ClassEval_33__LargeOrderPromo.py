class _M:
    @staticmethod
    def LargeOrderPromo(order):
        """
        Calcula el descuento basado en la cantidad de productos diferentes en el pedido. Si la cantidad de productos diferentes en el pedido alcanza 10 o más, todo el pedido disfrutará de un descuento del 7%.
        :param order: objeto, el pedido al que se aplicará el descuento
        :return: float, monto del descuento
        >>> customer = {'name': 'John Doe', 'fidelity': 1200}
        >>> cart = [{'product': 'product', 'quantity': 14, 'price': 23.5}]
        >>> order = DiscountStrategy(customer, cart, DiscountStrategy.LargeOrderPromo)
        >>> DiscountStrategy.LargeOrderPromo(order)
        0.0
    
        """
        # Contar la cantidad de productos diferentes en el carrito
        distinct_items = len(order.cart)
        
        # Si hay 10 o más productos diferentes, aplicar 7% de descuento
        if distinct_items >= 10:
            return order.total() * 0.07
        
        return 0.0