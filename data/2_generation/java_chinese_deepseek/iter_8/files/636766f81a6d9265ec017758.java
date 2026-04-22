@Override
public int hashCode() {
    // 这里假设类的字段为 field1, field2, field3
    // 使用 Objects.hash() 方法来生成哈希码
    return Objects.hash(field1, field2, field3);
}