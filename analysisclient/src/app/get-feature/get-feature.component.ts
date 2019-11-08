import { Component, OnInit } from '@angular/core';
import { Feature } from '../model/feature';
import { FeatureService } from '../service/feature-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-get-feature',
  templateUrl: './get-feature.component.html',
  styleUrls: ['./get-feature.component.css']
})

export class GetFeatureComponent implements OnInit {

  feature: Feature;
  ifMsg = false;
  error: string;
  name:string;
  val1:number;
  val2:number;
  val3:number;
  val4:number;
  val5:number;


  constructor(private featureService: FeatureService, private route: ActivatedRoute, private router: Router) {
    this.feature = new Feature();
  }

  ngOnInit() {
    
    this.route.params.subscribe(() => {
      this.featureService.findFeatureById(this.route.snapshot.paramMap.get('id')).subscribe(
        data => {
          this.ifMsg = false;
          this.feature = data;
        },
        error => {
          this.ifMsg = true;
          this.error = error.message;
          console.log(error);
        },
        () => {})
    });
  }

  onDelete(feature: any){
    this.featureService.deleteFeature(feature).subscribe(
      () => {},
      error => {
        this.ifMsg = true;
        this.error = error.message;
        console.log(error);
      },
      () => {
        this.router.navigate(['/features']);
      });
  }

  onUpdate(feature: any){
    this.featureService.updateFeature(feature).subscribe(
      () => {},
      error => {
        this.ifMsg = true;
        this.error = error.message;
        console.log(error.error);
      },
      () => {
        this.router.navigate(['/features']);
      });
  }
}