//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.6 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2012.09.29 à 04:45:56 PM CEST 
//


package com.gcc.monopoleirb.core.domain.conf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="squares" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="departure-square" type="{http://monopoleirb.gcc.com}type_departure-square" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="field" type="{http://monopoleirb.gcc.com}type_field" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="train-station" type="{http://monopoleirb.gcc.com}type_train-station" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="public-service" type="{http://monopoleirb.gcc.com}type_public-service" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="tax-square" type="{http://monopoleirb.gcc.com}type_tax-square" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="jail" type="{http://monopoleirb.gcc.com}type_jail" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="chance-square" type="{http://monopoleirb.gcc.com}type_chance-square" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="community-chest" type="{http://monopoleirb.gcc.com}type_community-chest" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="free-park" type="{http://monopoleirb.gcc.com}type_free-park" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="families" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="family" type="{http://monopoleirb.gcc.com}type_family" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="players" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="player" type="{http://monopoleirb.gcc.com}type_player" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="rules" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="rule" type="{http://monopoleirb.gcc.com}type_rule" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="chance-cards" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="card" type="{http://monopoleirb.gcc.com}type_card" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="community-chest-cards" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="card" type="{http://monopoleirb.gcc.com}type_card" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "configuration", namespace = "")
public class Configuration {

    protected Configuration.Squares squares;
    protected Configuration.Families families;
    protected Configuration.Players players;
    protected Configuration.Rules rules;
    @XmlElement(name = "chance-cards")
    protected Configuration.ChanceCards chanceCards;
    @XmlElement(name = "community-chest-cards")
    protected Configuration.CommunityChestCards communityChestCards;

    /**
     * Obtient la valeur de la propriété squares.
     * 
     * @return
     *     possible object is
     *     {@link Configuration.Squares }
     *     
     */
    public Configuration.Squares getSquares() {
        return squares;
    }

    /**
     * Définit la valeur de la propriété squares.
     * 
     * @param value
     *     allowed object is
     *     {@link Configuration.Squares }
     *     
     */
    public void setSquares(Configuration.Squares value) {
        this.squares = value;
    }

    /**
     * Obtient la valeur de la propriété families.
     * 
     * @return
     *     possible object is
     *     {@link Configuration.Families }
     *     
     */
    public Configuration.Families getFamilies() {
        return families;
    }

    /**
     * Définit la valeur de la propriété families.
     * 
     * @param value
     *     allowed object is
     *     {@link Configuration.Families }
     *     
     */
    public void setFamilies(Configuration.Families value) {
        this.families = value;
    }

    /**
     * Obtient la valeur de la propriété players.
     * 
     * @return
     *     possible object is
     *     {@link Configuration.Players }
     *     
     */
    public Configuration.Players getPlayers() {
        return players;
    }

    /**
     * Définit la valeur de la propriété players.
     * 
     * @param value
     *     allowed object is
     *     {@link Configuration.Players }
     *     
     */
    public void setPlayers(Configuration.Players value) {
        this.players = value;
    }

    /**
     * Obtient la valeur de la propriété rules.
     * 
     * @return
     *     possible object is
     *     {@link Configuration.Rules }
     *     
     */
    public Configuration.Rules getRules() {
        return rules;
    }

    /**
     * Définit la valeur de la propriété rules.
     * 
     * @param value
     *     allowed object is
     *     {@link Configuration.Rules }
     *     
     */
    public void setRules(Configuration.Rules value) {
        this.rules = value;
    }

    /**
     * Obtient la valeur de la propriété chanceCards.
     * 
     * @return
     *     possible object is
     *     {@link Configuration.ChanceCards }
     *     
     */
    public Configuration.ChanceCards getChanceCards() {
        return chanceCards;
    }

    /**
     * Définit la valeur de la propriété chanceCards.
     * 
     * @param value
     *     allowed object is
     *     {@link Configuration.ChanceCards }
     *     
     */
    public void setChanceCards(Configuration.ChanceCards value) {
        this.chanceCards = value;
    }

    /**
     * Obtient la valeur de la propriété communityChestCards.
     * 
     * @return
     *     possible object is
     *     {@link Configuration.CommunityChestCards }
     *     
     */
    public Configuration.CommunityChestCards getCommunityChestCards() {
        return communityChestCards;
    }

    /**
     * Définit la valeur de la propriété communityChestCards.
     * 
     * @param value
     *     allowed object is
     *     {@link Configuration.CommunityChestCards }
     *     
     */
    public void setCommunityChestCards(Configuration.CommunityChestCards value) {
        this.communityChestCards = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="card" type="{http://monopoleirb.gcc.com}type_card" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "card"
    })
    public static class ChanceCards {

        protected List<TypeCard> card;

        /**
         * Gets the value of the card property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the card property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCard().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TypeCard }
         * 
         * 
         */
        public List<TypeCard> getCard() {
            if (card == null) {
                card = new ArrayList<TypeCard>();
            }
            return this.card;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="card" type="{http://monopoleirb.gcc.com}type_card" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "card"
    })
    public static class CommunityChestCards {

        protected List<TypeCard> card;

        /**
         * Gets the value of the card property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the card property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCard().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TypeCard }
         * 
         * 
         */
        public List<TypeCard> getCard() {
            if (card == null) {
                card = new ArrayList<TypeCard>();
            }
            return this.card;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="family" type="{http://monopoleirb.gcc.com}type_family" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "family"
    })
    public static class Families {

        protected List<TypeFamily> family;

        /**
         * Gets the value of the family property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the family property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFamily().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TypeFamily }
         * 
         * 
         */
        public List<TypeFamily> getFamily() {
            if (family == null) {
                family = new ArrayList<TypeFamily>();
            }
            return this.family;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="player" type="{http://monopoleirb.gcc.com}type_player" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "player"
    })
    public static class Players {

        protected List<TypePlayer> player;

        /**
         * Gets the value of the player property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the player property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPlayer().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TypePlayer }
         * 
         * 
         */
        public List<TypePlayer> getPlayer() {
            if (player == null) {
                player = new ArrayList<TypePlayer>();
            }
            return this.player;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="rule" type="{http://monopoleirb.gcc.com}type_rule" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rule"
    })
    public static class Rules {

        protected List<TypeRule> rule;

        /**
         * Gets the value of the rule property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rule property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRule().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TypeRule }
         * 
         * 
         */
        public List<TypeRule> getRule() {
            if (rule == null) {
                rule = new ArrayList<TypeRule>();
            }
            return this.rule;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="departure-square" type="{http://monopoleirb.gcc.com}type_departure-square" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="field" type="{http://monopoleirb.gcc.com}type_field" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="train-station" type="{http://monopoleirb.gcc.com}type_train-station" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="public-service" type="{http://monopoleirb.gcc.com}type_public-service" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="tax-square" type="{http://monopoleirb.gcc.com}type_tax-square" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="jail" type="{http://monopoleirb.gcc.com}type_jail" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="chance-square" type="{http://monopoleirb.gcc.com}type_chance-square" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="community-chest" type="{http://monopoleirb.gcc.com}type_community-chest" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="free-park" type="{http://monopoleirb.gcc.com}type_free-park" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "departureSquareAndFieldAndTrainStation"
    })
    public static class Squares {

        @XmlElements({
            @XmlElement(name = "departure-square", type = TypeDepartureSquare.class),
            @XmlElement(name = "field", type = TypeField.class),
            @XmlElement(name = "train-station", type = TypeTrainStation.class),
            @XmlElement(name = "public-service", type = TypePublicService.class),
            @XmlElement(name = "tax-square", type = TypeTaxSquare.class),
            @XmlElement(name = "jail", type = TypeJail.class),
            @XmlElement(name = "chance-square", type = TypeChanceSquare.class),
            @XmlElement(name = "community-chest", type = TypeCommunityChest.class),
            @XmlElement(name = "free-park", type = TypeFreePark.class)
        })
        protected List<Object> departureSquareAndFieldAndTrainStation;

        /**
         * Gets the value of the departureSquareAndFieldAndTrainStation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the departureSquareAndFieldAndTrainStation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDepartureSquareAndFieldAndTrainStation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TypeDepartureSquare }
         * {@link TypeField }
         * {@link TypeTrainStation }
         * {@link TypePublicService }
         * {@link TypeTaxSquare }
         * {@link TypeJail }
         * {@link TypeChanceSquare }
         * {@link TypeCommunityChest }
         * {@link TypeFreePark }
         * 
         * 
         */
        public List<Object> getDepartureSquareAndFieldAndTrainStation() {
            if (departureSquareAndFieldAndTrainStation == null) {
                departureSquareAndFieldAndTrainStation = new ArrayList<Object>();
            }
            return this.departureSquareAndFieldAndTrainStation;
        }

    }

}
