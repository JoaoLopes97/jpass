![](https://i.imgur.com/r2Upi0M.png)

## Verificação e Validação de Software

### Professor: 
José Campos

### Alunos:
João Lopes      nº55812
Filipe Martins  nº55814

# Assignment #1

## JPass
### Projeto
O projeto JPass é uma aplicação desktop que visa apresentar uma forma simples e portátil com a qual um utilizador consegue fazer a gestão das suas palavras-passes. Juntamente com as palavras-passes guardadas é possível associar as mesmas a um nome e um URL entre muitas outras opções.  
### Organização
O código apresenta-se organizado por diversas pastas:
- **crypto**: Esta pasta está encarregue de ter todas as classes referentes a encriptação e desencriptação do projeto como também as devidas exceções.
- **data**: Pasta que lida com as classes encarregues de guardar e interpretar toda a data da aplicação.
- **ui**: Pasta onde estão todas as classes que lidam com a interface da aplicação.
- **util**: Nesta pasta existem várias classes com métodos estáticos que ajudam e complementam várias funções pela aplicação.
- **xml**: Pasta que trata de receber, enviar e converter ficheiros xml.
 


## Static Testing

*Static testing* trata-se de uma técnica *white box* de testes que se aplicam a um software em desenvolvimento sem que este esteja em execução de forma a encontrar possíveis erros/faltas. 

Esta técnica divide-se em 2 tipos:
- Manual: Examinação manual do código, ou seja, fazer *review* do código.
- Automática: Analise automática do código com o auxílio de ferramentas externas ou internas.



### Importância   
Esta técnica apresenta alguns fatores que são cruciais para o bom desenvolvimento de software:

- Deteção inicial de bugs antes da execução do software permite melhorar a produtividade, ao utilizar *static testing* podemos numa fase inicial detetar falhas e erros fáceis de corrigir. Irá também permitir diminuir o tempo alocado para fazer testes ao software e permitir aumentar o tempo alocado ao desenvolvimento de software.
- Permite melhorar significativamente a manutenção do software.
- Previne falhas e transmite conhecimento, a correção de bugs encontrados permite que no futuro os mesmos não se repitam.



## SpotBugs
Trata-se de uma ferramenta que permite fazer a *static analysis* a código Java de uma forma automática que permite encontrar faltas/erros presentes no mesmo, para tal o SpotBugs utiliza mais de 400 padrões.

### Configuração para o IDE Intellij
De modo a configurar o SpotBugs no IDE Intellij foi necessário primeiramente instalar o plugin do mesmo, através do *marketplace* do Intellij, e de modo a integrar a ferramenta no projeto foi preciso adicionar ao ficheiro pom.xml os dados relativos a ferramenta.

![](https://i.imgur.com/adID9QL.png)

![](https://i.imgur.com/SV9r7Ua.png)

Depois de instalado podemos, através do menu do SpotBugs, definir quais as categorias que achamos relevantes este analisar e também nos permite escolher, entre os 400 padrões oferecidos, quais achamos relevantes para o nosso projeto e desta forma evitamos analises a padrões irrelevantes.

![](https://i.imgur.com/HpNUR5K.png)

### Padrões adicionados/removidos
Visto que por definição bastantes padrões já se encontram selecionados, foi preciso verificar os mesmos, de modo a retirar padrões irrelevantes e a adicionar padrões que fizessem sentido de acordo com o nosso projeto. 

Como a aplicação JPass é simplesmente utilizada no computador do utilizador e não tem qualquer contacto com a WEB iniciamos a analise sobre este ponto, tendo removido o padrão ***CrossSiteScripting***, visto que não existe nenhuma página WEB, nem comunicações HTTP.

De seguida verificamos que nesta aplicação não existe o uso de Threads, tendo removido todos os padrões que as analisam, neste caso os padrões:

* ***MultithreadedInstanceAccess***
* ***SuspiciousThreadInterrupted***
* ***FindRunInvocations***
* ***FindSleepWithLockHeld***
* ***StartInConstructor***

Por fim como não a aplicação guarda os seus dados em ficheiros do tipo .jpass, e não numa base de dados removemos o padrão ***FindSqlInjection***.

Passando aos padrões adicionados, começamos pelo padrão ***FindCircularDependencies***, visto que queremos ter a nossa aplicação o menos acoplada possivel e para tal não podemos ter dependencias circulares, após a adição deste padrão verificamos que o número de avisos aumentou.
Depois verificamos que existem na aplicação conversões de objetos para arrays, sendo util verifica as mesmas, para tal é necessário o padrão ***InefficientToArray***.
Por último verificamos também o uso do metodo `String.indexOf()`, tendo ativado o padrão ***InefficientIndexOf*** de modo a verificar se o uso do mesmo era necessário e se não havia problemas em termos de performance.




## Bugs

Nesta secção iremos apresentar 5 bugs encontrados pelo SpotBugs, quais as suas implicações e a sua correção.
## Bug 1 

Este bug ocorre quando o código desenvolvido é confuso, apresenta anomalias ou a sua utilização pode gerar confusão. Trata-se de um bug da categoria *Dodgy code* e tem o rank de *Troubling*.

*Warning* apresentado pelo Spotbugs:
- ***Warning*: Useless condition: it's always current < 65536 (0x10000) because variable type is char.**
```
    if ((current == 0x9) || (current == 0xA) || (current == 0xD)
                    || ((current >= 0x20) && (current <= 0xD7FF))
                    || ((current >= 0xE000) && (current <= 0xFFFD))
                    || ((current >= 0x10000) && (current <= 0x10FFFF))) {
                out.append(current);
            } else {
                out.append('?');
            }
```
            
Neste caso, o bug reporta que a última validação do if nunca chegara a ser verificada.


### Solução
Neste caso, o bug reporta que a última validação do if nunca chegara a ser verificada.
De forma a resolver o bug bastou retirar a última validação apresentada no if, apesar de estas solução resolver o bug, a utilidade do método fica comprometida. Esta situação iria implicar uma revisão ao método e á sua utilidade.
```
if ((current == 0x9) || (current == 0xA) || (current == 0xD)
                    || ((current >= 0x20) && (current <= 0xD7FF))
                    || ((current >= 0xE000) && (current <= 0xFFFD))) {
                out.append(current);
            } else {
                out.append('?');
            }
```

## Bug 2

Este bug ocorre caso a variável url seja null, levando a um *NullPointerException* aquando da chamada do método toURI(), este bug é da categoria *Correctness* e tem o rank de *Scary*.

*Warning* apresentado pelo Spotbugs:

* ***Warning*: Possible null pointer dereference of url in jpass.ui.SvgImageIcon.update().**

```
 try {
            diagram = svgUniverse.getDiagram(url.toURI());
        } catch (Exception ex) {
            LOG.log(Level.WARNING, String.format("Could not get SVG image [%s] due to [%s]", name, ex.getMessage()));
        }
```

### Solução
De modo a corrigir o mesmo, é necessário validar se o url é ou não null, e assim evitar o possível *NullPointerException*.

```
try {
            if (url != null)
                diagram = svgUniverse.getDiagram(url.toURI());
        } catch (Exception ex) {
            LOG.log(Level.WARNING, String.format("Could not get SVG image [%s] due to [%s]", name, ex.getMessage()));
        }
```

## Bug 3
Neste bug é referida a má pratica da utilização do caracter de newline `\n` ao invés do uso do caracter `%n`, pois com o caracter `%n` produz sempre o separador de linha específico da plataforma correta, ou seja, é portátil entre plataformas enquanto que o caracter `\n` não é.
Este bug é da categoria *Bad practice* e tem o rank de *Of Concern*.


*Warning* apresentado pelo Spotbugs:

* ***Warning*: Format string should use %n rather than \n.**

```
private static final String FILE_OVERWRITE_QUESTION_MESSAGE =
            "File is already exists:\n%s\n\nDo you want to overwrite?";

```
### Solução
A solução passa por substituir o caracter `\n` pelo caracter `%n` e desta forma este bug fica corrigido.

## Bug 4
Este bug refere a possibilidade de existir perigo de adversários conseguirem aceder ao código alterar o mesmo, comprometendo assim a integridade do código. Trata-se de um bug da categoria *Malicious Code* e tem o rank de *Of Concern*.

*Warning* apresentado pelo Spotbugs:

* ***Warning*: jpass.data.DataModel.getPassword() may expose internal representation by returning DataModel.password.**
```
    public byte[] getPassword() {
        return this.password;
    }
```

Neste caso devolver a variável, esta fica exposta a alterações sendo que dependendo do tipo de variável pode ser algo que coloca em perigo o software.

### Solução

A solução para este bug é bastante simples, passa por criar uma variável local e igualar à ao objeto, devolvendo depois o atributo pretendido.
```
    public byte[] getPassword() {
    	DataModel dM = DataModel.getInstance();
        return dM.password;
    }
```




## Bug 5

Por último temos um bug relativo a dependências circulares, onde a classe EntryHelper usa a classe `EntryDialog` e a classe `JPassFrame` e estas utilizam a classe `EntryHelper`, algo que aumenta o acoplamento.
Este bug é da categoria *Dodgy code* e tem o rank de *Of Concern*.

*Warning* apresentado pelo Spotbugs:

* ***Warning*: Class EntryHelper has a circular dependency with other classes.**

###### Código relativo à classe `EntryHelper`:
```
       public static void copyEntryField(JPassFrame parent, String content) {
        try {
            ClipboardUtils.setClipboardContent(content);
        } catch (Exception e) {
            showErrorMessage(parent, e.getMessage());
        }
    }  
```

###### Código relativo à classe `EntryDialog`:

```
} else if ("copy_button".equals(command)) {
            copyEntryField(JPassFrame.getInstance(), String.valueOf(this.passwordField.getPassword()));
        }
```
###### Código relativo à classe `JPassFrame`:

```
public void exitFrame() {
        if (Configuration.getInstance().is("clear.clipboard.on.exit.enabled", false)) {
            EntryHelper.copyEntryField(this, null);
        }
```


### Solução
De forma a resolver este problema foi criada uma classe `GenericHelper` que contem o método `copyEntryField` e desta forma é quebrada a dependência para com a classe `EntryHelper` e deixamos de ter uma dependência circular, passando as classes `EntryDialog` e `JPassFrame` a usar agora a classe `GenericHelper`.
