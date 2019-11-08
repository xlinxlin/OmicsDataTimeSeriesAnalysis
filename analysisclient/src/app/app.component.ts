import { Component} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'analysisclient';

  featureName: string = '';

  constructor(private router: Router) {}

  onSearch(){
    if(this.featureName != ''){
      this.router.navigateByUrl('/search?name=' + this.featureName);
    } 
  }
}