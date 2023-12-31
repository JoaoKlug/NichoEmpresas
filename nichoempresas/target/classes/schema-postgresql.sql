drop table if exists tb_nicho;

CREATE TABLE tb_nicho
(
    cnpj_empresa float(8) NOT NULL PRIMARY KEY,
    razao_social_empresa text UNIQUE,
    natureza_juridica_empresa text,
    qualificacao_responsavel_empresa text,
    data_inicio_matriz timestamp,
    cnae_matriz float(7),
    cnae_matriz_descricao text,
    municipio_matriz text,
    uf_matriz varchar(2),
    telefone_principal_matriz varchar(13) UNIQUE,
    telefone_secundario_matriz varchar(13) UNIQUE,
    email_matriz text UNIQUE,
    nome_socio text,
    faixa_etaria_socio text
)