package ne.wsdlparse.esql;

import ne.wsdlparse.esql.constant.ESQLSource;
import ne.wsdlparse.utility.ConsoleStyle;

public class ESQLCommentLine extends ESQLLine {
    private String value;

    ESQLCommentLine(String value) {
        super();
        this.value = value;
    }

    String generate() {
        if (this.value == null)
            return "";
        return "-- ".concat(this.value).concat(";");
    }

    @Override
    public void print() {
        if (this.value == null)
            System.out.println();
        else
            System.out.println(ConsoleStyle.addTextColor("-- " + this.value, ConsoleStyle.Color.LIGHT_GRAY));
    }
}