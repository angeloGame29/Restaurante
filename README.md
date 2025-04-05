# Sistema de Gerenciamento de Pedidos para Restaurante

Este projeto tem como objetivo desenvolver um sistema para gerenciamento de pedidos em um restaurante. O sistema permite o cadastro, consulta, atualização e cancelamento de pedidos, além de oferecer funcionalidades para cálculo do valor total dos pedidos e armazenamento dos dados.

## índice

- [Funcionalidades Implementadas](#funcionalidades-implementadas)
- [Funcionalidades Futuras](#funcionalidades-futuras)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)

## Funcionalidades Implementadas

- **Verificação de Existência de Pedido:** Método que verifica se um pedido existe no sistema a partir do seu código.

- **Cadastro de Pedido por Dados Individuais:** Permite cadastrar um pedido fornecendo dados como nome do cliente, código do pedido, número da mesa, itens pedidos, data e status do pedido.

- **Cadastro de Pedido por Objeto:** Possibilita o cadastro de um pedido passando um objeto Pedido diretamente.

- **Pesquisa de Pedidos do Dia:** Retorna todos os pedidos realizados em um dia específico.

- **Pesquisa de Pedido por Código:** Busca e retorna os dados de um pedido específico a partir do código informado.

- **Atualização de Itens do Pedido:** Permite adicionar novos itens a um pedido existente.

- **Atualização do Status do Pedido:** Modifica o status do pedido para indicar seu progresso (aceito, preparando, entregue, cancelado etc.).

- **Cancelamento de Pedido:** Cancela um pedido existente no sistema.

- **Cálculo do Valor Total do Pedido:** Calcula o valor total dos itens de um pedido específico.

- **Persistência de Pedidos:** Métodos para salvar e recuperar pedidos do sistema.

## Funcionalidades Futuras

- **Autenticação e Controle de Acesso:** Implementar um sistema de login para gerentes e funcionários.

- **Controle de Estoque:** Criar um sistema para verificar disponibilidade de ingredientes para os pedidos.

- **Feedback dos Clientes:** Permitir que clientes avaliem os pedidos e o serviço do restaurante.

## Tecnologias Utilizadas

- **Linguagem:** Java
- **Paradigma:** Programação Orientada a Objetos (POO)
- **Tratamento de Exceções:** Implementação de exceções personalizadas (PedidoExistenteException, PedidoInexistenteException).
- **Persistência de Dados:** Métodos para salvar e recuperar pedidos utilizando arquivos.