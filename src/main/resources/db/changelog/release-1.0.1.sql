-- add some initial transactions for testing
INSERT INTO fx_deal (id, from_currency, to_currency, timestamp, amount)
VALUES
('initialTestId1', 'USD', 'EUR', '2010-12-31 01:15:00', 10.12),
('initialTestId2', 'PKR', 'BTC', '2015-12-31 01:15:00', 10.1),
('initialTestId3', 'ETH', 'EUR', '2020-12-31 01:15:00', 1022);