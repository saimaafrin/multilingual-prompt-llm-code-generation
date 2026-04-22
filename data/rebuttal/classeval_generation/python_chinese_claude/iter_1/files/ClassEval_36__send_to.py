class _M:
    import datetime
    
    class EmailClient:
        def __init__(self, email, capacity):
            """
            初始化邮件客户端
            :param email: 邮箱地址
            :param capacity: 邮箱容量
            """
            self.email = email
            self.capacity = capacity
            self.inbox = []
            self.current_size = 0
        
        def send_to(self, recv, content, size):
            """
            发送电子邮件到给定的电子邮件地址。
            :param recv: 接收者的电子邮件地址，str。
            :param content: 电子邮件的内容，str。
            :param size: 电子邮件的大小，float。
            :return: 如果电子邮件成功发送则返回 True，如果接收者的邮箱已满则返回 False。
            >>> sender = EmailClient('sender@example.com', 100)
            >>> receiver = EmailClient('receiver@example.com', 50)
            >>> sender.send_to(receiver, 'Hello', 10)
            True
            >>> receiver.inbox
            {'sender': 'sender@example.com', 'receiver': 'receiver@example.com', 'content': 'Hello', 'size': 10, 'time': '2023-07-13 11:36:40', 'state': 'unread'}
    
            """
            # 检查接收者邮箱是否有足够空间
            if recv.current_size + size > recv.capacity:
                return False
            
            # 创建邮件对象
            email = {
                'sender': self.email,
                'receiver': recv.email,
                'content': content,
                'size': size,
                'time': datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'),
                'state': 'unread'
            }
            
            # 将邮件添加到接收者的收件箱
            recv.inbox.append(email)
            recv.current_size += size
            
            return True