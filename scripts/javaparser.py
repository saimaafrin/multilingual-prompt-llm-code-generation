import requests
import hashlib

class JavaParserClient:
    """
    A client class that interacts with a Java parser server for analyzing Java code.

    This class provides methods to interact with a server that can parse Java code, 
    extract information such as class names, imports, method code, and more. It also 
    includes utility methods for handling GitHub URLs and generating SHA-256 hashes.

    Attributes:
        gateway (object): The gateway object for communication with the server.
        java_parser_server (object): The Java parser server that handles code analysis.
    """

    def __init__(self, gateway, java_parser_server):
        """
        Initializes the JavaParserClient with a gateway and Java parser server.

        Args:
            gateway (object): The gateway for communication with the server.
            java_parser_server (object): The Java parser server to analyze Java code.
        """
        self.gateway = gateway
        self.java_parser_server = java_parser_server

    def close(self):
        """Closes the gateway connection."""
        self.gateway.close()

    def to_raw_github_url(self, github_url):
        """
        Converts a GitHub URL to a raw GitHub content URL.

        Args:
            github_url (str): The original GitHub URL (e.g., pointing to a Java file).

        Returns:
            str: The corresponding raw content URL (e.g., pointing to the raw Java file).
        """
        raw_url = github_url.replace("github.com", "raw.githubusercontent.com")
        raw_url = raw_url.replace("/blob/", "/")
        return raw_url

    def make_request(self, url):
        """
        Makes an HTTP GET request to fetch the content of a URL.

        Args:
            url (str): The URL to make the request to.

        Returns:
            str: The raw text content from the response.
        """
        response = requests.get(url)
        return response.text

    def make_sha(self, string):
        """
        Generates a SHA-256 hash of a given string.

        Args:
            string (str): The input string to hash.

        Returns:
            str: The SHA-256 hash of the input string.
        """
        sha256_hash = hashlib.sha256()
        sha256_hash.update(string.encode())
        return sha256_hash.hexdigest()

    def get_class_name(self, java_code):
        """
        Extracts the class name from the provided Java code.

        Args:
            java_code (str): The Java code to parse.

        Returns:
            str: The name of the class in the provided Java code.
        """
        return self.java_parser_server.getClassName(java_code)

    def get_java_class(self, java_code, class_name):
        """
        Retrieves the Java class from the provided code for the given class name.

        Args:
            java_code (str): The Java code to parse.
            class_name (str): The name of the class to extract.

        Returns:
            dict: The details of the specified Java class.
        """
        return self.java_parser_server.getJavaClass(java_code, class_name)

    def get_imports(self, java_code):
        """
        Extracts the import statements from the provided Java code.

        Args:
            java_code (str): The Java code to parse.

        Returns:
            list: A list of import statements in the Java code.
        """
        return self.java_parser_server.getImports(java_code)

    def get_doc_and_signature(self, java_code):
        """
        Extracts documentation and method signatures from the provided Java code.

        Args:
            java_code (str): The Java code to parse.

        Returns:
            dict: A dictionary containing method documentation and signatures.
        """
        return self.java_parser_server.getDocAndSignature(java_code)

    def getMethodCode(self, java_code, method_code, id):
        """
        Retrieves the method code for a given method in the Java code.

        Args:
            java_code (str): The Java code containing the method.
            method_code (str): The method code to search for.
            id (str): An identifier for the method.

        Returns:
            str: The method code, or "ERROR" if an exception occurs.
        """
        try:
            return self.java_parser_server.getMethodCode(java_code, method_code, id)
        except Exception as e:
            return "ERROR"
