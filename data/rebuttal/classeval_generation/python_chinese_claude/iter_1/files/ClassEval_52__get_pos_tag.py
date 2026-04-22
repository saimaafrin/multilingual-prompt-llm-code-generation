class _M:
    import nltk
    from nltk import word_tokenize, pos_tag
    import string
    
    class Lemmatization:
        def __init__(self):
            # Download required NLTK data if not already present
            try:
                nltk.data.find('tokenizers/punkt')
            except LookupError:
                nltk.download('punkt')
            try:
                nltk.data.find('taggers/averaged_perceptron_tagger')
            except LookupError:
                nltk.download('averaged_perceptron_tagger')
        
        def get_pos_tag(self, sentence):
            """
            移除句子中的标点符号并对输入句子进行分词，为每个单词标记词性标签。
            :param sentence: 一个句子，str
            :return: list，句子中每个单词的词性标签。
            >>> lemmatization = Lemmatization()
            >>> lemmatization.get_pos_tag("I am running in a race.")
            ['PRP', 'VBP', 'VBG', 'IN', 'DT', 'NN']
            """
            # Tokenize the sentence
            tokens = word_tokenize(sentence)
            
            # Remove punctuation from tokens
            tokens = [token for token in tokens if token not in string.punctuation]
            
            # Get POS tags for each token
            pos_tags = pos_tag(tokens)
            
            # Extract only the tags (second element of each tuple)
            tags = [tag for word, tag in pos_tags]
            
            return tags