# 🏥 Sistema de Prontuário --- CRUD de Exames

Projeto desenvolvido em Java utilizando arquitetura MVC e PostgreSQL,
com interface gráfica em Swing.

## 📁 Estrutura do Projeto

    src/
     ├─ controller/
     │    └─ ControllerExame.java
     ├─ model/
     │    ├─ Conexao.java
     │    ├─ Exame.java
     │    ├─ ExameDataAcessObject.java
     ├─ view/
     │    └─ TelaExame.java
     ├─ prontuario/
          └─ Main.java

## 🛠️ Tecnologias Utilizadas

-   Java 17+
-   Swing (GUI)
-   PostgreSQL 17
-   JDBC
-   IntelliJ IDEA
-   DAO Pattern / MVC

## 🗄️ Banco de Dados

Execute:

``` sql
CREATE ROLE tiagousuario LOGIN PASSWORD '1234';
GRANT ALL PRIVILEGES ON DATABASE bda TO tiagousuario;
```

## 🔌 Configuração da Conexão

Arquivo `Conexao.java`:

``` java
private static final String URL = "jdbc:postgresql://localhost:5432/bda";
private static final String USER = "tiagousuario";
private static final String PASS = "1234";
```

## ▶️ Como Executar

1.  Abra no IntelliJ
2.  Adicione o driver JDBC
3.  Execute `Main.java`

## 🧪 CRUD Implementado --- Exames

-   Criar
-   Listar
-   Atualizar
-   Excluir

## 👤 Autor

Tiago Cosme
