import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderModule } from "./header/header.module";
import { RestaurantListingModule } from './restaurant-listing/restaurant-listing.module';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantListingComponent } from './restaurant-listing/components/restaurant-listing.component';
import { FoodCatalogueModule } from './food-catalogue/food-catalogue.module';
import { OrderSummeryComponent } from './order-summary/components/order-summery/order-summery.component';
import { OrderSumeryModule } from './order-summary/order-sumery.module';

@NgModule({
    declarations: [
        AppComponent,
        OrderSummeryComponent,
        
        
    ],
    providers: [],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HeaderModule,
        RestaurantListingModule,
        HttpClientModule,
        FoodCatalogueModule,
        OrderSumeryModule

    ]
})
export class AppModule { }
