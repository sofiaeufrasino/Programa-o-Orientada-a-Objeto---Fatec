public class Continente {
    private String nome;
    private Pais[] paises;
    private int quantidadePaises;

    public Continente(String nome) {
        this.nome = nome;
        paises = new Pais[48];
        quantidadePaises = 0;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarPais(Pais pais) {
        if (pais != null && quantidadePaises < paises.length) {
            paises[quantidadePaises] = pais;
            quantidadePaises++;
        }
    }

    public double dimensaoTotal() {
        double total = 0;
        for (int i = 0; i < quantidadePaises; i++) {
            total += paises[i].getDimensao();
        }
        return total;
    }

    public long populacaoTotal() {
        long total = 0;
        for (int i = 0; i < quantidadePaises; i++) {
            total += paises[i].getPopulacao();
        }
        return total;
    }

    public double densidadePopulacional() {
        double dimensao = dimensaoTotal();
        if (dimensao == 0) {
            return 0;
        }
        return populacaoTotal() / dimensao;
    }

    public Pais paisMaiorPopulacao() {
        if (quantidadePaises == 0) return null;

        Pais maior = paises[0];
        for (int i = 1; i < quantidadePaises; i++) {
            if (paises[i].getPopulacao() > maior.getPopulacao()) {
                maior = paises[i];
            }
        }
        return maior;
    }

    public Pais paisMenorPopulacao() {
        if (quantidadePaises == 0) return null;

        Pais menor = paises[0];
        for (int i = 1; i < quantidadePaises; i++) {
            if (paises[i].getPopulacao() < menor.getPopulacao()) {
                menor = paises[i];
            }
        }
        return menor;
    }

    public Pais paisMaiorDimensao() {
        if (quantidadePaises == 0) return null;

        Pais maior = paises[0];
        for (int i = 1; i < quantidadePaises; i++) {
            if (paises[i].getDimensao() > maior.getDimensao()) {
                maior = paises[i];
            }
        }
        return maior;
    }

    public Pais paisMenorDimensao() {
        if (quantidadePaises == 0) return null;

        Pais menor = paises[0];
        for (int i = 1; i < quantidadePaises; i++) {
            if (paises[i].getDimensao() < menor.getDimensao()) {
                menor = paises[i];
            }
        }
        return menor;
    }

    public double razaoTerritorial() {
        Pais maior = paisMaiorDimensao();
        Pais menor = paisMenorDimensao();

        if (maior == null || menor == null || menor.getDimensao() == 0) {
            return 0;
        }
        return maior.getDimensao() / menor.getDimensao();
    }
}
