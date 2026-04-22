import org.objectweb.asm.Symbol;

public class SymbolTable {
    private final Entry[] entries;
    private int size;
    private static final int CONSTANT_NAMEANDTYPE = 12;
    
    private static class Entry {
        final int type;
        final String name;
        final String value;
        Entry next;
        
        Entry(int type, String name, String value, Entry next) {
            this.type = type;
            this.name = name;
            this.value = value;
            this.next = next;
        }
    }

    public Symbol addConstantNameAndType(final String name, final String descriptor) {
        int hashCode = hash(CONSTANT_NAMEANDTYPE, name, descriptor);
        Entry entry = entries[hashCode % entries.length];
        
        while (entry != null) {
            if (entry.type == CONSTANT_NAMEANDTYPE 
                && entry.name.equals(name)
                && entry.value.equals(descriptor)) {
                return new Symbol(entry.type, entry.name, entry.value, size);
            }
            entry = entry.next;
        }
        
        return addConstantNameAndTypeInternal(name, descriptor);
    }
    
    private Symbol addConstantNameAndTypeInternal(final String name, final String descriptor) {
        int hashCode = hash(CONSTANT_NAMEANDTYPE, name, descriptor);
        Entry entry = new Entry(CONSTANT_NAMEANDTYPE, name, descriptor, 
                              entries[hashCode % entries.length]);
        entries[hashCode % entries.length] = entry;
        return new Symbol(CONSTANT_NAMEANDTYPE, name, descriptor, size++);
    }
    
    private static int hash(int type, String name, String value) {
        return 0x7FFFFFFF & (type + name.hashCode() * value.hashCode());
    }
}