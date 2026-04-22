class _M:
    Looking at this problem, I need to count the total number of arrangements when choosing at least 1 and at most n items from n items.
    
    For each choice of k items (where 1 ≤ k ≤ n), the number of arrangements is the permutation P(n,k) = n!/(n-k)!
    
    The total count is: Σ(k=1 to n) P(n,k) = Σ(k=1 to n) n!/(n-k)!
    
    Let me verify with the example:
    - n=4
    - k=1: P(4,1) = 4
    - k=2: P(4,2) = 12
    - k=3: P(4,3) = 24
    - k=4: P(4,4) = 24
    - Total: 4 + 12 + 24 + 24 = 64 ✓
    
    There's also a mathematical formula for this sum: Σ(k=1 to n) P(n,k) = floor(e × n!) - 1
    
    
    @staticmethod
    def count_all(n):
        """
        Cuenta el número total de posibles arreglos al elegir al menos 1 artículo y como máximo n artículos de n artículos.
        :param n: int, el número total de artículos.
        :return: int, el conteo de todas las disposiciones.
        >>> ArrangementCalculator.count_all(4)
        64
    
        """
        import math
        
        total = 0
        for k in range(1, n + 1):
            # P(n, k) = n! / (n-k)!
            total += math.perm(n, k)
        
        return total