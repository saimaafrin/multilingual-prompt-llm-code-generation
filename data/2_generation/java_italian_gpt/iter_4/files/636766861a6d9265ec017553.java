import java.util.HashSet;
import java.util.Set;

public class Template {
    private Set<String> templateVariables;

    public Template() {
        this.templateVariables = new HashSet<>();
    }

    public void addTemplateVariable(String name) {
        templateVariables.add(name);
    }

    /** 
     * Verifica se una variabile di template è un membro di questo template.
     * @param name nome La variabile di template.
     * @return true se la variabile di template è un membro del template, altrimenti false.
     */
    public final boolean isTemplateVariablePresent(String name) {
        return templateVariables.contains(name);
    }

    public static void main(String[] args) {
        Template template = new Template();
        template.addTemplateVariable("var1");
        System.out.println(template.isTemplateVariablePresent("var1")); // true
        System.out.println(template.isTemplateVariablePresent("var2")); // false
    }
}