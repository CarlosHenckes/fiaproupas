FIAP 30SCJ - Frameworks

1. O sistema necessita do ActiveMQ para rodar.

2. startar a aplicação.

3. Iniciar um banco de dados MYSQL. Editar o arquivo application.properties com o usuário de senha do seu DB. 
	Criar uma base de dados chamada fiap.
	
	3.1. chamar o endpoint '/mokeproduct' para popular a base de produtos (Moke)
	3.2. chamar o endpoint '/mokecustomer' ...
	3.3. chamar o endpoint '/mokeorder' ...
	
4. criar em c: um diretório chamado 'cupons'
	
5. para produzir uma nova nota fiscal chamar o endpoint '/ticket/{id}', onde {id} é o número do pedido na faixa
	de 1 até 1000. {id} igual a -1 (menos um) gera todas os pedidos referentes ao mês de Fevereiro de 2018.