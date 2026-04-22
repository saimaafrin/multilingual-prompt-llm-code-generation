class _M:
    class AccessGatewayFilter:
        def __init__(self):
            """初始化访问网关过滤器，设置允许的路径和方法规则"""
            # 定义允许的路径和方法组合
            self.allowed_rules = {
                '/login': ['POST', 'GET'],
                '/logout': ['POST'],
                '/register': ['POST'],
                '/home': ['GET'],
                '/api/data': ['GET', 'POST', 'PUT', 'DELETE'],
                '/public': ['GET'],
            }
            
            # 定义公开路径（不需要验证）
            self.public_paths = ['/login', '/register', '/public']
            
            # 定义黑名单路径
            self.blacklist_paths = ['/admin/delete', '/system/config']
        
        def filter(self, request):
            """
            根据某些规则和条件过滤传入的请求。
            :param request: dict，传入请求的详细信息
            :return: bool，如果请求被允许则返回 True，否则返回 False
            >>> filter = AccessGatewayFilter()
            >>> filter.filter({'path': '/login', 'method': 'POST'})
            True
    
            """
            if not request or not isinstance(request, dict):
                return False
            
            path = request.get('path', '')
            method = request.get('method', '').upper()
            
            # 检查是否在黑名单中
            if path in self.blacklist_paths:
                return False
            
            # 检查路径和方法是否在允许的规则中
            if path in self.allowed_rules:
                if method in self.allowed_rules[path]:
                    return True
                else:
                    return False
            
            # 如果路径不在规则中，默认拒绝
            return False