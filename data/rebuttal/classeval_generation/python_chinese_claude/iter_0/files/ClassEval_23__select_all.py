class _M:
    from typing import List
    from itertools import combinations
    
    class CombinationCalculator:
        def __init__(self, data: List[str]):
            self.data = data
        
        def select(self, count: int) -> List[List[str]]:
            """Helper method to generate combinations of a specific size."""
            return [list(combo) for combo in combinations(self.data, count)]
        
        def select_all(self) -> List[List[str]]:
            """
            生成从给定数据列表中选择元素的所有可能组合，并使用select方法。
            :return: 组合的列表，List[List[str]]。
            >>> calc = CombinationCalculator(["A", "B", "C", "D"])
            >>> calc.select_all()
            [['A'], ['B'], ['C'], ['D'], ['A', 'B'], ['A', 'C'], ['A', 'D'], ['B', 'C'], ['B', 'D'], ['C', 'D'], ['A', 'B', 'C'], ['A', 'B', 'D'], ['A', 'C', 'D'], ['B', 'C', 'D'], ['A', 'B', 'C', 'D']]
            """
            result = []
            for i in range(1, len(self.data) + 1):
                result.extend(self.select(i))
            return result