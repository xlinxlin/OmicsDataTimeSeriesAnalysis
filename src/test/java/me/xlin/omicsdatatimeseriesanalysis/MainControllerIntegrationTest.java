package me.xlin.omicsdatatimeseriesanalysis;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import me.xlin.omicsdatatimeseriesanalysis.controller.MainController;
import me.xlin.omicsdatatimeseriesanalysis.model.Feature;
import me.xlin.omicsdatatimeseriesanalysis.service.FeatureServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerIntegrationTest {
  
  @Autowired
  private MockMvc mvc;
 
  @MockBean
  private FeatureServiceImpl featureService;
    
  @Test
  public void givenFeatures_whenGetFeatures_thenReturnJsonArray() throws Exception {
    Feature f = new Feature("P001",1,2,3,4,5);
     
    List<Feature> expectedFeatures = Arrays.asList(f);
        
    doReturn(expectedFeatures).when(featureService).getFeatures();  
          
    mvc.perform(get("/features")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name", is(f.getName())));
    }
}