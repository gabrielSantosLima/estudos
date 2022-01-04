import java.util.*;

// Converte ‘string’ em camelCase para lista de 'string'
interface IConverteString {
    List<String> converterCamelCase(String original);
}

public class ConverteString implements IConverteString{

    public List<String> converterCamelCase(String original) throws InvalidStringException{
        validarString(original);
        List<String> palavras = Arrays.asList(original.split("(?=[A-Z][a-z])|(?=CPF)|(?=[0-9]{2})"))
                .stream()
                .map(this::prepararString)
                .toList();
        return palavras;
    }

    private String prepararString(String string){
        if(string.matches("[A-Z]+")){
            return string;
        }
        return string.toLowerCase(Locale.ROOT);
    }

    private void validarString(String string) throws InvalidStringException{
        if(temCaracteresEspeciais(string) || comecaComNumero(string)){
            throw new InvalidStringException("Formato inválido de string pois começa com números ou possui caracteres especiais.");
        }
    }

    private boolean temCaracteresEspeciais(String string){
        boolean contemCaracteresEspeciais = string.matches("\\w*\\W\\w*");
        return contemCaracteresEspeciais;
    }

    private boolean comecaComNumero(String string){
        boolean iniciaComNumero = string.matches("^[0-9]\\w*");
        return iniciaComNumero;
    }
}
