package br.ufpb.dcx.restaurante;

import java.io.Serializable;
import java.util.Objects;

public class SistemaData implements Serializable {
    private static final long serialVersionUID = 1L;

    private int dia;
    private int mes;
    private int ano;

    public SistemaData(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    } //… outros métodos da classe

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }

    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SistemaData that = (SistemaData) o;
        return dia == that.dia && mes == that.mes && ano == that.ano;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, mes, ano);
    }
}
