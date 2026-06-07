package model;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario(int id, String nome, String cpf, String email, String cargo, double salario) {
        super(id, nome, cpf, email);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}