# Linguagem de Programação 1 (Java) - Trabalho: Lista de Tarefas
Desenvolver uma aplicação de lista de tarefas para ser utilizada a partir do terminal (Aplicação console). As tarefas deverão ser armazenadas usando um banco de dados em arquivo (SQLite ou H2), fazendo uso das APIs JDBC. 
### Uma tarefa deve conter os seguintes campos:
- Texto (String) (descrevendo a tarefa a ser executada)
- Concluído (Booleano) (indicando se a tarefa foi concluída ou não
- Data de Alteração (indicando a data de alteração de status da tarefa)
### A aplicação deverá permitir:
- Cadastrar uma tarefa
- Alterar o status de uma tarefa
- Filtrar as tarefas por: Todas as Tarefas, Tarefas Pendentes e Tarefas Concluídas

A entrega deverá ser feita através de um repositório no GitHub. Para a entrega deverá ser criada uma tag específica, através dos comandos:

```git
git tag -a entrega -m "Entrega do Projeto"
git push origin --tags
```

**Nota**: Para verificar se a tag foi criada, ver o link "tags" em seu repositório git. Lembrando que a tag é uma fotografia do repositório no momento em que ela foi criada então verifique, antes de sua criação, se o código está devidamente publicado no repositório.     
