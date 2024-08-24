import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserDTO } from '../model/suiviInterface';

const BASE_URL = ["http://localhost:8080/BonDintervention/"]

@Injectable({
  providedIn: 'root'
})
export class BonDiterventionService {

  constructor(private http: HttpClient) { }


  private createAuhtorizationHeader() {
    const jwtToken = localStorage.getItem('jwt');
      return new HttpHeaders().set( "Authorization", "Bearer " + jwtToken)
    
  }
  getAllUser(): Observable<UserDTO[]> {
    return this.http.get<UserDTO[]>('http://localhost:8080/suiviAT/findALLUsers', {headers: this.createAuhtorizationHeader()})
  }
  findAllZones(): Observable<UserDTO[]> {
    return this.http.get<UserDTO[]>(BASE_URL + 'findAllZones', {headers: this.createAuhtorizationHeader()})
  }
  findAllTypeDeFamilles(): Observable<any[]> {
    return this.http.get<any[]>(BASE_URL + 'findAllTypeDeFamilles', {headers: this.createAuhtorizationHeader()})
  }
  getAllMaterial(): Observable<any> {
    return this.http.get<any>(BASE_URL + 'findALLMaterial', {headers: this.createAuhtorizationHeader()})
  }
  fingAll(): Observable<any[]> {
    return this.http.get<any[]>(BASE_URL + 'findAll', {headers: this.createAuhtorizationHeader()})
  }

  create(bonD: any): Observable<any> {
    return this.http.post(BASE_URL + 'create', bonD,{headers: this.createAuhtorizationHeader()})
  }
  deleteById(id: any): Observable<any> {
    return this.http.post(BASE_URL + 'deletById', id,{headers: this.createAuhtorizationHeader()})
  }

}
