import java.time.LocalDate;

public class PessoaFisica extends Pessoa{
public String cpf;
public LocalDate dataNascimento;
public double CalcularImposto(double rendimento){
    if (rendimento <= 1500){
        return 0;

    } else if (rendimento > 1500 && rendimento <= 3500){
        double resultado = (rendimento / 100) * 2;
        return resultado;

    }else if (rendimento > 3500 && rendimento <= 6000){
        double resultado = (rendimento / 100) * 3.5f;
        return resultado;

    }else {
        double resultado = (rendimento / 100) * 5;
        return resultado;
    }
}
}
