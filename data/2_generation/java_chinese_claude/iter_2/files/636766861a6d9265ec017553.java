import java.util.Map;
import java.util.HashMap;

public class Template {
    private Map<String, Object> variables;
    
    public Template() {
        variables = new HashMap<>();
    }
    
    /**
     * 确定模板变量是否是该模板的成员。
     * @param name 模板变量的名称。
     * @return 如果模板变量是模板的成员，则返回真；否则返回假。
     */
    public final boolean isTemplateVariablePresent(String name) {
        if (name == null) {
            return false;
        }
        return variables.containsKey(name);
    }
}