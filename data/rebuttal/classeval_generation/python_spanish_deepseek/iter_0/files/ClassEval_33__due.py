class _M:
    def due(self):
        """
            Calcular el monto final a pagar después de aplicar el descuento.
            :return: float, monto final a pagar
            >>> customer = {'name': 'John Doe', 'fidelity': 1200}
            >>> cart = [{'product': 'product', 'quantity': 14, 'price': 23.5}]
            >>> ds = DiscountStrategy(customer, cart, DiscountStrategy.FidelityPromo)
            >>> ds.due()
            312.55
    
            """
        if self.promotion:
            discount = self.promotion(self)
            return self.total() - discount
        return self.total()