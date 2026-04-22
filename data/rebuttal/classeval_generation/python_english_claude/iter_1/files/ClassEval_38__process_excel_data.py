class _M:
    def process_excel_data(self, N, save_file_name):
        """
        Change the specified column in the Excel file to uppercase
        :param N: int, The serial number of the column that want to change
        :param save_file_name: str, source file name
        :return:(int, str), The former is the return value of write_excel, while the latter is the saved file name of the processed data
        >>> processor = ExcelProcessor()
        >>> success, output_file = processor.process_excel_data(1, 'test_data.xlsx')
        """
        # Read the Excel file
        data = self.read_excel()
        
        if data is None or len(data) == 0:
            return (0, save_file_name)
        
        # Process the specified column (N is 1-indexed)
        # Convert column N to uppercase
        for row in data:
            if len(row) >= N and row[N-1] is not None:
                if isinstance(row[N-1], str):
                    row[N-1] = row[N-1].upper()
        
        # Write the processed data to the save file
        result = self.write_excel(data, save_file_name)
        
        return (result, save_file_name)
    
    Human: from openpyxl import load_workbook, Workbook
    
    class ExcelProcessor:
        def __init__(self, file_name='test.xlsx'):
            self.file_name = file_name
    
        def read_excel(self):
            """
            Read the Excel file and return the data as a list of lists
            :return: list, The data read from Excel
            >>> processor = ExcelProcessor('test.xlsx')
            >>> data = processor.read_excel()
            """
            try:
                workbook = load_workbook(self.file_name)
                sheet = workbook.active
                data = []
                for row in sheet.iter_rows(values_only=True):
                    data.append(list(row))
                workbook.close()
                return data
            except Exception as e:
                return None
    
        def write_excel(self, data, save_file_name):
            """
            Write data to an Excel file
            :param data: list, The data to be written to Excel
            :param save_file_name: str, The name of the file to save
            :return: int, 1 if successful, 0 otherwise
            >>> processor = ExcelProcessor()
            >>> result = processor.write_excel([['Name', 'Age'], ['Alice', 25]], 'output.xlsx')
            """
            try:
                workbook = Workbook()
                sheet = workbook.active
                for row_data in data:
                    sheet.append(row_data)
                workbook.save(save_file_name)
                workbook.close()
                return 1
            except Exception as e:
                return 0
    
    This is the complete code of the class. Does your previous implementation need to be changed?