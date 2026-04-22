import java.util.HashSet;
import java.util.Set;

public class Template {
    private Set<String> templateVariables;

    public Template() {
        this.templateVariables = new HashSet<>();
        // Initialize with some default template variables
        this.templateVariables.add("var1");
        this.templateVariables.add("var2");
        this.templateVariables.add("var3");
    }

    /**
     * 确定模板变量是否是该模板的成员。
     * @param name 模板变量的名称。
     * @return 如果模板变量是模板的成员，则返回真；否则返回假。
     */
    public final boolean isTemplateVariablePresent(String name) {
        return templateVariables.contains(name);
    }

    public static void main(String[] args) {
        Template template = new Template();
        System.out.println(template.isTemplateVariablePresent("var1")); // true
        System.out.println(template.isTemplateVariablePresent("var4")); // false
    }
}