package ne.wsdlparse.esql;

import ne.wsdlparse.constant.ESQLVerbosity;
import ne.wsdlparse.utility.ConsoleStyle;

public class ESQLCommentLine extends ESQLLine {
    private String value;
    private String title;
    private ESQLVerbosity verbosityType;

    ESQLCommentLine(ESQLVerbosity type, String title, String value) {
        super();
        this.value = value;
        this.title = title;
        this.verbosityType = type;
    }

    ESQLCommentLine(ESQLVerbosity type, String value) {
        super();
        this.value = value;
        this.verbosityType = type;
    }

    String generate(boolean useColors) {
        if (this.value == null)
            return "";
        return "-- ".concat(this.value).concat(";");
    }

    @Override
    public void print() {
        if (this.value == null) {
            System.out.println();
            return;
        }
        if (this.title == null) {
            System.out.println(ConsoleStyle.addTextColor("-- " + this.value, ConsoleStyle.Color.LIGHT_GRAY));
            return;
        }
        System.out.println(ConsoleStyle.addTextColor("-- ", ConsoleStyle.Color.LIGHT_GRAY) + this.title
                + ConsoleStyle.addTextColor(this.value, ConsoleStyle.Color.LIGHT_GRAY));

    }

    public ESQLVerbosity getVerbosity() {
        return this.verbosityType;
    }
}