import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Product } from '../product/product';
export class InMemoryDataService implements InMemoryDbService {
    createDb() {
        const PRODUCTLIST: Product[] = [
            { id: 0, name: 'Zero', price: 0, imagePath: "", description: "", currency: "=" },
            { id: 211, name: 'Reebok Sneakers', price: 2500, imagePath: "nike.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "INDIA" },
            { id: 212, name: 'Reebok Shoes ', price: 2549, imagePath: "nike.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "america" },
            { id: 213, name: 'Bata Shoes', price: 1300, imagePath: "nike.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "india" },
            { id: 134, name: 'US Polo Tshirt', price: 1333, imagePath: "shirt.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "india" },
            { id: 415, name: 'Reebok Shorts', price: 999, imagePath: "shorts.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "india" },
            { id: 116, name: 'Wrangler Jeans', price: 99, imagePath: "jeans.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "india" },
            { id: 137, name: 'Reebok Pullover', price: 2215, imagePath: "pullover.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "india" },
            { id: 148, name: 'Puma Shoes ', price: 2775, imagePath: "batashoes.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "INdia" },
            { id: 159, name: 'Puma Pullover', price: 465, imagePath: "pullover.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "india" },
            { id: 210, name: 'Adidas Shoes', price: 1976, imagePath: "nike.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "india" },
            { id: 101, name: "Television", price: 10999, imagePath: "nike.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "america" },
            { id: 102, name: "Smartphone", price: 9999, imagePath: "mobile.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "india" },
            { id: 103, name: "Laptop", price: 109999, imagePath: "laptop.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "india" },
            { id: 104, name: "Smartwatch", price: 999, imagePath: "nike.jpg", description: "Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.", currency: "india" },
           ];
        return { PRODUCTLIST };
    }
}