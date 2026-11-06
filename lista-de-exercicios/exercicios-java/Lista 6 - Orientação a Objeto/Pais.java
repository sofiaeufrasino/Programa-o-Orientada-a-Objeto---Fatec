public class Pais {
    private String codigoISO;
    private String nome;
    private long populacao;
    private double dimensao;
    private Pais[] fronteiras;
    private int quantidadeFronteiras;

    public Pais(String codigoISO, String nome, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.dimensao = dimensao;
        this.populacao = 0;
        this.fronteiras = new Pais[40];
        this.quantidadeFronteiras = 0;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public void adicionarFronteira(Pais pais) {
        if (pais == null || equals(pais) || ehLimitrofe(pais)) {
            return;
        }
        if (quantidadeFronteiras < fronteiras.length) {
            fronteiras[quantidadeFronteiras] = pais;
            quantidadeFronteiras++;
        }
    }

    public boolean equals(Pais outro) {
        return outro != null && codigoISO.equals(outro.codigoISO);
    }

    public boolean ehLimitrofe(Pais outro) {
        if (outro == null) {
            return false;
        }

        for (int i = 0; i < quantidadeFronteiras; i++) {
            if (fronteiras[i].equals(outro)) {
                return true;
            }
        }
        return false;
    }

    public double densidadePopulacional() {
        if (dimensao == 0) {
            return 0;
        }
        return populacao / dimensao;
    }

    // Retorna os países que fazem fronteira com os dois países.
    public Pais[] vizinhosComuns(Pais outro) {
        Pais[] comuns = new Pais[40];
        int quantidade = 0;

        if (outro == null) {
            return new Pais[0];
        }

        for (int i = 0; i < quantidadeFronteiras; i++) {
            Pais vizinho = fronteiras[i];
            if (outro.ehLimitrofe(vizinho)) {
                comuns[quantidade] = vizinho;
                quantidade++;
            }
        }

        Pais[] resultado = new Pais[quantidade];
        for (int i = 0; i < quantidade; i++) {
            resultado[i] = comuns[i];
        }
        return resultado;
    }
}
