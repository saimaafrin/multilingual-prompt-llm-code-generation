class _M:
    def sin(self, x):
        """
        Calcular el valor del seno del ángulo en grados x
        :param x: float
        :return: float
        >>> tricalculator.sin(30)
        0.5
        """
        import math
        return math.sin(math.radians(x))