//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.6 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2012.09.29 � 04:45:56 PM CEST 
//


package com.gcc.monopoleirb.core.domain.conf;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour type_rent-policy complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="type_rent-policy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="rent-policy1" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="rent-policy2" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="rent-policy3" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="rent-policy4" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="rent-policy5" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "type_rent-policy")
public class TypeRentPolicy {

    @XmlAttribute(name = "rent-policy1", required = true)
    protected BigInteger rentPolicy1;
    @XmlAttribute(name = "rent-policy2", required = true)
    protected BigInteger rentPolicy2;
    @XmlAttribute(name = "rent-policy3", required = true)
    protected BigInteger rentPolicy3;
    @XmlAttribute(name = "rent-policy4", required = true)
    protected BigInteger rentPolicy4;
    @XmlAttribute(name = "rent-policy5", required = true)
    protected BigInteger rentPolicy5;

    /**
     * Obtient la valeur de la propri�t� rentPolicy1.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRentPolicy1() {
        return rentPolicy1;
    }

    /**
     * D�finit la valeur de la propri�t� rentPolicy1.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRentPolicy1(BigInteger value) {
        this.rentPolicy1 = value;
    }

    /**
     * Obtient la valeur de la propri�t� rentPolicy2.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRentPolicy2() {
        return rentPolicy2;
    }

    /**
     * D�finit la valeur de la propri�t� rentPolicy2.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRentPolicy2(BigInteger value) {
        this.rentPolicy2 = value;
    }

    /**
     * Obtient la valeur de la propri�t� rentPolicy3.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRentPolicy3() {
        return rentPolicy3;
    }

    /**
     * D�finit la valeur de la propri�t� rentPolicy3.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRentPolicy3(BigInteger value) {
        this.rentPolicy3 = value;
    }

    /**
     * Obtient la valeur de la propri�t� rentPolicy4.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRentPolicy4() {
        return rentPolicy4;
    }

    /**
     * D�finit la valeur de la propri�t� rentPolicy4.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRentPolicy4(BigInteger value) {
        this.rentPolicy4 = value;
    }

    /**
     * Obtient la valeur de la propri�t� rentPolicy5.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRentPolicy5() {
        return rentPolicy5;
    }

    /**
     * D�finit la valeur de la propri�t� rentPolicy5.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRentPolicy5(BigInteger value) {
        this.rentPolicy5 = value;
    }

}
