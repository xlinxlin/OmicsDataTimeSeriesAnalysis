package me.xlin.omicsdatatimeseriesanalysis.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import me.xlin.omicsdatatimeseriesanalysis.exception.FeatureNotFoundException;
import me.xlin.omicsdatatimeseriesanalysis.model.Feature;
import me.xlin.omicsdatatimeseriesanalysis.repository.FeatureRepository;

@Service
public class FeatureServiceImpl implements FeatureService {
  
  @Autowired
  private FeatureRepository repository;
  
  @Override
  public Feature addFeature(Feature feature) {
    return repository.save(feature);
  }
  
  @Override
  public Feature getFeatureById(int id) {
    Optional<Feature> feature = repository.findById(id);
    return feature.orElseThrow(() -> new FeatureNotFoundException("Feature id " + id + " not found."));
  }
  
  @Override
  public List<Feature> getFeatures(){
    return Lists.newArrayList(repository.findAll());
  }
  
  @Override
  public Feature deleteFeatureById(int id) {
    Optional<Feature> feature = repository.findById(id);
    if(feature.isPresent() ) {
      repository.deleteById(id); 
    }
    return feature.orElseThrow(() -> new FeatureNotFoundException("Feature id " + id + " not found."));
  }
  
  @Override
  public Feature updateFeature(int id,Feature feature) {
    Optional<Feature> checkFeature = repository.findById(id);
    if(checkFeature.isPresent()) {
      Feature updateFeature = checkFeature.get();
      updateFeature.setName(feature.getName());
      updateFeature.setValue1(feature.getValue1());
      updateFeature.setValue2(feature.getValue2());
      updateFeature.setValue3(feature.getValue3());
      updateFeature.setValue4(feature.getValue4());
      updateFeature.setValue5(feature.getValue5());
      repository.save(updateFeature);
    } 
    return checkFeature.orElseThrow(() -> new FeatureNotFoundException("Feature id " + id + " not found."));
  }
  
  @Override
  public List<Feature> getFeaturesByNameMatch(String name){
    return Lists.newArrayList(repository.findByNameMatch(name));
  }
}
