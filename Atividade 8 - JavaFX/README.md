# Atividade 8 — Aplicativos JavaFX

Este diretório contém uma solução independente para cada exercício.

## Organização

| Exercício | Pasta | Arquivo principal | Descrição |
| --- | --- | --- |
| 1 | `Exercicio 1 - Scrapbooking` | `ScrapbookingApp.java` | Colagem de quatro pontos turísticos, com imagens locais e legendas. |
| 2 | `Exercicio 2 - Km por Litro` | `CalculadoraKmPorLitro.java` | Calcula quilômetros por litro. |
| 3 | `Exercicio 3 - Soma JavaFX` | `SomaJavaFX.java` | Soma dois valores inteiros em uma interface JavaFX. |
| 4 | `Exercicio 4 - Polilinha` | `PolylineApp.java` | Círculo e polilinha que acompanham o cursor, limitados a 50 pontos. |
| 5 | `Exercicio 5 - Gradientes` | `UsingGradients.java` | Retângulo com gradiente linear/radial e cores RGBA configuráveis. |

## Como executar

1. Instale um JDK e o [JavaFX SDK](https://openjfx.io/).
2. Entre na pasta do exercício que deseja executar. Por exemplo:

```bash
cd "Exercicio 2 - Km por Litro"
```

3. Compile o arquivo (substitua `/caminho/javafx-sdk/lib` pelo local do SDK):

```bash
javac --module-path /caminho/javafx-sdk/lib --add-modules javafx.controls NomeDoArquivo.java
```

4. Execute a classe compilada:

```bash
java --module-path /caminho/javafx-sdk/lib --add-modules javafx.controls NomeDaClasse
```

Exemplo: para o exercício 2, use `CalculadoraKmPorLitro.java` e `CalculadoraKmPorLitro`.

O exercício 1 usa as imagens locais da pasta `assets`, portanto funciona sem conexão com a internet. Execute o comando a partir desta pasta (`Atividade 8 - JavaFX`) para que o programa encontre os arquivos.
