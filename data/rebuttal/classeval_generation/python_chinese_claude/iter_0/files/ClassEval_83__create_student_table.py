class _M:
    import sqlite3
    
    class StudentDatabaseProcessor:
        def __init__(self, db_name):
            """
            初始化数据库处理器
            :param db_name: 数据库文件名
            """
            self.db_name = db_name
            self.connection = None
        
        def __enter__(self):
            """支持上下文管理器"""
            self.connection = sqlite3.connect(self.db_name)
            return self
        
        def __exit__(self, exc_type, exc_val, exc_tb):
            """支持上下文管理器"""
            if self.connection:
                self.connection.close()
        
        def create_student_table(self):
            """
            如果数据库中尚不存在,则创建一个"students"表。字段包括类型为int的ID,类型为str的姓名,类型为int的年龄,类型为str的性别,以及类型为int的年级。
            :return: None
            >>> processor = StudentDatabaseProcessor("students.db")
            >>> processor.create_student_table()
            """
            conn = sqlite3.connect(self.db_name)
            cursor = conn.cursor()
            
            cursor.execute('''
                CREATE TABLE IF NOT EXISTS students (
                    id INTEGER,
                    name TEXT,
                    age INTEGER,
                    gender TEXT,
                    grade INTEGER
                )
            ''')
            
            conn.commit()
            conn.close()