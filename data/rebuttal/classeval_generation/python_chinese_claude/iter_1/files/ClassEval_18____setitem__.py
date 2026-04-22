class _M:
    class CamelCaseMap:
        def __init__(self):
            self._data = {}
        
        def _to_camel_case(self, snake_str):
            """将snake_case转换为camelCase"""
            components = snake_str.split('_')
            return components[0] + ''.join(x.title() for x in components[1:])
        
        def __setitem__(self, key, value):
            """
            将与键对应的值设置为指定的值
            :param key:str
            :param value:str，指定的值
            :return:None
            >>> camelize_map = CamelCaseMap()
            >>> camelize_map['first_name'] = 'John'
            >>> camelize_map.__setitem__('first_name', 'new name')
            camelize_map['first_name'] = 'new name'
            """
            camel_key = self._to_camel_case(key)
            self._data[camel_key] = value
        
        def __getitem__(self, key):
            """获取键对应的值"""
            camel_key = self._to_camel_case(key)
            return self._data[camel_key]
        
        def __repr__(self):
            return f"CamelCaseMap({self._data})"