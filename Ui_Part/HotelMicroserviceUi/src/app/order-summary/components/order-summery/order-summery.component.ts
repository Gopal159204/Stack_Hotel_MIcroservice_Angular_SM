import { Component, OnInit } from '@angular/core';
import { OrderDTO } from '../../models/OrderDTO';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderSummaryService } from '../../services/order-summary.service';

@Component({
  selector: 'app-order-summery',
  templateUrl: './order-summery.component.html',
  styleUrls: ['./order-summery.component.css']
})
export class OrderSummeryComponent implements OnInit {
  orderSummary: OrderDTO;
  obj: any;
  total: any;
  showDialog: boolean = false;

  constructor(private route: ActivatedRoute, private orderService: OrderSummaryService, private router: Router) { }
  
  ngOnInit() {
    const data = this.route.snapshot.queryParams['data'];
    this.obj = JSON.parse(data);
    this.obj.userId=1;
    this.orderSummary= this.obj
    // this.total=this.orderSummary?.foodItemsList?.reduce(())

    this.total = this.orderSummary?.foodItemsList?.reduce((accumulator, currentValue) => {
      return accumulator + (currentValue.quantity * currentValue.price);
    }, 0);

  }

  saveOrder() {
    this.orderService.saveOrder(this.orderSummary)
      .subscribe(
        response => {
            this.showDialog = true;
        },
        error => {
          console.error('Failed to save data:', error);
        }
      );
  }

  closeDialog() {
    this.showDialog = false;
    this.router.navigate(['/']); // Replace '/home' with the actual route for your home page
  }

}
