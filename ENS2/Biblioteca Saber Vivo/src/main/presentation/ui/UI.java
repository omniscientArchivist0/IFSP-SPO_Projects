package presentation.ui;

public class UI {

    public void showMessage(String text) {
        System.out.println(text);
    }
    public void insertData() {
        System.out.println("Insira os dados a seguir:");
    }
    public void found(String subject) {
        System.out.println("O " + subject + " foi encontrado.");
    }
    public void notFound(String subject) {
        System.out.println("O " + subject + " não foi encontrado.");
    }
    public void added(String subject) {
        System.out.println("O " + subject + " foi adicionado.");
    }
    public void removed(String subject) {
        System.out.println("O " + subject + " foi removido.");
    }
    public void unableToFindBook() {
        System.out.println("O livro pesquisado não foi encontrado.");
    }
    public void updated(String subject) {
        System.out.println("O " + subject + " foi atualizado.");
    }
    public void bookReturned() {
        System.out.println("O livro foi retornado com sucesso.");
    }
    public void instructions() {
        System.out.println("O menu apresenta as seguintes opções:\n1. Registrar um novo usuário.\n2. Registrar um novo bibliotecario.\n3. Registrar um novo livro.\n4. Verificar a existência de um livro.\n5. Remover um livro.\n6. Pegar um livro emprestado.\n7. Devolver um livro emprestado.\n8. Verificar a existência de um emprestimo.\n9. Verificar a existência de um usuário.\n10. Sair do menu.");
    }
}
