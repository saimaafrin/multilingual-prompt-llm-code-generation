class _M:
    import string
    import nltk
    from nltk import pos_tag, word_tokenize
    from nltk.corpus import wordnet
    from nltk.stem import WordNetLemmatizer
    
    class Lemmatization:
        def __init__(self):
            self.lemmatizer = WordNetLemmatizer()
            # Download required NLTK data if not already present
            try:
                nltk.data.find('tokenizers/punkt')
            except LookupError:
                nltk.download('punkt')
            try:
                nltk.data.find('taggers/averaged_perceptron_tagger')
            except LookupError:
                nltk.download('averaged_perceptron_tagger')
            try:
                nltk.data.find('corpora/wordnet')
            except LookupError:
                nltk.download('wordnet')
        
        def get_wordnet_pos(self, treebank_tag):
            """
            将Penn Treebank词性标签转换为WordNet词性标签
            """
            if treebank_tag.startswith('J'):
                return wordnet.ADJ
            elif treebank_tag.startswith('V'):
                return wordnet.VERB
            elif treebank_tag.startswith('N'):
                return wordnet.NOUN
            elif treebank_tag.startswith('R'):
                return wordnet.ADV
            else:
                return wordnet.NOUN  # 默认为名词
        
        def lemmatize_sentence(self, sentence):
            """
            移除句子中的标点符号并对输入句子进行分词，为每个单词标记词性标签，
            根据它们的词性对单词进行词形还原，并将结果存储在一个列表中。
            :param sentence: 一个句子，str
            :return: 一个已进行词形还原的单词列表。
            >>> lemmatization = Lemmatization()
            >>> lemmatization.lemmatize_sentence("I am running in a race.")
            ['I', 'be', 'run', 'in', 'a', 'race']
            """
            # 移除标点符号
            sentence_no_punct = sentence.translate(str.maketrans('', '', string.punctuation))
            
            # 分词
            tokens = word_tokenize(sentence_no_punct)
            
            # 词性标注
            pos_tags = pos_tag(tokens)
            
            # 词形还原
            lemmatized_words = []
            for word, tag in pos_tags:
                wordnet_pos = self.get_wordnet_pos(tag)
                lemmatized_word = self.lemmatizer.lemmatize(word, pos=wordnet_pos)
                lemmatized_words.append(lemmatized_word)
            
            return lemmatized_words