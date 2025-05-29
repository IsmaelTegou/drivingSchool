import { Component } from '@angular/core';
import {Payment} from '../../models/payment';
import {PaymentService} from '../../service/payment.service';
import {CurrencyPipe} from '@angular/common';
import {Router} from '@angular/router';

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

  constructor(private paymentService: PaymentService, private router: Router) {
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

  deletePayment(payment: any){
    const conf: boolean = confirm('Are you sur you want to delete this payment ?');
    if (conf) {
      this.paymentService.deletePayment(payment).subscribe({
        next: data => {
          this.getAllPayments();
        }, error: error => {
          console.log(error);
        }
      })
    }
  }

  addPayment() {
    this.router.navigateByUrl('new-payment');
  }
}
