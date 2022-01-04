# TDD – Desenvolvimento de Software Guiado por Testes - ITA

## TDD (Test Driven Development)
É uma técnica de desenvolvimento e projeto de software, 
em que os testes são criados antes do código de produção

### Fluxo de Desenvolvimento
- Ciclo do TDD
  - Adicionar um teste
  - Ver o teste falhar
  - Escrever o código
  - Rodar os testes
  - Refatorar
  - (Se inicia um novo teste)
- Adicionar um teste inclui **projetar a interface da classe que você irá testar** e 
definir o seu **comportamento**.
- Fazer o teste passar inclui criar o comportamento da classe da forma **mais simples possível**.
- Refatorar inclui ajustar seu código de forma a ficar mais limpo e melhor estruturado.

## Exercícios 
### 1 - Converter strings camel case para lista
- Casos de Testes:
  - nome - “nome”
  - Nome - “nome”
  - nomeComposto - “nome”, “composto”
  - NomeComposto - “nome”, “composto”
  - CPF - “CPF”
  - numeroCPF - “numero”, “CPF”
  - numeroCPFContribuinte - “numero”, “CPF”, “contribuinte”
  - recupera10Primeiros - “recupera”, “10”, “primeiros”
  - 10Primeiros - Inválido → não deve começar com números
  - nome#Composto - Inválido → caracteres especiais não são permitidos, somente letras e números