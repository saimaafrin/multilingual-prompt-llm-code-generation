class _M:
    class ExpressionCalculator:
        def calculate(self, expression):
            """
            计算给定后缀表达式的结果
            :param expression: 字符串，要计算的后缀表达式
            :return: 浮点数，计算结果
            >>> expression_calculator = ExpressionCalculator()
            >>> expression_calculator.calculate("2 + 3 * 4")
            14.0
    
            """
            # First convert infix to postfix, then evaluate
            postfix = self._infix_to_postfix(expression)
            return self._evaluate_postfix(postfix)
        
        def _infix_to_postfix(self, expression):
            """Convert infix expression to postfix notation"""
            precedence = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3}
            output = []
            stack = []
            
            tokens = self._tokenize(expression)
            
            for token in tokens:
                if self._is_number(token):
                    output.append(token)
                elif token == '(':
                    stack.append(token)
                elif token == ')':
                    while stack and stack[-1] != '(':
                        output.append(stack.pop())
                    if stack:
                        stack.pop()  # Remove '('
                elif token in precedence:
                    while (stack and stack[-1] != '(' and 
                           stack[-1] in precedence and
                           precedence[stack[-1]] >= precedence[token]):
                        output.append(stack.pop())
                    stack.append(token)
            
            while stack:
                output.append(stack.pop())
            
            return output
        
        def _evaluate_postfix(self, postfix):
            """Evaluate postfix expression"""
            stack = []
            
            for token in postfix:
                if self._is_number(token):
                    stack.append(float(token))
                else:
                    if len(stack) < 2:
                        raise ValueError("Invalid expression")
                    b = stack.pop()
                    a = stack.pop()
                    
                    if token == '+':
                        stack.append(a + b)
                    elif token == '-':
                        stack.append(a - b)
                    elif token == '*':
                        stack.append(a * b)
                    elif token == '/':
                        stack.append(a / b)
                    elif token == '^':
                        stack.append(a ** b)
            
            return stack[0] if stack else 0.0
        
        def _tokenize(self, expression):
            """Tokenize the expression into numbers and operators"""
            tokens = []
            current_number = ""
            
            for char in expression:
                if char.isdigit() or char == '.':
                    current_number += char
                elif char in '+-*/^()':
                    if current_number:
                        tokens.append(current_number)
                        current_number = ""
                    tokens.append(char)
                elif char == ' ':
                    if current_number:
                        tokens.append(current_number)
                        current_number = ""
            
            if current_number:
                tokens.append(current_number)
            
            return tokens
        
        def _is_number(self, token):
            """Check if token is a number"""
            try:
                float(token)
                return True
            except ValueError:
                return False