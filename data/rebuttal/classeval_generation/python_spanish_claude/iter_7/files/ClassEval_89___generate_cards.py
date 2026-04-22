class _M:
    def _generate_cards(self):
        """
        Generar números aleatorios entre 1 y 9 para las cartas.
        """
        import random
        return [random.randint(1, 9) for _ in range(2)]