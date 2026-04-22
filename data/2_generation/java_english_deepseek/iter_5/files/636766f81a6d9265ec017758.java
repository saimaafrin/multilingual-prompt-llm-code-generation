@Override
public int hashCode() {
    // Using a prime number to reduce collisions
    final int prime = 31;
    int result = 1;
    // Combine the hash code of the fields of this type
    // Example: result = prime * result + (field1 == null ? 0 : field1.hashCode());
    // Replace field1 with actual fields of the type
    return result;
}