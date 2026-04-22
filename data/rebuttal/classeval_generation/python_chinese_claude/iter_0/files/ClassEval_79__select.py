class _M:
    class SQLGenerator:
        def __init__(self, table_name):
            """
            初始化 SQLGenerator 实例。
            :param table_name: str, 表名。
            """
            self.table_name = table_name
        
        def select(self, fields=None, condition=None):
            """
            根据指定的字段和条件生成一个 SELECT SQL 语句。
            :param fields: list, 可选。默认为 None。要查询的字段列表。
            :param condition: str, 可选。默认为 None。查询的条件表达式。
            :return: str。生成的 SQL 语句。
            >>> sql = SQLGenerator('table1')
            >>> sql.select(['field1', 'field2'], 'filed3 = value1')
            'SELECT field1, field2 FROM table1 WHERE filed3 = value1;'
            """
            # 处理字段列表
            if fields is None or len(fields) == 0:
                field_str = '*'
            else:
                field_str = ', '.join(fields)
            
            # 构建基本的 SELECT 语句
            sql = f'SELECT {field_str} FROM {self.table_name}'
            
            # 添加 WHERE 条件（如果存在）
            if condition is not None and condition.strip():
                sql += f' WHERE {condition}'
            
            # 添加分号结尾
            sql += ';'
            
            return sql