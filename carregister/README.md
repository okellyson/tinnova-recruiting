# Cadastro de Veículos

## Backend

Consiste em uma API REST em Spring Boot que permite:

- Cadastro de Veiculos
- Atualização dos dados de um veículo
- Exclusão de um veículo
- Consultar veículos disponíveis na base
- Listar veículos por década
- Listar veículos por fabricante
- Exibir veículos registrados na última semana
- Garantir consistencia das marcas escritas

## Frontend

Uma aplicação simples em Vue.JS, com Vuetify, para consumir de forma rápida e clara os dados fornecidos pela API

<hr>

# Tecnologias utilizadas

### Backend:

- Java 8
- Spring Boot 2.4.4
- Postgres 12.0

### Frontend:

- Node 14.6.0
- Npm 6.14.6
- Vue 2.6.11
- Vuetify 2.4.0

# Configuração


## Clonando o projeto

Caso tenha o git instalado, execute o comando abaixo na pasta que você deseja clonar o projeto.

> Ainda não tem? Não faz mal, dá uma corridinha [aqui](https://git-scm.com/downloads) que tu consegue instalar rapidinho

```
git clone https://github.com/okellyson/tinnova-recruiting.git
```


## Banco de Dados
### Instalando o Postgres

O projeto conta com um banco de dados armazenado em núvem para facilitar a configuração,
mas caso queira configurar o banco localmente, baixe-o no [site oficial](https://www.postgresql.org/download/),
escolha sua plataforma e a versão especificada acima, nas **Tecnologias utilizadas** e siga o passo a passo.

> Para o SO Ubuntu, siga o passo a passo abaixo, retiradas do [site oficial](https://www.postgresql.org/download/linux/ubuntu/) em 25/03/2021

```bash
# Crie a configuração do repositório de arquivos:
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'

# Importe a chave de assinatura do repositório:
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -

# Atualize as listas de pacotes:
sudo apt-get update

# Instale a versão 12 do PostgreSQL:
sudo apt-get -y install postgresql-12
```

### Migrations

Após configurado o postgres, crie o banco de dados e usuário situados na [migration](backend/src/main/resources/db/migration) 
[**_00.sql**](backend/src/main/resources/db/migration/_00.sql) e então execute as outras sequencialmente, de acordo com o seu número.

### Seeds

Após criar o banco de dados, execute as seeds presentes na pasta [backend/src/main/resources/db/seeds](backend/src/main/resources/db/seeds)


## Frontend

> Utilize o `node` na versão `v14.6.0` e o `npm` na versão `6.14.6`

Utilizando o terminal, entre na pasta `{diretorio-do-projeto}/frontend` e execute:

```bash
npm install
```

Para executar, execute:

```bash
npm run serve
```

## Backend
### Instalando o Java

Antes de iniciar, caso ainda não tenha o Java instalado, faça o download da JDK versão 1.8

> Caso queira executar utilizando alguma IDE de seu costume, esteja à vontade.  
> Para executar no IntelliJ *(2020.3.3)*, abra a pasta backend e selecione a opção que permite que
> o download das dependências seja feito automaticamente.  
> Execute através dos controles na barra de opções, ou, com *shift + F10*
### Instalando o Maven

Instalação maven no diretório `/opt`
```bash
sudo mkdir -p /opt/ferramentas
```

```bash
cd /opt/ferramentas
```

Download
```bash
sudo wget http://mirror.nbtelecom.com.br/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
```

Descompactar
```bash
sudo tar -xvzf apache-maven-3.6.3-bin.tar.gz
```

Alterar nome diretorio
```bash
sudo mv apache-maven-3.6.3 maven
```
Após a instalação, é necessário que as variáveis de ambiente sejam configuradas

Abrir o arquivo
```bash
sudo nano /etc/profile.d/maven.sh
```

Adicionar as seguites linhas e salvar as alterações:
```bash
export M2_HOME=/opt/ferramentas/maven
export PATH=${M2_HOME}/bin:${PATH}
```

Para ativar as configurações, execute os seguintes comandos
```bash
sudo chmod +x /etc/profile.d/maven.sh
source /etc/profile.d/maven.sh
```

Verificar versão instalada
```bash
mvn --version
```

Na pasta do **backend** do projeto, execute:
```bash
mvn spring-boot:run
```