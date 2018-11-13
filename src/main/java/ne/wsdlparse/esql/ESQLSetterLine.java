package ne.wsdlparse.esql;

import java.util.Locale;

import ne.wsdlparse.esql.constant.ESQLSource;
import ne.wsdlparse.utility.ConsoleStyle;
import ne.wsdlparse.xsd.constant.XSDSimpleElementType;

public class ESQLSetterLine extends ESQLLine {
    private XSDSimpleElementType xsdType;
    private ESQLSource source = ESQLSource.OUTPUT;
    private String xPath;
    private boolean inputMode;

    public ESQLSetterLine(String xPath, XSDSimpleElementType xsdType) {
        super();
        this.xPath = xPath;
        this.xsdType = xsdType;
    }

    public void setSource(ESQLSource source) {
        this.source = source;
    }
    public void setInputMode(boolean useReference){
        this.inputMode = useReference;
    }

    @Override
    String generate() {
        return String.format(Locale.getDefault(), "SET %s.XMLNSC.%s = '' -- %s;", this.source.get(), this.xPath,
                this.xsdType.getDesc());
    }

    @Override
    public void print() {
        String placeholder = "SET %s.XMLNSC.%s = '' %s;%s";
        System.out.printf(Locale.getDefault(), placeholder,
                ConsoleStyle.addTextColor(this.source.get(), ConsoleStyle.Color.GREEN),
                ConsoleStyle.addTextColor(this.xPath, ConsoleStyle.Color.BLUE),
                ConsoleStyle.addTextColor("-- " + this.xsdType.getDesc(), ConsoleStyle.Color.LIGHT_GRAY),
                System.getProperty("line.separator"));
    };

}