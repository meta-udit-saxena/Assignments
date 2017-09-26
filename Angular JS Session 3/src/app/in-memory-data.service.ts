import {InMemoryDbService} from 'angular-in-memory-web-api';
import {Product} from '../product/product';
export class InMemoryDataService implements InMemoryDbService {
    createDb() {
        const PRODUCTLIST: Product[] = [
            {id :0,name:'Zero',price:0},
            { id: 211, name: 'Reebok Sneakers', price: 2500 },
            { id: 212, name: 'Reebok Shoes ', price: 2549 },
            { id: 213, name: 'Bata Shoes', price: 1300 },
            { id: 134, name: 'US Polo Tshirt', price: 1333 },
            { id: 415, name: 'Reebok Shorts', price: 999 },
            { id: 116, name: 'Wrangler Jeans', price: 99 },
            { id: 137, name: 'Reebok Pullover', price: 2215 },
            { id: 148, name: 'Puma Shoes ', price: 2775 },
            { id: 159, name: 'Puma Pullover', price: 465 },
            { id: 210, name: 'Adidas Shoes', price: 1976 },
            { id: 101, name: "Television", price: 10999 },
            { id: 102, name: "Smartphone", price: 10999 },
            { id: 103, name: "Laptop", price: 10999 },
            { id: 104, name: "Smartwatch", price: 10999 },
            { id: 105, name: "Television", price: 10999 },
            { id: 106, name: "Smartphone", price: 10999 },
            { id: 107, name: "Television", price: 10999 },
            { id: 108, name: "Smartphone", price: 10999 },
            { id: 109, name: "Television", price: 10999 },
            { id: 110, name: "Smartphone", price: 10999 },
            { id: 111, name: "Television", price: 10999 },
            { id: 112, name: "Smartphone", price: 10999 },
        ];
        return {PRODUCTLIST};
    }
}