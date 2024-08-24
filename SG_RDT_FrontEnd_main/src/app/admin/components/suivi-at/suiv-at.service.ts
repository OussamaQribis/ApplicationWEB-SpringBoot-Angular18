import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer, MaterialDTO, suiviDTO, UserDTO } from '../model/suiviInterface';
import { Observable } from 'rxjs';

const BASE_URL = ["http://localhost:8080/suiviAT/"]

@Injectable({
  providedIn: 'root'
})
export class SuivATService {

  constructor(private http: HttpClient) { 
  

  }

  
  getCustomersSmall() {
      return this.http.get<any>('assets/demo/data/customers-small.json')
          .toPromise()
          .then(res => res.data as Customer[])
          .then(data => data);
  }

  getCustomersMedium() {
      return this.http.get<any>('assets/demo/data/customers-medium.json')
          .toPromise()
          .then(res => res.data as Customer[])
          .then(data => data);
  }

  getCustomersLarge() {
      return this.http.get<any>('assets/demo/data/customers-large.json')
          .toPromise()
          .then(res => res.data as Customer[])
          .then(data => data);
  }

  private createAuhtorizationHeader() {
    const jwtToken = localStorage.getItem('jwt');
      return new HttpHeaders().set( "Authorization", "Bearer " + jwtToken)
    
  }

 
  getAllSuivi(): Observable<suiviDTO[]> {
    return this.http.get<suiviDTO[]>(BASE_URL + 'findAll', {headers: this.createAuhtorizationHeader()})
  }

  getAllUser(): Observable<UserDTO[]> {
    return this.http.get<UserDTO[]>(BASE_URL + 'findALLUsers', {headers: this.createAuhtorizationHeader()})
  }
  getAllMaterial(): Observable<MaterialDTO[]> {
    return this.http.get<MaterialDTO[]>(BASE_URL + 'findALLMaterial', {headers: this.createAuhtorizationHeader()})
  }
  addSuiviAT(suiviAT: any): Observable<any> {
    return this.http.post(BASE_URL + 'create', suiviAT,{headers: this.createAuhtorizationHeader()})
  }
  deleteById(suiviAT: any): Observable<any> {
    return this.http.post(BASE_URL + 'deletById', suiviAT,{headers: this.createAuhtorizationHeader()})
  }
  changeEtat(suiviAT: any): Observable<any> {
    return this.http.post(BASE_URL + 'RenduNoRendu', suiviAT,{headers: this.createAuhtorizationHeader()})
  }
  
}

  

