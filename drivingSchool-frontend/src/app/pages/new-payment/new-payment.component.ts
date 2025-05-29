import { Component } from '@angular/core';
import {PaymentService} from '../../service/payment.service';
import {Router} from '@angular/router';
import {Payment} from '../model/Payment.model';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-new-payment',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './new-payment.component.html',
  styleUrl: './new-payment.component.css'
})
export class NewPaymentComponent {

  constructor(private paymentService: PaymentService, private router: Router ) { }

  savePayment(payment: Payment){
    payment.administratorId = 1;
    this.paymentService.savePayment(payment).subscribe({
      next: data => {
        this.router.navigateByUrl('payments');
      }, error: error => {
        console.log(error);
      }
    });
  }

}
