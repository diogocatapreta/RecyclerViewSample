package com.example.diogocatapreta.recyclerviewsample.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solicitacao {

    private Integer numero;
    private String nomeFornecedor;
    private String docFornecedor;
    private double valor;
    private Date dataCriacao;

    public Solicitacao(Integer numero, String nomeFornecedor, String docFornecedor, double valor) {
        this.numero = numero;
        this.nomeFornecedor = nomeFornecedor;
        this.docFornecedor = docFornecedor;
        this.valor = valor;
        this.dataCriacao = Calendar.getInstance().getTime(); ;
    }

    public Solicitacao(){

    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getDocFornecedor() {
        return docFornecedor;
    }

    public void setDocFornecedor(String docFornecedor) {
        this.docFornecedor = docFornecedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    /*
    public Date getDataCriacao() {
        return dataCriacao;
    }
    */

    public String getDataCriacao(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(this.dataCriacao);
        return strDate;

    }

    public void setDatacriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) throws ParseException {
        this.dataCriacao = new SimpleDateFormat("dd/MM/yyyy").parse(dataCriacao);
    }
}
