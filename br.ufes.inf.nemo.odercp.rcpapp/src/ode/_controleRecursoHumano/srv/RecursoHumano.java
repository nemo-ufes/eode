/**
 * RecursoHumano.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ode._controleRecursoHumano.srv;

public class RecursoHumano  extends ode._controleRecursoHumano.srv.ObjetoPersistente  implements java.io.Serializable {
    private boolean ativo;

    private java.lang.Integer cargaHoraria;

    private ode._controleRecursoHumano.srv.KRecursoHumano cargo;

    private java.lang.String email;

    private java.lang.String nome;

    private java.lang.String telefone;

    private ode._controleRecursoHumano.srv.Tema[] temasInteresse;

    public RecursoHumano() {
    }

    public RecursoHumano(
           java.lang.String uuid,
           java.lang.Object id,
           java.lang.Object version,
           boolean ativo,
           java.lang.Integer cargaHoraria,
           ode._controleRecursoHumano.srv.KRecursoHumano cargo,
           java.lang.String email,
           java.lang.String nome,
           java.lang.String telefone,
           ode._controleRecursoHumano.srv.Tema[] temasInteresse) {
        super(
            uuid,
            id,
            version);
        this.ativo = ativo;
        this.cargaHoraria = cargaHoraria;
        this.cargo = cargo;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.temasInteresse = temasInteresse;
    }


    /**
     * Gets the ativo value for this RecursoHumano.
     * 
     * @return ativo
     */
    public boolean isAtivo() {
        return ativo;
    }


    /**
     * Sets the ativo value for this RecursoHumano.
     * 
     * @param ativo
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


    /**
     * Gets the cargaHoraria value for this RecursoHumano.
     * 
     * @return cargaHoraria
     */
    public java.lang.Integer getCargaHoraria() {
        return cargaHoraria;
    }


    /**
     * Sets the cargaHoraria value for this RecursoHumano.
     * 
     * @param cargaHoraria
     */
    public void setCargaHoraria(java.lang.Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }


    /**
     * Gets the cargo value for this RecursoHumano.
     * 
     * @return cargo
     */
    public ode._controleRecursoHumano.srv.KRecursoHumano getCargo() {
        return cargo;
    }


    /**
     * Sets the cargo value for this RecursoHumano.
     * 
     * @param cargo
     */
    public void setCargo(ode._controleRecursoHumano.srv.KRecursoHumano cargo) {
        this.cargo = cargo;
    }


    /**
     * Gets the email value for this RecursoHumano.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this RecursoHumano.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the nome value for this RecursoHumano.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this RecursoHumano.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the telefone value for this RecursoHumano.
     * 
     * @return telefone
     */
    public java.lang.String getTelefone() {
        return telefone;
    }


    /**
     * Sets the telefone value for this RecursoHumano.
     * 
     * @param telefone
     */
    public void setTelefone(java.lang.String telefone) {
        this.telefone = telefone;
    }


    /**
     * Gets the temasInteresse value for this RecursoHumano.
     * 
     * @return temasInteresse
     */
    public ode._controleRecursoHumano.srv.Tema[] getTemasInteresse() {
        return temasInteresse;
    }


    /**
     * Sets the temasInteresse value for this RecursoHumano.
     * 
     * @param temasInteresse
     */
    public void setTemasInteresse(ode._controleRecursoHumano.srv.Tema[] temasInteresse) {
        this.temasInteresse = temasInteresse;
    }

    public ode._controleRecursoHumano.srv.Tema getTemasInteresse(int i) {
        return this.temasInteresse[i];
    }

    public void setTemasInteresse(int i, ode._controleRecursoHumano.srv.Tema _value) {
        this.temasInteresse[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RecursoHumano)) return false;
        RecursoHumano other = (RecursoHumano) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.ativo == other.isAtivo() &&
            ((this.cargaHoraria==null && other.getCargaHoraria()==null) || 
             (this.cargaHoraria!=null &&
              this.cargaHoraria.equals(other.getCargaHoraria()))) &&
            ((this.cargo==null && other.getCargo()==null) || 
             (this.cargo!=null &&
              this.cargo.equals(other.getCargo()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.telefone==null && other.getTelefone()==null) || 
             (this.telefone!=null &&
              this.telefone.equals(other.getTelefone()))) &&
            ((this.temasInteresse==null && other.getTemasInteresse()==null) || 
             (this.temasInteresse!=null &&
              java.util.Arrays.equals(this.temasInteresse, other.getTemasInteresse())));
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
        _hashCode += (isAtivo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCargaHoraria() != null) {
            _hashCode += getCargaHoraria().hashCode();
        }
        if (getCargo() != null) {
            _hashCode += getCargo().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getTelefone() != null) {
            _hashCode += getTelefone().hashCode();
        }
        if (getTemasInteresse() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTemasInteresse());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTemasInteresse(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RecursoHumano.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://srv._controleRecursoHumano.ode/", "recursoHumano"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargaHoraria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cargaHoraria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cargo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cargo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://srv._controleRecursoHumano.ode/", "kRecursoHumano"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temasInteresse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temasInteresse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://srv._controleRecursoHumano.ode/", "tema"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
