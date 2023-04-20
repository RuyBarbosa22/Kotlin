-- as instruções neste arquivo são executadas
-- caso exista a configuração
-- spring.jpa.defer-datasource-initialization=true
-- no application.properties
insert into musica
(nome, data_gravacao, nota_spotify, infantil)
values
('música A', '2020-01-01', 5.5, true),
('música BB', '2019-01-01', 7.5, true),
('música CCC', '2018-01-01', 9.5, false),
('música DDDD', '2017-01-01', 9.9, true),
('música EEEEE', '2016-01-01', 10.0, true);

-- é possível ter várias instruções SQL aqui,
-- basta que estejam separadas por ponto e vírgula