package ne.wsdlparse.esql;

import java.util.ArrayList;
import java.util.HashSet;

import ne.wsdlparse.WSDLManagerRetrieval;
import ne.wsdlparse.esql.constant.ESQLDataType;
import ne.wsdlparse.esql.constant.ESQLSource;

public class ESQLBlock {
    private WSDLManagerRetrieval manager;
    private ArrayList<ESQLLine> elementsLines;
    private ArrayList<ESQLLine> nsDeclarations;
    private HashSet<String> prefixes;

    public ESQLBlock(WSDLManagerRetrieval manager) {
        this.manager = manager;
        this.elementsLines = new ArrayList<ESQLLine>();
        this.nsDeclarations = new ArrayList<ESQLLine>();
        this.prefixes = new HashSet<String>();
    }

    void addLine(ESQLLine line) {
        this.elementsLines.add(line);
    }

    void addPrefix(String prefix) {
        if (prefix == null)
            return;
        this.prefixes.add(prefix);
    }

    private void generateNSLines() {
        this.nsDeclarations.clear();
        for (String prefix : prefixes) {
            this.nsDeclarations
                    .add(new ESQLDeclareLine(prefix, ESQLDataType.NAMESPACE, this.manager.getNamespaceURI(prefix)));
        }
    }

    public String generate(ESQLSource type) {
        this.generateNSLines();
        StringBuilder builder = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        for (ESQLLine line : this.nsDeclarations) {
            builder.append(line.generate());
            builder.append(newLine);
        }
        for (ESQLLine line : this.elementsLines) {
            builder.append(line.generate());
            builder.append(newLine);
        }
        return builder.toString();
    }
}