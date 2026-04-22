class _M:
    class AccessGatewayFilter:
        def __init__(self):
            """初始化访问网关过滤器，设置允许的路径和方法规则"""
            # 定义允许的路径和方法组合
            self.allowed_rules = {
                '/login': ['POST', 'GET'],
                '/register': ['POST'],
                '/home': ['GET'],
                '/api/data': ['GET', 'POST', 'PUT', 'DELETE'],
                '/logout': ['POST', 'GET'],
                '/public': ['GET', 'POST', 'PUT', 'DELETE', 'PATCH']
            }
            
            # 定义公共路径前缀（无需验证）
            self.public_prefixes = ['/public', '/static', '/assets']
            
            # 定义黑名单路径
            self.blacklist_paths = ['/admin/delete', '/system/shutdown']
            
        def filter(self, request):
            """
            根据某些规则和条件过滤传入的请求。
            :param request: dict，传入请求的详细信息
            :return: bool，如果请求被允许则返回 True，否则返回 False
            >>> filter = AccessGatewayFilter()
            >>> filter.filter({'path': '/login', 'method': 'POST'})
            True
    
            """
            if not isinstance(request, dict):
                return False
            
            path = request.get('path', '')
            method = request.get('method', '').upper()
            
            # 检查必要字段是否存在
            if not path or not method:
                return False
            
            # 检查是否在黑名单中
            if path in self.blacklist_paths:
                return False
            
            # 检查是否是公共路径前缀
            for prefix in self.public_prefixes:
                if path.startswith(prefix):
                    return True
            
            # 检查路径和方法是否在允许规则中
            if path in self.allowed_rules:
                if method in self.allowed_rules[path]:
                    return True
                else:
                    return False
            
            # 默认拒绝未定义的路径
            return False