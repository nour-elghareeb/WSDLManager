package ne.wsdlparse.esql;

import ne.wsdlparse.esql.constant.ESQLSource;

public class ESQLCommentLine extends ESQLLine {
    private String value;

    ESQLCommentLine(String value) {
        super();
        this.value = value;
    }

    String generate() {
        return "-- ".concat(this.value).concat(";");
    }
}