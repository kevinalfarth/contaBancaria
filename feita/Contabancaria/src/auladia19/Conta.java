/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auladia19;

import java.util.Random;

/**
 *
 * @author Kevin
 */

public class Conta {

    private double saldo;
    private int numeroConta;
    public String nomeCliente;
    public String cidadeCliente;
    private String extrato;
    
 
    
    

    public Conta(double saldoInicial, String nome, String cidade) {
        
        
        this.saldo = saldoInicial;
        this.nomeCliente = nome;
        this.cidadeCliente = cidade;

        Random rand = new Random();
        this.numeroConta = rand.nextInt(10000);
        this.extrato = "\nConta Aberta\n";
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }
   

    public boolean sacar(double vlrSaque) {
        if (this.saldo >= vlrSaque) {
            this.saldo -= vlrSaque;
            this.gerarExtrato("Saque realizado: "+vlrSaque);
            return true;
        } else {
            return false;
        }
    }
    public void emprestimo(double vlremprestimo)
    {
     this.saldo += vlremprestimo;
     this.gerarExtrato("Emprestimo realizada: "+vlremprestimo);
    }
    public void depositar(double vlrDeposito) {
        this.saldo += vlrDeposito;
        this.gerarExtrato("deposito realizado: "+vlrDeposito);//Demorei 4 hrs pra faze esse esquema minusculo sdksakdksak

    }

    public boolean transferir(int numeroConta, double vlrTransferencia) {
        if (this.saldo >= vlrTransferencia) {
            this.saldo -= vlrTransferencia;
            this.gerarExtrato("transferencia realizada: "+vlrTransferencia);
            return true;
        } else {
            return false;
        }

    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getExtrato() {
        return this.extrato;
    }

    private void gerarExtrato(String log) {
        this.extrato += log+"\n\n";
    }

}
