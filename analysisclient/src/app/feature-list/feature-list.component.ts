import { Component, OnInit } from '@angular/core';
import { Feature } from '../model/feature';
import { FeatureService } from '../service/feature-service.service';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-feature-list',
  templateUrl: './feature-list.component.html',
  styleUrls: ['./feature-list.component.css']
})
export class FeatureListComponent implements OnInit {
  
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  features: Feature[];

  ifMsg = false;
  error: string;

  constructor(private featureService: FeatureService) {}

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10
    };

    this.featureService.findAllFeatures().subscribe(
      data => {
        this.ifMsg = false;
        this.features = data;
        this.dtTrigger.next();
      },
      error => {
        this.ifMsg = true;
        this.error = error.message;
      },
      () => {})
  }
}