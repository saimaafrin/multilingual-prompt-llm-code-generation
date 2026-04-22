class _M:
    import math
    
    class Statistics3:
        @staticmethod
        def correlation_matrix(data):
            """
            计算给定列表的相关性矩阵。
            :param data: 给定的列表，列表。
            :return: 给定列表的相关性矩阵，列表。
            >>> statistics3 = Statistics3()
            >>> statistics3.correlation_matrix([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
            [[1.0, 1.0, 1.0], [1.0, 1.0, 1.0], [1.0, 1.0, 1.0]]
    
            """
            n = len(data)
            if n == 0:
                return []
            
            # Initialize correlation matrix
            corr_matrix = [[0.0 for _ in range(n)] for _ in range(n)]
            
            # Calculate correlation for each pair
            for i in range(n):
                for j in range(n):
                    corr_matrix[i][j] = Statistics3._correlation(data[i], data[j])
            
            return corr_matrix
        
        @staticmethod
        def _correlation(x, y):
            """
            Calculate Pearson correlation coefficient between two lists.
            """
            if len(x) != len(y) or len(x) == 0:
                return 0.0
            
            n = len(x)
            
            # Calculate means
            mean_x = sum(x) / n
            mean_y = sum(y) / n
            
            # Calculate standard deviations and covariance
            numerator = sum((x[i] - mean_x) * (y[i] - mean_y) for i in range(n))
            
            std_x = math.sqrt(sum((x[i] - mean_x) ** 2 for i in range(n)))
            std_y = math.sqrt(sum((y[i] - mean_y) ** 2 for i in range(n)))
            
            # Avoid division by zero
            if std_x == 0 or std_y == 0:
                return 1.0 if x == y else 0.0
            
            correlation = numerator / (std_x * std_y)
            
            return correlation