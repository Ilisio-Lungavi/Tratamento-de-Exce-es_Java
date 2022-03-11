pacote  br.com.dio.exceptions ;

import  javax.swing.* ;
import  java.io.* ;

// Imprime um arquivo no console.
 classe  pública CheckedException {
    public  static  void  main ( String [] args ) {
        String nomeDoArquivo =  " romance-blake-crouch.txt " ;

        tente {
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch ( FileNotFoundException e) {
            JOptionPane . showMessageDialog( null ,
                    " Revisar o nome do arquivo que você deseja imprimir! "  + e . getCausa());
            e . printStackTrace();
        } catch ( IOException e){
            // e.printStackTrace();
            JOptionPane . showMessageDialog( null ,
                    " Ocorreu um erro inesperado! Entre em contato com o suporte! "  + e . getCausa());
        } finalmente {
            Sistema . fora . println( " Chegou não finalmente! " );
        }

        Sistema . fora . println( " Apesar da exceção ou não, o programa continua... " );
    }

    public  static  void  imprimirArquivoNoConsole ( String  nomeDoArquivo ) lança  IOException {
        Arquivo arquivo =  novo  Arquivo (nomeDoArquivo);

        BufferedReader br =  new  BufferedReader ( new  FileReader (arquivo . getName()));
        String linha = br . Leia a linha();

        BufferedWriter bw =  new  BufferedWriter ( new  OutputStreamWriter ( System . out));

        fazer {
            bw . escreva(linha);
            bw . nova linha();
            linha = br . Leia a linha();
        } while (linha !=  null );
        bw . rubor();
        br . Fechar();
    }
}


-----------------------------------------------------------------------------------------

pacote  br.com.dio.exceptions ;

public  class  DivisaoNaoExataException  estende  Exception {

    private  int numerado;
     denominador int privado ;

    public  DivisaoNaoExataException ( String  message , int  numerado , int  denominador ) {
        super (mensagem);
        isso . numerado = numerado;
        isso . denominador = denominador;
    }
}

--------------------------------------------------------------

pacote  br.com.dio.exceptions ;

import  javax.swing.* ;
import  java.io.* ;

 classe  pública ExceptionCustomizada_1 {
    public  static  void  main ( String [] args ) {
        String nomeDoArquivo =  JOptionPane . showInputDialog( " Nome do arquivo a ser exibido: " );

        imprimirArquivoNoConsole(nomeDoArquivo);
        Sistema . fora . println( " \n Com exceção ou não, o programa continua... " );
    }

    public  static  void  imprimirArquivoNoConsole ( String  nomeDoArquivo ) {

        tente {
            BufferedReader br = lerArquivo(nomeDoArquivo);
            String linha = br . Leia a linha();
            BufferedWriter bw =  new  BufferedWriter ( new  OutputStreamWriter ( System . out));
            fazer {
                bw . escreva(linha);
                bw . nova linha();
                linha = br . Leia a linha();
            } while (linha !=  null );
            bw . rubor();
            br . Fechar();
        } catch ( ImpossivelAberturaDeArquivoException e) {
            JOptionPane . showMessageDialog( null ,
                    e . getMensagem());
            // e.printStackTrace();
        } catch ( IOException ex) {
            JOptionPane . showMessageDialog( null ,
                    " Ocorreu um erro não esperado, por favor, fale com o suporte. "  + ex . getMensagem());
            ex . printStackTrace();
        }
    }

    public  static  BufferedReader  lerArquivo ( String  nomeDoArquivo ) lança  ImpossivelAberturaDeArquivoException {

        Arquivo arquivo =  novo  Arquivo (nomeDoArquivo);
        tente {
            return  new  BufferedReader ( new  FileReader (nomeDoArquivo));
        } catch ( FileNotFoundException e) {
            lançar  nova  ImpossivelAberturaDeArquivoException (arquivo . getName(), arquivo . getPath());
        }
    }
}

class  ImpossivelAberturaDeArquivoException  estende  Exception {

    private  String nomeDoArquivo;
     diretório de strings privado ;

    public  ImpossivelAberturaDeArquivoException ( String  nomeDoArquivo , String  diretório ) {
        super ( " O "  arquivo + nomeDoArquivo +  " não foi encontrado no diretório "  + diretório);
        isso . nomeDoArquivo = nomeDoArquivo;
        isso . diretório = diretório;
    }

    /* @Substituir
    public String toString() {
        return "ImpossivelAberturaDeArquivoException{" +
                "nomeDoArquivo='" + nomeDoArquivo + '\'' +
                ", diretório='" + diretório + '\'' +
                '}';
    } */

}




--------------------------------------------------------------------------------

pacote  br.com.dio.exceptions ;

import  javax.swing.* ;

public  class  ExceptionCustomizada_2 {
    public  static  void  main ( String [] args ){
        int [] numerador = { 4 , 5 , 8 , 10 };
        int [] denominador = { 2 , 4 , 0 , 2 , 8 };

        for ( int i =  0 ; i < denominador . length; i ++ ) {
            tente {
                if (numerador[i] % 2  !=  0 )
                    throw  new  DivisaoNaoExataException ( " Divisão não exata! " , numerador[i], denominador[i]);

                int resultado = numerador[i] / denominador[i];
                Sistema . fora . println(resultado);
            } catch ( DivisaoNaoExataException  |  ArithmeticException  |  ArrayIndexOutOfBoundsException e) {
                e . printStackTrace();
                JOptionPane . showMessageDialog( null , e . getMessage());
            }
        }

        Sistema . fora . println( " O programa continua... " );
    }
}

----------------------------------------------------------------------------------------


pacote  br.com.dio.exceptions ;

import  javax.swing.* ;

// Fazer uma divisão de 2 valores inteiros
public  class  UncheckedException {
    public  static  void  main ( String [] args ) {

        boolean continueLooping =  true ;
        fazer {
            String a =  JOptionPane . showInputDialog( " Numerador: " );
            String b =  JOptionPane . showInputDialog( " Denominador: " );

            tente {
                int resultado = dividir( Integer . parseInt(a), Integer . parseInt(b));
                Sistema . fora . println( " Resultado: "  + resultado);
                continueLooping =  false ;
            } catch ( NumberFormatException e) {
                e . printStackTrace();
                JOptionPane . showMessageDialog( null , " Entrada inválida, informe um número inteiro! "  + e . getMessage());
            } catch ( AritméticaException e) {
                e . printStackTrace();
                JOptionPane . showMessageDialog( null , " Impossível dividir um número por 0 " );
            }
            finalmente {
                Sistema . fora . println( " Chegou não finalmente! " );
            }
        } while (continueLooping);


        Sistema . fora . println( " O código continua... " );
    }

    public  static  int  dividir ( int  a , int  b ) {
        retornar a / b;
    }
}


-------------------------------------------------------------------------------



