import java.util.Objects;

public class Template {
    private Set<String> variables;

    /**
     * Ascertain if a template variable is a member of this template.
     * @param name The template variable.
     * @return true if the template variable is a member of the template, otherwise false.
     */
    public boolean containsVariable(String name) {
        if (name == null) {
            return false;
        }
        return variables != null && variables.contains(name.trim());
    }
}