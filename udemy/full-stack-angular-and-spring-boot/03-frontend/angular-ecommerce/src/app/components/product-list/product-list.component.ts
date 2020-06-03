import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/common/product';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[]
  currentCategoryId: number
  currentCategoryName: string
  searchMode: boolean

  constructor(private productService: ProductService,
    private route: ActivatedRoute) {

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

    // search for products using keyword
    this.productService.searchProducts(theKeyWord).subscribe(
      data => this.products = data
    )
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

    this.productService.getProductList(this.currentCategoryId).subscribe(
      data => { this.products = data }
    )
  }

}
