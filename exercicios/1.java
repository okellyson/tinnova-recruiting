public class Eleitores{

    private Integer totalDeEleitores = 1000;
    private Integer votosValidos = 800;
    private Integer votosBrancos = 150;
    private Integer votosNulos = 50;

    private Double calculaPercentualValidos() {
        return this.votosValidos / this.totalDeEleitores;
    }

    private Double calculaPercentualBrancos() {
        return this.votosBrancos / this.totalDeEleitores;
    }

    private Double calculaPercentualNulos() {
        return this.votosNulos / this.totalDeEleitores;
    }

}