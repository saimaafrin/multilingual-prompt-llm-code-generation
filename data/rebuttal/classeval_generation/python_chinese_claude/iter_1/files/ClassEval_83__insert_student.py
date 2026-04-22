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
        
        def create_student_table(self):
            """
            创建students表
            """
            self.connection = sqlite3.connect(self.db_name)
            cursor = self.connection.cursor()
            cursor.execute('''
                CREATE TABLE IF NOT EXISTS students (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    age INTEGER,
                    gender TEXT,
                    grade INTEGER
                )
            ''')
            self.connection.commit()
        
        def insert_student(self, student_data):
            """
            将新学生插入到"students"表中。
            :param student_data: dict，一个包含学生信息的字典（姓名、年龄、性别、年级）。
            :return: None
            >>> processor = StudentDatabaseProcessor("students.db")
            >>> processor.create_student_table()
            >>> student_data = {'name': 'John', 'age': 15, 'gender': 'Male', 'grade': 9}
            >>> processor.insert_student(student_data)
            """
            if self.connection is None:
                self.connection = sqlite3.connect(self.db_name)
            
            cursor = self.connection.cursor()
            cursor.execute('''
                INSERT INTO students (name, age, gender, grade)
                VALUES (?, ?, ?, ?)
            ''', (student_data['name'], student_data['age'], student_data['gender'], student_data['grade']))
            self.connection.commit()