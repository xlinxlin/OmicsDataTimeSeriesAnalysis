import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FeatureListComponent } from './feature-list/feature-list.component'
import { FeatureFormComponent } from './feature-form/feature-form.component'
import { OutputGraphComponent } from './output-graph/output-graph.component'
import { GetFeatureComponent } from './get-feature/get-feature.component'
import { SearchResultComponent } from './search-result/search-result.component'

const routes: Routes = [
  { path: 'features', component: FeatureListComponent },
  { path: 'add', component: FeatureFormComponent },
  { path: 'plot', component: OutputGraphComponent },
  { path: 'features/:id', component: GetFeatureComponent },
  { path: 'search', component: SearchResultComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
