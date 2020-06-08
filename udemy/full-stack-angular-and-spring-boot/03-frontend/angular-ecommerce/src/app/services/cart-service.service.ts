import { Injectable } from '@angular/core';
import { CartItem } from '../common/cart-item';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItems: CartItem[] = []
  totalPrice: Subject<number> = new Subject<number>()
  totalQuantity: Subject<number> = new Subject<number>()

  constructor() { }

  addToCart(theCartItem: CartItem) {
    // check if we already have the item in our cart
    let alreadyExistsInCart: boolean = false
    let existingCartItem: CartItem = undefined

    existingCartItem = this.cartItems.find(tempCartItem => tempCartItem.id == theCartItem.id)

    /* if (this.cartItems.length > 0) {
      // find the item in the cart based on the item ID
      for (let tempCartItem of this.cartItems) {
        if (tempCartItem.id == theCartItem.id) {
          existingCartItem = tempCartItem
          break
        }
      }
    } */

    // check if we found it
    alreadyExistsInCart = (existingCartItem != undefined)

    if (alreadyExistsInCart) {
      // increment the quantity
      existingCartItem.quantity++
    } else {
      this.cartItems.push(theCartItem)
    }

    // compute cart toal price and total quantity
    this.computeCartTotals()

  }

  computeCartTotals() {
    let totalPriceValue: number = 0
    let totalQuantityValue: number = 0

    this.cartItems.forEach(currentCartItem => {
      totalPriceValue += currentCartItem.quantity * currentCartItem.unitPrice
      totalQuantityValue += currentCartItem.quantity
    })

    //public the new values to all subscribers
    // .next will publish the event
    this.totalPrice.next(totalPriceValue)
    this.totalQuantity.next(totalQuantityValue)

    this.logCartData(totalPriceValue, totalQuantityValue)
  }

  logCartData(totalPriceValue: number, totalQuantityValue: number) {
    console.log("Contents of cart:")
    this.cartItems.forEach(element => {
      const subTotalPrice = element.quantity * element.unitPrice
      console.log(`name: ${element.name}, quantity=${element.quantity}, unitPrice=${element.unitPrice}, subTotalPrice=${subTotalPrice}`)
    });
    console.log(`totalPrice: ${totalPriceValue.toFixed(2)}, totalQuantity=${totalQuantityValue}`)
    console.log(`------`)
  }

  decrementQuantity(theCartItem: CartItem) {
    theCartItem.quantity--
    if (theCartItem.quantity == 0) {
      this.remove(theCartItem)
    } else {
      this.computeCartTotals()
    }
  }

  remove(theCartItem: CartItem) {
    // get index of item in the array
    const itemIndex = this.cartItems.findIndex(tempCartItem => tempCartItem.id == theCartItem.id)
    // if found, remove the item from the array at the given index
    if (itemIndex > -1) {
      this.cartItems.splice(itemIndex, 1)
      this.computeCartTotals()
    }
  }
}
