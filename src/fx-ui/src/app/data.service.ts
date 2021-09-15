import { Injectable } from '@angular/core';

import { FxDeal } from './DataTypes';

@Injectable({
  providedIn: 'root',
})
export class DataService {

  getAllFxDeals(): Promise<Response> {
    return fetch('/api/v1/fx-deals');
  }

  getFxDealByUniqueId(id: string): Promise<Response> {
    return fetch(`/api/v1/fx-deals/${id}`);
  }

  createFxDeal(fxDeal: FxDeal) {
    return fetch('/api/v1/fx-deals', {
        method: 'POST',
        body: JSON.stringify(fxDeal),
        headers: {
            'Content-Type': 'application/json'
        },
    });
  }

}