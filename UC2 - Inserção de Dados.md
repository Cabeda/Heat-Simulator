## **- Formato breve** ##
O utilizador irá ter de preencher os dados pela seguinte ordem de categorias (Dimensões, Limites da sala, Aberturas da sala, número de pessoas, número de aparelhos e temperatura). O programa apenas avança após ter os dados de cada categoria preenchidos. Quando tal ocorre os dados são guardados no controller. Na inserção dos dados de limites e aberturas o programa permite a inserção de um número infinito dos mesmos.

## **- SSD de formato breve** ##

![uc2.png](https://bitbucket.org/repo/doqoR8/images/545227651-uc2.png)


## **- Formato completo** ##

Ator principal
Utilizador

Partes interessadas e seus interesses
Utilizador: Inserção dos dados corretos 

### Pré-condições ###
-
### Pós-condições ###
A informação do evento é registada no sistema.

Cenário de sucesso principal (ou fluxo básico)
1.	O utilizador inicia o programa

2.	O sistema solicita os dados de dimensões

3.	O utilizador introduz os dados solicitados.

4.	O sistema pede para introduzir os objetos limite

5.	O utilizador introduz os dados solicitados

6.	O sistema repete os passos 4 e 5 até o utilizador pedir para continuar

7.	O sistema pede para introduzir os objetos abertura

8.	O utilizador introduz os dados solicitados

9.	O sistema repete os passos 7 e 8 até o utilizador pedir para continuar

10.	O sistema solicita os dados do número de pessoas

11.	O utilizador introduz os dados solicitados

12.	O sistema solicita os dados dos aparelhos

13.	O utilizador introduz os dados solicitados

14.	O sistema solicita os dados de temperaturas

15.	O utilizador introduz os dados solicitados

### Extensões (ou fluxos alternativos) ###
*a. A qualquer momento o utilizador solicita cancelamento da introdução de dados. 
O caso de uso termina.
*b. A qualquer momento o utilizador solicita a reintrodução de dados. 
O sistema permite a reintrodução dos dados da categoria selecionada.

### Requisitos especiais ###
-
### Tecnologia e Lista de Variações dos Dados ###
-
### Frequência de Ocorrência ###
- 
### Questões em aberto ###

-	Deve existir um número máximo de limites e de aberturas?

-	A introdução dos dados deve ter uma ordem específica?


