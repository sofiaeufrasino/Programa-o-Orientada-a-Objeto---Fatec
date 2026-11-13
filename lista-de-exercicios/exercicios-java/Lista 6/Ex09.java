public class Pessoa {
    private String nome;
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa(String nome) {
        this(nome, null, null);
    }

    public Pessoa(String nome, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.pai = pai;
        this.mae = mae;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa getPai() {
        return pai;
    }

    public Pessoa getMae() {
        return mae;
    }

    public boolean equals(Pessoa outra) {
        if (outra == null) {
            return false;
        }

        boolean mesmaMae;
        if (mae == null) {
            mesmaMae = outra.mae == null;
        } else {
            mesmaMae = mae.equals(outra.mae);
        }

        return nome.equals(outra.nome) && mesmaMae;
    }

    public boolean ehIrma(Pessoa outra) {
        if (outra == null || this == outra) {
            return false;
        }

        boolean mesmoPai = (pai == null && outra.pai == null)
                || (pai != null && pai.equals(outra.pai));
        boolean mesmaMae = (mae == null && outra.mae == null)
                || (mae != null && mae.equals(outra.mae));

        return mesmoPai && mesmaMae;
    }

    // Verifica se a pessoa informada aparece na árvore de antecessores.
    public boolean ehAntecessora(Pessoa pessoa) {
        if (pessoa == null) {
            return false;
        }

        if ((pai != null && pai.equals(pessoa))
                || (mae != null && mae.equals(pessoa))) {
            return true;
        }

        return (pai != null && pai.ehAntecessora(pessoa))
                || (mae != null && mae.ehAntecessora(pessoa));
    }
}
