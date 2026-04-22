@Override
public int hashCode() {
    // 这里假设类中有两个字段：field1 和 field2
    // 你可以根据实际情况调整字段和计算方式
    final int prime = 31;
    int result = 1;
    result = prime * result + ((field1 == null) ? 0 : field1.hashCode());
    result = prime * result + ((field2 == null) ? 0 : field2.hashCode());
    return result;
}