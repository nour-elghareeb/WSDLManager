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
    private boolean lastWasEmpty = false;

    public ESQLBlock(WSDLManagerRetrieval manager) {
        this.manager = manager;
        this.elementsLines = new ArrayList<ESQLLine>();
        this.nsDeclarations = new ArrayList<ESQLLine>();
        this.prefixes = new HashSet<String>();
    }

    void addLine(ESQLLine line) {
        this.elementsLines.add(line);
        this.lastWasEmpty = false;
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

    public void print(ESQLSource type) {
        this.generateNSLines();
        for (ESQLLine line : this.nsDeclarations) {
            line.print();
        }
        for (ESQLLine line : this.elementsLines) {
            line.print();
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

    public void addEmptyLine(boolean allowMultiSuccessiveEmpty) {
        if (!this.lastWasEmpty || (allowMultiSuccessiveEmpty && this.lastWasEmpty))
            this.elementsLines.add(new ESQLCommentLine(null));
        this.lastWasEmpty = true;
    }

    public void clear() {
        this.elementsLines.clear();
        this.prefixes.clear();
        this.nsDeclarations.clear();
        this.lastWasEmpty = false;
    }
}