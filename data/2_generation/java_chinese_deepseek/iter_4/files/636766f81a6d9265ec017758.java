@Override
public int hashCode() {
    // 这里假设类中有一些字段，例如 field1, field2, field3
    // 你可以根据实际情况调整这些字段
    final int prime = 31;
    int result = 1;
    result = prime * result + ((field1 == null) ? 0 : field1.hashCode());
    result = prime * result + ((field2 == null) ? 0 : field2.hashCode());
    result = prime * result + ((field3 == null) ? 0 : field3.hashCode());
    return result;
}