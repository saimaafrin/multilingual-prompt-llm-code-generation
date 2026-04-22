class _M:
    class ShoppingCart:
        def __init__(self):
            self.items = {}
        
        def add_item(self, name: str, price: float, quantity: int):
            """添加商品到购物车"""
            if name in self.items:
                self.items[name]["quantity"] += quantity
            else:
                self.items[name] = {"price": price, "quantity": quantity}
        
        def remove_item(self, name: str, quantity: int):
            """从购物车移除商品"""
            if name in self.items:
                self.items[name]["quantity"] -= quantity
                if self.items[name]["quantity"] <= 0:
                    del self.items[name]
        
        def view_items(self) -> dict:
            """
            返回当前购物清单项目
            :return: dict，当前购物清单项目
            >>> shoppingcart.add_item("apple", 1, 5)
            >>> shoppingcart.remove_item("apple", 3)
            >>> shoppingcart.view_items()
            {"apple":{"price":1, "quantity":2}}
            """
            return self.items