import org.objectweb.asm.Symbol;

public class SymbolTable {
    private final Entry[] entries;
    private int size;
    private static final int CONSTANT_NAMEANDTYPE = 12;

    private static class Entry {
        final int type;
        final String name;
        final String value;
        final int index;
        Entry next;

        Entry(int type, String name, String value, int index) {
            this.type = type;
            this.name = name;
            this.value = value;
            this.index = index;
        }
    }

    public Symbol addConstantNameAndType(final String name, final String descriptor) {
        int hashCode = hash(CONSTANT_NAMEANDTYPE, name, descriptor);
        Entry entry = entries[hashCode % entries.length];
        
        while (entry != null) {
            if (entry.type == CONSTANT_NAMEANDTYPE 
                && entry.name.equals(name)
                && entry.value.equals(descriptor)) {
                return new Symbol(entry.index);
            }
            entry = entry.next;
        }

        // Not found, create new entry
        Entry newEntry = new Entry(CONSTANT_NAMEANDTYPE, name, descriptor, size++);
        newEntry.next = entries[hashCode % entries.length];
        entries[hashCode % entries.length] = newEntry;
        return new Symbol(newEntry.index);
    }

    private static int hash(int type, String name, String value) {
        return 0x7FFFFFFF & (type + name.hashCode() * value.hashCode());
    }
}