import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/common/product';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/common/cart-item';
import { CartService } from 'src/app/services/cart-service.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[]
  currentCategoryId: number = 1
  previousCategoryId: number = 1
  currentCategoryName: string
  searchMode: boolean

  // new properties for pagination
  thePageNumber: number = 1
  thePageSize: number = 5
  theTotalElements: number = 0

  previousKeyWord: string = null

  constructor(private productService: ProductService,
    private route: ActivatedRoute,
    private cartService: CartService) {

  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listProducts()
    })
  }

  listProducts() {
    this.searchMode = this.route.snapshot.paramMap.has('keyword')

    if (this.searchMode) {
      // search
      this.handleSearchProducts();
    } else {
      this.handleListProducts()
    }
  }

  handleSearchProducts() {
    const theKeyWord = this.route.snapshot.paramMap.get('keyword')

    // if we have a different keyword than previously
    // the set page number to 1
    if (this.previousKeyWord != theKeyWord) {
      this.thePageNumber = 1
    }

    this.previousKeyWord = theKeyWord
    console.log(`keyword=${theKeyWord}, thePageNumber=${this.thePageNumber}`)

    // search for products using keyword
    this.productService.searchProductsPaginate(this.thePageNumber - 1, this.thePageSize, theKeyWord).subscribe(this.processResult())
  }

  handleListProducts() {
    /// check if "id" parameter is available
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id')

    if (hasCategoryId) {
      // get the id and convert the string to a number using the "+" symbol
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id')
      this.currentCategoryName = this.route.snapshot.paramMap.get('name')
    } else {
      // not available... default category id
      this.currentCategoryId = 1
      this.currentCategoryName = "Books"
    }

    // Check if we have a different category than previous
    // Note: angular will reuse a component if it currently being viewed

    // if we have a different category id than previously
    // then we need to reset the page number back to 1

    if (this.previousCategoryId != this.currentCategoryId) {
      this.thePageNumber = 1
    }

    this.previousCategoryId = this.currentCategoryId
    console.log(`currentCategoryId=${this.currentCategoryId}, thePageNumber=${this.thePageNumber}`)

    this.productService.getProductListPaginate(this.thePageNumber - 1, this.thePageSize, this.currentCategoryId).subscribe(this.processResult())
  }

  processResult() {
    return data => {
      this.products = data._embedded.products;
      this.thePageNumber = data.page.number + 1;
      this.thePageSize = data.page.size;
      this.theTotalElements = data.page.totalElements;
    }
  }

  updatePageSize(pageSize: number) {
    this.thePageSize = pageSize;
    this.thePageNumber = 1;
    this.listProducts();
  }

  addToCart(theProduct: Product) {
    console.log(`Adding to cart: ${theProduct.name}, ${theProduct.unitPrice}`)

    const cartItem: CartItem = new CartItem(theProduct)
    this.cartService.addToCart(cartItem)
  }

}
