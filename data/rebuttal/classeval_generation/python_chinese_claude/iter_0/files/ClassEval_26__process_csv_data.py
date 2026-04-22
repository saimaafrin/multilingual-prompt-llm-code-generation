class _M:
    import csv
    import os
    
    class CSVProcessor:
        def read_csv(self, file_name):
            """
            读取CSV文件并返回标题和数据
            """
            try:
                with open(file_name, 'r', encoding='utf-8') as f:
                    reader = csv.reader(f)
                    rows = list(reader)
                    if len(rows) == 0:
                        return ([], [])
                    title = rows[0]
                    data = rows[1:]
                    return (title, data)
            except:
                return ([], [])
        
        def process_csv_data(self, N, save_file_name):
            """
            读取一个csv文件到变量title和data中。
            仅保留第N列（从0开始）的数据并将其大写，将标题和新数据存储到一个新的csv文件中。
            在旧文件名后添加'_process'后缀，作为新文件名。
            :param N: int，第N列（从0开始）
            :param save_file_name: 需要处理的文件名。
            :return: int，如果成功返回1，否则返回0
            """
            try:
                # 读取CSV文件
                title, data = self.read_csv(save_file_name)
                
                # 检查是否成功读取数据
                if not title or not data:
                    return 0
                
                # 检查N是否在有效范围内
                if N < 0 or N >= len(title):
                    return 0
                
                # 保留第N列的标题
                new_title = [title[N]]
                
                # 保留第N列的数据并转换为大写
                new_data = []
                for row in data:
                    if N < len(row):
                        new_data.append([row[N].upper()])
                
                # 生成新文件名
                base_name, ext = os.path.splitext(save_file_name)
                new_file_name = base_name + '_process' + ext
                
                # 写入新的CSV文件
                with open(new_file_name, 'w', newline='', encoding='utf-8') as f:
                    writer = csv.writer(f)
                    writer.writerow(new_title)
                    writer.writerows(new_data)
                
                return 1
            except:
                return 0