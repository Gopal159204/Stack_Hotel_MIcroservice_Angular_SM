import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { API_URL_RL } from 'src/app/constant/url';


@Injectable({
  providedIn: 'root'
})
export class RestaurantServiceService {

  constructor(private http: HttpClient) { }

// private apiUrl = API_URL_RL+'/restaurant/fetchAll';
 apiUrl='http://localhost:9091/restaurant/fetchAll'; 


getAllRestaurants(): Observable<any> {
  return this.http.get<any>(`${this.apiUrl}`)
    .pipe(
      catchError(this.handleError)
    );
}


private handleError(error: any) {
  console.error('An error occurred:', error);
  return throwError(error.message || error);
}
}