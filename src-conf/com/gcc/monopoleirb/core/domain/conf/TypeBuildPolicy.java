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
 * <p>Classe Java pour type_build-policy complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propri�t� housePrice.
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
     * D�finit la valeur de la propri�t� housePrice.
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
     * Obtient la valeur de la propri�t� hotelPrice.
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
     * D�finit la valeur de la propri�t� hotelPrice.
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
