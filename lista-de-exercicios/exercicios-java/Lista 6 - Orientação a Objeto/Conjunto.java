public class Conjunto {
    private String[] elementos;
    private int quantidade;

    public Conjunto() {
        elementos = new String[5];
        quantidade = 0;
    }

    // Aumenta o tamanho do array quando ele fica cheio.
    private void aumentarArray() {
        String[] novo = new String[elementos.length * 2];
        for (int i = 0; i < elementos.length; i++) {
            novo[i] = elementos[i];
        }
        elementos = novo;
    }

    public void adicionar(String elemento) {
        if (elemento == null || pertence(elemento)) {
            return;
        }

        if (quantidade == elementos.length) {
            aumentarArray();
        }

        elementos[quantidade] = elemento;
        quantidade++;
    }

    public boolean pertence(String elemento) {
        for (int i = 0; i < quantidade; i++) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public Conjunto uniao(Conjunto outro) {
        Conjunto resultado = new Conjunto();

        for (int i = 0; i < quantidade; i++) {
            resultado.adicionar(elementos[i]);
        }
        for (int i = 0; i < outro.quantidade; i++) {
            resultado.adicionar(outro.elementos[i]);
        }

        return resultado;
    }

    public Conjunto inter(Conjunto outro) {
        Conjunto resultado = new Conjunto();

        for (int i = 0; i < quantidade; i++) {
            if (outro.pertence(elementos[i])) {
                resultado.adicionar(elementos[i]);
            }
        }
        return resultado;
    }

    public Conjunto menos(Conjunto outro) {
        Conjunto resultado = new Conjunto();

        for (int i = 0; i < quantidade; i++) {
            if (!outro.pertence(elementos[i])) {
                resultado.adicionar(elementos[i]);
            }
        }
        return resultado;
    }

    public int tamanho() {
        return quantidade;
    }

    @Override
    public String toString() {
        String texto = "{";
        for (int i = 0; i < quantidade; i++) {
            texto += elementos[i];
            if (i < quantidade - 1) {
                texto += ", ";
            }
        }
        return texto + "}";
    }
}
