# Define the content of the README.md file
readme_content = """
# 2048 Game

Este é um projeto do jogo 2048 desenvolvido em Java.

## Estrutura do Projeto

- **build.xml**: Arquivo de configuração para o Apache Ant.
- **lib/**: Diretório com bibliotecas necessárias para o projeto.
- **manifest.mf**: Arquivo manifest para o JAR.
- **nbproject/**: Diretório com arquivos de configuração do NetBeans.
- **saves/**: Diretório contendo arquivos de salvamento do jogo.
- **src/**: Diretório com o código-fonte do projeto.
- **Start_game.bat**: Script para iniciar o jogo.
- **test/**: Diretório com testes do projeto.

## Requisitos

- Java JDK instalado

## Como Executar

### Via Script

1. Navegue até o diretório raiz do projeto.
2. Execute o script `Start_game.bat`.

### Via NetBeans

1. Abra o NetBeans.
2. Importe o projeto existente (`nbproject`).
3. Compile e execute o projeto a partir do NetBeans.

### Via Linha de Comando

1. Navegue até o diretório raiz do projeto.
2. Rode o programa -jar:
   ```sh
   java -jar dist/Backup3.jar
