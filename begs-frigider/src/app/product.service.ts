import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './products.model';
import { MyList } from './mylist.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

    students: MyList[] = [
    {
        image: "cherry",
        name: 'Cherry'
    },
    { image: "cheese",
        name: 'Cheese'
    },
    { image: "banana",
        name: 'Banana'
    },
    { image: "kiwi",
        name: 'Kiwi'
    }];

  constructor() { }

  public getStudents(): any {
     const studentsObservable = new Observable(observer => {
            setTimeout(() => {
                observer.next(this.students);
            }, 1000);
     });

     return studentsObservable;
 }

}
