import java.util.ArrayList;
import java.util.List;

public class Template {
    private List<String> templateVariables;

    public Template() {
        templateVariables = new ArrayList<>();
    }

    /**
     * Verifica se una variabile di template è un membro di questo template.
     * @param name nome La variabile di template.
     * @return true se la variabile di template è un membro del template, altrimenti false.
     */
    public final boolean isTemplateVariablePresent(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return templateVariables.contains(name.trim());
    }
}