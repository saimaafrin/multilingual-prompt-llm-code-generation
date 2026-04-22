import org.objectweb.asm.Symbol;
import org.objectweb.asm.Constants;

public class SymbolTable {
    private final Symbol[] symbols;
    private int size;

    public SymbolTable(int initialCapacity) {
        this.symbols = new Symbol[initialCapacity];
        this.size = 1;
    }

    int addConstantNameAndType(final String name, final String descriptor) {
        int hashCode = Symbol.CONSTANT_NAME_AND_TYPE_TAG + name.hashCode() * descriptor.hashCode();
        
        // Check if symbol already exists
        Symbol symbol = lookupSymbol(hashCode, Symbol.CONSTANT_NAME_AND_TYPE_TAG, name, descriptor);
        if (symbol != null) {
            return symbol.index;
        }
        
        // Add name and descriptor to constant pool if not already present
        int nameIndex = addConstantUtf8(name);
        int descriptorIndex = addConstantUtf8(descriptor);
        
        // Create new NameAndType symbol
        symbol = new Symbol(
            size++, 
            Symbol.CONSTANT_NAME_AND_TYPE_TAG,
            nameIndex,
            descriptorIndex,
            hashCode,
            symbols
        );
        
        // Add to symbol table
        int index = hash(hashCode);
        symbol.next = symbols[index];
        symbols[index] = symbol;
        
        return symbol.index;
    }
    
    private Symbol lookupSymbol(int hashCode, int tag, String name, String descriptor) {
        int index = hash(hashCode);
        Symbol symbol = symbols[index];
        while (symbol != null) {
            if (symbol.tag == tag 
                && symbol.hashCode == hashCode
                && symbol.name.equals(name)
                && symbol.value.equals(descriptor)) {
                return symbol;    
            }
            symbol = symbol.next;
        }
        return null;
    }
    
    private int hash(int hashCode) {
        return hashCode % symbols.length;
    }
    
    private int addConstantUtf8(final String value) {
        int hashCode = Symbol.CONSTANT_UTF8_TAG + value.hashCode();
        Symbol symbol = lookupSymbol(hashCode, Symbol.CONSTANT_UTF8_TAG, value, null);
        if (symbol != null) {
            return symbol.index;
        }
        
        symbol = new Symbol(
            size++,
            Symbol.CONSTANT_UTF8_TAG, 
            value,
            null,
            hashCode,
            symbols
        );
        
        int index = hash(hashCode);
        symbol.next = symbols[index];
        symbols[index] = symbol;
        
        return symbol.index;
    }
}