class _M:
    import sqlite3
    
    class BookManagementDB:
        def __init__(self, db_name):
            self.db_name = db_name
            self.connection = sqlite3.connect(db_name)
            self.cursor = self.connection.cursor()
        
        def return_book(self, book_id):
            """
            根据给定的书籍ID在数据库中标记书籍为已归还。
            :param book_id: int
            >>> book_db = BookManagementDB("test.db")
            >>> book_db.return_book(1)
            """
            try:
                # 更新书籍状态为已归还(假设有一个status字段或borrowed字段)
                # 常见的设计是使用borrowed字段,0表示未借出,1表示已借出
                self.cursor.execute(
                    "UPDATE books SET borrowed = 0 WHERE id = ?",
                    (book_id,)
                )
                self.connection.commit()
            except sqlite3.Error as e:
                print(f"Database error: {e}")
                self.connection.rollback()
        
        def __del__(self):
            if hasattr(self, 'connection'):
                self.connection.close()