import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Symbol> constantPool = new HashMap<>();

    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (constantPool.containsKey(key)) {
            return constantPool.get(key).getIndex();
        } else {
            Symbol symbol = new Symbol(constantPool.size() + 1, name, descriptor);
            constantPool.put(key, symbol);
            return symbol.getIndex();
        }
    }

    private static class Symbol {
        private final int index;
        private final String name;
        private final String descriptor;

        public Symbol(int index, String name, String descriptor) {
            this.index = index;
            this.name = name;
            this.descriptor = descriptor;
        }

        public int getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        public String getDescriptor() {
            return descriptor;
        }
    }
}