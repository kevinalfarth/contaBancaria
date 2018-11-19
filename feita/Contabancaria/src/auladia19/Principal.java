package auladia19;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        String nomeCliente, cidade;
        double saldo, vlr,sb,descontos,sl,valorPorcentagem,quantoEmprestimo; 
        boolean ativo = true;
        int opcao, numeroConta;

        Scanner ent = new Scanner(System.in);
        System.out.println("Seje bem vindo ao seu banco");
        //Sloicita dados de abertura
        System.out.println("Informe seu Nome:");
        nomeCliente = ent.next();
        System.out.println("Informe sua Cidade:");
        cidade = ent.next();
        System.out.println("Informe o saldo inicial");
        saldo = ent.nextDouble();
        DecimalFormat formato = new DecimalFormat("#.#");      
        saldo = Double.valueOf(formato.format(saldo));

        Conta c = new Conta(saldo, nomeCliente, cidade);
        {
            System.out.println("ParabÃ©ns sua conta foi aberta");
            System.out.println("NÃºmero da conta: " + c.getNumeroConta());
            //InteraÃ§Ã£o com a conta
            while (ativo) {
                System.out.println("Escolha uma opÃ§Ã£o");
                System.out.println("1 - Sacar");
                System.out.println("2 - Despositar");
                System.out.println("3 - Ver Saldo");
                System.out.println("4 - Tranferencia");
                System.out.println("5 - Dados da conta");
                System.out.println("6 - Ver Extratos");
                System.out.println("7 - Fazer emprestimo");
                System.out.println("10 - Sair ");

                opcao = ent.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Informe valor de saque");
                        vlr = ent.nextDouble();
                        if (c.sacar(vlr)) {
                            System.out.println("Saque realizado com sucesso");
                        } else {
                            System.out.println("Saldo insufinciente!");
                        }
                        break;
                    case 2:
                        System.out.println("Informe o valor do deposito");
                        vlr = ent.nextDouble();
                        c.depositar(vlr);
                        System.out.println("Deposito realizado com sucesso");
                        break;
                    case 3:
                        System.out.println("Saldo: R$" + c.getSaldo());
                        break;
                    case 4:
                        System.out.println("Informe o valor da transferencia:");
                        vlr = ent.nextDouble();
                        System.out.println("Informe o numero da conta de destino");
                        numeroConta = ent.nextInt();

                        if (c.transferir(numeroConta, vlr)) {
                            System.out.println("Transferencia realizada com sucesso");
                        } else {
                            System.out.println("Saldo Insuficiente");
                        }
                        break;
                    case 5:
                        System.out.println("Dados da conta");
                        System.out.println("Numero:" + c.getNumeroConta() + " | Cliente: " + c.nomeCliente + " | cidade:" + c.cidadeCliente + " | Saldo:" + c.getSaldo());
                    case 6:
                        System.out.println("Extratos:"+c.getExtrato()+"\nSaldo = R$"+c.getSaldo());
                        break;
                    case 7 :
                        System.out.println("Qual é seu salario bruto?");
                        sb = ent.nextDouble();
                        System.out.println("Qual é a contia dos descontos no seu salario?");
                        descontos = ent.nextDouble();
                        System.out.println("Quantos reais vc quer no emprestismo?");
                        quantoEmprestimo = ent.nextDouble();
                        sl = sb-descontos;//para saber salario limpo
                         valorPorcentagem = (sl*30)/100;//valor que pode retirar
                         if (valorPorcentagem > quantoEmprestimo )
                         {
                             System.out.println("Operação bem sucedida!");
                            c.emprestimo(quantoEmprestimo);
                             
                         }
                             else
                         {
                             System.out.println("Você não pode pegar emprestado mais de 30% do seu salario");
                         } 
                         
                       break;
                    default:
                        ativo = false;
                        break;

                }
            }
        }
    }
}
