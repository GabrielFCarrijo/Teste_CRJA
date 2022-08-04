INSERT INTO tb_people (name, created_At, fk_department) VALUES ('Camila', NOW(), 1);
INSERT INTO tb_people (name, created_At, fk_department) VALUES ('Pedro', NOW(), 2);
INSERT INTO tb_people (name, created_At, fk_department) VALUES ('Fabiano', NOW(), 3);
INSERT INTO tb_people (name, created_At, fk_department) VALUES ('Raquel', NOW(), 3);
INSERT INTO tb_people (name, created_At, fk_department) VALUES ('Patricia', NOW(), 3);
INSERT INTO tb_people (name, created_At, fk_department) VALUES ('Joaquim', NOW(), 1);


INSERT INTO tb_tasks (id,titulo, description, date, fk_department, duration, fk_pessoa, finish) VALUES (1001,'Validar NF Janeiro','Validar notas recebidas no mês de Janeiro', TIMESTAMP WITH TIME ZONE '2022-02-15T10:00:00Z', 1, 14 , 1, true);
INSERT INTO tb_tasks (id,titulo, description, date, fk_department, duration, finish) VALUES (1002,'Bug 352','Corrigir bug 352 na versão 1.25', TIMESTAMP WITH TIME ZONE '2022-05-10T10:00:00Z', 3, 25 , false);
INSERT INTO tb_tasks (id,titulo, description, date, fk_department, duration, fk_pessoa, finish) VALUES (1003,'Liberação da versão 1.24','Disponibilizar pacote para testes', TIMESTAMP WITH TIME ZONE '2022-02-02T10:00:00Z', 3, 2 , 3, false);
INSERT INTO tb_tasks (id,titulo, description, date, fk_department, duration, finish) VALUES (1004,'Reunião A','Reunião com cliente A para apresentação do produto', TIMESTAMP WITH TIME ZONE '2022-02-05T10:00:00Z', 2, 5 , false);
INSERT INTO tb_tasks (id,titulo, description, date, fk_department, duration, finish) VALUES (1005,'Reunião final','Fechamento contrato', TIMESTAMP WITH TIME ZONE '2022-03-28T10:00:00Z', 2, 6 , false);
INSERT INTO tb_tasks (id,titulo, description, date, fk_department, duration, fk_pessoa, finish) VALUES (1006,'Pagamento 01/2022','Realizar pagamento dos fornecedore', TIMESTAMP WITH TIME ZONE '2022-01-31T10:00:00Z', 1, 6 , 1, true);
INSERT INTO tb_tasks (id,titulo, description, date, fk_department, duration, fk_pessoa, finish) VALUES (1007,'Bug 401','Corrigir bug 401 na versão 1.20', TIMESTAMP WITH TIME ZONE '2022-01-02T10:00:00Z', 3, 2 , 4, true);
INSERT INTO tb_tasks (id,titulo, description, date, fk_department, duration, fk_pessoa, finish) VALUES (1008,'Bug 399','Corrigir bug 399 na versão 1.20', TIMESTAMP WITH TIME ZONE '2022-01-28T10:00:00Z', 3, 6 , 5, true);
INSERT INTO tb_tasks (id,titulo, description, date, fk_department, duration, fk_pessoa, finish) VALUES (1009,'Reunião B','Reunião com cliente B para apresentação do produto', TIMESTAMP WITH TIME ZONE '2022-01-31T10:00:00Z', 2, 5 , 2, true);
INSERT INTO tb_tasks (id,titulo, description, date, fk_department, duration, fk_pessoa, finish) VALUES (1010,'Validar NF Fevereiro','Validar notas recebidas no mês de Fevereiro', TIMESTAMP WITH TIME ZONE '2022-03-15T10:00:00Z', 1, 14 , 6, false);

INSERT INTO tb_department (titulo) VALUES ('Financeiro');
INSERT INTO tb_department (titulo) VALUES ('Comercial');
INSERT INTO tb_department (titulo) VALUES ('Desenvolvimento');


-- Montar select que retorne nome do departamento, quantidade de tarefas finalizadas e quantidade de tarefas não finalizadas

-- Não exatamente é o esperado para o resultado como informado o banco H2 não consegui fazer as buscas...
-- Entretanto se quiserem fazer um teste utilizando PostgreSQL ou MongoDB fico a disposição para mostrar meus conhecimentos

--select count (id) as numTrue from tb_tasks where finish = 'true'
--select count (id) as numfalse from tb_tasks where finish = 'false'



