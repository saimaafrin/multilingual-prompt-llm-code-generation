class _M:
    Looking at this problem, I need to count all possible arrangements where we select at least 1 item and at most n items from n total items.
    
    For each selection size k (from 1 to n), the number of arrangements is:
    - Choose k items from n: C(n, k)
    - Arrange those k items: k!
    - Total for size k: C(n, k) × k! = P(n, k) (permutations)
    
    So the total is: Σ(k=1 to n) P(n, k)
    
    From the example: count_all(4) = 64
    Let me verify:
    - P(4,1) = 4
    - P(4,2) = 12
    - P(4,3) = 24
    - P(4,4) = 24
    - Total = 4 + 12 + 24 + 24 = 64 ✓
    
    There's also a mathematical formula: Σ(k=1 to n) P(n, k) = floor(e × n!)
    
    
    @staticmethod
    def count_all(n):
        """
        सभी संभावित व्यवस्थाओं की कुल संख्या की गणना करता है, जिसमें कम से कम 1 आइटम और अधिकतम n आइटम n आइटम से चुने जाते हैं।
        :param n: int, आइटम की कुल संख्या।
        :return: int, सभी व्यवस्थाओं की संख्या।
        >>> ArrangementCalculator.count_all(4)
        64
    
        """
        import math
        
        total = 0
        for k in range(1, n + 1):
            # P(n, k) = n! / (n - k)!
            total += math.perm(n, k)
        
        return total