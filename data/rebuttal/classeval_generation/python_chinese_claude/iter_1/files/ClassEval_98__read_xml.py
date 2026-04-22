class _M:
    import xml.etree.ElementTree as ET
    
    class XMLProcessor:
        def __init__(self, file_path):
            """
            初始化 XMLProcessor 类。
            :param file_path: XML 文件的路径
            """
            self.file_path = file_path
        
        def read_xml(self):
            """
            读取 XML 文件并返回根元素。
            :return: Element，XML 文件的根元素。
            >>> xml_processor = XMLProcessor('test.xml')
            >>> root_element = xml_processor.read_xml()
            >>> print(root_element)
            <Element 'root' at 0x7f8e3b7eb180>
            """
            tree = ET.parse(self.file_path)
            root = tree.getroot()
            return root