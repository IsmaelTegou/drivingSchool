import { Component } from '@angular/core';
import {Payment} from '../../models/payment';
import {PaymentService} from '../../service/payment.service';
import {CurrencyPipe} from '@angular/common';

@Component({
  selector: 'app-billing',
  standalone: true,
  imports: [
    CurrencyPipe
  ],
  templateUrl: './payment.component.html',
  styleUrl: './payment.component.css'
})
export class PaymentComponent {
  payments: any;

  constructor(private paymentService: PaymentService) {
    this.getAllPayments();
  }

  getAllPayments() {
    this.paymentService.getAllPayments().subscribe({
      next: data => {
        this.payments = data;
      }, error: error => {
        console.log(error);
      }
    });
  }
}
