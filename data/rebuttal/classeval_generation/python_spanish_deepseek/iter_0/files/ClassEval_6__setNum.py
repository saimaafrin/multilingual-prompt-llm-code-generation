class _M:
    def setNum(self):
        """
            Calcula el tamaño de cada bloque y el resto de la división.
            :return: el tamaño de cada bloque y el resto de la división, tupla.
            >>> a = AvgPartition([1, 2, 3, 4], 2)
            >>> a.setNum()
            (2, 0)
    
            """
        n = len(self.lst)
        size = n // self.limit
        remainder = n % self.limit
        return (size, remainder)