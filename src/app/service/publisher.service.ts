import { Injectable } from '@angular/core';
import { Publisher } from '../entity/publisher';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PublisherService {

  addEmpURL : string;
  getEmpURL : string;
  updateEmpUrl : string;
  deleteEmpUrl : string;

  constructor(private http : HttpClient) {

    this.addEmpURL = 'http://localhost:8086/postroom';
    this.getEmpURL = 'http://localhost:8086/room';
    this.updateEmpUrl = 'http://localhost:8086/updateroom';
    this.deleteEmpUrl = 'http://localhost:8086/deleteroom';

   }

   addRoom(publisher : Publisher): Observable<Publisher> {
     return this.http.post<Publisher>(this.addEmpURL,publisher);
   }

   getAllRoom(): Observable<Publisher[]>{
     return this.http.get<Publisher[]>(this.getEmpURL);
   }

   updateRoom(room :Publisher) : Observable<Publisher>{
     return this.http.put<Publisher>(this.updateEmpUrl, Publisher);
   }
   
  findAll(): Observable<any> {
    console.log(Publisher)
    return this.http.get('http://localhost:8086/room');
  }

   deleteRoom(publisher : Publisher) : Observable<Publisher> {
     return this.http.delete<Publisher>(this.deleteEmpUrl+'/'+publisher.publisherId);
   }
  

}