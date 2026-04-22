class _M:
    def __delitem__(self, key):
        """
        删除与键对应的值
        :param key:str
        :return:None
        >>> camelize_map = CamelCaseMap()
        >>> camelize_map['first_name'] = 'John'
        >>> camelize_map.__delitem__('first_name')
        >>> flag = 'first_name' in camelize_map
        flag = False
        """
        # Convert the key to camelCase format
        camel_key = self._to_camel_case(key)
        # Delete the item from the internal dictionary
        del self._data[camel_key]
    
    def _to_camel_case(self, snake_str):
        """
        Convert snake_case string to camelCase
        """
        components = snake_str.split('_')
        return components[0] + ''.join(x.title() for x in components[1:])
    
    
    Note: This implementation assumes that the `CamelCaseMap` class has:
    1. An internal `_data` dictionary to store the key-value pairs
    2. A `_to_camel_case` helper method to convert snake_case keys to camelCase
    
    If you need the complete class implementation:
    
    
    class CamelCaseMap:
        def __init__(self):
            self._data = {}
        
        def _to_camel_case(self, snake_str):
            """Convert snake_case string to camelCase"""
            components = snake_str.split('_')
            return components[0] + ''.join(x.title() for x in components[1:])
        
        def __setitem__(self, key, value):
            """Set item with camelCase key"""
            camel_key = self._to_camel_case(key)
            self._data[camel_key] = value
        
        def __delitem__(self, key):
            """
            删除与键对应的值
            :param key:str
            :return:None
            >>> camelize_map = CamelCaseMap()
            >>> camelize_map['first_name'] = 'John'
            >>> camelize_map.__delitem__('first_name')
            >>> flag = 'first_name' in camelize_map
            flag = False
            """
            camel_key = self._to_camel_case(key)
            del self._data[camel_key]
        
        def __contains__(self, key):
            """Check if key exists"""
            camel_key = self._to_camel_case(key)
            return camel_key in self._data