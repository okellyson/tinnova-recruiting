public class Eleitores{

    private Integer totalDeEleitores = 1000;
    private Integer votosValidos = 800;
    private Integer votosBrancos = 150;
    private Integer votosNulos = 50;

    public Double calculaPercentualValidos() {
        return this.votosValidos / this.totalDeEleitores;
    }

    public Double calculaPercentualBrancos() {
        return this.votosBrancos / this.totalDeEleitores;
    }

    public Double calculaPercentualNulos() {
        return this.votosNulos / this.totalDeEleitores;
    }

}