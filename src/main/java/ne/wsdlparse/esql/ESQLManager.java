package ne.wsdlparse.esql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ne.wsdlparse.Utils;
import ne.wsdlparse.WSDLManager;
import ne.wsdlparse.xsd.constant.XSDSimpleElementType;

public class ESQLManager {
    private int level = 0;
    private WSDLManager manager;
    private ESQLBlock block;
    private ArrayList<String> paramTree;
    private boolean levelIsRaised = false;
    private HashMap<String, Boolean> isRaised = new HashMap<String, Boolean>();

    public ESQLManager(WSDLManager manager) {
        this.manager = manager;
        this.block = new ESQLBlock(manager);
        this.paramTree = new ArrayList<String>();
    }

    private void addPrefix(String prefix) {
        this.block.addPrefix(prefix);
    }

    private boolean existsInParamTree(String param) {
        for (String par : this.paramTree) {
            String paramWithoutPrefix = Utils.splitPrefixes(par)[1];
            if (paramWithoutPrefix == null)
                paramWithoutPrefix = par;
            if (param.equals(paramWithoutPrefix))
                return true;
        }
        return false;
    }

    public void levelUp(String prefix, String param) {
        if (param == null) {
            return;
        }
        if (this.existsInParamTree(param))
            return;
        // this.levelIsRaised = true;
        // this.isRaised.put(Utils.getParamWithPrefix(param, prefix), true);
        this.level++;
        this.paramTree.add(Utils.getParamWithPrefix(prefix, param));
        this.addPrefix(prefix);
    }

    public void addComment(String comment) {
        if (comment == null)
            return;
        this.block.addLine(new ESQLCommentLine(comment));
    }

    public void addParam(String prefix, String param, XSDSimpleElementType type) {
        if (param == null)
            return;
        this.addPrefix(prefix);
        ESQLSetterLine line = new ESQLSetterLine(
                "".concat(String.join(".", this.paramTree).concat(".").concat(Utils.getParamWithPrefix(prefix, param))),
                type);
        this.block.addLine(line);
    }

    public void levelDown(String param, String prefix) {
        // if (!this.levelIsRaised)
        // return;
        if (param == null)
            return;
        String nameWithPrefix = Utils.getParamWithPrefix(prefix, param);
        this.paramTree.remove(nameWithPrefix);
        this.levelIsRaised = false;
        this.level--;
    }

    public ESQLBlock getESQLBlock() {
        return this.block;
    }

    public void addEmptyLine(boolean allowMultiSuccessiveEmpty) {
        this.block.addEmptyLine(allowMultiSuccessiveEmpty);
    }
}