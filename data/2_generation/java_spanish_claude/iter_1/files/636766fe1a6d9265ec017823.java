import org.objectweb.asm.Symbol;
import org.objectweb.asm.Constants;

public class SymbolTable {
    private final Symbol[] symbols;
    private int size;

    public SymbolTable(int initialCapacity) {
        this.symbols = new Symbol[initialCapacity];
        this.size = 1;
    }

    public int addConstantNameAndType(final String name, final String descriptor) {
        int hashCode = Symbol.CONSTANT_NAME_AND_TYPE_TAG + name.hashCode() * descriptor.hashCode();
        Symbol symbol = lookupSymbol(hashCode);
        
        if (symbol != null && symbol.tag == Symbol.CONSTANT_NAME_AND_TYPE_TAG 
            && symbol.name.equals(name) && symbol.value.equals(descriptor)) {
            return symbol.index;
        }
        
        symbol = addConstantUtf8(name);
        int nameIndex = symbol.index;
        symbol = addConstantUtf8(descriptor); 
        int descriptorIndex = symbol.index;
        
        symbol = addNewSymbol(Symbol.CONSTANT_NAME_AND_TYPE_TAG, nameIndex, descriptorIndex, 
                            hashCode, name, descriptor);
        return symbol.index;
    }

    private Symbol lookupSymbol(int hashCode) {
        for (int i = 1; i < size; i++) {
            if (symbols[i] != null && symbols[i].hashCode == hashCode) {
                return symbols[i]; 
            }
        }
        return null;
    }

    private Symbol addNewSymbol(int tag, int index1, int index2, int hashCode, 
                              String name, String value) {
        Symbol symbol = new Symbol(tag, index1, index2, hashCode, name, value);
        symbols[size] = symbol;
        symbol.index = size++;
        return symbol;
    }

    private Symbol addConstantUtf8(String value) {
        int hashCode = Symbol.CONSTANT_UTF8_TAG + value.hashCode();
        Symbol symbol = lookupSymbol(hashCode);
        
        if (symbol != null && symbol.tag == Symbol.CONSTANT_UTF8_TAG 
            && symbol.value.equals(value)) {
            return symbol;
        }
        
        return addNewSymbol(Symbol.CONSTANT_UTF8_TAG, 0, 0, hashCode, null, value);
    }
}