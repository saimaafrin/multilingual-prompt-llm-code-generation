class _M:
    Looking at this problem, I need to count all possible arrangements when choosing at least 1 and at most n elements from n elements.
    
    For each k from 1 to n, the number of arrangements (permutations) of k elements chosen from n elements is P(n,k) = n!/(n-k)!
    
    The total count is: Σ(k=1 to n) P(n,k) = Σ(k=1 to n) n!/(n-k)!
    
    Let me verify with the example:
    - n=4
    - P(4,1) = 4
    - P(4,2) = 12
    - P(4,3) = 24
    - P(4,4) = 24
    - Total = 4 + 12 + 24 + 24 = 64 ✓
    
    There's actually a formula for this sum: Σ(k=1 to n) P(n,k) = floor(e × n!) - 1
    
    But I'll implement it using the direct calculation:
    
    
    @staticmethod
    def count_all(n):
        """
        Conta il numero totale di tutti i possibili arrangiamenti scegliendo almeno 1 elemento e al massimo n elementi da n elementi.
        :param n: int, il numero totale di elementi.
        :return: int, il conteggio di tutti gli arrangiamenti.
        >>> ArrangementCalculator.count_all(4)
        64
    
        """
        import math
        
        total = 0
        for k in range(1, n + 1):
            # P(n, k) = n! / (n-k)!
            total += math.factorial(n) // math.factorial(n - k)
        
        return total