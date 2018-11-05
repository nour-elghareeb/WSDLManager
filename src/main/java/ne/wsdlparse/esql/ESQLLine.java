package ne.wsdlparse.esql;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

import ne.wsdlparse.Utils;
import ne.wsdlparse.WSDLManagerRetrieval;
import java.util.LinkedHashSet;
import ne.wsdlparse.xsd.constant.XSDSimpleElementType;

public class ESQLLine {

    private WSDLManagerRetrieval manager;

    private LinkedHashSet<String> paramPrefixes = new LinkedHashSet<String>();
    private ArrayList<String> paramNs = new ArrayList<String>();
    private ArrayList<String> paramNames = new ArrayList<String>();
    private LinkedHashSet<String> paramAsString = new LinkedHashSet<String>();
    private HashSet<String> prefixes = new HashSet<String>();
    private String value;
    private String xPath = new String();
    Boolean isDone = false;
    private XSDSimpleElementType elementType;

    public ESQLLine(ESQLLine line) {
        this.manager = line.manager;
        this.xPath = line.xPath;
        this.prefixes = line.prefixes;
    }

    public void setElementType(XSDSimpleElementType type) {
        this.elementType = type;
    }


    public ESQLLine(WSDLManagerRetrieval manager) {
        this.manager = manager;
    }

    public Boolean isDone() {
        return this.isDone;
    }

    public void setDone() {
        this.isDone = true;
    }

    public String getXPath() {
        return this.xPath;
    }

    public void setXPath(String path) {
        this.xPath = path;
    }

    public void addParam(String prefix, String name) {
        if (name == null)
            return;
        paramPrefixes.add(prefix);
        String ns = this.manager.getXPath().getNamespaceContext().getNamespaceURI(prefix);
        paramNs.add(ns);
        paramNames.add(name);
        if (!paramAsString.contains(name))
            paramAsString.add(Utils.getParamWithPrefix(prefix, name));
        if (prefix != null)
            prefixes.add(prefix);
        this.xPath += "." + Utils.getParamWithPrefix(prefix, name);
    }

    public String generate(ESQLRoot root) {

        this.value = String.format(Locale.getDefault(), "%s.XMLNSC%s = ''", root.get(), this.xPath);

        return this.value;
    }

    /**
     * @return WSDLManagerRetrieval return the manager
     */
    public WSDLManagerRetrieval getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(WSDLManagerRetrieval manager) {
        this.manager = manager;
    }

    /**
     * @return ArrayList<String> return the paramPrefixes
     */
    public LinkedHashSet<String> getParamPrefixes() {
        return paramPrefixes;
    }

    /**
     * @param paramPrefixes the paramPrefixes to set
     */
    public void LinkedHashSet(LinkedHashSet<String> paramPrefixes) {
        this.paramPrefixes = paramPrefixes;
    }

    /**
     * @return ArrayList<String> return the paramNs
     */
    public ArrayList<String> getParamNs() {
        return paramNs;
    }

    /**
     * @param paramNs the paramNs to set
     */
    public void setParamNs(ArrayList<String> paramNs) {
        this.paramNs = paramNs;
    }

    /**
     * @return ArrayList<String> return the paramNames
     */
    public ArrayList<String> getParamNames() {
        return paramNames;
    }

    /**
     * @param paramNames the paramNames to set
     */
    public void setParamNames(ArrayList<String> paramNames) {
        this.paramNames = paramNames;
    }

    /**
     * @return ArrayList<String> return the paramAsString
     */
    public LinkedHashSet<String> getParamAsString() {
        return paramAsString;
    }

    /**
     * @return HashSet<String> return the prefixes
     */
    public HashSet<String> getPrefixes() {
        return prefixes;
    }

    public String getValue() {
        return this.value;
    }

    /**
     * @param paramPrefixes the paramPrefixes to set
     */
    public void setParamPrefixes(LinkedHashSet<String> paramPrefixes) {
        this.paramPrefixes = paramPrefixes;
    }

    /**
     * @param paramAsString the paramAsString to set
     */
    public void setParamAsString(LinkedHashSet<String> paramAsString) {
        this.paramAsString = paramAsString;
    }

    /**
     * @param prefixes the prefixes to set
     */
    public void setPrefixes(HashSet<String> prefixes) {
        this.prefixes = prefixes;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

}