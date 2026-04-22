class _M:
    def register_student(self, student):
        """
            registra uno studente nel sistema, aggiunge lo studente alla lista degli studenti, se lo studente è già registrato, restituisce 0, altrimenti restituisce 1
            """
        for existing_student in self.students:
            if existing_student['name'] == student['name']:
                return 0
        self.students.append(student)
        return 1