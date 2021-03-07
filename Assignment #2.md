![](https://i.imgur.com/r2Upi0M.png)

## Verificação e Validação de Software

### Professor: 
José Campos

### Alunos:
João Lopes      nº55812
Filipe Martins  nº55814

# Assignment #2

Este assignment consiste na realização de testes unitarios, sendo estes testes do tipo *Black-Box Testing* e através do metodo Category-Partition.Para tal tivemos de identificar 5 funções do projeto Jpass para testar, tendo estas de pertencer ao pacote assignado **jpass.util**.

O Category-Partition proporciona-nos uma forma sistemática de desenvolver
testes derivados, com base nas características dos parametros das funções
parâmetros. Através disto conseguimos reduzir o número de testes a um
número prático.
Para a realização dos testes unitários utilizamos a ferramente JUnit, que é uma das ferramentas mais utilizadas na criação de testes unitários para Java.

Neste assignment consta uma breve explicação da função a ser testada, como foi utilizada a category-partition e quais os testes a realizar para a mesma, e por fim uma explicação dos testes desenvolvidos e também os resultados obtidos.

## Função - 1

Esta função tem como propósito remover todos os caracteres que não são imprimíveis, para tal é utilizado um *loop* pelos caracteres da `String` fornecida como parâmetro e é verificado se cada caracter é ou não imprimível, utilizando o seu valor hexadecimal, caso o caracter não seja imprimível é substituído por o caracter `'?'`.

```
 public static String stripNonValidXMLCharacters(final String in) {
        if (in == null || in.isEmpty()) {
            return in;
        }
        StringBuilder out = new StringBuilder();
        char current;
        for (int i = 0; i < in.length(); i++) {
            current = in.charAt(i);
            if ((current == 0x9) || (current == 0xA) || (current == 0xD)
                    || ((current >= 0x20) && (current <= 0xD7FF))
                    || ((current >= 0xE000) && (current <= 0xFFFD))) {
                out.append(current);
            } else {
                out.append('?');
            }
        }
        return out.toString();
    }
```
**Category-Partition**

Em termos dos parâmetros existentes nesta função, só temos um, que é uma `String`, este parâmetro não pode ser *null* nem vazio, de resto pode ter qualquer valor valido para uma string, seja ele imprimível ou não.
Desta forma obtemos os testes possíveis a desenvolver:

* `String` com o valor *null*.
* `String` com o valor vazio.
* `String` com caracteres não imprimíveis.
* `String` sem caracteres não imprimíveis.

**Testes unitários**

 No primeiro teste o objetivo era verificar se a função conseguia ou não lidar com o parâmetro *null*, após a sua realização concluímos que a função lida bem com este caso, sendo retornado o valor fornecido, neste caso *null*.
 
 Seguiu-se o teste onde pretendemos verificar se a função lidava bem com um parâmetro vazio, tal como no teste prévio. Também concluímos que a função lida bem com strings vazias, retornando a mesma.
 
O terceiro teste teve como objetivo verificar se a função realmente substitui os caracteres não imprimíveis, para tal utilizamos o caracter � e mais quatro caracteres que eram imprimíveis.
No final verificamos que a string retornada tinha o caracter substituído, tendo, portanto, funcionado como previsto.

Por fim foi testada uma string sem caracteres não imprimíveis, onde era previsto não ser feita qualquer alteração a string fornecida.
Após execução do teste conseguimos comprovar o que tinha sido previsto, ou seja, nenhum dos caracteres presentes na string foi alterado.

 
## Função - 2

A função `formatIsoDateTime` tem como objetivo receber uma data em formato `String` e retornar a mesma transformada no formato pretendido. Para tal recebe 2 argumentos, uma data em formato `String` e `DateTimeFormatter` com o formato que deve ser aplicado à data. 
Em primeiro lugar a função tenta transformar a data passada como argumento para o formato desejado, caso não seja possível, a função tenta criar uma variável `Date` com a string passada como argumento, caso também não seja possível a função devolve uma a primeira data conhecido ’01.01.1970 ’no formata desejado.


```
public static String formatIsoDateTime(String dateString, DateTimeFormatter formatter) {
        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } catch (DateTimeParseException | NullPointerException e) {
            try {
                // fallback to epoch timestamp
                Date date = new Date(Long.parseLong(dateString));
                dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
            } catch (NumberFormatException | DateTimeParseException | NullPointerException ex) {
          
                dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(0), ZoneId.systemDefault());
            }
        }
        return formatter.format(dateTime.truncatedTo(ChronoUnit.SECONDS));
    }
```

**Category-Partition**

Em relação aos parâmetros existentes nesta função, temos dois, uma data do tipo `String`, e um `DateTimeFormatter`, que corresponde a formatação desejada para a data fornecida. Em termos de características/restrições, ambos os parâmetros só não podiam ser nulos. 
De forma a testar todas as formas possíveis foram criadas as seguintes categorias. Um `DateTimeFormatter`: *null*, vazio, correto ou   incorreto sendo que para cada uma destas hipóteses será utilizada uma string com uma data correta, incorreta, vazia ou *null*.
Assim obtemos os possíveis testes a desenvolver:



* `DateTimeFormatter` vazio.
* `DateTimeFormatter` `null` com uma data correcta.
* `DateTimeFormatter` `null` com uma data incorreta.
* `DateTimeFormatter` `null` com uma data vazia.
* `DateTimeFormatter` `null` com uma data `null`.
* `DateTimeFormatter` incorreto com uma data correcta.
* `DateTimeFormatter` incorreto com uma data incorreta.
* `DateTimeFormatter` incorreto com uma data vazia.
* `DateTimeFormatter` incorreto com uma data `null`.
* `DateTimeFormatter` correto com uma data correcta.
* `DateTimeFormatter` correto com uma data incorreta.
* `DateTimeFormatter` correto com uma data vazia.
* `DateTimeFormatter` correto com uma data `null`.

**Testes Unitários**

Para começar foi feito um teste com o `DateTimeFormatter` a vazio, a função devolve uma string vazia, apesar de não serem levantadas exceções, esta situação sugere que a função deve ser revista pois esta não aparenta ser o comportamento desejado.

Para a segunda bateria de testes no qual o `DateTimeFormatter` esta fixo com o valor `null` sendo o único ponto de variação na data. Todos os testes deram conforme esperado, o que sugere que os métodos foram bem implementados.

Para a terceira bateria de testes o parâmetro `DateTimeFormatter` foi testado com o valor da incorreto e com a data a `null` Todos os testes deram positivo.

Por fim bastou testar o `DateTimeFormatter` correto fixo com variação na data. Todos os testes deram positivo.

## Função - 3

O Propósito da função `createFormatter` é de através de um padrão de datas do tipo `String` recebido como parâmetro, ex. (01-01-2010), caso este seja valido, transformá-lo num objeto do tipo `DateTimeFormatter` de modo a formatar datas do tipo `DateTime`.
A função recebe o padrão desejado como string e tenta criar um objeto do tipo `DateTimeFormatter` utilizando o método `DateTimeFormatter.ofPattern(String pattern)`, caso o padrão seja valido o objeto será criado e retornado pela função, caso seja invalido o método tentará apanhar uma exceção do tipo `IllegalArgumentException`, que indica que o padrão não é um padrão valido para formatar datas, ou uma exceção do tipo `NullPointerException` caso o padrão esteja a *null*. Nestes casos o método retorna um `DateTimeFormatter` pré-definido utilizando o padrão `ISO_DATE`.


```
public static DateTimeFormatter createFormatter(String format){
        DateTimeFormatter formatter;
        try {
            formatter = DateTimeFormatter.ofPattern(format);
        } catch (IllegalArgumentException | NullPointerException e) {
            LOG.log(Level.WARNING, String.format("Could not parse date format [%s] due to [%s]", format, e.getMessage()));
            formatter = DateTimeFormatter.ISO_DATE;
        }
        return formatter;
    }
```

**Category-Partition**

De modo a testarmos o método especificado dividimos os testes em categorias, e desta forma cobrindo todos os possíveis resultados da função. Para tal inicialmente analisamos o tipo de parâmetro necessário e qual o seria o resultado esperado, assim sendo começamos por separar em 2 partes, parâmetro com valor e sem valor.

Começando pela primeira parte, verificamos que caso o padrão fornecido fosse valido deveria ser retornado o `DateTimeFormatter` específico, mas caso o mesmo seja invalido deveria ser retornado um `DateTimeFormatter` definido internamente. Assim ficamos com as duas primeiras categorias:

* Parametro `format` com um valor valido. Exemplo: `"21.12.2021"`
* Parametro `format` com um valor invalido. Exemplo: `"21.12.202"`

Passando para a segunda parte, verificamos que tanto podemos passar um padrão a `null` como um padrão vazio. Em ambos os casos deve ser retornado o `DateTimeFormatter` definido internamente. Desta forma obtemos as restantes categorias:

* Parametro `format` com o valor null. Exemplo: `null`
* Parametro `format` com o valor vazio. Exemplo: `""`



**Testes Unitários**

Tendo obtido quais os testes necessários a realizar, foram então criados e analisados, de modo a verificar se a função a ser avaliada se comportava como planeado.

Começando pelo teste para quando o padrão tem o valor *null*, o mesmo teve como objetivo verificar se a função conseguia lidar com o valor *null*.
Neste teste o valor esperado seria um `DateTimeFormatter` pré-definido internamente, algo que se sucedeu. 
Desta forma concluímos que esta função consegue lidar bem com o valor *null*, e não emite exceções relacionadas com o mesmo.

Passando ao teste referente ao padrão ter um valor vazio, tal como no teste anterior, a função deveria retornar o `DateTimeFormatter` pré-definido internamente. Neste teste conseguimos perceber que o mesmo não ocorre, o que é retornado é um `DateTimeFormatter` vazio, ou seja, a função não verifica se o input é uma string vazia e deixa que esta seja utilizada para criar o objeto do tipo `DateTimeFormatter`. 
Este problema pode levar a diversos erros, visto que esta função é utilizada para criar o formatador de datas, e desta forma várias datas irão ser apagadas com este formatador.

De seguida temos o teste para quando o padrão tem um valor invalido, neste caso, como o padrão fornecido não existe, e não é possível a criação do objeto `DateTimeFormatter`, deveria ser retornado o `DateTimeFormatter` pré-definido. Neste teste concluímos que o mesmo se sucede, ou seja, não é criado um formatador invalido, nem nos é emitida uma exceção, tal como seria esperado o `DateTimeFormatter` pré-definido é retornado.

Por fim temos o teste referente ao padrão ter um valor valido, este é o único caso onde deveria ser retornado o `DateTimeFormatter` com o padrão fornecido.
Após analise do teste verificamos que este é realmente o seu comportamento, retornando o `DateTimeFormatter` correto.




## Função - 4

Esta função tem como objetivo cortar uma `String` com mais de x caracteres e retornar uma `String`. A função recebe uma string como argumento e um número que ira servir para limite de carateres, a função ira depois verificar se a string tem ou não um número de caracteres superior ao que foi passado como parâmetro. Caso seja superior a mesma ira ser cortada e todos os caracteres depois do limite irão serão substituídos por '...' caso contrário é devolvida a string por inteiro.
  
```
    public static String stripString(String text) {
        return stripString(text, 80);
    }

    public static String stripString(String text, int length) {
        String result = text;
        if (text != null && text.length() > length) {
            result = text.substring(0, length) + "...";
        }
        return result;
    }
```

**Category-Partition**

Visto existirem dois parâmetros, a partição dos parâmetros tem de ser feita em conjunto de forma a testar todas as hipóteses possíveis para os parâmetros. O limite que deve ser estabelecido para cortar a string, deve ser testado com um número positivo, negativo e igual a 0 e a string com um número de caracteres, caso seja possível, superior, inferior e igual ao limite estabelecido.

**Limite igual a 0:**

* Limite igual a 0 e uma `String` com um número de caracteres superior a 0.
* Limite igual a 0 e uma `String` com um número de caracteres igual a 0.

Existe a hipótese de o limite ser 0, neste caso existe a possibilidade da `String` passada como argumento ter um número de carateres superior ou igual a 0.

* Limite igual a 0 e uma `String` com um número de caracteres inferior a 0.

Este cenário é impossível pois não é possível criar uma string com um número de caracteres inferior a 0.

**Limite superior a 0 (limite de 10):**

* Limite igual a 10 e uma `String` com um número de caracteres superior a 10.
* Limite igual a 10 e uma `String` com um número de caracteres inferior a 10.
* Limite igual a 10 e uma `String` com um número de caracteres igual a 10.


**Limite inferior a 0 (limite de -2):**

* Limite inferior a -2 e uma `String` com um número de caracteres igual a 10. 
Para este cenário basta testar para um caso. O caso em que o limite ´inferior a 0, eliminado assim a necessidade de ter que realizar outros testes para o tamanho da `String`. 

**Testes Unitários**

Para o primeiro caso da Category-Cartition, os testes para esta categoria passam por realizar 2 métodos com o limite de caracteres fixo no número 0 e em que a o único ponto de variância é o tamanho da string. Ambos os testes deram positivo, pelo que o resultado esperado é cumprido, validando assim esta categoria de testes.

O segundo caso da Category-Cartition, passa por realizar 3 métodos com o limite de caracteres igual a 10 e com uma string superior, inferior ou igual ao limite. Todos os testes deram positivo, pelo que o resultado esperado é cumprido, validando assim esta categoria de testes.

Para o caso em que o limite é negativo o tamanho da string não tem nenhuma importância, pois o *length* com um número negativo iria levantar uma exceção. Este teste levanta uma exceção pelo que deve ser prudente verificar e rever a função de forma a evitar problemas no futuro.



## Função - 5

A ultima função escolhida para realizar os testes é a função `setClipboardContent(String str)`, esta função tem como objetivo recebe uma string  definir a mesma no System ClipBoard.

```
public static void setClipboardContent(String str) throws Exception {
        if (str == null || str.isEmpty()) {
            clearClipboardContent();
            return;
        }
        try {
            StringSelection selection = new StringSelection(str);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
        } catch (Throwable throwable) {
            throw new Exception("Cannot set clipboard content.");
        }
    }
```

**Category-Partition**

De forma a conseguirmos testar o método na sua completude temos primeiro de analisar o parâmetro da mesma perceber quais os possíveis parâmetros. A função em questão recebe apenas uma `String` como parâmetro, o que torna os testes a realizar bastante fáceis pois só temos 3 casos possíveis.

* Parametro `String` com um valor valido. Exemplo: `"Novo conteúdo!!""`
* Parametro `String` com um valor empty. Exemplo: `""`
* Parametro `String` com um valor null. Exemplo: `null`

**Testes Unitários**

Tendo obtido quais os testes necessários a realizar, foram então criados e analisados, de modo a verificar se a função a ser avaliada se comportava como planeado.

Foram realizados 3 métodos para cobrir todas as hipóteses possíveis.
O primeiro teste foi feito com uma string válida de forma a testar se quando o parâmetro passado é valido existe algum problema. O teste foi bem-sucedido.
O segundo e terceiro testes apontam para testar se a função esta preparada para receber algo diferente de uma string válida, foram realizados testes para uma string empty e um objeto null. Ambos os testes passaram, pois, a função trato o argumento como era suposto.
Em suma, esta função passou em todos os testes que pensamos que façam sentido realizar.

