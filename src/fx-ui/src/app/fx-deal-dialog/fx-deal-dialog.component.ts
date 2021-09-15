import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'fx-deal-dialog',
  templateUrl: './fx-deal-dialog.component.html',
  styleUrls: ['./fx-deal-dialog.component.css']
})
export class FxDealDialogComponent {
  fxDeal = undefined;
  dealForm = this.formBuilder.group({
    id: ['', Validators.required],
    fromCurrency: ['', Validators.required],
    toCurrency: ['', Validators.required],
    amount: ['', Validators.required],
  });

  constructor(private formBuilder: FormBuilder) {}

  formChange() {
    const { fromCurrency, toCurrency, amount } = this.dealForm.value;
    this.dealForm.patchValue({
      fromCurrency: fromCurrency.toUpperCase(),
      toCurrency: toCurrency.toUpperCase(),
    });
    if (amount) {
      this.dealForm.patchValue({
        amount: parseFloat(amount).toFixed(2),
      });
    }
  }

}
