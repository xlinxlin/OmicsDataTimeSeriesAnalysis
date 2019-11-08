//import { AfterViewInit, Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Component, OnInit, ViewChild } from '@angular/core';
import * as Highcharts from 'highcharts';
import { Feature } from '../model/feature';
import { FeatureService } from '../service/feature-service.service';
import { Subject } from 'rxjs';
import { DataTableDirective } from 'angular-datatables';


declare let require: any;
let Boost = require('highcharts/modules/boost');
let noData = require('highcharts/modules/no-data-to-display');
let More = require('highcharts/highcharts-more');

Boost(Highcharts);
noData(Highcharts);
More(Highcharts);
noData(Highcharts);

@Component({
  selector: 'app-output-graph',
  templateUrl: './output-graph.component.html',
  styleUrls: ['./output-graph.component.css']
})

export class OutputGraphComponent implements OnInit {
  chart:any;

  @ViewChild(DataTableDirective, {static: false})
  dtElement: DataTableDirective;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  ifMsg = false;
  selectedOption: string = "Euclidean Distance";
  error: string;
  
  algos = [
    { name: "Euclidean Distance", value: 1 },
    { name: "Slope Distance", value: 2 }
  ]
  
  features: Feature[];
  //received = false;
  
  options : any = {         
    chart : {
      type:'line',
      events: {
        click: function (e:any){
          let x = Math.round(e.xAxis[0].value);
          let y = e.yAxis[0].value;
          if(this.series[0].data.length > 0){
            let signal = 0;
            for(let i=0;i<this.series[0].data.length;i++){  //check if there already a point exsits at x
              if(x == this.series[0].data[i].x){
                signal = 1;
                break;
              }
            }
            if (signal == 0){
              this.series[0].addPoint([x, y]);
            }
          } else {
            this.series[0].addPoint([x, y]);
          }
        }
      }
    },
    title : {
      text: "Omics Data Analysis"   
    },   
    subtitle : {
      text: 'time series analysis'
    },
    xAxis : {
      categories: ['0 min','10 min','30 min','60 min','120 min'],
      max:4,
      min:0
    },
    yAxis : {
      tickInterval:2,
      max:5,
      min:-5
    },
    series : [{
      data: [],
      name:'user'
    }]
  };
 
  constructor(private featureService: FeatureService) { }

  ngOnInit(){
    // configuration for highcharts
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
    };
    this.chart=Highcharts.chart('container', this.options);
  }


  startPlotting(): void {
    if(this.chart.series[0].data.length < 5){
      this.ifMsg = true;
      this.error = 'Please input 5 points.';
    } else {
      this.ifMsg = false;
      this.chart=Highcharts.chart('container', this.options);
      this.featureService.plotChart(this.chart.series[0].data[0].y,
        this.chart.series[0].data[1].y,this.chart.series[0].data[2].y,
        this.chart.series[0].data[3].y,this.chart.series[0].data[4].y,
        this.selectedOption).subscribe(
          data => {    
            this.features = data;
            this.rerender();
            //data.sort( function(a,b){ return a.score - b.score; } );
            this.features.sort( function(a,b){ return a.score - b.score; } );
            let displayListLength = this.features.length > 10 ? 10 : this.features.length;
            for(let i=0; i<displayListLength; i++){
              let arrSeries = [];
              arrSeries.push([0,data[i].value1]);
              arrSeries.push([1,data[i].value2]);
              arrSeries.push([2,data[i].value3]);
              arrSeries.push([3,data[i].value4]);
              arrSeries.push([4,data[i].value5]);
              this.chart.addSeries({
                data: arrSeries,
                name: data[i].name,
                type: 'line'
              })
            }
          }, 
          error => {
            this.ifMsg = true;
            this.error = error.message;
            console.log(error);
          },
          () => {});
    }
  }

  onSelect(selectedFeature: any): void {
    let arrSeries = [];
    arrSeries.push([0,selectedFeature.value1]);
    arrSeries.push([1,selectedFeature.value2]);
    arrSeries.push([2,selectedFeature.value3]);
    arrSeries.push([3,selectedFeature.value4]);
    arrSeries.push([4,selectedFeature.value5]);
    this.chart.addSeries({
      data: arrSeries,
      name: selectedFeature.name,
      type: 'line'
    })
  }

  onChange(): void {
    //if(this.received == true || this.chart.series[0].data.length == 5){
    if(this.chart.series[0].data.length == 5){
      this.chart.destroy();
      this.chart=Highcharts.chart('container', this.options);
      this.rerender();
      this.startPlotting();
    }
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