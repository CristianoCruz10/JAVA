public class IntegerHuge {
    private int[] digitos = new int[40];

    public void parse(String valor) {
        for (int i = 0; i < 40; i++) {
            digitos[i] = 0;
        }

        int indice = 39;
        for (int i = valor.length() - 1; i >= 0; i--) {
            digitos[indice] = Character.getNumericValue(valor.charAt(i));
            indice--;
        }
    }

    public String toString() {
        int inicio = 0;
        while (inicio < 39 && digitos[inicio] == 0) {
            inicio++;
        }

        StringBuilder resultado = new StringBuilder();
        for (int i = inicio; i < 40; i++) {
            resultado.append(digitos[i]);
        }

        return resultado.toString();
    }

    public boolean isZero() {
        for (int digito : digitos) {
            if (digito != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isEqualAt(IntegerHuge outro, int posicao) {
        return digitos[posicao] == outro.digitos[posicao];
    }

    public boolean isDifferentFrom(IntegerHuge outro) {
        for (int i = 0; i < 40; i++) {
            if (digitos[i] != outro.digitos[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean isBiggerThan(IntegerHuge outro) {
        for (int i = 0; i < 40; i++) {
            if (digitos[i] > outro.digitos[i]) {
                return true;
            } else if (digitos[i] < outro.digitos[i]) {
                return false;
            }
        }
        return false;
    }

    public boolean isLessThan(IntegerHuge outro) {
        return outro.isBiggerThan(this);
    }

    public boolean isBiggerThanEqualAt(IntegerHuge outro, int posicao) {
        return digitos[posicao] >= outro.digitos[posicao];
    }

    public boolean isLessThanEqualAt(IntegerHuge outro, int posicao) {
        return digitos[posicao] <= outro.digitos[posicao];
    }
}
