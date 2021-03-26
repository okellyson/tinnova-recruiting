GRANT USAGE ON SCHEMA public TO wjgauzfz;
GRANT SELECT, USAGE ON ALL SEQUENCES IN SCHEMA public TO wjgauzfz;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO wjgauzfz;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA inventario TO wjgauzfz;


-- Marca

CREATE TABLE public.marca (
	id serial PRIMARY KEY,
	nome varchar NOT NULL,
	codigo varchar NOT NULL,
	CONSTRAINT marca_pk PRIMARY KEY (id),
);
COMMENT ON TABLE public.marca IS 'Tabela para armazenar as marcas disponíveis';

-- Column comments

COMMENT ON COLUMN public.marca.id IS 'Identificador único da entidade';
COMMENT ON COLUMN public.marca.nome IS 'Nome fantasia da marca';
COMMENT ON COLUMN public.marca.codigo IS 'codigo de identificação da marca';


-- Veículos

CREATE TABLE public.veiculo (
	id serial NOT NULL,
	modelo varchar NOT NULL,
	marca int4 NOT NULL,
	ano int4 NOT NULL,
	descricao text NULL,
	vendido bool NOT NULL,
	created date NOT NULL,
	updated date NULL,
	CONSTRAINT veiculo_pk PRIMARY KEY (id),
	CONSTRAINT veiculo_fk FOREIGN KEY (marca) REFERENCES public.marca(id)
);
COMMENT ON TABLE public.veiculo IS 'Tabela para armazenar os registros de veículo';

-- Column comments

COMMENT ON COLUMN public.veiculo.id IS 'Identificador único da entidade';
COMMENT ON COLUMN public.veiculo.modelo IS 'Modelo do veículo';
COMMENT ON COLUMN public.veiculo.marca IS 'Chave estrangeira para a marca do veículo';
COMMENT ON COLUMN public.veiculo.ano IS 'Número que indica o ano de fabricação do veículo';
COMMENT ON COLUMN public.veiculo.descricao IS 'Descrição do veículo';
COMMENT ON COLUMN public.veiculo.vendido IS 'Flag que indica se o carro foi vendido';
COMMENT ON COLUMN public.veiculo.created IS 'Data de criação da entidade';
COMMENT ON COLUMN public.veiculo.updated IS 'última data de atualização da entidade';