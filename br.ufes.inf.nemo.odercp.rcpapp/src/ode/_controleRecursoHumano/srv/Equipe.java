/**
 * Equipe.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ode._controleRecursoHumano.srv;

public class Equipe  extends ode._controleRecursoHumano.srv.ObjetoPersistente  implements java.io.Serializable {
    private ode._controleRecursoHumano.srv.Projeto projeto;

    public Equipe() {
    }

    public Equipe(
           java.lang.String uuid,
           java.lang.Object id,
           java.lang.Object version,
           ode._controleRecursoHumano.srv.Projeto projeto) {
        super(
            uuid,
            id,
            version);
        this.projeto = projeto;
    }


    /**
     * Gets the projeto value for this Equipe.
     * 
     * @return projeto
     */
    public ode._controleRecursoHumano.srv.Projeto getProjeto() {
        return projeto;
    }


    /**
     * Sets the projeto value for this Equipe.
     * 
     * @param projeto
     */
    public void setProjeto(ode._controleRecursoHumano.srv.Projeto projeto) {
        this.projeto = projeto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Equipe)) return false;
        Equipe other = (Equipe) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.projeto==null && other.getProjeto()==null) || 
             (this.projeto!=null &&
              this.projeto.equals(other.getProjeto())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getProjeto() != null) {
            _hashCode += getProjeto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Equipe.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://srv._controleRecursoHumano.ode/", "equipe"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projeto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "projeto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://srv._controleRecursoHumano.ode/", "projeto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
