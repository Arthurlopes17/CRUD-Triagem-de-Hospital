# CRUD-Triagem-de-Hospital
Este é um CRUD simples de Triagem de Hospital que fiz pra uma prova da faculdade.
# 🏥 Sistema de Triagem Hospitalar (CRUD)

Este é um sistema desktop simples e funcional desenvolvido em **Java** para gerenciar a fila de triagem de um hospital. O projeto utiliza a interface gráfica nativa do Java (`JOptionPane`) para interação com o usuário e armazena todos os dados de forma persistente em um arquivo **CSV** local utilizando a biblioteca **OpenCSV**.

---

## 🚀 Funcionalidades

O sistema cobre todas as operações básicas de um CRUD:

* **Cadastrar Paciente (Create):** Coleta os dados do paciente (Nome, CPF, Idade, Sintomas e Nível de Prioridade de 1 a 5) e os adiciona ao final do arquivo CSV.
* **Visualizar Triagem (Read):** Lê o arquivo CSV e exibe na tela uma lista formatada com todos os pacientes atualmente na fila.
* **Atualizar Paciente (Update):** Busca um paciente pelo CPF e permite alterar qualquer um de seus dados cadastrais.
* **Remover Paciente (Delete):** Busca um paciente pelo CPF e o remove da fila (simulando uma alta ou encaminhamento médico).

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 8 ou superior)
* **Interface Gráfica:** Java Swing (`JOptionPane`)
* **Persistência de Dados:** Arquivo de texto delimitado por vírgulas (`.csv`)
* **Biblioteca Externa:** [OpenCSV](https://opencsv.sourceforge.net/) (Para leitura e escrita otimizada do arquivo)

---

## 📋 Pré-requisitos e Dependências

Para que o projeto funcione corretamente, é obrigatório adicionar a biblioteca **OpenCSV** ao Classpath do seu projeto. 

Se você estiver utilizando o **IntelliJ IDEA** (sem Maven/Gradle), siga estes passos rápidos:
1. Abra o projeto e pressione `Ctrl + Alt + Shift + S` (ou vá em *File > Project Structure*).
2. Vá em **Libraries** no menu esquerdo e clique no botão de **`+`**.
3. Escolha **From Maven...** e pesquise por: `com.opencsv:opencsv:5.9`.
4. Clique em **OK**, aplique as alterações e pronto!

---

## 📂 Estrutura de Arquivos

* `src/crud/Crud.java`: Contém os atributos do paciente e toda a lógica de manipulação do arquivo CSV (Criar, Ler, Atualizar e Deletar).
* `src/crud/Hospital.java`: Classe principal (`main`) que inicializa o sistema e gerencia o menu de opções visual.
* `triagem_hospital.csv`: Arquivo gerado automaticamente na raiz do projeto assim que o primeiro paciente é cadastrado.
