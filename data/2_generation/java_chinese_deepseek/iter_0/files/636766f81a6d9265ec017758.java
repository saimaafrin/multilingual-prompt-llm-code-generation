@Override
public int hashCode() {
    // 假设这是一个简单的类，包含一个字段 `value`
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
}