import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Array list consegue fazer alterações posteriormente ao contrário de Array
        ArrayList<PessoaFisica> listaPF = new ArrayList<>();
        ArrayList<PessoaJuridica> listaPJ = new ArrayList<>();
        PessoaFisica metodosPf = new PessoaFisica();
        PessoaJuridica metodosPj = new PessoaJuridica();

        System.out.println("Bem vindo ao sistema de cadastro de Pessoa Física e Pessoa Jurídica\n");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção: \n1 - Pessoa Física \n2 - Pessoa Jurídica  \n0 Sair\n");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int opcaoPf;
                    do {
                        System.out.println("Escolha uma opção: \n1 - Cadastrar Pessoa Física  \n2 - Listar Pessoa Física \n0 - Voltar ao menu anterior\n");
                        opcaoPf = scanner.nextInt();


                        switch (opcaoPf) {
                            case 1:
                                PessoaFisica novaPF = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();


                                System.out.println("Digite o nome da pessoa física: ");
                                scanner.nextLine();
                                novaPF.nome = scanner.nextLine();

                                System.out.println("Digite o CPF: ");
                                novaPF.cpf = scanner.next();

                                System.out.println("Digite o rendimento mensal (somente números): ");
                                novaPF.rendimento = scanner.nextDouble();
                                scanner.nextLine();



                                System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
                                //A variavel date recebe o Scanner convertido para DateTime e no formato dia mes e ano
                                LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                //Periodo faz um calculo de período entre duas datas [data digitada - a data de hoje]
                                Period periodo = Period.between(date, LocalDate.now());

                                novaPF.dataNascimento = date;

                                if (periodo.getYears() >= 18) {
                                    System.out.println("A pessoa tem mais de 18 anos\n");
                                } else {
                                    System.out.println("A pessoa tem menos de 18 anos. Retornando...\n");
                                    break;
                                }

                                System.out.println("Digite o logadouro: ");
                                novoEndPf.logradouro = scanner.nextLine();
                                //scanner.next();

                                System.out.println("Digite o numero: ");
                                novoEndPf.numero = scanner.next();
                                //scanner.next();

                                System.out.println("Este endereço é comercial? S/N: ");
                                char endCom;
                                endCom = (char)System.in.read();

                                if (endCom == 'S' || endCom == 's') {
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

                                if (listaPF.size() > 0) {
                                    for (PessoaFisica cadaPf : listaPF) {
                                        System.out.println("\nNome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Endereço: " + cadaPf.endereco.logradouro + ", Nº: " + cadaPf.endereco.numero);
                                        System.out.println("Data de Nascimento: " + cadaPf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.printf("Imposto a ser pago: R$ %.2f\n", metodosPf.CalcularImposto(cadaPf.rendimento));
                                    }
                                    System.out.println("\nDigite 0 para continuar... ");
                                    opcaoPf = scanner.nextInt();
                                    scanner.nextLine();
                                } else {
                                    System.out.println("Lista está vazia");
                                }
                                break;
                            case 0:
                                System.out.println("voltando ao Menu anterior\n");
                                break;
                            default:
                                System.out.println("A opção: " + opcaoPf + " é Invalida - Selecione uma opção correta\n");
                                break;
                        }
                    } while (opcaoPf != 0);
                    break;
                case 2:
                    int opcaoPj;
                    do {
                        System.out.println("Escolha uma opção: \n1 - Cadastrar Pessoa Jurídica  \n2 - Listar Pessoa Jurídica \n0 - Voltar ao menu anterior\n");
                        opcaoPj = scanner.nextInt();

                        switch (opcaoPj) {
                            case 1:
                                //dados Pessoa Jurifica
                                PessoaJuridica novaPJ = new PessoaJuridica();
                                Endereco novoEndPj = new Endereco();

                                System.out.println("Digite o nome da pessoa jurídica: ");
                                scanner.nextLine();
                                novaPJ.nome = scanner.nextLine();
                                //scanner.nextLine();
                                System.out.println("Digite o nome da Razão Social da Empresa: ");
                                novaPJ.razaoSocial = scanner.nextLine();
                                //scanner.nextLine();
                                System.out.println("Digite o CNPJ: ");
                                novaPJ.cnpj = scanner.next();
                                //scanner.next();

                                System.out.println("Digite o rendimento mensal (somente números): ");
                                novaPJ.rendimento = scanner.nextDouble();
                                scanner.nextLine();

                                //Dados do endereço comercial

                                System.out.println("Digite o logadouro: ");
                                novoEndPj.logradouro = scanner.nextLine();

                                System.out.println("Digite o numero: ");
                                novoEndPj.numero = scanner.next();

                                System.out.println("Este endereço é comercial? S/N: ");
                                char endCom = (char)System.in.read();


                                if (endCom == 'S' || endCom == 's') {
                                    novoEndPj.enderecoComercial = true;
                                } else {
                                    novoEndPj.enderecoComercial = false;
                                }
                                //NovaPF endereço atualiza com as informações de NovoEndPf
                                novaPJ.endereco = novoEndPj;

                                listaPJ.add(novaPJ);
                                System.out.println("Cadastro realizado com sucesso!");
                                break;
                            case 2:
                                if (listaPJ.size() > 0) {
                                    for (PessoaJuridica cadaPj : listaPJ) {
                                        System.out.println("\nNome: " + cadaPj.nome);
                                        System.out.println("Razao Social: " + cadaPj.razaoSocial);
                                        System.out.println("CNPJ: " + cadaPj.cnpj);
                                        System.out.println("Endereço: " + cadaPj.endereco.logradouro + ", Nº: " + cadaPj.endereco.numero);
                                        System.out.printf("Imposto a ser pago: R$ %.2f", metodosPj.CalcularImpostoJuridico(cadaPj.rendimento));
                                    }
                                    System.out.println("\nDigite 0 para continuar ");
                                    opcaoPj = scanner.nextInt();
                                } else {
                                    System.out.println("Lista está vazia");
                                }
                                break;
                            case 0:
                                System.out.println("voltando ao Menu anterior\n");
                                break;
                            default:
                                System.out.println("A opção: " + opcaoPj + " é Invalida - Selecione uma opção correta\n");
                                break;
                        }

                    } while (opcaoPj != 0);
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