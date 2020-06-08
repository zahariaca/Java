import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { CartService } from 'src/app/services/cart-service.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  checkoutFormGroup: FormGroup
  totalPrice: number = 0
  totalQuantity: number = 0

  constructor(private formBuilder: FormBuilder,
    private cartService: CartService) { }

  ngOnInit(): void {
    this.cartService.totalPrice.subscribe(
      data => this.totalPrice = data
    )
    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    )
    this.cartService.computeCartTotals()

    this.checkoutFormGroup = this.formBuilder.group({
      customer: this.formBuilder.group({
        firstName: [""],
        lastName: [""],
        email: [""]
      }),
      shippingAddress: this.formBuilder.group({
        street: [""],
        city: [""],
        state: [""],
        country: [""],
        zipCode: [""]
      }),
      billingAddress: this.formBuilder.group({
        street: [""],
        city: [""],
        state: [""],
        country: [""],
        zipCode: [""]
      }),
      creditCardInformation: this.formBuilder.group({
        cardType: [""],
        nameOnCard: [""],
        cardNumber: [""],
        securityCode: [""],
        expirationMonth: [""],
        expirationYear: [""]
      })
    })
  }

  copyShippingAddressToBilingAddress(event) {
    if (event.target.checked) {
      this.checkoutFormGroup.controls.billingAddress.setValue(this.checkoutFormGroup.controls.shippingAddress.value)
    } else {
      this.checkoutFormGroup.controls.billingAddress.reset()
    }
  }

  onSubmit() {
    console.log("Handling form submission")
    console.log(this.checkoutFormGroup.get("customer").value)
    console.log(`The email address is: ${this.checkoutFormGroup.get("customer").value.email}`)
  }


}
