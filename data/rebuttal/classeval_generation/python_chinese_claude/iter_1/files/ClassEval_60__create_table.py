class _M:
    import sqlite3
    
    class TicketDatabase:
        def __init__(self, db_name='tickets.db'):
            self.db_name = db_name
            self.conn = None
            self.cursor = None
        
        def connect(self):
            self.conn = sqlite3.connect(self.db_name)
            self.cursor = self.conn.cursor()
        
        def close(self):
            if self.conn:
                self.conn.close()
        
        def create_table(self):
            """
            如果数据库中尚不存在，则创建一个"tickets"表。字段包括类型为int的ID，类型为str的电影名称，类型为str的剧院名称，类型为str的座位号，以及类型为str的顾客名称。
            :return: None
            """
            if not self.conn:
                self.connect()
            
            self.cursor.execute('''
                CREATE TABLE IF NOT EXISTS tickets (
                    ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    电影名称 TEXT NOT NULL,
                    剧院名称 TEXT NOT NULL,
                    座位号 TEXT NOT NULL,
                    顾客名称 TEXT NOT NULL
                )
            ''')
            
            self.conn.commit()