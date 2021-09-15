import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatDialogModule } from '@angular/material/dialog';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { FxDealComponent } from './fx-deal/fx-deal.component';
import { FxDealSearchComponent } from './fx-deal-search/fx-deal-search.component';
import { FxDealListComponent } from './fx-deal-list/fx-deal-list.component';
import { FxDealDialogComponent } from './fx-deal-dialog/fx-deal-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    FxDealComponent,
    FxDealSearchComponent,
    FxDealListComponent,
    FxDealDialogComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatGridListModule,
    MatDialogModule,
    MatProgressSpinnerModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
