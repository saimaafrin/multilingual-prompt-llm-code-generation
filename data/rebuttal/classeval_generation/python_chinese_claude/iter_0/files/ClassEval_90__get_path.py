class _M:
    import urllib.parse
    
    class URLHandler:
        def __init__(self, url):
            """
            初始化 URLHandler
            :param url: 完整的 URL 字符串
            """
            self.url = url
            self.parsed_url = urllib.parse.urlparse(url)
        
        def get_path(self):
            """
            获取 URL 的第三部分，即资源的地址
            :return: 字符串，如果成功，返回 URL 的资源地址
            >>> urlhandler = URLHandler("https://www.baidu.com/s?wd=aaa&rsv_spt=1#page")
            >>> urlhandler.get_path()
            "/s?wd=aaa&rsv_spt=1#page"
            """
            path = self.parsed_url.path
            query = self.parsed_url.query
            fragment = self.parsed_url.fragment
            
            result = path if path else ""
            
            if query:
                result += "?" + query
            
            if fragment:
                result += "#" + fragment
            
            return result if result else "/"