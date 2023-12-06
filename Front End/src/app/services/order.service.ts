import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../_class/order';
import { OrderDetail } from '../_class/order-detail';

const ORDER_API = 'http://localhost:8080/api/order/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  constructor(private http: HttpClient) {}

  // getListOrder(): Observable<any> {
  //   return this.http.get(ORDER_API, httpOptions);
  // }

  // getListOrderByUser(username: string): Observable<any> {
  //   let params = new HttpParams();
  //   params = params.append('username', username);
  //   return this.http.get(ORDER_API + 'user', { params: params });
  // }

  // placeOrder(
  //   firstname: string,
  //   lastname: string,
  //   country: string,
  //   address: string,
  //   town: string,
  //   state: string,
  //   postCode: string,
  //   phone: string,
  //   email: string,
  //   note: string,
  //   orderDetails: OrderDetail[],
  //   username: string
  // ): Observable<any> {
  //   return this.http.post(
  //     ORDER_API + 'create',
  //     {
  //       firstname,
  //       lastname,
  //       country,
  //       address,
  //       town,
  //       state,
  //       postCode,
  //       phone,
  //       email,
  //       note,
  //       orderDetails,
  //       username,
  //     },
  //     httpOptions
  //   );
  // }

  // getOrderById(id: number): Observable<any> {
  //   return this.http.get(ORDER_API + id, httpOptions);
  // }

  // getListOrderDetail(id: number): Observable<any> {
  //   return this.http.get(ORDER_API + 'detail/' + id, httpOptions);
  // }

  // deleteOrder(id: number) {
  //   return this.http.delete(ORDER_API + 'delete/' + id, httpOptions);
  // }

  // enableOrder(id: number) {
  //   return this.http.put(ORDER_API + 'enable/' + id, httpOptions);
  // }

  placeOrder(
    userId: number,
    address: string,
    orderDetails: OrderDetail[]
  ): Observable<any> {
    return this.http.post(
      ORDER_API + 'create',
      {
        userId,
        address,
        orderDetails,
      },
      httpOptions
    );
  }

  getListByChefId(id: number): Observable<any> {
    return this.http.get(ORDER_API + 'chef/' + id, httpOptions);
  }

  getOrdersByUserDESC(userId: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('userId', userId);
    return this.http.get(ORDER_API + 'userup', { params: params });
  }

  getOrdersByUserASC(userId: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('userId', userId);
    return this.http.get(ORDER_API + 'userpast', { params: params });
  }

  getDetails(orderId: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('orderId', orderId);
    return this.http.get(ORDER_API + 'detail', { params: params });
  }
}