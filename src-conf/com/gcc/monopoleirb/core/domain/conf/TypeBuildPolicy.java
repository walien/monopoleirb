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
 * <p>Classe Java pour type_build-policy complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="type_build-policy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="housePrice" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="hotelPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "type_build-policy")
public class TypeBuildPolicy {

    @XmlAttribute(name = "housePrice", required = true)
    protected BigInteger housePrice;
    @XmlAttribute(name = "hotelPrice", required = true)
    protected BigInteger hotelPrice;

    /**
     * Obtient la valeur de la propriété housePrice.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHousePrice() {
        return housePrice;
    }

    /**
     * Définit la valeur de la propriété housePrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHousePrice(BigInteger value) {
        this.housePrice = value;
    }

    /**
     * Obtient la valeur de la propriété hotelPrice.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getHotelPrice() {
        return hotelPrice;
    }

    /**
     * Définit la valeur de la propriété hotelPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setHotelPrice(BigInteger value) {
        this.hotelPrice = value;
    }

}
