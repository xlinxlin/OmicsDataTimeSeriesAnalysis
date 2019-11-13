package me.xlin.omicsdatatimeseriesanalysis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

/**
 * This is the Feature class. Each feature has a name, an ID and 5 values. 
 * 
 * @author Yan
 */
@Entity
@Table(name = "feature")
public class Feature {
  /** Initializes feature id. */
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private Integer id;
  
  /** Initializes feature value1. */
  @Column(name="value1")
  private double value1;
  
  /** Initializes feature value2. */
  @Column(name="value2")
  private double value2;
  
  /** Initializes feature value3. */
  @Column(name="value3")
  private double value3;
  
  /** Initializes feature value4. */
  @Column(name="value4")
  private double value4;
  
  /** Initializes feature value5. */
  @Column(name="value5")
  private double value5;
  
  /** Initializes feature name. */
  @Column(name="name")
  private String name;
  
  /** Initializes feature score. */
  @Transient
  private double score;
   
  /**
   * Sets feature value1.
   * @param value1 feature value1.
   */
   public void setValue1(double value1) {
      this.value1 = value1;
   }
   
  /**
   * Gets feature value1.
   * @return feature value1.
   */
   public double getValue1() {
      return value1;
   }
   
  /**
   * Sets feature value2.
   * @param value2 feature value2.
   */
   public void setValue2(double value2) {
      this.value2 = value2;
   }
   
  /**
   * Gets feature value2.
   * @return feature value2.
   */
   public double getValue2() {
      return value2;
   }
   
  /**
   * Sets feature value3.
   * @param value3 feature value3.
   */
   public void setValue3(double value3) {
      this.value3 = value3;
   }
   
  /**
   * Gets feature value3.
   * @return feature value3.
   */
   public double getValue3() {
      return value3;
   }
   
  /**
   * Sets feature value4.
   * @param value4 feature value4.
   */
   public void setValue4(double value4) {
      this.value4 = value4;
   }
   
  /**
   * Gets feature value4.
   * @return feature value4.
   */
   public double getValue4() {
      return value4;
   }
   
  /**
   * Sets feature value5.
   * @param value5 feature value5.
   */
   public void setValue5(double value5) {
      this.value5 = value5;
   }
   
  /**
   * Gets feature value5.
   * @return feature value5.
   */
   public double getValue5() {
      return value5;
   }
   
  /**
   * Sets feature name.
   * @param name feature name.
   */
   public void setName(String name) {
      this.name = name;
   }
   
  /**
   * Gets feature name.
   * @return feature name.
   */
   public String getName() {
      return name;
   }
   
  /**
   * Sets feature ID.
   * @param id the feature id.
   */
   public void setId(Integer id) {
      this.id = id;
   }
   
  /**
   * Gets feature id.
   * @return feature id.
   */
   public Integer getId() {
      return id;
   }
   
   /**
    * Sets feature score.
    * @param score the feature score.
    */
   public void setScore(double score) {
     this.score = score;
   }
   
   /**
    * Gets feature score.
    * @return feature score.
    */
   public double getScore() {
     return score;
   }
   
   public Feature() { }
   
   public Feature(String name, double value1, double value2, double value3, double value4, double value5) {
     this.name = name;
     this.value1 = value1;
     this.value2 = value2;
     this.value3 = value3;
     this.value4 = value4;
     this.value5 = value5;
   }
   
}