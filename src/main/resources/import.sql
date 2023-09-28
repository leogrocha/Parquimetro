insert into tb_endereco (logradouro, bairro, numero, complemento, cep, municipio) values ('Rua Teste', 'Centro', 'S/N', null, '37950-000', 'Paraiso');

insert into tb_condutor (nome, cpf, email, telefone, forma_pagamento, endereco_id) values ('Seu Madruga', '111.111.111-88', 'contato@hotmail.com', '35988774455', 'PIX', 1);

insert into tb_veiculo (marca, modelo, placa, ano_fabricacao) values ('Ferrari', 'V1', 'ABC-1234', 2010);
insert into tb_veiculo (marca, modelo, placa, ano_fabricacao) values ('Fiat UNO', 'V2', 'CPF-4578', 2004);

insert into tb_condutor_veiculo (condutor_id, veiculo_id) values (1,1);
insert into tb_condutor_veiculo (condutor_id, veiculo_id) values (1,2);

