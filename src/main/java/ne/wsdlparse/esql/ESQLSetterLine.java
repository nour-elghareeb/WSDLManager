package ne.wsdlparse.esql;

import java.util.Locale;

import ne.wsdlparse.esql.constant.ESQLSource;
import ne.wsdlparse.xsd.constant.XSDSimpleElementType;

public class ESQLSetterLine extends ESQLLine {
    private XSDSimpleElementType xsdType;
    private ESQLSource source = ESQLSource.OUTPUT;
    private String xPath;

    public ESQLSetterLine(String xPath, XSDSimpleElementType xsdType) {
        super();
        this.xPath = xPath;
        this.xsdType = xsdType;
    }

    public void setSource(ESQLSource source) {
        this.source = source;
    }

    @Override
    String generate() {
        return String.format(Locale.getDefault(), "%s.XMLNSC.%s = '' -- %s;", this.source.get(), this.xPath,
                this.xsdType.getDesc());
    };

}