import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Product } from '../common/product';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseurl = 'http://localhost:8080/api/products';
  private categoryUrl = 'http://localhost:8080/api/product-category';

  constructor(private httpClient: HttpClient) { }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.httpClient
      .get<GetResponseProductCategory>(this.categoryUrl)
      .pipe(
        map((response) => response._embedded.productCategory)
      );
  }

  getProductListPaginate(thePage: number, thePageSize: number, categoryId: number): Observable<GetResponseProducts> {
    // build url based on category id /api/products/search/findByCategoryId?id=1&page=0&size=10
    const searchUrl = `${this.baseurl}/search/findByCategoryId?id=${categoryId}&page=${thePage}&size=${thePageSize}`
    return this.httpClient.get<GetResponseProducts>(searchUrl)
  }

  getProductList(categoryId: number): Observable<Product[]> {
    // build url based on category id /api/products/search/findByCategoryId?id=1
    const searchUrl = `${this.baseurl}/search/findByCategoryId?id=${categoryId}`
    return this.getProducts(searchUrl);
  }

  searchProducts(theKeyWord: string) {
    const searchUrl = `${this.baseurl}/search/findByNameContaining?name=${theKeyWord}`
    return this.getProducts(searchUrl)
  }

  searchProductsPaginate(thePage: number, thePageSize: number, theKeyWord: string): Observable<GetResponseProducts> {
    // build url based on category id /search/findByNameContaining?name=Java&page=0&size=10
    const searchUrl = `${this.baseurl}/search/findByNameContaining?name=${theKeyWord}&page=${thePage}&size=${thePageSize}`
    return this.httpClient.get<GetResponseProducts>(searchUrl)
  }

  private getProducts(searchUrl: string): Observable<Product[]> {
    return this.httpClient
      .get<GetResponseProducts>(searchUrl)
      .pipe(
        map((response) => response._embedded.products)
      );
  }

  getProduct(theProductId: number): Observable<Product> {
    const productUrl = `${this.baseurl}/${theProductId}`
    return this.httpClient.get<Product>(productUrl)
  }


}

interface GetResponseProducts {
  _embedded: {
    products: Product[];
    page: {
      size: number,
      totalElements: number,
      totalPages: number,
      number: number
    }
  };
}

// TODO: read more about this, unclear how it works
// a representation of the JSON we are receiving
interface GetResponseProductCategory {
  _embedded: {
    productCategory: ProductCategory[];
  };
}