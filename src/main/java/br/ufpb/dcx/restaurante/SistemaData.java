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
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
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
        return Objects.hash(Integer.valueOf(dia),Integer.valueOf(mes) ,Integer.valueOf(ano));
    }

    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

    public static SistemaData converteEmSistemaData (String data){
        String[] partes = data.split("/");

        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        return new SistemaData(dia, mes, ano);
    }
}
