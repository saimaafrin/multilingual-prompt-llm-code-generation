import java.util.Objects;

public class Template {
    private Set<String> templateVariables;

    public Template() {
        this.templateVariables = new HashSet<>();
    }

    /**
     * Ascertain if a template variable is a member of this template.
     * @param name The template variable.
     * @return true if the template variable is a member of the template, otherwise false.
     */
    public final boolean isTemplateVariablePresent(String name) {
        if (name == null) {
            return false;
        }
        return templateVariables.contains(name.trim());
    }
}