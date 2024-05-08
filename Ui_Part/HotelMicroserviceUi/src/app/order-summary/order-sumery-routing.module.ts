import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderSummeryComponent } from './components/order-summery/order-summery.component';

const routes: Routes = [
  { path: 'orderSummary', component: OrderSummeryComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrderSumeryRoutingModule { }
