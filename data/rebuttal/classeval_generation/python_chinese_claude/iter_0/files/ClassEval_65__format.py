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
            
            # Convert integer to words
            result = self._convert_to_words(x)
            return result + " ONLY"
        
        def _convert_to_words(self, num):
            if num == 0:
                return ""
            
            result = []
            thousand_index = 0
            
            while num > 0:
                chunk = num % 1000
                if chunk != 0:
                    chunk_words = self._convert_chunk(chunk)
                    if thousand_index > 0:
                        chunk_words += " " + self.thousands[thousand_index]
                    result.append(chunk_words)
                num //= 1000
                thousand_index += 1
            
            return " ".join(reversed(result))
        
        def _convert_chunk(self, num):
            """Convert a number less than 1000 to words"""
            if num == 0:
                return ""
            
            result = []
            
            # Handle hundreds
            hundreds = num // 100
            if hundreds > 0:
                result.append(self.ones[hundreds] + " HUNDRED")
            
            # Handle tens and ones
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