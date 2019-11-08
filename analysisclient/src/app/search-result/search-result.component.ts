import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FeatureService } from '../service/feature-service.service';
import { Feature } from '../model/feature';
import { Subject } from 'rxjs';
import { DataTableDirective } from 'angular-datatables';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})

export class SearchResultComponent implements OnInit {

  @ViewChild(DataTableDirective, {static: false})
  dtElement: DataTableDirective;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  features: Feature[];
  error: string;
  ifMsg = false;

  constructor(private route:ActivatedRoute, private featureService:FeatureService){}

  ngOnInit(){
    
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10
    };
    
    this.route.queryParams.subscribe(
      params =>{
        this.featureService.searchFeaturesByNameMatch(params.name).subscribe(
          data => {
            this.rerender();
            this.ifMsg = false;
            this.features = data
          },
          error => {
            this.ifMsg = true;
            this.error = error.message;
            console.log(error);
          });
      })
  }

  ngAfterViewInit(): void {
    this.dtTrigger.next();
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }

  rerender(): void {
    this.dtElement.dtInstance.then((dtInstance: DataTables.Api) => {
      dtInstance.destroy();
      this.dtTrigger.next();
    });
  }
}
