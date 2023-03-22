INSERT INTO tb_plan (name, free_Minutes, additional_Tariff) VALUES ('FaleMais 30', 30, 1.1);
INSERT INTO tb_plan (name, free_Minutes, additional_Tariff) VALUES ('FaleMais 60', 60, 1.1);
INSERT INTO tb_plan (name, free_Minutes, additional_Tariff) VALUES ('FaleMais 120', 120, 1.1);

INSERT INTO tb_tariff(origin, destiny, price_per_minute) VALUES ('011', '016', 1.9);
INSERT INTO tb_tariff(origin, destiny, price_per_minute) VALUES ('016', '011', 2.9);
INSERT INTO tb_tariff(origin, destiny, price_per_minute) VALUES ('011', '017', 1.7);
INSERT INTO tb_tariff(origin, destiny, price_per_minute) VALUES ('017', '011', 2.7);
INSERT INTO tb_tariff(origin, destiny, price_per_minute) VALUES ('011', '018', 0.9);
INSERT INTO tb_tariff(origin, destiny, price_per_minute) VALUES ('018', '011', 1.9);