import java.util.HashSet;
import java.util.Set;

public class Template {
    private Set<String> templateVariables;

    public Template() {
        this.templateVariables = new HashSet<>();
        // Example initialization, you can add more variables as needed
        this.templateVariables.add("var1");
        this.templateVariables.add("var2");
        this.templateVariables.add("var3");
    }

    /**
     * Verifica se una variabile di template è un membro di questo template.
     * @param name nome La variabile di template.
     * @return true se la variabile di template è un membro del template, altrimenti false.
     */
    public final boolean isTemplateVariablePresent(String name) {
        return this.templateVariables.contains(name);
    }

    public static void main(String[] args) {
        Template template = new Template();
        System.out.println(template.isTemplateVariablePresent("var1")); // true
        System.out.println(template.isTemplateVariablePresent("var4")); // false
    }
}