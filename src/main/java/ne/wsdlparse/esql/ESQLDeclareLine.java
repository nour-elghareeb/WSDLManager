package ne.wsdlparse.esql;

import java.util.Locale;

import ne.wsdlparse.esql.constant.ESQLDataType;

public class ESQLDeclareLine extends ESQLLine {
    private String param;
    private ESQLDataType type;
    private String defaultValue = "";

    ESQLDeclareLine(String paramName, ESQLDataType type, String defaultValue) {
        super();
        this.param = paramName;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    ESQLDeclareLine(String paramName, ESQLDataType type) {
        super();
        this.param = paramName;
        this.type = type;
    }

    @Override
    String generate() {
        return String.format(Locale.getDefault(), "DECLARE %s %s '%s';", this.param, this.type.getValue(),
                this.defaultValue);
    }
}