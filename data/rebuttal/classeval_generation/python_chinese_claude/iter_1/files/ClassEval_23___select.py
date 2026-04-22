class _M:
    from typing import List
    
    class CombinationCalculator:
        def __init__(self, data: List[str]):
            self.data = data
        
        def _select(self, dataIndex: int, resultList: List[str], resultIndex: int, result: List[List[str]]):
            """
            通过递归生成具有指定元素数量的组合。
            :param dataIndex: 要选择的数据的索引，int。
            :param resultList: 组合中元素的列表，List[str]。
            :param resultIndex: 组合中元素的索引，int。
            :param result: 组合的列表，List[List[str]]。
            :return: None。
            >>> calc = CombinationCalculator(["A", "B", "C", "D"])
            >>> result = []
            >>> calc._select(0, [None] * 2, 0, result)
            >>> result
            [['A', 'B'], ['A', 'C'], ['A', 'D'], ['B', 'C'], ['B', 'D'], ['C', 'D']]
    
            """
            # 如果已经选择了足够的元素（resultIndex达到resultList的长度）
            if resultIndex == len(resultList):
                # 将当前组合添加到结果中
                result.append(resultList[:])
                return
            
            # 如果数据索引超出范围，返回
            if dataIndex >= len(self.data):
                return
            
            # 遍历从dataIndex开始的所有可能的元素
            for i in range(dataIndex, len(self.data)):
                # 选择当前元素
                resultList[resultIndex] = self.data[i]
                # 递归选择下一个元素，从i+1开始以避免重复
                self._select(i + 1, resultList, resultIndex + 1, result)