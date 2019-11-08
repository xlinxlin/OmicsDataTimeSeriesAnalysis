import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Feature } from '../model/feature';
import { FeatureService } from '../service/feature-service.service';

@Component({
  selector: 'app-feature-form',
  templateUrl: './feature-form.component.html',
  styleUrls: ['./feature-form.component.css']
})

export class FeatureFormComponent {
  
  feature: Feature;
  name:string;
  val1:number;
  val2:number;
  val3:number;
  val4:number;
  val5:number;

  ifMsg = false;
  error: string;

  constructor(private router: Router, private featureService: FeatureService) {
    this.feature = new Feature();
  }
  
  onSubmit() {
    this.featureService.saveFeature(this.feature).subscribe(
      () => {},
      error => {
        this.ifMsg = true;
        this.error= error.message;             
      },
      () => {
        this.router.navigate(['/features']);
      });
  }
}