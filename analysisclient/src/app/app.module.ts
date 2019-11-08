import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { FeatureListComponent } from './feature-list/feature-list.component';
import { FeatureFormComponent } from './feature-form/feature-form.component';
import { FeatureService } from './service/feature-service.service';
import { OutputGraphComponent } from './output-graph/output-graph.component';
import { DataTablesModule } from 'angular-datatables';
import { GetFeatureComponent } from './get-feature/get-feature.component';
import { SearchResultComponent } from './search-result/search-result.component';

@NgModule({
  declarations: [
    AppComponent,
    FeatureListComponent,
    FeatureFormComponent,
    OutputGraphComponent,
    GetFeatureComponent,
    SearchResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    DataTablesModule
  ],
  providers: [FeatureService],
  bootstrap: [AppComponent]
})

export class AppModule { }
