class _M:
    def _generate_cards(self):
        """
            Generar números aleatorios entre 1 y 9 para las cartas.
            """
        self.nums = random.sample(range(1, 10), 4)