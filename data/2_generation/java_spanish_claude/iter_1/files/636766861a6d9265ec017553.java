import java.util.Objects;

public class Template {
    private List<String> templateVariables;

    public Template() {
        this.templateVariables = new ArrayList<>();
    }

    /**
     * Determina si una variable de plantilla es un miembro de esta plantilla.
     * @param name nombre La variable de plantilla.
     * @return true si la variable de plantilla es un miembro de la plantilla, de lo contrario false.
     */
    public final boolean isTemplateVariablePresent(String name) {
        if (name == null) {
            return false;
        }
        return templateVariables.contains(name.trim());
    }
}