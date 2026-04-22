class _M:
    @staticmethod
    def add(states, stat):
        """
            Agrega un estado al estado actual y verifica si los parámetros son legales.
            :param states: Estado actual, int.
            :param stat: Estado a agregar, int.
            :return: El estado después de agregar el estado, int.
            >>> bit_status_util = BitStatusUtil()
            >>> bit_status_util.add(2,4)
            6
    
            """
        BitStatusUtil.check([states, stat])
        return states | stat