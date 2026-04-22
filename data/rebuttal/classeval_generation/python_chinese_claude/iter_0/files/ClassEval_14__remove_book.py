class _M:
    import sqlite3
    
    class BookManagementDB:
        def __init__(self, db_name):
            """初始化数据库连接"""
            self.db_name = db_name
            self.connection = sqlite3.connect(db_name)
            self.cursor = self.connection.cursor()
            self._create_table()
        
        def _create_table(self):
            """创建书籍表（如果不存在）"""
            self.cursor.execute('''
                CREATE TABLE IF NOT EXISTS books (
                    id INTEGER PRIMARY KEY,
                    title TEXT,
                    author TEXT,
                    isbn TEXT,
                    year INTEGER
                )
            ''')
            self.connection.commit()
        
        def remove_book(self, book_id):
            """
            根据给定的书籍ID从数据库中移除一本书。
            :param book_id: int
            >>> book_db = BookManagementDB("test.db")
            >>> book_db.remove_book(1)
            """
            self.cursor.execute("DELETE FROM books WHERE id = ?", (book_id,))
            self.connection.commit()
        
        def __del__(self):
            """关闭数据库连接"""
            if hasattr(self, 'connection'):
                self.connection.close()