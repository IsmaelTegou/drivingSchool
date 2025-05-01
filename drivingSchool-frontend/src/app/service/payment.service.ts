import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Payment} from '../models/payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  private readonly apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getAllPayments() {
    return this.http.get(`${this.apiUrl}/findAllPayments`);
  }
}
