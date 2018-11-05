package ne.wsdlparse.esql;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

import ne.wsdlparse.WSDLManagerRetrieval;

public class ESQLBlock {
    private WSDLManagerRetrieval manager;
    private ArrayList<ESQLLine> elementsLines;
    private ArrayList<String> namespaceloines;

    public ESQLBlock(WSDLManagerRetrieval manager, ArrayList<ESQLLine> lines) {
        this.manager = manager;
        this.elementsLines = lines;
        this.generateNSLines();
    }

    private void generateNSLines() {
        final HashSet<String> prefixes = new HashSet<String>();
        for (ESQLLine line : this.elementsLines) {
            prefixes.addAll(line.getPrefixes());
        }

        this.namespaceloines = new ArrayList<String>() {
            {
                for (String prefix : prefixes.toArray(new String[prefixes.size()])) {
                    add(String.format(Locale.getDefault(), "DECLARE %s NAMESPACE '%s';", prefix,
                            ESQLBlock.this.manager.getXPath().getNamespaceContext().getNamespaceURI(prefix)));
                }
            }
        };
    }

    public String generate(ESQLRoot root) {
        StringBuilder builder = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        for (String ns : this.namespaceloines) {
            builder.append(ns);
            builder.append(newLine);
        }
        for (ESQLLine line : this.elementsLines) {
            line.generate(root);
            builder.append(line.getValue());
            builder.append(newLine);
        }
        return builder.toString();
    }
}