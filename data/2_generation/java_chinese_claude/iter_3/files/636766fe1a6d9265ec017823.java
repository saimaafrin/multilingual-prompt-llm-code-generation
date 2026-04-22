import org.objectweb.asm.Symbol;
import org.objectweb.asm.Constants;

public class SymbolTable {
    private final Symbol[] symbols;
    private int size;
    
    public int addConstantNameAndType(final String name, final String descriptor) {
        int hashCode = Symbol.CONSTANT_NAME_AND_TYPE_TAG + name.hashCode() * descriptor.hashCode();
        
        // Search for an existing symbol with the same value
        Symbol symbol = symbols[hashCode % symbols.length];
        while (symbol != null) {
            if (symbol.tag == Symbol.CONSTANT_NAME_AND_TYPE_TAG 
                && symbol.name.equals(name)
                && symbol.descriptor.equals(descriptor)) {
                return symbol.index;
            }
            symbol = symbol.next;
        }
        
        // Not found, create a new symbol
        int nameIndex = addConstantUtf8(name);
        int descriptorIndex = addConstantUtf8(descriptor);
        symbol = new Symbol(
            size++, 
            Symbol.CONSTANT_NAME_AND_TYPE_TAG,
            new Symbol(nameIndex, Symbol.CONSTANT_UTF8_TAG, name, null),
            new Symbol(descriptorIndex, Symbol.CONSTANT_UTF8_TAG, descriptor, null)
        );
        
        // Add to symbol table
        int index = hashCode % symbols.length;
        symbol.next = symbols[index];
        symbols[index] = symbol;
        
        return symbol.index;
    }
    
    // Helper method to add UTF8 constant
    private int addConstantUtf8(final String value) {
        int hashCode = Symbol.CONSTANT_UTF8_TAG + value.hashCode();
        Symbol symbol = symbols[hashCode % symbols.length];
        while (symbol != null) {
            if (symbol.tag == Symbol.CONSTANT_UTF8_TAG && symbol.value.equals(value)) {
                return symbol.index;
            }
            symbol = symbol.next;
        }
        symbol = new Symbol(size++, Symbol.CONSTANT_UTF8_TAG, value, null);
        int index = hashCode % symbols.length;
        symbol.next = symbols[index];
        symbols[index] = symbol;
        return symbol.index;
    }
}