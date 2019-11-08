package me.xlin.omicsdatatimeseriesanalysis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import me.xlin.omicsdatatimeseriesanalysis.service.FeatureService;
import me.xlin.omicsdatatimeseriesanalysis.service.FeatureServiceImpl;
import me.xlin.omicsdatatimeseriesanalysis.model.Feature;
import me.xlin.omicsdatatimeseriesanalysis.repository.FeatureRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class FeatureServiceIntefrationTest {
  
  
  @TestConfiguration
  static class EmployeeServiceImplTestContextConfiguration {

      @Bean
      public FeatureService featureService() {
          return new FeatureServiceImpl();
      }
  }
  
  @Autowired
  private FeatureService featureService;

  @MockBean
  private FeatureRepository featureRepository;
  
  @Test
  public void whenFindAll_thenFeaturesShouldBeFound() {
    // given
    Feature f = new Feature("P001",1,2,3,4,5);
    List<Feature> expectedFeatures = Arrays.asList(f); 
    doReturn(expectedFeatures).when(featureRepository).findAll();  
    
    // when
    List<Feature> actualFeatures = featureService.getFeatures();
    
    // then
    assertThat(actualFeatures).isEqualTo(expectedFeatures);  
   }
}
