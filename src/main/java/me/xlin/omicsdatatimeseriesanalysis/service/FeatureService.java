package me.xlin.omicsdatatimeseriesanalysis.service;

import java.util.List;

import me.xlin.omicsdatatimeseriesanalysis.model.Feature;

public interface FeatureService {
  
  /**
   * Adds feature.
   * @param feature a feature object.
   */
  public abstract Feature addFeature(Feature feature);
   
   /**
    * Gets feature by ID.
    * @param id feature id.
    */
  public abstract Feature getFeatureById(int id);
  
  /**
   * Gets feature.
   * @param id feature id.
   */
  /*
  public abstract Feature getFeatureByName(String name);
  */
  
  /**
   * Gets feature list. 
   */
  public abstract List<Feature> getFeatures();
   
  /**
    * Deletes feature by ID.
    * @param id feature id.
    */
  public abstract Feature deleteFeatureById(int id);
    
   /**
    * Updates feature.
    * @param id feature id.
    * @param feature a Feature object.
    */
  public abstract Feature updateFeature(int id, Feature feature);
  
  /**
   * Search features by name match.
   * @param name feature name.
   */
  public abstract List<Feature> getFeaturesByNameMatch(String name);

}
