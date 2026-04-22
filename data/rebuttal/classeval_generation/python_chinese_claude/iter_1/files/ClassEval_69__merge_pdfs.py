class _M:
    import PyPDF2
    from PyPDF2 import PdfMerger, PdfReader
    
    class PDFHandler:
        def __init__(self, pdf_files):
            """
            初始化 PDFHandler
            :param pdf_files: list of str, PDF 文件路径列表
            """
            self.pdf_files = pdf_files
            self.readers = [PdfReader(pdf_file) for pdf_file in pdf_files]
        
        def merge_pdfs(self, output_filepath):
            """
            读取存储多个 PDF 文件句柄的 self.readers 中的文件。
            将它们合并为一个 PDF 并更新页码，然后保存到磁盘。
            :param output_filepath: str, 输出文件的保存路径
            :return: str, 如果成功合并则为"Merged PDFs saved at {output_filepath}" 
            >>> handler = PDFHandler(['a.pdf', 'b.pdf'])
            >>> handler.merge_pdfs('out.pdf')
            Merged PDFs saved at out.pdf
            """
            merger = PdfMerger()
            
            # 遍历所有的 PDF readers 并将它们添加到 merger 中
            for reader in self.readers:
                merger.append(reader)
            
            # 将合并后的 PDF 写入到输出文件
            with open(output_filepath, 'wb') as output_file:
                merger.write(output_file)
            
            # 关闭 merger
            merger.close()
            
            return f"Merged PDFs saved at {output_filepath}"