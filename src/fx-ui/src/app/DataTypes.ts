export interface FxDeal {
  'id': string;
  'fromCurrency': string;
  'toCurrency': string;
  'timestamp': string;
  'amount': number;
}

export interface AlertState {
  visible: boolean;
  status: string;
  message: string;
}
