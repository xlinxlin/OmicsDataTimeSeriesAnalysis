package me.xlin.omicsdatatimeseriesanalysis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import me.xlin.omicsdatatimeseriesanalysis.model.Feature;
import me.xlin.omicsdatatimeseriesanalysis.repository.FeatureRepository;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FeatureRepositoryIntegrationTest {
 
  @Autowired
  private TestEntityManager entityManager;
 
  @Autowired
  private FeatureRepository featureRepository;    

    
  @Test
  public void whenFindById_thenReturnFeature() {
    // given
    Feature f = new Feature("P001",1,2,3,4,5);
    entityManager.persist(f);
    entityManager.flush();
     
    // when
    Feature found = featureRepository.findById(f.getId()).get();
    
    // then
    assertThat(found.getName()).isEqualTo(f.getName());
  }
}