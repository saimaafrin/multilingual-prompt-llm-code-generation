import java.util.Stack;

public class FrameStack {
    private Stack<String> stack;

    /**
     * Rimuove quanti più tipi astratti possibile dallo stack del frame di output come descritto dal descrittore fornito.
     * @param descriptor un tipo o un descrittore di metodo (nel qual caso vengono rimossi i suoi tipi di argomento).
     */
    private void pop(final String descriptor) {
        if (descriptor.startsWith("(")) {
            // È un descrittore di metodo, estrai gli argomenti
            int endParams = descriptor.indexOf(')');
            String params = descriptor.substring(1, endParams);
            
            int i = 0;
            while (i < params.length()) {
                char c = params.charAt(i);
                switch (c) {
                    case 'L': // Tipo riferimento
                        i = params.indexOf(';', i) + 1;
                        stack.pop();
                        break;
                    case '[': // Array
                        while (params.charAt(i) == '[') i++;
                        if (params.charAt(i) == 'L') {
                            i = params.indexOf(';', i) + 1;
                        } else {
                            i++;
                        }
                        stack.pop();
                        break;
                    case 'J': // long
                    case 'D': // double
                        stack.pop();
                        stack.pop(); // Occupa due slot
                        i++;
                        break;
                    default: // Tipo primitivo singolo
                        stack.pop();
                        i++;
                        break;
                }
            }
        } else {
            // È un singolo tipo
            if (descriptor.equals("J") || descriptor.equals("D")) {
                stack.pop();
                stack.pop(); // long e double occupano due slot
            } else {
                stack.pop();
            }
        }
    }
}