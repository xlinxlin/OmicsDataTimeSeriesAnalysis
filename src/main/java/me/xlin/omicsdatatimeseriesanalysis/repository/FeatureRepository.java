package me.xlin.omicsdatatimeseriesanalysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import me.xlin.omicsdatatimeseriesanalysis.model.Feature;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface FeatureRepository extends CrudRepository<Feature, Integer> {
  
  @Query(value = "select f from Feature f where f.name like %?1%")
  public List<Feature> findByNameMatch(String name);
  
}
