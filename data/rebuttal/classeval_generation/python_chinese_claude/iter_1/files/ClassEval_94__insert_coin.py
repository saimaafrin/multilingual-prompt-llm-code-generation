class _M:
    class VendingMachine:
        def __init__(self):
            """初始化自动售货机，余额为0"""
            self.balance = 0.0
        
        def insert_coin(self, amount):
            """
            将硬币插入自动售货机。
            :param amount: 要插入的硬币数量，浮点数。
            :return: 插入硬币后自动售货机的余额，浮点数。
            >>> vendingMachine = VendingMachine()
            >>> vendingMachine.insert_coin(1.25)
            1.25
    
            """
            self.balance += amount
            return self.balance