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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour type_public-service complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="type_public-service">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="mortgage-policy" type="{http://monopoleirb.gcc.com}type_mortgage-policy"/>
 *       &lt;/all>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="family" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="buyingPrice" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "type_public-service", propOrder = {

})
public class TypePublicService {

    @XmlElement(name = "mortgage-policy", required = true)
    protected TypeMortgagePolicy mortgagePolicy;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "family", required = true)
    protected BigInteger family;
    @XmlAttribute(name = "buyingPrice", required = true)
    protected BigInteger buyingPrice;

    /**
     * Obtient la valeur de la propriété mortgagePolicy.
     * 
     * @return
     *     possible object is
     *     {@link TypeMortgagePolicy }
     *     
     */
    public TypeMortgagePolicy getMortgagePolicy() {
        return mortgagePolicy;
    }

    /**
     * Définit la valeur de la propriété mortgagePolicy.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeMortgagePolicy }
     *     
     */
    public void setMortgagePolicy(TypeMortgagePolicy value) {
        this.mortgagePolicy = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété family.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFamily() {
        return family;
    }

    /**
     * Définit la valeur de la propriété family.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFamily(BigInteger value) {
        this.family = value;
    }

    /**
     * Obtient la valeur de la propriété buyingPrice.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBuyingPrice() {
        return buyingPrice;
    }

    /**
     * Définit la valeur de la propriété buyingPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBuyingPrice(BigInteger value) {
        this.buyingPrice = value;
    }

}
