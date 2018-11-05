package ne.wsdlparse.xsd.constant;

import ne.wsdlparse.exception.WSDLException;
import ne.wsdlparse.exception.WSDLExceptionCode;

public enum XSDSimpleElementType {
    BYTE("byte", "A signed 8-bit integer", String.class), DECIMAL("decimal", "A decimal value", String.class),
    INT("int", "A signed 32-bit integer", String.class), INTEGER("integer", "An integer value", String.class),
    LONG("long", "A signed 64-bit integer", String.class),
    NEGATIVE_INTEGER("negativeInteger", "An integer containing only negative values (..,-2,-1", String.class),
    NON_NEGATIVE_INTEGER("nonNegativeInteger", "An integer containing only non-negative values (0,1,2,..)",
            String.class),
    NON_PISITIVE_INTEGER("nonPositiveInteger", "An integer containing only non-positive values (..,-2,-1,0)",
            String.class),
    POSITIVE_INTEGER("positiveInteger", "An integer containing only positive values (1,2,..)", String.class),
    SHORT("short", "A signed 16-bit integer", String.class),
    UNSIGNED_LONG("unsignedLong", "An unsigned 64-bit integer", String.class),
    UNSIGNED_INTEGER("unsignedInt", "An unsigned 32-bit integer", String.class),
    UNSIGNED_SHORT("unsignedShort", "An unsigned 16-bit integer", String.class),
    UNSIGNED_BYTE("unsignedByte", "An unsigned 8-bit integer", String.class),
    DOUBLE("double", "a 64-bit floating-point", String.class), FLOAT("float", "32-bit floating-point", String.class),
    BASE64_BINARY("base64Binary", "A base64-encoded binary data", String.class),

    STRING("string", "String", String.class), ANY_URI("anyURI", "URI string, ie: http://example.com", String.class),
    DATE("date", "Date format example: YYYY-MM-DD", String.class),
    BOOLEAN("boolean", "Boolean value, true or false", String.class),
    HEX_BINRARY("hexBinary", "hexadecimal-encoded binary data", String.class), APP_INFO("appInfo", "", String.class),
    DOCUMENTATION("documentation", "", String.class);

    private String desc;
    private String type;
    private Class<?> classType;

    XSDSimpleElementType(String type, String desc, Class<?> classType) {
        this.type = type;
        this.desc = desc;
        this.classType = classType;
    }

    public static XSDSimpleElementType parse(String value) throws WSDLException {
        for (XSDSimpleElementType type : XSDSimpleElementType.values()) {
            if (value.equals(type.getType()))
                return type;
        }
        throw new WSDLException(WSDLExceptionCode.XSD_NOT_SIMPLE_ELEMENT);
    }

    /**
     * @return String return the desc
     */
    public String getDesc() {
        return desc;
    }

    public String getType() {
        return this.type;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Class<?> return the classType
     */
    public Class<?> getClassType() {
        return this.classType;
    }

    /**
     * @param classType the classType to set
     */
    public void setClassType(Class<?> classType) {
        this.classType = classType;
    }

}