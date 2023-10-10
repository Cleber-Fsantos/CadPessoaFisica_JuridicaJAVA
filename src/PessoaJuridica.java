public class PessoaJuridica extends Pessoa{
public String cnpj;
public String razaoSocial;
public double CalcularImpostoJuridico(double rendimento){
    double resultado;
    if (rendimento <= 3000){
        resultado = rendimento * 0.03f;
        return resultado;

    } else if (rendimento > 3000 && rendimento <= 6000){
        resultado = rendimento * 0.05f;
        return resultado;

    }else if (rendimento > 6000 && rendimento <= 10000){
        resultado = rendimento * 0.07f;
        return resultado;

    }else {
        resultado = rendimento * 0.09f;
        return resultado;
    }
}
}
