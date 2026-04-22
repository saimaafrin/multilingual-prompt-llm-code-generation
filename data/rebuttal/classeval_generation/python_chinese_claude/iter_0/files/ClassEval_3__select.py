class _M:
    from itertools import permutations
    
    class ArrangementCalculator:
        def __init__(self, data):
            """
            初始化 ArrangementCalculator
            :param data: 用于生成排列的数据列表
            """
            self.data = data
        
        def select(self, m=None):
            """
            通过从内部数据中选择 m 个元素来生成排列列表。
            如果未提供 m，则选择所有元素。
            :param m: int，选择的元素数量（默认=None）。
            :return: List，排列的列表。
            >>> ac = ArrangementCalculator([1, 2, 3, 4])
            >>> ac.select(2)
            [[1, 2], [1, 3], [1, 4], [2, 1], [2, 3], [2, 4], [3, 1], [3, 2], [3, 4], [4, 1], [4, 2], [4, 3]]
    
            """
            if m is None:
                m = len(self.data)
            
            return [list(perm) for perm in permutations(self.data, m)]