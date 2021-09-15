import { TestBed } from '@angular/core/testing';

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


describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
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
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'fx-ui'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('fx-ui');
  });

  it('should render search component', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('fx-deal-search'))?.not.toBe(null);
  });

  it('should render list component', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('fx-deal-list'))?.not.toBe(null);
  });
});
