import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Feature } from '../model/feature';
import { Observable } from 'rxjs';
 
@Injectable()
export class FeatureService {
 
  private featuresUrl: string;
  private plotChartUrl: string;
  private searchUrl: string;

  constructor(private http: HttpClient) {
    this.featuresUrl = 'http://localhost:8080/features/';
    this.plotChartUrl = 'http://localhost:8080/plot/';
    this.searchUrl = 'http://localhost:8080/search/';
  }
 
  public findFeatureById(featureId:string): Observable<Feature> {
    return this.http.get<Feature>(this.featuresUrl + featureId);
  }
  
  public findAllFeatures(): Observable<Feature[]> {
    return this.http.get<Feature[]>(this.featuresUrl);
  }

  public plotChart(val1:number,val2:number,val3:number,val4:number,val5:number,algo:string): Observable<Feature[]> {
    let params = new HttpParams();
    params = params.append('val1', val1.toString());
    params = params.append('val2', val2.toString());
    params = params.append('val3', val3.toString());
    params = params.append('val4', val4.toString());
    params = params.append('val5', val5.toString());
    params = params.append('algo', algo);
    return this.http.get<Feature[]>(this.plotChartUrl,{ params: params });
  }
 
  public saveFeature(feature: Feature): Observable<Feature> {
    return this.http.post<Feature>(this.featuresUrl, feature);
  }

  public deleteFeature(feature: Feature): Observable<Feature>{
    return this.http.delete<Feature>(this.featuresUrl + feature.id);
  }

  public updateFeature(feature: Feature): Observable<Feature>{
    return this.http.put<Feature>(this.featuresUrl + feature.id,feature);
  }

  public searchFeaturesByNameMatch(name:string): Observable<Feature[]>  {
    let params = new HttpParams();
    params = params.append('name', name);
    return this.http.get<Feature[]>(this.searchUrl, { params:params });
  }
}