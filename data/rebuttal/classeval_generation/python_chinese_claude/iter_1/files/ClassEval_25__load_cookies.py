class _M:
    import json
    import os
    
    class CookiesUtil:
        def __init__(self, cookies_file):
            """
            初始化 CookiesUtil 类
            :param cookies_file: cookies 文件路径
            """
            self.cookies_file = cookies_file
            self.cookies = {}
        
        def load_cookies(self):
            """
            从 cookies_file 加载 cookies 到 cookies 数据中。
            :return: cookies 数据，dict。
            >>> cookies_util = CookiesUtil('cookies.json')
            >>> cookies_util.load_cookies()
            {'key1': 'value1', 'key2': 'value2'}
    
            """
            if os.path.exists(self.cookies_file):
                try:
                    with open(self.cookies_file, 'r', encoding='utf-8') as f:
                        self.cookies = json.load(f)
                except (json.JSONDecodeError, IOError):
                    self.cookies = {}
            else:
                self.cookies = {}
            
            return self.cookies