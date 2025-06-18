# Engenharia de Software 2 - Trabalho: Biblioteca Saber Vivo
## Cenário do Domínio: Biblioteca "Saber Infinito"
A biblioteca "Saber Infinito" precisa de um sistema para gerenciar seu acervo de livros e os empréstimos realizados pelos seus membros.
Principais Funcionalidades Desejadas:
1. Gerenciamento de Livros:
  ○ Adicionar novos livros ao acervo (com título, autor(es), ISBN, número de cópias).
  ○ Buscar livros por título, autor ou ISBN.
  ○ Visualizar detalhes de um livro, incluindo quantas cópias estão disponíveis.
2. Gerenciamento de Membros:
  ○ Registrar novos membros (com nome, ID de membro, informações de contato).
  ○ Buscar membros por nome ou ID.
3. Gerenciamento de Empréstimos:
  ○ Realizar empréstimo de um livro para um membro (verificar disponibilidade do livro e se o membro não possui pendências).
  ○ Registrar a data de empréstimo e a data prevista de devolução.
  ○ Registrar a devolução de um livro.
  ○ Listar livros emprestados por um membro.
  ○ Listar membros com livros atrasados.
### Linguagem Ubíqua (Ubiquitous Language):
● Identifique e liste os termos chave do domínio da biblioteca. Discuta seus significados para garantir um entendimento comum.
● Exemplos: Livro, Cópia de Livro, Membro, Empréstimo, Devolução, ISBN, Atraso, Disponibilidade.
### Contexto Delimitado (Bounded Context):
● Para este exercício, vamos focar em um Bounded Context principal que podemos chamar de "Contexto de Empréstimos e
Acervo".
● Descreva brevemente a principal responsabilidade deste contexto.
### Identificação de Entidades, Objetos de Valor e Agregados:
● Entidades: Quais são os objetos com identidade única e ciclo de vida?
  ○ Pense em: Livro (o conceito abstrato do título), CópiaDeLivro (o item físico), Membro, Empréstimo.
● Objetos de Valor: Quais são os atributos que descrevem características e não têm identidade própria?
  ○ Pense em: ISBN, NomeAutor, EnderecoMembro, PeriodoEmprestimo (data início, data fim).
● Agregados e Raízes de Agregado:
  ○ Agrupe entidades e objetos de valor que devem ser tratados como uma unidade de consistência. Qual é a Raiz de cada Agregado?
  ○ Sugestão:
    ■ Livro como raiz, gerenciando suas CopiaDeLivro (para controlar disponibilidade total e dados do título).
    ■ Membro como raiz, gerenciando seus dados e talvez um resumo de seus empréstimos ativos.
    ■ Empréstimo como raiz, ligando um Membro a uma CopiaDeLivro específica, e contendo regras sobre o empréstimo em si.
  ○ Defina as invariantes (regras de consistência) para cada agregado.
    ■ Ex: Um Empréstimo só pode ser criado se a CopiaDeLivro estiver disponível.
    ■ Ex: Um Membro não pode pegar mais que X livros emprestados simultaneamente.
### Esboço dos Agregados:
● Para cada Agregado identificado, liste:
  ○ Raiz do Agregado.
  ○ Entidades internas.
  ○ Objetos de Valor.
  ○ Principais comportamentos (métodos na Raiz do Agregado).
### Implementação dos Agregados e Entidades/VOs:
● Comece a criar as classes/estruturas para suas Entidades, Objetos de Valor e Raízes de Agregado.
● Implemente os construtores e os métodos que encapsulam os comportamentos e garantem as invariantes.
### Repositórios (Repository Pattern):
● Defina interfaces para os Repositórios de cada Agregado.
  ○ Ex: ILivroRepository, IMembroRepository, IEmprestimoRepository.
● Quais métodos são essenciais (Ex: salvar(agregado), buscarPorId(id),
buscarEmprestimosAtivosPorMembro(membroId))?
● Padrão GoF: O próprio Repository é um padrão arquitetural, mas sua implementação pode usar outros padrões como Façade
para simplificar o acesso a diferentes mecanismos de persistência (mesmo que aqui seja em memória)
### Fábricas (Factory Method ou Abstract Factory Pattern):
● Considere a criação de Empréstimo. A criação de um empréstimo envolve verificar a disponibilidade do livro e as condições
do membro.
● Tarefa: Implemente uma EmprestimoFactory que seja responsável por criar um objeto Empréstimo válido, garantindo que
todas as pré-condições sejam atendidas.
● Discussão: Por que usar uma Factory aqui é benéfico? Qual padrão GoF (Factory Method ou Abstract Factory) seria mais
adequado e por quê?
### Serviços de Domínio (Domain Services):
● Pode haver operações que não se encaixam naturalmente em um único agregado?
● Exemplo: Um serviço para "Verificar Disponibilidade de Múltiplos Livros para um Carrinho de Empréstimo" ou "Processar
Devolução com Cálculo de Multa por Atraso" (se a lógica de multa for complexa e envolver vários objetos).
● Tarefa (Opcional): Se identificar um, esboce a interface de um Serviço de Domínio.
### Padrão Strategy para Políticas de Empréstimo/Multa:
● Imagine que a biblioteca tem diferentes políticas de empréstimo ou cálculo de multa (ex: para membros VIP vs. membros
regulares, ou para tipos diferentes de livros).
● Tarefa: Como você poderia usar o Strategy Pattern para permitir que a política de cálculo de data de devolução ou de multa
seja flexível e intercambiável dentro do Agregado Empréstimo ou em um Serviço de Domínio? Esboce as interfaces e
classes.
### Padrão State para o Status de CopiaDeLivro ou Empréstimo:
● Uma CopiaDeLivro pode estar "Disponível", "Emprestada", "Em Manutenção".
● Um Empréstimo pode estar "Ativo", "Devolvido", "Atrasado".
● Tarefa: Escolha um deles e discuta como o State Pattern poderia ser usado para gerenciar esses estados e os
comportamentos/transições associados. Esboce a estrutura.
### Eventos de Domínio (Domain Events) e Padrão Observer:
● Quais eventos importantes acontecem no domínio?
○ Ex: LivroEmprestadoEvent, LivroDevolvidoEvent, AtrasoIdentificadoEvent.
● Como o Observer Pattern poderia ser usado para notificar outras partes do sistema (ou outros Bounded Contexts, se existissem)
quando esses eventos ocorrem?
● Discussão: Quais os benefícios de usar Eventos de Domínio para desacoplamento?
### Outros Padrões Identificados:
● Você identificou o uso de outros padrões GoF (ex: Builder para construir objetos Livro complexos, Adapter para integrar com um
sistema legado de catalogação, Decorator para adicionar responsabilidades a um Emprestimo)? Documente-os.
### Desafios e Decisões de Design:
● Quais foram os principais desafios ao modelar o domínio?
● Quais decisões de design importantes você tomou e por quê?
● Como o DDD ajudou (ou dificultou) a aplicação dos Padrões de Projeto?
## Lista de Entregaveis
### Documento de Modelagem DDD:
● Lista da Linguagem Ubíqua.
● Descrição do Bounded Context.
● Lista de Entidades, Objetos de Valor e Agregados (com suas Raízes e invariantes).
### Código Fonte (ou Pseudocódigo Detalhado):
● Implementação dos Agregados, Entidades, VOs.
● Interfaces e (pelo menos) uma implementação simulada (em memória) dos Repositórios.
● Implementação da EmprestimoFactory.
● Esboços/implementações das aplicações dos padrões Strategy e State.
### Documento de Reflexão:
● Discussão sobre o uso de Eventos de Domínio e o padrão Observer.
● Lista de outros padrões identificados.
● Respostas para as perguntas sobre desafios e decisões de design.
