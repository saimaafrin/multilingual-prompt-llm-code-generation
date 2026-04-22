class _M:
    class Server:
        def __init__(self):
            self.send_data = None
            self.receive_data = None
        
        def send(self, data):
            """Store data to be sent"""
            self.send_data = data
        
        def recv(self, data):
            """Store received data"""
            self.receive_data = data
        
        def show(self, type):
            """
            返回指定类型的结构体
            :param type: 字符串，要返回的结构体类型，可以是 'send' 或 'receive'
            :return: 如果 type 等于 'send' 或 'receive'，则返回相应的结构体；否则，返回 False
            >>> server.recv({"addr":88,"content":"abc"})
            >>> server.send({"addr":66,"content":"ABC"})
            >>> server.show("send")
            {"addr":66,"content":"ABC"}
            """
            if type == 'send':
                return self.send_data
            elif type == 'receive':
                return self.receive_data
            else:
                return False