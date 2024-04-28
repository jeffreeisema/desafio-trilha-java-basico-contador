import java.util.Scanner;

public class Contador {
    public int parametroUm;
    public int parametroDois;

    public Scanner scanner = new Scanner(System.in);

    public void contar() {
        for (int i = 0; i <= (this.parametroUm - this.parametroDois); i++) {
            System.out.println("Contando... : ".concat(Integer.toString(i)));
        }
    }

    public void checarEntrada() {
        try {
            if (this.parametroUm <= this.parametroDois) {
                throw new ParametrosInvalidosException("O primeiro número não pode ser igual ou menor que o segundo");
            }

            if (this.parametroUm - this.parametroDois > 50) {
                throw new ParametrosInvalidosException(
                        "O toatal de interções por vez é limitado a 50 para melhor desempenho do programa.");
            }

            this.contar();
        } catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    public void obterEntrada() {
        try {
            System.out.println("Digite o primeiro parâmetro inteiro: ");
            this.parametroUm = this.scanner.nextInt();

            System.out.println("Digite o segundo parâmetro inteiro: ");
            this.parametroDois = this.scanner.nextInt();

            this.checarEntrada();
        } catch (Exception e) {
            System.out.println("Houve um erro ao obter entradas, tente novamente! Erro: ".concat(e.getMessage()));
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        Contador contador = new Contador();

        contador.obterEntrada();
    }
}
