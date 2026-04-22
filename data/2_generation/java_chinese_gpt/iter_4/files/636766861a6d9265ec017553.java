public final boolean isTemplateVariablePresent(String name) {
    // Assuming we have a list of template variables stored in a Set for quick lookup
    Set<String> templateVariables = new HashSet<>(Arrays.asList("var1", "var2", "var3")); // Example variables

    // Check if the provided name is present in the set of template variables
    return templateVariables.contains(name);
}