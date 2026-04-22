class _M:
    import string
    
    class LongestWord:
        def __init__(self):
            self.word_list = []
        
        def add_word(self, word):
            """Add a word to the word list."""
            self.word_list.append(word)
        
        def find_longest_word(self, sentence):
            """
            移除标点符号并将句子拆分为单词列表。找到在 self.word_list 中的最长拆分单词。
            单词严格区分大小写。
            :param sentence: 一个句子 str
            :return str: 在 self.word_list 中的最长拆分单词。如果 self.word_list 为空，则返回 ''。
            >>> longestWord = LongestWord()
            >>> longestWord.add_word('A')
            >>> longestWord.add_word('aM')
            >>> longestWord.find_longest_word('I am a student.')
            'a'
            """
            if not self.word_list:
                return ''
            
            # Remove punctuation from the sentence
            translator = str.maketrans('', '', string.punctuation)
            cleaned_sentence = sentence.translate(translator)
            
            # Split sentence into words
            words = cleaned_sentence.split()
            
            # Find the longest word that exists in self.word_list
            longest = ''
            for word in words:
                if word in self.word_list and len(word) > len(longest):
                    longest = word
            
            return longest