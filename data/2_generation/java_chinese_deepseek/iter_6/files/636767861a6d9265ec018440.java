public void abbreviate(final int nameStart, final StringBuffer buf) {
    if (buf == null || nameStart < 0 || nameStart >= buf.length()) {
        return; // 如果缓冲区为空或起始位置无效，直接返回
    }

    // 获取名称部分
    String name = buf.substring(nameStart);

    // 缩写逻辑：取每个单词的首字母
    String[] words = name.split("\\s+");
    StringBuilder abbreviation = new StringBuilder();
    for (String word : words) {
        if (!word.isEmpty()) {
            abbreviation.append(word.charAt(0));
        }
    }

    // 替换原名称部分为缩写
    buf.replace(nameStart, buf.length(), abbreviation.toString());
}