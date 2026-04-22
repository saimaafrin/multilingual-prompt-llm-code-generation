class _M:
    @staticmethod
    def select(table, columns='*', where=None):
        """
            Genera la declaración SQL SELECT a partir de los parámetros dados.
            :param table: str, la tabla de consulta en la base de datos.
            :param columns: lista de str, ['col1', 'col2'].
            :param where: dict, {key1: value1, key2: value2 ...}. La condición de consulta.
            return query: str, la declaración de consulta SQL.
            >>> SQLQueryBuilder.select('table1', columns = ["col1","col2"], where = {"age": 15})
            "SELECT col1, col2 FROM table1 WHERE age='15'"
            """
        if columns == '*':
            columns_str = '*'
        else:
            columns_str = ', '.join(columns)
        query = f'SELECT {columns_str} FROM {table}'
        if where:
            where_clause = ' AND '.join((f"{k}='{v}'" for k, v in where.items()))
            query += f' WHERE {where_clause}'
        return query