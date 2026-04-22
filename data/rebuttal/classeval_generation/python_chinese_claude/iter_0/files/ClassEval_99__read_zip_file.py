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
        
        def read_zip_file(self):
            """
            获取打开的文件对象
            :return: 如果成功，返回打开的文件对象；否则，返回 None
            >>> zfp = ZipFileProcessor("aaa.zip")
            >>> file = zfp.read_zip_file()
            """
            try:
                if not os.path.exists(self.zip_path):
                    return None
                
                if not zipfile.is_zipfile(self.zip_path):
                    return None
                
                zip_file = zipfile.ZipFile(self.zip_path, 'r')
                return zip_file
            except Exception:
                return None