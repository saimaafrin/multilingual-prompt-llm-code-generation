import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Symbol> constantPool = new HashMap<>();

    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (constantPool.containsKey(key)) {
            return constantPool.get(key).getIndex();
        } else {
            Symbol symbol = new Symbol(name, descriptor, constantPool.size() + 1);
            constantPool.put(key, symbol);
            return symbol.getIndex();
        }
    }

    private static class Symbol {
        private final String name;
        private final String descriptor;
        private final int index;

        public Symbol(String name, String descriptor, int index) {
            this.name = name;
            this.descriptor = descriptor;
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}