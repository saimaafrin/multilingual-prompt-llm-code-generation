class _M:
    import zipfile
    import os
    
    class ZipFileProcessor:
        def __init__(self, zip_path):
            """
            初始化 ZipFileProcessor
            :param zip_path: zip 文件的路径
            """
            self.zip_path = zip_path
        
        def extract_all(self, output_path):
            """
            提取所有 zip 文件并将其放置在指定路径中
            :param output_path: 字符串，提取文件的位置
            :return: True 或 False，表示提取操作是否成功
            >>> zfp = ZipFileProcessor("aaa.zip")
            >>> zfp.extract_all("result/aaa")
            """
            try:
                # 检查 zip 文件是否存在
                if not os.path.exists(self.zip_path):
                    return False
                
                # 创建输出目录（如果不存在）
                if not os.path.exists(output_path):
                    os.makedirs(output_path)
                
                # 打开并提取 zip 文件
                with zipfile.ZipFile(self.zip_path, 'r') as zip_ref:
                    zip_ref.extractall(output_path)
                
                return True
            except (zipfile.BadZipFile, PermissionError, OSError, Exception):
                return False