CREATE TABLE fx_deal(

    id VARCHAR(255) not null,
    from_currency VARCHAR(3) not null,
    to_currency VARCHAR(3) not null,
    timestamp DATETIME not null,
    amount DECIMAL(15, 2) not null,

    PRIMARY KEY (id)
);
