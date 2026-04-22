class _M:
    class NumberWordFormatter:
        def __init__(self):
            self.ones = ["", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"]
            self.teens = ["TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", 
                          "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"]
            self.tens = ["", "", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"]
            self.thousands = ["", "THOUSAND", "MILLION", "BILLION", "TRILLION"]
        
        def format(self, x):
            """
            将数字转换为单词格式
            :param x: int 或 float，要转换为单词格式的数字
            :return: str，数字的单词格式
            >>> formatter = NumberWordFormatter()
            >>> formatter.format(123456)
            "ONE HUNDRED AND TWENTY THREE THOUSAND FOUR HUNDRED AND FIFTY SIX ONLY"
            """
            if x == 0:
                return "ZERO ONLY"
            
            # Handle negative numbers
            if x < 0:
                return "MINUS " + self.format(-x)
            
            # Handle floats
            if isinstance(x, float):
                integer_part = int(x)
                decimal_part = x - integer_part
                result = self.format(integer_part)
                if decimal_part > 0:
                    # Remove "ONLY" and add decimal part
                    result = result.replace(" ONLY", "")
                    decimal_str = str(decimal_part)[2:]  # Remove "0."
                    result += " POINT"
                    for digit in decimal_str:
                        result += " " + self.ones[int(digit)]
                    result += " ONLY"
                return result
            
            result = self._convert_to_words(x)
            return result + " ONLY"
        
        def _convert_to_words(self, num):
            if num == 0:
                return ""
            
            # Break number into groups of three digits
            groups = []
            while num > 0:
                groups.append(num % 1000)
                num //= 1000
            
            # Convert each group to words
            words = []
            for i, group in enumerate(groups):
                if group != 0:
                    group_words = self._convert_group(group)
                    if i > 0:
                        group_words += " " + self.thousands[i]
                    words.append(group_words)
            
            # Reverse and join
            words.reverse()
            return " ".join(words)
        
        def _convert_group(self, num):
            """Convert a number from 0-999 to words"""
            if num == 0:
                return ""
            
            result = []
            
            # Hundreds place
            hundreds = num // 100
            if hundreds > 0:
                result.append(self.ones[hundreds] + " HUNDRED")
            
            # Tens and ones place
            remainder = num % 100
            if remainder > 0:
                if hundreds > 0:
                    result.append("AND")
                
                if remainder < 10:
                    result.append(self.ones[remainder])
                elif remainder < 20:
                    result.append(self.teens[remainder - 10])
                else:
                    tens_digit = remainder // 10
                    ones_digit = remainder % 10
                    if ones_digit > 0:
                        result.append(self.tens[tens_digit] + " " + self.ones[ones_digit])
                    else:
                        result.append(self.tens[tens_digit])
            
            return " ".join(result)