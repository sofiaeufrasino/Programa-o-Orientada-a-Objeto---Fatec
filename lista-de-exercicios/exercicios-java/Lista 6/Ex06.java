public class Matriz {
    private int linhas;
    private int colunas;
    private double[][] dados;

    public Matriz(int linhas, int colunas) {
        if (linhas <= 0 || colunas <= 0) {
            throw new IllegalArgumentException("As dimensões devem ser positivas.");
        }

        this.linhas = linhas;
        this.colunas = colunas;
        dados = new double[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public double getElemento(int linha, int coluna) {
        return dados[linha][coluna];
    }

    public void setElemento(int linha, int coluna, double valor) {
        dados[linha][coluna] = valor;
    }

    public boolean equals(Matriz outra) {
        if (outra == null || linhas != outra.linhas || colunas != outra.colunas) {
            return false;
        }

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (Double.compare(dados[i][j], outra.dados[i][j]) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public Matriz transposta() {
        Matriz resultado = new Matriz(colunas, linhas);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                resultado.dados[j][i] = dados[i][j];
            }
        }
        return resultado;
    }

    public Matriz oposta() {
        Matriz resultado = new Matriz(linhas, colunas);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                resultado.dados[i][j] = -dados[i][j];
            }
        }
        return resultado;
    }

    // Transforma esta matriz em uma matriz nula.
    public void zerar() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = 0;
            }
        }
    }

    public boolean ehIdentidade() {
        if (linhas != colunas) return false;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (i == j && dados[i][j] != 1) return false;
                if (i != j && dados[i][j] != 0) return false;
            }
        }
        return true;
    }

    public boolean ehDiagonal() {
        if (linhas != colunas) return false;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (i != j && dados[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Segue a definição escrita no enunciado: matriz diagonal
    // cujos elementos da diagonal principal são todos iguais.
    public boolean ehSingular() {
        if (!ehDiagonal()) return false;

        for (int i = 1; i < linhas; i++) {
            if (Double.compare(dados[i][i], dados[0][0]) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean ehSimetrica() {
        if (linhas != colunas) return false;
        return equals(transposta());
    }

    public boolean ehAntiSimetrica() {
        if (linhas != colunas) return false;
        return oposta().equals(transposta());
    }

    // Soma outra matriz a esta matriz.
    public void somar(Matriz outra) {
        verificarMesmasDimensoes(outra);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] += outra.dados[i][j];
            }
        }
    }

    public void subtrair(Matriz outra) {
        verificarMesmasDimensoes(outra);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] -= outra.dados[i][j];
            }
        }
    }

    // A multiplicação substitui esta matriz pelo resultado.
    public void multiplicar(Matriz outra) {
        if (colunas != outra.linhas) {
            throw new IllegalArgumentException(
                    "O número de colunas da primeira deve ser igual ao número de linhas da segunda.");
        }

        double[][] resultado = new double[linhas][outra.colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < outra.colunas; j++) {
                for (int k = 0; k < colunas; k++) {
                    resultado[i][j] += dados[i][k] * outra.dados[k][j];
                }
            }
        }

        dados = resultado;
        colunas = outra.colunas;
    }

    private void verificarMesmasDimensoes(Matriz outra) {
        if (outra == null || linhas != outra.linhas || colunas != outra.colunas) {
            throw new IllegalArgumentException("As matrizes devem ter as mesmas dimensões.");
        }
    }

    public Matriz copia() {
        Matriz resultado = new Matriz(linhas, colunas);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                resultado.dados[i][j] = dados[i][j];
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        String texto = "";
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                texto += dados[i][j] + " ";
            }
            texto += "\n";
        }
        return texto;
    }
}
