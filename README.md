# library-management-system

# 📚 Library Management System (Java + MySQL)

Este é um projeto completo de **sistema de gerenciamento de biblioteca**, desenvolvido em **Java (Swing - JFrame via NetBeans)** com banco de dados **MySQL** e execução local via **XAMPP**. 

> ⚙️ Desenvolvido com foco em CRUD completo, visual estilizado com imagens, JPanels personalizados e integração direta com banco de dados.

---

## ✅ Funcionalidades

- Login administrativo seguro
- Cadastro, edição e exclusão de:
  - 📖 Livros
  - 👤 Estudantes
  - 🧑‍💼 Bibliotecários
  - 🔄 Empréstimos e Devoluções
- Atualização em tempo real da interface com banco de dados
- Uso de JCalendar para seleção e formatação de datas
- Tabelas Swing vinculadas ao MySQL via JDBC

## 🖼️ Diagramas (📁 `/diagramas`)

> Os diagramas de Classes, Casos de Uso e Entidade-Relacionamento da aplicação estão na pasta 'diagramas'.


## 💾 Banco de Dados (📁 `/database`)

- Arquivo `.sql` para criação automática do banco `mylibrarydb` e suas tabelas:  
  - `student`
  - `book`
  - `borrowing`
  - `librarian`

> ✅ Basta importar o arquivo no phpMyAdmin (XAMPP) para executar o sistema localmente.

---

## 🧪 Tecnologias Utilizadas

- **Java SE 8+**
- **Swing (NetBeans GUI Builder)**
- **MySQL 5.7+**
- **XAMPP (Apache + MySQL)**
- **JDBC**
- **JCalendar (para manipulação de datas)**

---

## ▶️ Como Executar o projeto

1. Instale o [XAMPP](https://www.apachefriends.org/)
2. Inicie `Apache` e `MySQL`
3. Importe o arquivo `mylibrarydb.sql` via `phpMyAdmin`
4. Abra o projeto no NetBeans
5. Execute o `Main` ou `AdminLoginJFrame`
6. Use o login:
   - **Usuário:** `admin`
   - **Senha:** `123`

---

## 👨‍💻 Sobre mim

Este projeto foi desenvolvido como forma de consolidar conhecimentos em Java, Swing, banco de dados relacional e boas práticas de separação de camadas e lógica. Na aba projetos do meu LinkedIn tem um vídeo aonde eu mostro o funcinamento desse projeto.

📫 Contato para oportunidades: 
Linkedin: www.linkedin.com/in/luís-f-6a0ba72a4


