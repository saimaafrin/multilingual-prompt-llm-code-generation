public class FrameVisitor {
    private int[] currentFrame;
    private int nextIndex;

    public FrameVisitor() {
        this.currentFrame = new int[0];
        this.nextIndex = 0;
    }

    /**
     * Inicia la visita de un nuevo "stack map frame", almacenado en {@link #currentFrame}.
     * @param offset   el desplazamiento de bytecode de la instrucción a la que corresponde el "frame".
     * @param numLocal el número de variables locales en el "frame".
     * @param numStack el número de elementos apilados en el "frame".
     * @return el índice del siguiente elemento que se escribirá en este "frame".
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // Calcular el tamaño total del frame
        int frameSize = numLocal + numStack;
        
        // Inicializar el frame con el tamaño calculado
        currentFrame = new int[frameSize];
        
        // Reiniciar el índice del siguiente elemento
        nextIndex = 0;
        
        // Devolver el índice del siguiente elemento que se escribirá
        return nextIndex;
    }
}