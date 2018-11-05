package ne.wsdlparse.esql;

public enum ESQLRoot {
    INPUT("InputRoot"), OUTPUT("OutputRoot"), ENVIRONMENT("Environment"), LOCAL_ENVIRONMENT("LocalEnvironment"),
    LOCAL_OUTPUT_ENVIRONMENT("LocalOutputEnvironment");
    private String value;

    ESQLRoot(String value) {
        this.value = value;
    }

    public String get() {
        return this.value;
    }
}