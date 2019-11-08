package me.xlin.omicsdatatimeseriesanalysis.util;


import me.xlin.omicsdatatimeseriesanalysis.model.Feature;

/**
 * Algorithms for chart plotting.
 * 
 * @author Yan
 */
public class PlottingAlgorithm {

  public static double euclideanDistanceAlgo(double[] usrPoints, Feature feature) {
    double score = 
        (Math.pow(usrPoints[0]-feature.getValue1(),2)) + (Math.pow(usrPoints[1]-feature.getValue2(),2))
        + (Math.pow(usrPoints[2]-feature.getValue3(),2)) + (Math.pow(usrPoints[3]-feature.getValue4(),2))
        + (Math.pow(usrPoints[4]-feature.getValue5(),2));
      score = Math.sqrt(score);
    return score;
  }
  
  public static double slopeDistanceAlgo(double[] usrPoints, Feature feature) {
    double score = 0.0;
    double[] scoreUsr = new double[] {1/(usrPoints[1]-usrPoints[0]),1/(usrPoints[2]-usrPoints[1]),
        1/(usrPoints[3]-usrPoints[2]),1/(usrPoints[4]-usrPoints[3])};
    double[] scoreRef = new double[] {1/(feature.getValue2()-feature.getValue1()),1/(feature.getValue3()-feature.getValue2()),
        1/(feature.getValue4()-feature.getValue3()), 1/(feature.getValue5()-feature.getValue4())};
    for(int i = 0; i < 4; i++) {
      if(scoreUsr[i]*scoreRef[i] >0) {
        score = score + Math.abs(scoreUsr[i] - scoreRef[i]);
      } else {
        score = -1;
        break;
      }
    }
    return score;
  }
}