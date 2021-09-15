import { Component, EventEmitter, Output } from '@angular/core';
import { DataService } from '../data.service';
import { AlertState } from '../DataTypes';

@Component({
  selector: 'fx-deal-list',
  templateUrl: './fx-deal-list.component.html',
  styleUrls: ['./fx-deal-list.component.css']
})
export class FxDealListComponent {
  fxDeals = [];

  @Output() loading = new EventEmitter<boolean>();
  @Output() alert = new EventEmitter<AlertState>();

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.getAllFxDeals();
  }

  async getAllFxDeals() {
    this.loading.emit(true);
    try {
      const response = await this.dataService.getAllFxDeals();
      if (!response.ok) {
        const { error } = await response.json();
        this.fxDeals = [];
        this.alert.emit({
          visible: true,
          status: 'danger',
          message: error.message,
        });
        return;
      }
      const { responseBody } = await response.json();
      this.fxDeals = JSON.parse(JSON.stringify(responseBody));
    } catch (e) {
      this.fxDeals = [];
      this.alert.emit({
        visible: true,
        status: 'danger',
        message: 'Error!',
      });
    } finally {
      this.loading.emit(false);
    }
  }

}
