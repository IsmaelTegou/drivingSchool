import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Payment} from '../pages/model/Payment.model';


@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  private readonly apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getAllPayments() {
    return this.http.get(`${this.apiUrl}/findAllPayments`);
  }

  deletePayment(payment: any){
    console.log(payment);
    return this.http.delete(`${this.apiUrl}/deletePayment/${payment.id}`);
  }

  savePayment(payment: Payment){
    console.log(payment);
    return this.http.post(`${this.apiUrl}/createPayment`, payment);
  }

}
