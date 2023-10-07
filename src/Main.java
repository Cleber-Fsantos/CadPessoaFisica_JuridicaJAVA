import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Array list consegue fazer alterações posteriormente ao contrário de Array
        ArrayList<PessoaFisica> listaPF = new ArrayList<>();
        PessoaFisica metodosPf = new PessoaFisica();
        System.out.println("Bem vindo ao sistema de cadastro de Pessoa Física e Pessoa Jurídica\n");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção: \n1 - Pessoa Física \n2 - Pessoa Jurídica  \n0 Sair\n");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    int opcaoPf;
                    do {
                        System.out.println("Escolha uma opção: \n1 - Cadastrar Pessoa Física  \n2 - Listar Pessoa Física \n0 - Voltar ao menu anterior\n");
                        opcaoPf = scanner.nextInt();

                        switch (opcaoPf){
                            case 1:
                                PessoaFisica novaPF = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();


                                System.out.println("Digite o nome da pessoa física: ");
                                novaPF.nome = scanner.next();

                                System.out.println("Digite o CPF: ");
                                novaPF.cpf = scanner.next();

                                System.out.println("Digite o rendimento mensal (somente números): ");
                                novaPF.rendimento = scanner.nextInt();

                                System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
                                //A variavel date recebe o Scanner convertido para DateTime e no formato dia mes e ano
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                //Periodo faz um calculo de período entre duas datas [data digitada - a data de hoje]
                                Period periodo = Period.between(date,LocalDate.now());

                                novaPF.dataNascimento = date;

                                if(periodo.getYears() >= 18){
                                    System.out.println("A pessoa tem mais de 18 anos");
                                }else {
                                    System.out.println("A pessoa tem menos de 18 anos. Retornando...");
                                }

                                System.out.println("Digite o logadouro: ");
                                novoEndPf.logradouro= scanner.next();

                                System.out.println("Digite o numero: ");
                                novoEndPf.numero= scanner.next();

                                System.out.println("Este endereço é comercial? S/N: ");
                                String endCom = scanner.next();
                                if (endCom.equalsIgnoreCase("S")){
                                    novoEndPf.enderecoComercial = true;
                                } else {
                                    novoEndPf.enderecoComercial = false;
                                }
                                //NovaPF endereço atualiza com as informações de NovoEndPf
                                novaPF.endereco = novoEndPf;

                                listaPF.add(novaPF);

                                System.out.println("Cadastro realizado com sucesso!");

                                break;
                            case 2:

                                if (listaPF.size() > 0){
                                    for(PessoaFisica cadaPf : listaPF){
                                        System.out.println("\nNome " + cadaPf.nome);
                                        System.out.println("CPF " + cadaPf.cpf);
                                        System.out.println("Endereço " + cadaPf.endereco.logradouro + ", Nº: " +cadaPf.endereco.numero);
                                        System.out.println("Data de Nascimento " + cadaPf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago " + metodosPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println("\nDigite 0 para continuar ");
                                        scanner.nextLine();
                                    }

                                    opcaoPf = scanner.nextInt();
                                }else {
                                    System.out.println("Lista está vazia");
                                }
                                break;
                            case 0:
                                System.out.println("voltando ao Menu anterior\n");
                                break;
                            default:
                                System.out.println("A opção: " + opcao + " é Invalida - Selecione uma opção correta\n");
                                break;
                        }
                    }while (opcaoPf != 0);
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar nosso sistema\n");
                    break;
                default:
                    System.out.println("A opção: " + opcao + " é Invalida - Selecione uma opção correta");
                    break;
            }
        } while (opcao != 0);
    }
}