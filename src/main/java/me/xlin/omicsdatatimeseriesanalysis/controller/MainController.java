package me.xlin.omicsdatatimeseriesanalysis.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import me.xlin.omicsdatatimeseriesanalysis.model.Feature;
import me.xlin.omicsdatatimeseriesanalysis.service.FeatureServiceImpl;
import me.xlin.omicsdatatimeseriesanalysis.util.PlottingAlgorithm;

/**
 * This is the controller class.
 * 
 * @author Yan
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {
  
  @Autowired
  private FeatureServiceImpl service;
  
  public MainController() {}
  
  @RequestMapping(value = "/features/{id}", method = RequestMethod.GET)
  public Feature getFeatureById(@PathVariable int id) {
    return service.getFeatureById(id);
  }
  
  @RequestMapping(value = "/features/{id}", method = RequestMethod.DELETE)
  public Feature deleteFeatureById(@PathVariable int id) {
    return service.deleteFeatureById(id);
  }
  
  @RequestMapping(value = "/features/{id}", method = RequestMethod.PUT)
  public Feature updateFeature(@PathVariable int id, @RequestBody Feature feature) {
    return service.updateFeature(id, feature);
  }
  
  @RequestMapping(value = "/features", method = RequestMethod.GET)
  public List<Feature> getFeatures() {
    return service.getFeatures();
  }
  
  @RequestMapping(value = "/features", method = RequestMethod.POST)
  public Feature addFeature(@RequestBody Feature feature) {
    return service.addFeature(feature);
  }
  
  @RequestMapping(value = "/plot", method = RequestMethod.GET)
  public List<Feature> startPlot(@RequestParam(value = "val1") String val1,
      @RequestParam(value = "val2") String val2,
      @RequestParam(value = "val3") String val3, 
      @RequestParam(value = "val4") String val4,
      @RequestParam(value = "val5") String val5,
      @RequestParam(value = "algo") String algo,
      HttpServletRequest request) {
    List<Feature> features = service.getFeatures();
    
    double[] usrPoints = 
        new double[] {Double.valueOf(val1),Double.valueOf(val2),Double.valueOf(val3),
            Double.valueOf(val4),Double.valueOf(val5)};    
    for (Feature feature : features) {
      double score = algo.equals("Euclidean Distance")?
          PlottingAlgorithm.euclideanDistanceAlgo(usrPoints, feature) : PlottingAlgorithm.slopeDistanceAlgo(usrPoints, feature);
      feature.setScore(score);
    }
    features.removeIf(x -> x.getScore() == -1);
    return features;
  }
  
  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public List<Feature> getFeaturesByNameMatch(@RequestParam(value = "name") String name, HttpServletRequest request){
    List<Feature> features = service.getFeaturesByNameMatch(name);
    return features;
  }
}
