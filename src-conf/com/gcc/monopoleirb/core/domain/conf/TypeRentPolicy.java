//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.6 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2012.09.29 à 04:45:56 PM CEST 
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
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propriété rentPolicy1.
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
     * Définit la valeur de la propriété rentPolicy1.
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
     * Obtient la valeur de la propriété rentPolicy2.
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
     * Définit la valeur de la propriété rentPolicy2.
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
     * Obtient la valeur de la propriété rentPolicy3.
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
     * Définit la valeur de la propriété rentPolicy3.
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
     * Obtient la valeur de la propriété rentPolicy4.
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
     * Définit la valeur de la propriété rentPolicy4.
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
     * Obtient la valeur de la propriété rentPolicy5.
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
     * Définit la valeur de la propriété rentPolicy5.
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
