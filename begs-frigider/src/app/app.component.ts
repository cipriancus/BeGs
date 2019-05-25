import { Component, OnInit } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Product } from './products.model';
import { ProductService } from './product.service';
import { Router } from '@angular/router';
import { trigger } from '@angular/animations';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    products: Product[] = [];
    firstPage: boolean = true;
    secondPage: boolean = false;
    products2: Product[] = [
        {
            image: 'cherry',
            name: 'Cherry',
            description: 'Best Seller'
        },
        {
            image: 'apple',
            name: 'Apple',
            description: 'Bio Product No restrictions'
        },
        {
            image: 'redapple',
            name: 'Red Apple',
            description: 'Best Seller'
        },
        {
            image: 'strawberry',
            name: 'Strawberry',
            description: 'Hot right now No restrictions'
        }];
    constructor(private productservice: ProductService) { }

    drop(event: CdkDragDrop<string[]>) {
        if (event.previousContainer === event.container) {
            moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
        } else {
            transferArrayItem(event.previousContainer.data,
                event.container.data,
                event.previousIndex,
                event.currentIndex);
        }
    }

    ngOnInit() {
        const productObservable = this.productservice.getStudents();
        productObservable.subscribe((productsData: Product[]) => {
            this.products = productsData;
        });
    }


    changePage(event: any): void {
        if (event === true){
            this.secondPage = true;
            this.firstPage = false;
        }
    }

}
