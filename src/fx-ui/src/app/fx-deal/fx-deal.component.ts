import { Component, OnInit, Input } from '@angular/core';

import { FxDeal } from '../DataTypes';

@Component({
  selector: 'fx-deal',
  templateUrl: './fx-deal.component.html',
  styleUrls: ['./fx-deal.component.css']
})
export class FxDealComponent implements OnInit {
  @Input() fxDeal?: FxDeal;

  constructor() {}

  ngOnInit() {}
}
